package com.lattice.data;

import java.lang.annotation.*;

/**
 * 
 * @author crawford
 *
 */

@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.FIELD)
public @interface StringValidation
{
	boolean nullable () default true; 
	int [] minLength () default { }; 
	int [] maxLength () default { }; 
	String regex () default ""; 
	String errmsg (); 
}

// EOF