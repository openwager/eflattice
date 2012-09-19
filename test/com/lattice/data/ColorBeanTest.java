package com.lattice.data;

import org.testng.annotations.*;

/**
 * 
 * @author crawford
 *
 */

public class ColorBeanTest
	extends BeanTest<ColorBean>
{
	public
	ColorBeanTest ()
		throws Exception
	{
		super (ColorBean.class); 
		return; 
	}

	@Test(enabled=false)
	public void a () { }

	private static final ColorBean GOOD [] = {
		new ColorBean (Color.RED),
		new ColorBean (Color.PINK)
	}; 

	private static final ColorBean BAD [] = { 
		new ColorBean (), 
		new ColorBean (Color.BLUE),
		new ColorBean (Color.GREEN),
		new ColorBean (Color.ORANGE),
		new ColorBean (Color.YELLOW),
	};

	@Override
    ColorBean[] getBad ()
    {
	    return BAD; 
    }

	@Override
    ColorBean[] getGood ()
    {
	    return GOOD; 
    }

}

// EOF
