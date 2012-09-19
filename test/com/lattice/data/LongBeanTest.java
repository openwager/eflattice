package com.lattice.data;

import org.testng.annotations.*;

/**
 * 
 * @author crawford
 *
 */

public class LongBeanTest
	extends BeanTest<LongBean>
{
	public
	LongBeanTest ()	
		throws Exception
	{
		super (LongBean.class); 
		return; 
	}

	@Test(enabled=false)
	public void a () { }

	@Override
    LongBean[] getGood ()
    {
	    return GOOD; 
    }

	private static final LongBean [] GOOD = { 
		new LongBean (3L, 1L), 
		new LongBean (4L, 1L), 
		new LongBean (6L, 1L)
	};
	
	@Override
    LongBean[] getBad ()
    {
		return BAD;
    }

	private static final LongBean [] BAD = {
		new LongBean (null, 1L),
		new LongBean (3L, null),
		new LongBean (0L, 1L), 
		new LongBean (7L, 1L)
	};
}

// EOF 