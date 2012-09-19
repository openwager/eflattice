package com.lattice.util;

import org.testng.annotations.Test;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

public class PropertiedSupportTest
{
    @Test
    public
    void test1 ()
    {
        final Bean bean = new Bean ();
        bean.setProperty ("a", "b");
        bean.setProperty ("c", "d");
        bean.setProperty ("e", "f");
        System.out.println (bean); 
        return; 
    }

    @Test
    public
    void testSet ()
    {
    	
    }
    
    @Test
    public 
    void testRemove ()
    {
    	
    }
    
}

// EOF