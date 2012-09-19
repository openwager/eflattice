package com.lattice.data;

import com.lattice.validate.*;

/**
 * 
 * @author crawford
 *
 */

@CustomValidation (classes={ IntegerBean2.Bean1CustomValidation.class })
public class IntegerBean2
	extends IntegerBean
{
	public
	IntegerBean2 ()
	{
		return; 
	}
	
	public
	IntegerBean2 (final Integer width, final Integer height) 
	{
		setWidth (width); 
		setHeight (height); 
		return;
	}

	@SuppressWarnings("serial")
	public static class Bean1CustomValidation
		extends Validator<IntegerBean>
	{
		public
		Bean1CustomValidation ()
		{
			super (IntegerBean.class); 
			return;
		}

		@Override
	    public void validate (IntegerBean value)
	        throws ValidationException
	    {
			final int width = value.getWidth (); 
		    final int height = value.getHeight (); 
		    if (width * height > 100) { 
		    	throw new ValidationException (value, this, "width * height > 100"); 
		    } 
		    if ((width + height)  % 2 != 0) { 
		    	throw new ValidationException (value, this, "(width + height) is odd"); 
		    }
		    return;
	    }
	}
}

// EOF
