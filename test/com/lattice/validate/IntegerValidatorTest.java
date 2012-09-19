package com.lattice.validate;

import org.testng.annotations.Test;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

public class IntegerValidatorTest
    extends FieldValidatorTest <Bean2, Integer>
{
    public
    FieldValidator<Bean2, Integer> getValidator ()
        throws Exception
    {
        return new IntegerValidator<Bean2> (Bean2.class, "weight", false, 10, 20, "boo");
    }

    @Test
    public
    void test1 ()
        throws Exception
    {
        final Bean2 b = new Bean2 ();
        final Integer [] yes = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        final Integer [] no = { null, -1, 0, 1, 21, 22, 23 } ;

        // works
        for (Integer val : yes) {
            b.setWeight (val);
            test (b, true);
        }

        // fails
        for (Integer val : no) {
            b.setWeight (val);
            test (b, false);
        }

        return;
    }
}

// EOF