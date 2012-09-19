package com.lattice.data;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

import org.apache.log4j.*;

import com.lattice.validate.*;
import com.weaselworks.util.*;

/**
 * 
 * @author crawford
 *
 */

public class ValidationBuilder
{
	private static final Logger logger = Logger.getLogger (ValidationBuilder.class); 
	
	private
	ValidationBuilder ()
	{
		return;
	}

	/**
	 * 
	 * @param strs
	 * @return
	 */
	
	private static 
	String massage (final String [] strs)
	{
		switch (strs.length) { 
			case 0: return null; 
			case 1: return strs [0]; 
			default: throw new IllegalStateException (); 
		}
		// NOT REACHED
	}
	
	/**
	 * 
	 * @param ints
	 * @return
	 */
	
	private static
	Integer massage (final int [] ints)
	{
		switch (ints.length) { 
			case 0: return null; 
			case 1: return ints [0]; 
			default: throw new IllegalStateException (); 
		}
		// NOT REACHED
	}
	
	/**
	 * 
	 * @param longs
	 * @return
	 */
	
	private static
	Long massage (final long [] longs)
	{
		switch (longs.length) { 
			case 0: return null;  
			case 1: return longs [0]; 
			default: throw new IllegalStateException (); 					
		}
		// NOT REACHED
	}
	
	/**
	 * 
	 * @param <Type>
	 * @param type
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	
	@SuppressWarnings("unchecked")
    public static <Type>
	ObjectValidator<Type> buildValidator (final Class<Type> type)
		throws IllegalAccessException, InstantiationException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException
	{
		assert type != null; 
		
		logger.info ("Building validator for: " + type.getName ()); 		
		final ObjectValidator<Type> vor = new ObjectValidator<Type> (type);
		
		// Loop through each of the classes that comprise the object 
		
		for (Class<?> klass = type; klass != null; klass = klass.getSuperclass ()) { 			
			for (final Field field : klass.getDeclaredFields ()) {
				field.setAccessible (true); 
				final Class<?> ftype = field.getType ();
				final String fname = field.getName (); 
				
				if (field.isAnnotationPresent (NotNull.class)) {
					final NotNull nn = field.getAnnotation (NotNull.class);
					final NotNullValidator<Type> fv = new NotNullValidator<Type> (type, fname, nn.errmsg ());
					vor.addValidator (fv);
				}						
              
				if (ftype.equals (String.class)) { 
					if (field.isAnnotationPresent (StringValidation.class)) {
						final StringValidation sv = field.getAnnotation(StringValidation.class);
						final Integer minLen = massage (sv.minLength ()), maxLen = massage (sv.maxLength ()); 
						final StringValidator<Type> fv = new StringValidator<Type> (type, fname, sv.nullable (), minLen, maxLen, sv.regex (), sv.errmsg ());
						vor.addValidator (fv); 
					}
					if (field.isAnnotationPresent (StringValidations.class)) {
						final StringValidations ann = field.getAnnotation (StringValidations.class);
						for (final StringValidation sv : ann.validations ()) {
							final Integer minLen = massage (sv.minLength ()), maxLen = massage (sv.maxLength ()); 
							final StringValidator<Type> fv = new StringValidator<Type> (type, fname, sv.nullable (), minLen, maxLen, sv.regex (), sv.errmsg ());
							vor.addValidator (fv);
						}
					}
					if (field.isAnnotationPresent (ClassValidation.class)) {
						final ClassValidation cv = field.getAnnotation (ClassValidation.class); 
						final ClassNameValidator fv = new ClassNameValidator<Type> (type, fname, cv.instanceOf ()); 
						vor.addValidator (fv); 
					}
				} else if (ftype.equals (Integer.class) || ftype.equals (Integer.TYPE)) { 
					if (field.isAnnotationPresent (IntegerValidation.class)) {
						final IntegerValidation iv = field.getAnnotation (IntegerValidation.class);
						final Integer min = massage (iv.minValue ()), max = massage (iv.maxValue ());  
						final IntegerValidator<Type> fv = new IntegerValidator<Type> (type, fname, iv.nullable (), min, max, iv.errmsg ());
						vor.addValidator (fv);
					}
					if (field.isAnnotationPresent (IntegerValidations.class)) {
						final IntegerValidations ann = field.getAnnotation (IntegerValidations.class);
						for (final IntegerValidation iv : ann.validations ()) {
							final Integer min = massage (iv.minValue ()), max = massage (iv.maxValue ());  
							final IntegerValidator<Type> fv = new IntegerValidator<Type> (type, fname, iv.nullable (), min, max, iv.errmsg ());
							vor.addValidator (fv);
						}
					}					
				} else if (ftype.equals (Long.class) || ftype.equals (Long.TYPE)) { 
					if (field.isAnnotationPresent (LongValidation.class)) {
						final LongValidation lv = field.getAnnotation (LongValidation.class);
						final Long min = massage (lv.minValue ()), max = massage (lv.maxValue ()); 
						final LongValidator<Type> fv = new LongValidator<Type> (type, fname, lv.nullable (), min, max, lv.errmsg ());
						vor.addValidator (fv); 
					}
					if (field.isAnnotationPresent (LongValidations.class)) {
						final LongValidations ann = field.getAnnotation(LongValidations.class);
						for (final LongValidation lv : ann.validations ()) {
							final Long min = massage (lv.minValue ()), max = massage (lv.maxValue ()); 
							final LongValidator<Type> fv = new LongValidator<Type> (type, fname, lv.nullable (), min, max, lv.errmsg ());
							vor.addValidator (fv); 
						}
					}
				} else {
					if (field.isAnnotationPresent (ObjectValidation.class)) { 
						final ObjectValidation ov = field.getAnnotation (ObjectValidation.class); 
						final String errmsg = massage (ov.errmsg ()); 
						final ObjectFieldValidator<Type, ?> ofv = new ObjectFieldValidator (type, ftype, fname, ov.nullable (), errmsg); 
						vor.addValidator (ofv); 
					}
				}
				
				if (field.isAnnotationPresent (CustomFieldValidation.class)) {
					final CustomFieldValidation ann = field.getAnnotation (CustomFieldValidation.class);
					for (final Class<? extends FieldValidator> c : ann.classes ()) {
						final Constructor cons = c.getConstructor (new Class [] { Class.class, Class.class, String.class });
						// TODO: better error checking for above
						final Object [] args = new Object [] { type, ftype, fname }; 
						final FieldValidator<Type, ?> fv = (FieldValidator<Type, ?>) cons.newInstance (args);
						vor.addValidator (fv); 
					}
				}
				
                if (ClassUtil.implementsInterface (field.getType (), Collection.class)) {
                    if (field.isAnnotationPresent (CollectionValidation.class)) {
                        final CollectionValidation cv = field.getAnnotation (CollectionValidation.class);
                        final Integer min = massage (cv.minItems ()), max = massage (cv.maxItems ()); 
                        final CollectionValidator<Type> fv = new CollectionValidator<Type> (type, fname, min, max, cv.errmsg ());  
                        vor.addValidator (fv); 
                    }
                }
                
                
			}
			
			// Pick up any custom class validations. 
			
            if (klass.isAnnotationPresent (CustomValidation.class)) {
                final Annotation ann = klass.getAnnotation (CustomValidation.class);
                final CustomValidation cv = (CustomValidation) ann;
                final List<Validator<? super Type>> cvs = vor.getOtherValidators ();
                final Class<? extends Validator<?>> [] cs = cv.classes ();

                for (final Class<? extends Validator<?>> c : cs) {
                		final Constructor cons = c.getConstructor (new Class [] { Class.class }); 
                		if (cons == null) { 
                			logger.error ("No Constructor(Class) found for custom validator: " + c); 
                		} else { 
	                		// TODO: better error checking for above
	                		final Object [] args = { type }; 
	                		final Validator<? super Type> inst = (Validator <? super Type>) cons.newInstance (args); 
	                        cvs.add (inst);
                		}
                }
            }
		}
		
		return vor; 
	}
}

// EOF




