package com.lattice.validate;

import static org.testng.Assert.*;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

abstract public class FieldValidatorTest<BaseType, FieldType>
{
    /**
     * 
     * @return
     * @throws Exception
     */

    abstract public
    FieldValidator<BaseType, FieldType> getValidator ()
            throws Exception;

    /**
     *
     * @param value
     * @param succeeds
     * @throws Exception
     */

    public
    void test (final BaseType value, final boolean succeeds)
            throws Exception
    {
        try {
            System.err.println ("VALIDATING [" + value + "] expecting [" + succeeds + "]"); 
            getValidator ().validateOn (value);
            if (! succeeds) {
                fail ("Validation shoulnd't have succeeded.");
            }
        }
        catch (final ValidationException v_e) {
            if (succeeds) {
                fail ("Validation should have succeeded.");
            }
        }
        
        return;
    }
}

// EOF