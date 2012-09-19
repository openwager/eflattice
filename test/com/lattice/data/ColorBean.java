package com.lattice.data;


/**
 * 
 * @author crawford
 *
 */

public class ColorBean
	extends Bean
{
	public
	ColorBean ()
	{
		return; 
	}
	
	public
	ColorBean (final Color color)
	{
		setColor (color); 
		return; 
	}
	
	@NotNull (errmsg="Color must be specified.")
	@CustomFieldValidation (classes= { PrettyColorValidation.class })
	protected Color color; 
	public Color getColor () { return this.color; } 
	public void setColor (final Color color) { this.color = color; return; } 
}

// EOF