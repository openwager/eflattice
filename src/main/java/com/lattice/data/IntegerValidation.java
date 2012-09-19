package com.lattice.data;

import java.lang.annotation.*;

/**
 * 
 * @author crawford
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IntegerValidation
{
	boolean nullable () default true; 
	int [] minValue () default { }; 
	int [] maxValue () default { }; 
	String errmsg (); 
}

// EOF