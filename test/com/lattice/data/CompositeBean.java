package com.lattice.data;

/**
 * 
 * @author crawford
 *
 */

public class CompositeBean
	extends Bean 
{
	public
	CompositeBean ()
	{
		return; 
	}
	
	public
	CompositeBean (final IntegerBean ibean, final LongBean lbean, final StringBean sbean, final ColorBean cbean)
	{
		this.ibean = ibean; 
		this.lbean = lbean; 
		this.sbean = sbean; 
		this.cbean = cbean; 
		return; 
	}
	
	@NotNull (errmsg="IntegerBean can't be null")
	@ObjectValidation
	protected IntegerBean ibean;
	public IntegerBean getIntegerBean () { return this.ibean; } 
	public void setIntegerBean (final IntegerBean ibean) { this.ibean = ibean; return; } 
	
	@ObjectValidation (nullable=false)
	protected LongBean lbean;
	public LongBean getLongBean () { return this.lbean; } 
	public void setLongBean (final LongBean lbean) { this.lbean = lbean; return; } 
	
	@ObjectValidation (nullable=false, errmsg="Bad StringBean")
	protected StringBean sbean;
	public StringBean getStringBean () { return this.sbean; } 
	public void setStringBean (final StringBean sbean) { this.sbean = sbean; return; } 
	
	@NotNull (errmsg="ColorBean can't be null")
	@ObjectValidation (errmsg="Bad Colorbean")
	protected ColorBean cbean;
	public ColorBean getColorBean () { return this.cbean; } 
	public void setColorBean (final ColorBean cbean) { this.cbean = cbean; return; } 	
}

// EOF
