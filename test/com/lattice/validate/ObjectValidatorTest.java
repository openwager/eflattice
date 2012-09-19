package com.lattice.validate;

import static org.testng.Assert.*;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

public class ObjectValidatorTest<Type>
{
    public
    ObjectValidatorTest (final Class<Type> type)
        throws NoSuchFieldException
    {
        final ObjectValidator<Type> v = getValidator ();
        if (v != null) {
            ValidatorUtil.setValidator (type, v);
        }
        return;
    }
    
    /**
     *
     * @return
     * @throws Exception
     */

    protected
    ObjectValidator<Type> getValidator ()
        throws NoSuchFieldException
    {
        return null;
    }

    /**
     *
     * @param value
     * @param succeeds
     * @throws Exception
     */

    public
    void test (final Type value, final boolean succeeds)
            throws Exception
    {
        try {
            System.err.println ("VALIDATING [" + value + "] expecting [" + succeeds + "]");
            ValidatorUtil.validate (value);
            if (! succeeds) {
                fail ("Validation shoulnd't have succeeded.");
            }
        }
        catch (final ValidationException v_e) {
            if (succeeds) {
                throw v_e; 
            }
        }

        return;
    }
}

// EOF