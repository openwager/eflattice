package com.lattice.data;

/**
 * 
 * @author crawford
 *
 */

public class LongBean
	extends Bean
{
	public
	LongBean ()
	{
		return; 
	}

	public
	LongBean (final Long value, final Long anotherValue)
	{
		setValue (value); 
		setAnotherValue (anotherValue); 
		return; 
	}
	
	@LongValidations (validations={ 
		@LongValidation (minValue=3, errmsg="3 is the min"), 
		@LongValidation (maxValue=6, errmsg="6 is the max"),
		@LongValidation (nullable=false, errmsg="no null!")
	})
	protected Long value;
	public Long getValue () { return this.value; }
	public void setValue (final Long value) { this.value = value; return; } 

	@NotNull (errmsg="dont make me null")
	protected Long anotherValue; 
	public Long getAnotherValue () { return this.anotherValue; } 
	public void setAnotherValue (final Long anotherValue) { this.anotherValue = anotherValue; return; } 
}

// EOF