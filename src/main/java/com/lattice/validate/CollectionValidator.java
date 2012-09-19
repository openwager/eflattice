package com.lattice.validate;

import java.util.*;

/**
 * 
 * @author crawford
 *
 * @param <OwnerType>
 */

@SuppressWarnings({ "serial", "unchecked" })
public class CollectionValidator<OwnerType>
	extends FieldValidator<OwnerType, Collection>
{
	public
	CollectionValidator (final Class<OwnerType> otype, final String fname, final Integer minItems, final Integer maxItems, final String errmsg)
		throws SecurityException, NoSuchFieldException
	{
		super (otype, Collection.class, fname); 
		this.minItems = minItems; 
		this.maxItems = maxItems; 
		this.errmsg = errmsg; 
		return; 		
	}
	
	protected Integer minItems; 
	protected Integer maxItems; 
	protected String errmsg; 

    @Override
	public 
	void validate (final Collection value)
	    throws ValidationException
	{
        if (minItems != null) {
            if (value.size () < minItems) {
                throw new ValidationException (value, this, errmsg);
            }
        }
        if (maxItems != null) {
            if (value.size () > maxItems) {
                throw new ValidationException (value, this, errmsg);
            }
        }
	    return;
	}
}

// EOF
