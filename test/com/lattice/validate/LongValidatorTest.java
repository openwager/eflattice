package com.lattice.validate;

import org.testng.annotations.Test;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

public class LongValidatorTest
    extends FieldValidatorTest <Bean2, Long>
{
    public
    FieldValidator<Bean2, Long> getValidator ()
        throws Exception
    {
        return new LongValidator<Bean2> (Bean2.class, "height", false, 10L, 20L, "boo");
    }

    @Test
    public
    void test1 ()
        throws Exception
    {
        final Bean2 b = new Bean2 ();
        final Long [] yes = { 10L, 11L, 12L, 13L, 14L, 15L, 16L, 17L, 18L, 19L, 20L};
        final Long [] no = { null, -1L, 0L, 1L, 21L, 22L, 23L } ;

        // works
        for (Long val : yes) {
            b.setHeight (val);
            test (b, true);
        }

        // fails
        for (Long val : no) {
            b.setHeight (val);
            test (b, false);
        }

        return;
    }
}

// EOF