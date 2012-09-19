package com.lattice.data;

import java.lang.annotation.*;

/**
 * 
 * @author crawford
 *
 */

@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.FIELD)
public @interface ObjectValidation
{
	boolean nullable () default true; 
	String [] errmsg () default { };  
}

// EOF