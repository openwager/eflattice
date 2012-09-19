package com.lattice.validate;

import java.io.Serializable;

import com.weaselworks.util.*;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

@SuppressWarnings("serial")
abstract public class Validator<Type>
    implements Serializable
{
    public
    Validator (final Class<Type> type)
    {
        setType (type);
        return;
    }

    protected Class<Type> type;
    public Class<Type> getType () { return this.type; }
    protected void setType (final Class<Type> type) { this.type = type; return; }

    /**
     *
     * @param value
     * @throws ValidationException
     */

    abstract public
    void validate (final Type value)
        throws ValidationException;

    public
    boolean isValid (final Type value)
    {
        try {
            validate (value);
            return true;
        }
        catch (final ValidationException v_e) {
            return false;

        }
        // NOT REACHED
    }

    @Override
    public
    String toString ()
    {
    	return StringUtil.toString (this); 
    }
}

// EOF
