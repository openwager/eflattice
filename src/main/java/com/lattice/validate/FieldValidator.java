package com.lattice.validate;

import java.lang.reflect.Field;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

@SuppressWarnings("serial")
abstract public class FieldValidator <OwnerType, FieldType>
    extends Validator<FieldType>
{
    public
    FieldValidator (final Class<OwnerType> otype, final Class<FieldType> vtype, final String fieldName)
            throws SecurityException, NoSuchFieldException
    {
        super (vtype);
        setFieldName (fieldName);
        setOwnerType (otype);
        final Field field = getDeclaredFieldFromClassOrSuper (otype, fieldName);
        field.setAccessible (true);
        setField (field);
        return;
    }

    /**
     *
     * @param otype
     * @param fieldName
     * @return
     * @throws NoSuchFieldException
     */

    private
    Field getDeclaredFieldFromClassOrSuper(final Class<? super OwnerType> otype, final String fieldName)
        throws NoSuchFieldException
    {
        try {
            return otype.getDeclaredField (fieldName);
        }
        catch (final NoSuchFieldException nsf_e) {
            final Class<? super OwnerType> superType = otype.getSuperclass ();

            if (superType == null) {
                throw nsf_e;
            } else {
                return getDeclaredFieldFromClassOrSuper (superType, fieldName);
            }
        }

        // NOT REACHED
    }

    protected Class<OwnerType> ownerType;
    public Class<OwnerType> getOwnerType () { return this.ownerType; }
    public void setOwnerType (final Class<OwnerType> ownerType) { this.ownerType = ownerType; return; }

    protected String fieldName;
    protected void setFieldName (final String fieldName) { this.fieldName = fieldName; return; }
    public String getFieldName () { return this.fieldName; }

    // transient so that this is not serialized
    protected transient Field field;
    public Field getField () { return this.field; }
    protected void setField (final Field field) { this.field = field; return
; }

    @SuppressWarnings("unchecked")
    public
    void validateOn (final OwnerType owner)
            throws ValidationException
    {
        try {
            final Object value = getField ().get (owner);
            validate ((FieldType) value);
        }
        catch (final IllegalAccessException ia_e) {
            throw new ValidationException (owner, this, ia_e.getMessage ());
        }
        return;
    }

    public
    boolean isValidOn (final OwnerType owner)
    {
        try {
                validateOn (owner);
                return true;
        }
        catch (final ValidationException v_e) {
                return false;
        }
    }
}

// EOF