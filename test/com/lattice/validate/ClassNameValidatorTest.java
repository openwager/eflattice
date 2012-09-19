package com.lattice.validate;

import org.testng.annotations.Test;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

public class ClassNameValidatorTest
        extends FieldValidatorTest <Bean1, String>
{
    public
    FieldValidator<Bean1, String> getValidator ()
            throws Exception
    {
        return new ClassNameValidator<Bean1> (Bean1.class, "name", null);
    }

    @Test
    public
    void test1()
        throws Exception
    {
        final Bean1 b1 = new Bean1 ("bogus", null, null, null);
        final Bean1 b2 = new Bean1 ("java.lang.String", null, null, null);

        test (b2, true);
        test (b1, false);
        return;
    }
}

// EOF