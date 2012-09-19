package com.lattice.validate;

import java.util.*;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

@SuppressWarnings("serial")
public class ObjectValidator<Type>
    extends Validator<Type>
{
    public
    ObjectValidator (final Class<Type> type)
    {
        super (type);
        return;
    }
    
    /**
     * Contains the mappings from fields to the associated validators. 
     */

    protected Map<String, List<FieldValidator<? super Type, ?>>> validators =
        new HashMap<String, List<FieldValidator<? super Type, ?>>> ();

    /**
     * 
     * @return
     */
    
    public
    Set<String> getFields () 
    {
    	return validators.keySet (); 
    }
    
    /**
     *
     * @return
     */

    public
    Map<String, List<FieldValidator<? super Type, ?>>> getValidators ()
    {
        return this.validators;
    }

    /**
     *
     * @param field
     * @return
     */

    public
    List<FieldValidator<? super Type, ?>> getValidator (final String field)
    {
        return validators.get (field);
    }

    /**
     *
     */

    protected List<Validator<? super Type>> customValidators = new ArrayList<Validator<? super Type>>();

    /**
     *
     * @param otherValidator
     */

    public
    void addOtherValidator (final Validator<Type> otherValidator)
    {
    	customValidators.add (otherValidator);
        return;
    }

    /**
     *
     * @return
     */

    public
    List<Validator<? super Type>> getOtherValidators ()
    {
        return this.customValidators;
    }

    /**
     *
     * @param obj
     * @throws ValidationException
     */

    @SuppressWarnings("unchecked")
    public
    void validate (final Object obj)
        throws ValidationException
    {
        final Type t = (Type) obj;
        for (final String field : validators.keySet ()) { 
        	final List<FieldValidator<? super Type, ?>> vors = validators.get (field);
        	for (final FieldValidator<? super Type, ?> vor : vors) { 
              vor.validateOn (t);        		
        	}
        }
        if (! customValidators.isEmpty ()) {
            for (final Validator<? super Type> customValidator : customValidators ){
            	customValidator.validate (t);
            }
        }
        return;
    }

    /**
     *
     * @param validator
     */

    public
    void addValidator (final FieldValidator<? super Type, ?> validator)
    {
    	List<FieldValidator<? super Type, ?>> vors = validators.get (validator.getFieldName ()); 
    	if (vors == null) { 
    		vors = new ArrayList<FieldValidator<? super Type, ?>> (); 
    		validators.put (validator.getFieldName (), vors); 
    	}
        vors.add (validator); 
        return;
    }
}

// EOF