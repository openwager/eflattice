package com.lattice.validate;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

@SuppressWarnings("serial")
public class NoValidatorException
    extends ValidationException
{
    public
    NoValidatorException (final Object value, final Validator<?> validator, final String msg)
    {
        super (value, validator, msg);
        return;
    }
}

// EOF