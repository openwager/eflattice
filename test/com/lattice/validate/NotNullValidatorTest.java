package com.lattice.validate;

import org.testng.annotations.Test;

import java.util.Date;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

public class NotNullValidatorTest
        extends FieldValidatorTest<Bean1, Object>
{
    public
    FieldValidator<Bean1, Object> getValidator ()
            throws Exception
    {
        return new NotNullValidator<Bean1> (Bean1.class, "bean2", "boo");
    }

    @Test
    public
    void test1 ()
        throws Exception
    {
        final Bean1 b1 = new Bean1 ();
        final Bean1 b2 = new Bean1 ("foo", new Date(), Color.RED, new Bean2 ());

        // test negative
        test (b1, false);

        // test positive
        test (b2, true);

        return;
    }

    
}

// EOF