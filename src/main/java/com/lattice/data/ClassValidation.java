package com.lattice.data;

import java.lang.annotation.*;

/**
 * An annotation used to require that a field refers to a
 * defined class type. Optionally permits ensuring that the 
 * underlying class implements a given interface. 
 * 
 * @author crawford
 *
 */

@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.FIELD)
public @interface ClassValidation
{
    Class<?> instanceOf ();
}

// EOF