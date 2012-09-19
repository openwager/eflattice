package com.lattice.validate;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

@SuppressWarnings("serial")
public class Bean1Validator
    extends ObjectValidator<Bean1>
{
    public
    Bean1Validator ()
        throws NoSuchFieldException
    {
        super (Bean1.class);
        init ();
        return;
    }

    protected
    void init ()
        throws NoSuchFieldException
    {
        // name
        final StringValidator<Bean1> nameValidator = new StringValidator <Bean1> (Bean1.class, "name", false, 1, 64, null, "boo");
        addValidator(nameValidator);
        // color
//        final EnumValidator<Bean1, Color> colorValidator = new EnumValidator <Bean1, Color> (Bean1.class, Color.class, "color", false);
//        addValidator (colorValidator);
        // dateOfBirth
        final NotNullValidator<Bean1> dobValidator = new NotNullValidator<Bean1> (Bean1.class, "dateOfBirth", "boo");
        addValidator (dobValidator);
        // bean2
//        final ObjectFieldValidator<Bean1, Bean2> bean2Validator = new ObjectFieldValidator (Bean1.class, Bean2.class, "bean2", false, "boo"); 
//        addValidator (bean2Validator);
        return;
    }

}

// EOF