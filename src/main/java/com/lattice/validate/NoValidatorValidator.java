package com.lattice.validate;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

@SuppressWarnings("serial")
class NoValidatorValidator<Type>
	extends ObjectValidator<Type>
{
    public
    NoValidatorValidator (final Class<Type> type)
    {
        super (type); 
        return;
    }

    public
    void validate (final Object obj)
        throws ValidationException
    {
        throw new NoValidatorException (obj, this, "No Validator found."); 
    }
}

// EOF