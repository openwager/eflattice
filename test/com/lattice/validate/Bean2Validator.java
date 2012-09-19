package com.lattice.validate;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

@SuppressWarnings("serial")
public class Bean2Validator
    extends ObjectValidator <Bean2>
{
    public
    Bean2Validator ()
        throws NoSuchFieldException
    {
        super (Bean2.class);
        init ();
        return;
    }

    /**
     * 
     * @throws NoSuchFieldException
     */

    protected
    void init ()
        throws NoSuchFieldException
    {
        // weight
        final IntegerValidator<Bean2> weightValidator = new IntegerValidator<Bean2> (Bean2.class, "weight", false, 1, 250, "boo");
        addValidator (weightValidator); 
        // height
        final LongValidator<Bean2> heightValidator = new LongValidator <Bean2> (Bean2.class, "height", false, 1L, 100L, "boo" );
        addValidator (heightValidator);
        return;
    }
}

// EOF