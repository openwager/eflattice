package com.lattice.data;

import org.testng.annotations.*;

/**
 * 
 * @author crawford
 *
 */

public class CompositeBeanTest
	extends BeanTest <CompositeBean>
{
	public
	CompositeBeanTest ()
		throws Exception
	{
		super (CompositeBean.class); 
		return; 
	}
	
	interface INTEGER_BEAN {
		public final IntegerBean GOOD = new IntegerBean (3, 5); 
		public final IntegerBean BAD = new IntegerBean (1, 15); 
	}
	interface LONG_BEAN { 
		public final LongBean GOOD = new LongBean (5L, 4L); 
		public final LongBean BAD = new LongBean (1L, null); 
	}
	interface COLOR_BEAN { 
		public final ColorBean GOOD = new ColorBean (Color.RED);
		public final ColorBean BAD = new ColorBean ();  
	}
	interface STRING_BEAN { 
		public final StringBean GOOD = new StringBean ("Leeroy", "123-1234"); 
		public final StringBean BAD = new StringBean ("Ed", "234-2345");  
	}
	

	@Test(enabled=false)
	public void a () { }

	private static final CompositeBean GOOD [] = {
		new CompositeBean (INTEGER_BEAN.GOOD, LONG_BEAN.GOOD, STRING_BEAN.GOOD, COLOR_BEAN.GOOD)
	}; 
	
	@Override
    CompositeBean[] getGood ()
    {
	    return GOOD; 
    }

	private static final CompositeBean BAD [] = { 
		new CompositeBean (null, null, null, null),		
		new CompositeBean (null, LONG_BEAN.GOOD, STRING_BEAN.GOOD, COLOR_BEAN.GOOD),
		new CompositeBean (INTEGER_BEAN.GOOD, null, STRING_BEAN.GOOD, COLOR_BEAN.GOOD),
		new CompositeBean (INTEGER_BEAN.GOOD, LONG_BEAN.GOOD, null, COLOR_BEAN.GOOD),
		new CompositeBean (INTEGER_BEAN.GOOD, LONG_BEAN.GOOD, STRING_BEAN.GOOD, null),
		new CompositeBean (INTEGER_BEAN.BAD, LONG_BEAN.GOOD, STRING_BEAN.GOOD, COLOR_BEAN.GOOD),
		new CompositeBean (INTEGER_BEAN.GOOD, LONG_BEAN.BAD, STRING_BEAN.GOOD, COLOR_BEAN.GOOD),
		new CompositeBean (INTEGER_BEAN.GOOD, LONG_BEAN.GOOD, STRING_BEAN.BAD, COLOR_BEAN.GOOD),
		new CompositeBean (INTEGER_BEAN.GOOD, LONG_BEAN.GOOD, STRING_BEAN.GOOD, COLOR_BEAN.BAD)
	};
	
	@Override
	CompositeBean[] getBad ()
    {
	    return BAD; 
    }
}

// EOF
