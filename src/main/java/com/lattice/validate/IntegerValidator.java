package com.lattice.validate;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

@SuppressWarnings("serial")
public class IntegerValidator<OwnerType>
    extends FieldValidator<OwnerType, Integer>
{
    public
    IntegerValidator (final Class<OwnerType> otype, final String fieldName, final boolean nullable, final Integer minValue, final Integer maxValue, final String errmsg)
        throws NoSuchFieldException
    {
            super (otype, Integer.class, fieldName);
            this.nullable = nullable;
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.errmsg = errmsg; 
            return;
    }

    protected String errmsg; 
    public String getErrmsg () { return this.errmsg; } 
    
    protected boolean nullable;
    public boolean getNullable () { return this.nullable; } 
   
    protected Integer minValue;
    public Integer getMinValue () { return this.minValue; } 
    
    protected Integer maxValue;
    public Integer getMaxValue () { return this.maxValue; } 
    
    @Override
    public void validate (final Integer value)
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