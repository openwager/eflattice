package com.lattice.validate;

import org.testng.annotations.Test;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

public class StringValidatorTest
        extends FieldValidatorTest<Bean1, String>
{
    public
    FieldValidator<Bean1, String> getValidator ()
        throws Exception
    {
        return new StringValidator<Bean1> (Bean1.class, "name", false, 3, 6, "[abcdefg]*", "boo");
    }

    @Test
    public
    void test1 ()
        throws Exception
    {
        final Bean1 b = new Bean1 (); 
        final String [] yes = { "abc", "abcd", "abcde", "abcdef"};
        final String [] no = { null, "a", "aa", "hhh", "abcabcabc" };

        // works
        for (String val : yes) {
            b.setName (val);
            test (b, true);
        }

        // fails
        for (String val : no) {
            b.setName (val);
            test (b, false);
        }

        return; 
    }
}

// EOF