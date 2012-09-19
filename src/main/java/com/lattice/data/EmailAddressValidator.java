package com.lattice.data;

import java.util.regex.*;

import com.lattice.validate.*;
import com.weaselworks.util.*;


/**
 * 
 * @author crawford
 *
 */

@SuppressWarnings("serial")
public class EmailAddressValidator <OwnerType>
	extends FieldValidator<OwnerType, String>
{
	public
	EmailAddressValidator (final Class<OwnerType> owner, final Class<String> fieldType, final String field)
		throws NoSuchFieldException
	{
		super (owner, fieldType, field); 
		return ;
	}

	/**
	 * Contains the regular expression for a valid email address
	 */
	
    public static final String EMAIL_REGEX = "[^\\@\\.][^\\@]*@([a-zA-Z\\d-]{1,63}\\.)*[a-zA-Z]{2,6}";
    
    /** 
     * Pre-compiled version of the regular expression for testing. 
     */
    
    protected static final Pattern pattern = Pattern.compile (EMAIL_REGEX);
    
	@Override
    public void validate (final String value)
        throws ValidationException
    {
		if (! StringUtil.isEmpty (value)) { 
			final Matcher m = pattern.matcher (value); 
			if (! m.matches ()) { 
				throw new ValidationException (value, this, "Not a valid email address."); 
			}
		}
		return; 
    }
}

// EOF