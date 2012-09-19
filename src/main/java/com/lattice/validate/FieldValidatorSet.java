package com.lattice.validate;

import java.util.*;

/**
 * Implements a {@linkplain FieldValidator} that contains a set of enclosed validators
 * to which validation is delegated. 
 * 
 * @author crawford
 *
 * @param <OwnerType>
 * @param <FieldType>
 */

@SuppressWarnings("serial")
public class FieldValidatorSet <OwnerType,FieldType>
	extends FieldValidator <OwnerType, FieldType>
{
    public
    FieldValidatorSet (final Class<OwnerType> otype, final Class<FieldType> ftype, final String fieldName)
        throws NoSuchFieldException
    {
        super (otype, ftype, fieldName);
        return;
    }
    
    /**
     * Contains the list of enclosed {@linkplain FieldValidator FieldValidators}. 
     */
    
    protected List<FieldValidator<OwnerType, FieldType>> validators = new ArrayList<FieldValidator<OwnerType, FieldType>> (); 
    
    public
    void addValidator (final FieldValidator<OwnerType, FieldType> validator) 
    {
    	validators.add (validator); 
    	return; 
    }
    
    @Override
    public void validate (final FieldType value)
        throws ValidationException
    {
    	for (final FieldValidator<OwnerType, FieldType> validator : validators) { 
    		validator.validate (value); 
    	}
        return;
    }	
}

// EOF