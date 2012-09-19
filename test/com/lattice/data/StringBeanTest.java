package com.lattice.data;

import org.testng.annotations.*;

import com.weaselworks.util.*;

/**
 * 
 * @author crawford
 *
 */

public class StringBeanTest
	extends BeanTest<StringBean> 
{
	public
	StringBeanTest ()
		throws Exception
	{
		super (StringBean.class); 
		return; 
	}

	@Test(enabled=false)
	public void a () { }
	
	private static final StringBean [] BAD = { 
		new StringBean (null, null), 
		new StringBean ("Leeroy", null), 
		new StringBean (null, "123-1234"),
		new StringBean ("Leeroy", "123-123"), 
		new StringBean ("", "123-1234"), 
		new StringBean ("12", "123-1234")
	};
	
	@Override
    StringBean [] getBad ()
    {
		return BAD; 
    }
	
	private static final StringBean [] GOOD = {
		new StringBean ("Leeroy", "123-1234"), 
		new StringBean ("Lee", "123-1234"), 
		new StringBean (StringUtil.repeat ("ab", 16), "123-1234")
	}; 

	@Override
    StringBean [] getGood ()
    {
	    return GOOD; 
    }	
}

// EOF