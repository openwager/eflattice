package com.lattice.validate;

import java.util.*;

import com.lattice.data.*;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

public class ValidatorUtil
{
    /**
     * Private constructor to defeat instantiation.
     */

    private
    ValidatorUtil ()
    {
        return;
    }

    /**
     * Contains the mapping from type to the registered {@linkplain ObjectValidator} for objects of that type. 
     */
    
    protected static Map<Class<?>, ObjectValidator<?>> map = new HashMap<Class<?>, ObjectValidator<?>>();

    /**
     * 
     * @return
     */
    
    public static
    Collection<ObjectValidator<?>> getRegisteredValidators () 
    {
    	return map.values (); 
    }
    
    /**
     * Retrieves the {@linkplain ObjectValidator} that has been registered for the specified type. Returns 
     * null if no {@linkplain ObjectValidator} has been registered. 
     * 
     * @param type
     * @return
     */
    
    @SuppressWarnings("unchecked")
    public static <Type>
    ObjectValidator<Type> getValidator (final Class<Type> type)
    	throws ValidationException
    {
    	ObjectValidator<Type> validator = (ObjectValidator<Type>) map.get (type); 
    	if (validator == null) { 
    		try { 
    			validator = ValidationBuilder.buildValidator (type);
    		}
    		catch (final Exception e) { 
    			throw new ValidationException (null, null, e.getMessage (), e); 
    		}
    		setValidator (type, validator);
    	}
        return validator; 
    }

    /**
     * Used to register a {@linkplain ObjectValidator} to be used for validating objects of the specified type. 
     * 
     * @param type
     * @param validator
     */
    
    public static
    void setValidator (final Class<?> type, final ObjectValidator<?> validator)
    {
        synchronized (map) {
            map.put (type, validator);
        }
        return;
    }

    /**
     * Used to remove the registered {@linkplain ObjectValidator} associated with the specified type. 
     * @param type
     */
    
    protected static
    void removeValidator (final Class<?> type) 
    {
    	synchronized (map) { 
    		map.remove (type); 
    	}
    	return; 
    }
    
    /**
     * Used to determine if a {@linkplain ObjectValidator} has been registered for the specified type. 
     * @param type
     * @return
     */
    
    protected static
    boolean hasValidator (final Class<?> type)
    {
        return map.containsKey (type);
    }

    /**
     * Used to validate the specified object. This only works effectively if a {@linkplain ObjectValidator}
     * has actually been registered for objects of the specified type. 
     * 
     * @param value
     * @throws ValidationException
     */
    
    public static 
    void validate (final Object value)
        throws ValidationException
    {
        final Class<?> type = value.getClass ();
        final ObjectValidator<?> v = getValidator (type);        
        v.validate (value);
        return;
    }
}

// EOF