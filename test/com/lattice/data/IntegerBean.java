package com.lattice.data;

/**
 * 
 * @author crawford
 *
 */

public class IntegerBean
	extends Bean
{
	public
	IntegerBean ()
	{
		return; 
	}

	public
	IntegerBean (final Integer width, final Integer height) 
	{
		setWidth (width); 
		setHeight (height); 
		return; 
	}
	
	@IntegerValidation (nullable=false, minValue=2, maxValue=1000, errmsg="Invalid amount (2 < i < 1000)")
	protected Integer width; 
	public Integer getWidth () { return this.width; } 
	public void setWidth (final Integer width) { this.width = width; return; } 
	
	@IntegerValidation (nullable=false, minValue=3, maxValue=10, errmsg="Invalid amount (3 < i < 10)")
	protected Integer height;
	public Integer getHeight () { return this.height; }
	public void setHeight (final Integer height) { this.height = height; return; } 
}

// EOF