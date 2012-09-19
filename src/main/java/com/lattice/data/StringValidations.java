package com.lattice.data;

import java.lang.annotation.*;

/**
 * 
 * @author crawford
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target (ElementType.FIELD)
public @interface StringValidations
{
	StringValidation [] validations (); 
}

// EOF