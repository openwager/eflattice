package com.lattice.validate;

import com.lattice.data.*;
import com.weaselworks.util.StringUtil;
import org.testng.annotations.Test;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

public class Bean2
{
    public
    Bean2 ()
    {
        return;
    }

    public
    Bean2 (final Integer weight, final Long height)
    {
        setHeight (height);
        setWeight (weight);
        return;
    }
    
    @CustomFieldValidation(classes={ EmailAddressValidator.class })
    protected String foo; 

    protected Integer weight;
    public Integer getWeight () { return this.weight; }
    public void setWeight (final Integer weight) { this.weight = weight; return; }

    protected Long height;
    public Long getHeight () { return this.height; }
    public void setHeight (final Long height) { this.height = height; return; }

    @Override
    public
    String toString ()
    {
        return StringUtil.toString (this);
    }

    @Test
    public
    void test1 ()
    {
        final Bean2 b = new Bean2 (123, 45678L);
        System.out.println (b);
        return;
    }
}

// EOF