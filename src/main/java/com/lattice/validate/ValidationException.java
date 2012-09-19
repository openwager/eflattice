package com.lattice.validate;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

@SuppressWarnings("serial")
public class ValidationException
    extends Exception
{
    public
    ValidationException (final Object value, final Validator<?> validator, final String msg)
    {
    	this (value, validator, msg, null); 
        return;
    }

    public
    ValidationException (final Object value, final Validator<?> validator, final String msg, final Throwable cause)
    {
    	super (msg, cause); 
        setValue (value);
        setValidator (validator);
        return; 
    }

    public
    ValidationException (final Object obj, final Object value, final Validator<?> validator, final String msg)
    {
    	this (obj, value, validator, msg, null); 
    	return; 
    }
    
    public
    ValidationException (final Object obj, final Object value, final Validator<?> validator, final String msg, final Throwable cause)
    {
        super (msg, cause);
        setValue (value);
        setObject (obj); 
        setValidator (validator);
        return;
    }

    protected Validator<?> validator;
    public Validator<?> getValidator () { return this.validator; }
    protected void setValidator (final Validator<?> validator) { this.validator = validator; return; }

    protected Object object;
    public Object getObject () { return this.object; }
    protected void setObject (final Object object) { this.object = object; return; }

    protected Object value;
    public Object getValue () { return this.value; }
    protected void setValue (final Object value) { this.value = value; return; }    
}

// EOF
