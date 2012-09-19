package com.lattice.validate;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

@SuppressWarnings("serial")
public class NotNullValidator<OwnerType>
    extends FieldValidator<OwnerType, Object>
{
    /**
     *
     * @param atype
     * @param field
     * @throws SecurityException
     * @throws NoSuchFieldException
     */

    public
    NotNullValidator (final Class<OwnerType> atype, final String field, final String errmsg)
        throws SecurityException, NoSuchFieldException
    {
        super (atype, Object.class, field);
        this.errmsg = errmsg;  
        return;
    }
    
    protected String errmsg;
    public String getErrmsg () { return this.errmsg; } 

    @Override
    public void validate (final Object value)
        throws ValidationException
    {
        if (null == value) {
            throw new ValidationException (value, this, errmsg);
        }
        return;
    }
}
// EOF