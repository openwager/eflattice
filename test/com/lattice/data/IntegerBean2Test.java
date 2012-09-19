package com.lattice.data;

import org.testng.annotations.*;

/**
 * 
 * @author crawford
 *
 */

public class IntegerBean2Test
	extends BeanTest<IntegerBean2>
{
	public
	IntegerBean2Test ()
		throws Exception
	{
		super (IntegerBean2.class); 
		return;  
	}

	@Test(enabled=false)
	public void a () { }
	
	protected static final IntegerBean2 [] GOOD = {
		new IntegerBean2 (24, 4),		
	};
	
	public 
	IntegerBean2 [] getGood () 
	{ 
		return GOOD; 
	}
	
	protected static final IntegerBean2 [] BAD = { 
		new IntegerBean2 (25, 5)
	};		
	
	public
	IntegerBean2 [] getBad ()
	{
		return BAD; 
	}
}

// EOF