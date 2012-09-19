package com.lattice.data;

import org.testng.annotations.*;

/**
 * 
 * @author crawford
 *
 */

public class IntegerBeanTest
	extends BeanTest<IntegerBean>
{
	public
	IntegerBeanTest ()
		throws Exception
	{
		super (IntegerBean.class); 
		return; 
	}
	
	@Test(enabled=false)
	public void a () { }
	
	protected IntegerBean [] GOOD = {
			new IntegerBean (2, 3), 
			new IntegerBean (4, 4), 
			new IntegerBean (1000, 10), 
	};
	
	public
	IntegerBean [] getGood () 
	{
		return GOOD; 
	}
	
	protected IntegerBean [] BAD = { 
		new IntegerBean (), 
		new IntegerBean (4, null), 
		new IntegerBean (null, 4), 
		new IntegerBean (1, 4), 
		new IntegerBean (1001, 4), 
		new IntegerBean (4, 1), 
		new IntegerBean (4, 11)
	};
	
	public
	IntegerBean [] getBad ()
	{
		return BAD; 
	}
}

// EOF