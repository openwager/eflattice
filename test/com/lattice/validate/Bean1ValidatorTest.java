package com.lattice.validate;

import org.testng.annotations.Test;

import java.util.Date;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

public class Bean1ValidatorTest
        extends ObjectValidatorTest <Bean1>
{
   public
   Bean1ValidatorTest ()
        throws NoSuchFieldException
   {
       super (Bean1.class);
       return;
   }

    @Test
    public
    void test1 ()
        throws Exception
    {
        final Bean1 b = new Bean1 ();
        test (b, false);

        final Bean1 b1 = new Bean1 ("fred", new Date(), Color.RED, null);
        test (b1, false);

        final Bean2 b2 = new Bean2 (0, 0L);
        b1.setBean2 (b2); 
        test (b1, true);

        final Bean2 b3 = new Bean2 (1, 1L);
        b1.setBean2 (b3);
        test (b1, true); 

        return;
    }

}

// EOF