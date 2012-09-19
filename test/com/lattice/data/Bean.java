package com.lattice.data;

import com.lattice.validate.*;
import com.weaselworks.util.*;

/**
 * 
 * @author crawford
 *
 */

abstract class Bean	
	implements Validateable
{
	public 	
	Bean ()
	{
		return; 
	}
	
	/**
	 * @see Validateable#validate()
	 */
	
    public void validate ()
        throws ValidationException
    {
	    ValidatorUtil.validate (this); 
	    return; 	    
    }
	
	@Override
	public
	String toString ()
	{
		return StringUtil.toString (this); 
	}
}

// EOF