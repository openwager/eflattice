package com.lattice.data;

import com.lattice.validate.*;

/**
 * 
 * @author crawford
 *
 */

@SuppressWarnings("serial")
public class PrettyColorValidation <OwnerType>
	extends FieldValidator<OwnerType, Color>
{
	public
	PrettyColorValidation (final Class<OwnerType> otype, final String fname)
		throws Exception
	{
		super (otype, Color.class, fname); 
		return; 
	}

	@Override
    public void validate (final Color color)
        throws ValidationException
    {
		switch (color) { 
			case RED: 
			case PINK: 
				return; 
			default: 
				throw new ValidationException (color, this, "Not a pretty color!"); 
		}
		// NOT REACHED
    }
}

// EOF