package com.lattice.validate;

import java.io.*;
import java.util.*;

import com.weaselworks.io.*;

/**
 * 
 * @author crawford
 *
 */

public class ObjectValidatorUtil
{
	private 
	ObjectValidatorUtil ()
	{
		return; 
	}
	
    /**
     * 
     * @param type
     * @param ov
     */
    
    public static <Type>
	void dump (final Class<Type> type, final ObjectValidator<Type> ov)
	{
		dump (type, ov, System.out); 
		return; 
	}
    
    /**
     * 
     * @param type
     * @param ov
     * @param os
     */
	
	public static <Type>
	void dump (final Class<Type> type, final ObjectValidator<Type> ov, final OutputStream os)
	{
		final PrintStream out = IOUtil.getPrintStream (os);
		out.println ("ObjectValidator<" + type.getSimpleName () + "> = {"); 
		final Map<String, List<FieldValidator<? super Type, ?>>> vs = ov.getValidators ();
		for (final String field : vs.keySet()) {
			int cnt = 1; 
			out.println ("  '" + field + "' {"); 
			final List<FieldValidator<? super Type, ?>> fvs = vs.get (field);
			for (final FieldValidator<? super Type, ?> fv : fvs) { 
				out.println ("    " + (cnt ++) + ": " + fv); 			
			}
			out.println ("  }"); 
		}
		out.println ("  Custom validators {"); 
		final List<?> others = ov.getOtherValidators ();
		int cnt = 1; 
		for (final Object other : others) { 
			out.println ("    " + cnt++ + ": " + other); 
		}
		out.println ("  }"); 
		out.println ("}"); 
		return; 
	}
}

// EOF

