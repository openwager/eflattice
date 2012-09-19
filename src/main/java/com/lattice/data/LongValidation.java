package com.lattice.data;

import java.lang.annotation.*;

/**
 * 
 * @author crawford
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface LongValidation
{
	boolean nullable () default true; 
	long [] minValue () default { }; 
	long [] maxValue () default { }; 
	String errmsg (); 
}

// EOF
