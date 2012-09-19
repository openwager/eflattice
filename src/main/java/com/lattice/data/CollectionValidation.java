package com.lattice.data;

import java.lang.annotation.*;

/**
 * 
 * @author crawford
 *
 */

@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.FIELD)
public @interface CollectionValidation
{
    int [] minItems () default { };
    int [] maxItems () default { };
    String errmsg ();
}

// EOF 