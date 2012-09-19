package com.lattice.validate;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

@SuppressWarnings("serial")
public class LongValidator<OwnerType>
    extends FieldValidator<OwnerType, Long>
{
    public
    LongValidator (final Class<OwnerType> otype, final String fieldName, final boolean nullable, final Long minValue, final Long maxValue, final String errmsg)
        throws NoSuchFieldException
    {
        super (otype, Long.class, fieldName);
        this.nullable = nullable;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.errmsg = errmsg; ;
        return;
    }
    
    protected String errmsg;
    public String getErrmsg () { return this.errmsg; } 

    protected boolean nullable;
    public boolean getNullable () { return this.nullable; } 

    protected Long minValue;
    public Long getMinValue () { return this.minValue; } 

    protected Long maxValue;
    public Long getMaxValue () { return this.maxValue; } 

    @Override
    public void validate (final Long value)
        throws ValidationException
    {
        if (value == null) {
            if (! nullable) {
                throw new ValidationException (value, this, errmsg);
            }
        } else {
            if (minValue != null) {
                if (value < minValue) {
                    throw new ValidationException (value, this, errmsg);
                }
            }
            if (maxValue != null) {
                if (value > maxValue) {
                    throw new ValidationException (value, this, errmsg);
                }
            }
        }

        return;
    }
}

// EOF