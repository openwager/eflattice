package com.lattice.validate;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

public class Bean3ValidatorTest
{
    @Test
    public
    void test1 ()
         throws Exception
    {
        final Weasel weasel = new Weasel ();
        try {
            ValidatorUtil.validate (weasel);
            fail ("Shouldn't have validated."); 
        }
        catch (final NoValidatorException nv_e) {
            // IGNORED
        }
        return; 
    }

    /**
     * A fake class for which there ought to be no validators.
     */

    public static final class Weasel
    {
        // EMPTY
    }
}

// EOF