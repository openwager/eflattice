package com.lattice.data;

import java.lang.annotation.*;

import com.lattice.validate.*;

/**
 * 
 * @author crawford
 *
 */

@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.FIELD)
public @interface CustomFieldValidation
{
	@SuppressWarnings("rawtypes")
	Class<? extends FieldValidator> [] classes (); 
}

// EOF
