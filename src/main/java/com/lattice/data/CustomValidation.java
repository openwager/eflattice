package com.lattice.data;

import java.lang.annotation.*;

import com.lattice.validate.*;

/**
 * 
 * @author crawford
 *
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface CustomValidation
{
	Class <? extends Validator<?>> [] classes (); 
}

// EOF
