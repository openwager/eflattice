package com.lattice.validate;

import java.util.regex.*;

import com.weaselworks.util.*;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

@SuppressWarnings("serial")
public class StringValidator<OwnerType>
    extends FieldValidator<OwnerType, String>
{
    public
    StringValidator (final Class<OwnerType> otype, final String fieldName, final boolean nullable, final Integer minLength, final Integer maxLength, final String regex, final String errmsg)
        throws NoSuchFieldException
    {
        super (otype, String.class, fieldName);
        this.nullable = nullable;
        this.minLength = minLength;
        this.maxLength = maxLength;
        if (! StringUtil.isEmpty (regex)) {
        	this.pattern = Pattern.compile (regex); 
        }
        this.errmsg = errmsg; 
        return;
    }

    protected boolean nullable;
    public boolean getNullable () { return this.nullable; } 
    
    protected Integer minLength;
    public Integer getMinLength () { return this.minLength; } 
    
    protected Integer maxLength;
    public Integer getMaxLength () { return this.maxLength; } 
    
    protected Pattern pattern;
    public Pattern getPattern () { return this.pattern; } 
    
    protected String errmsg;
    public String getErrmsg () { return this.errmsg; } 

    @Override
    public void validate (final String value)
        throws ValidationException
    {
        if (null == value) {
            if (! nullable) {
                throw new ValidationException (value, this, errmsg);
            }
        } else {
            if (minLength != null) {
                if (value.length () < minLength) {
                    throw new ValidationException (value, this, errmsg);
                }
            }
            if (maxLength != null) {
                if (value.length () > maxLength) {
                    throw new ValidationException (value, this, errmsg);
                }
            }
            if (pattern != null) {
            	if (! pattern.matcher (value).matches ()) {
                    throw new ValidationException (value, this, errmsg);
                }
            }
        }
        return;
    }
}

// EOF