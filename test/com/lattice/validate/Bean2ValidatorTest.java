package com.lattice.validate;

import org.testng.annotations.Test;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

public class Bean2ValidatorTest
    extends ObjectValidatorTest<Bean2>
{
    public
    Bean2ValidatorTest ()
        throws NoSuchFieldException
    {
        super (Bean2.class);
        return;
    }

    @Test
    public
    void test1 ()
        throws Exception
    {
        @SuppressWarnings("unused")
		final ObjectValidator<Bean2> v = new Bean2Validator ();
        final Bean2 b1 = new Bean2 ();
        test (b1, false);
        final Bean2 b3 = new Bean2 (0, 0L);
        test (b3, false);

        final Bean2 b2 = new Bean2 (1, 1L);
        test (b2, true); 

        return;
    }
}

// EOF