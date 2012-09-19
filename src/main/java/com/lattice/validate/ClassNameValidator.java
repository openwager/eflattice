package com.lattice.validate;

import com.weaselworks.util.*;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

@SuppressWarnings("serial")
public class ClassNameValidator<OwnerType>
    extends FieldValidator<OwnerType, String>
{
    public
    ClassNameValidator (Class<OwnerType> otype, String fieldName, Class<?> implementedInterface)
        throws SecurityException, NoSuchFieldException
    {
        super (otype, String.class, fieldName);
        this.implementedInterface = implementedInterface;
        return;
    }

    private Class<?> implementedInterface;

    @Override
    public
    void validate (final String input)
        throws ValidationException
    {
        if (! StringUtil.isEmpty (input)) {
            try {
        		final ClassLoader cl = Thread.currentThread ().getContextClassLoader ();
        		final Class<?> c = cl.loadClass (input);
                if (implementedInterface != null) { 
                	if (! ClassUtil.implementsInterface (c, implementedInterface)) {
                		throw new ValidationException (input, this, "Class must implement " + implementedInterface.toString ());
                	}
                }
            }
            catch (ClassNotFoundException e) {
                throw new ValidationException (input, this, "Class not found: " + input);
            }
        }

        return;
    }
}

// EOF