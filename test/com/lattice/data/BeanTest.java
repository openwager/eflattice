package com.lattice.data;

import static org.testng.Assert.*;

import org.testng.annotations.*;

import com.lattice.validate.*;

/**
 * 
 * @author crawford
 *
 * @param <Type>
 */

abstract public class BeanTest<Type>
{
	protected
	BeanTest (final Class<Type> type)
		throws Exception
	{
		assert type != null; 
		this.type = type; 
		this.validator = ValidatorUtil.getValidator (type);   
		return; 
	}
		
	@BeforeSuite (alwaysRun=true)
	public
	void dumpValidator ()
		throws ValidationException
	{
		final ObjectValidator<Type> validator = (ObjectValidator<Type>) ValidatorUtil.getValidator (type); 
		assertNotNull (validator); 
		ObjectValidatorUtil.dump (type, validator, System.err); 
		return; 
	}
	
	protected Class<Type> type;
	protected ObjectValidator<Type> validator; 

	abstract 
	Type  [] getGood (); 

	abstract 
	Type [] getBad (); 
	
	@Test (alwaysRun=true)
	public
	void validate ()
	{
		for (final Type b : getGood ()) { 
			validate (b, true); 
		}
		for (final Type b : getBad ()) { 
			validate (b, false); 
		}
		return; 
	}
	
	/**
	 * 
	 * @param bean
	 * @param isValid
	 */
	
	public 
	void validate (final Type bean, final boolean isValid)
	{
		try {
			System.err.println ("VALIDATING: " + bean); 
			System.err.println ("  EXPECT: " + (isValid ? "  VALID" : "INVALID")); 
			validator.validate (bean);
			System.err.println ("  RESULT:   VALID");  
			if (! isValid) { 
				fail ("Shouldn't be valid.");  
			}
		} catch (final ValidationException v_e) {
			System.err.println ("  RESULT: INVALID (" + v_e.getMessage () + ")"); 
			if (isValid) { 
				fail ("Should be valid."); 
			}
		}
		
		return; 
	}
}

// EOF