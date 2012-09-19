package com.lattice.validate;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

public interface Validateable
{
    /**
     *
     * @throws ValidationException
     */

    public
    void validate ()
        throws ValidationException;
}

// EOF