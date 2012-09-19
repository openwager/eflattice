package com.lattice.validate;

//import org.apache.log4j.*;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

@SuppressWarnings("serial")
public class ObjectFieldValidator<OwnerType, FieldType>
        extends FieldValidator<OwnerType, FieldType>
{
//	private static final Logger logger = Logger.getLogger (ObjectFieldValidator.class); 
	
    public
    ObjectFieldValidator (final Class<OwnerType> otype, final Class<FieldType> ftype, final String field, final boolean nullable, final String errmsg)
        throws NoSuchFieldException
    {
        super (otype, ftype, field);
        this.errmsg = errmsg; 
        this.nullable = nullable; 
        return; 
    }
    
    protected String errmsg; 
    public String getErrmsg () { return this.errmsg; } 
    public void setErrmsg (final String errmsg) { this.errmsg = errmsg; return; } 
    
    protected boolean nullable;
    public boolean getNullable () { return this.nullable; }
    public void setNullable (final boolean nullable) { this.nullable = nullable; return; }

    /**
     * @see com.lattice.validate.Validateable#validate()
     */

    public
    void validate (final FieldType value)
        throws ValidationException
    {
        if (value == null) {
            if (! nullable) {
                throw new ValidationException (value, this, errmsg);
            }
        } else { 
            try { 
            	ValidatorUtil.validate (value);            	
            }
            catch (final ValidationException v_e) { 
            	if (errmsg != null) { 
            		throw new ValidationException (value, this, errmsg); 
            	} else { 
            		throw v_e; 
            	}
            }
        }
        return;
    }
}


// EOF