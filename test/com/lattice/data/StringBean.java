package com.lattice.data;

/**
 * 
 * @author crawford
 *
 */

public class StringBean
	extends Bean
{
	public
	StringBean ()
	{
		return; 
	}
	
	public
	StringBean (final String name, final String phoneNumber)
	{
		setName (name); 
		setPhoneNumber (phoneNumber); 
		return; 
	}
	
	@StringValidations (validations={
		@StringValidation (nullable=false, errmsg="Must be specified."),
		@StringValidation (minLength=3, errmsg="Must be 3 or more characters"), 
		@StringValidation (maxLength=32, errmsg="Must be 32 or fewer characters"), 
		@StringValidation (regex="[a-zA-Z ]*", errmsg="Illegal characters used.")
	})
	protected String name;
	public String getName () { return this.name; } 
	public void setName (final String name) { this.name = name; return; } 
	
	@StringValidation (nullable=false, regex="\\d{3}-\\d{4}", errmsg="must be of format xxx-xxxx")
	protected String phoneNumber;
	public String getPhoneNumber () { return this.phoneNumber; }
	public void setPhoneNumber (final String phoneNumber) { this.phoneNumber = phoneNumber; return; } 
}

// EOF