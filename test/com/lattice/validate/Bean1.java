package com.lattice.validate;

import com.weaselworks.util.StringUtil;

import java.util.Date;

import org.testng.annotations.Test;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

public class Bean1
{
    public
    Bean1 ()
    {
        return;
    }

    public
    Bean1 (final String name, final Date dateOfBirth, final Color color, final Bean2 bean2)
    {
        setName (name);
        setDateOfBirth (dateOfBirth);
        setColor (color);
        setBean2 (bean2);
        return;
    }

    protected Bean2 bean2;
    public Bean2 getBean2 () { return this.bean2; }
    public void setBean2 (final Bean2 bean2) { this.bean2 = bean2; return; }

    protected String name;
    public String getName () { return this.name; }
    public void setName (final String name) { this.name = name; return; }

    protected Date dateOfBirth;
    public Date getDateOfBirth () { return this.dateOfBirth; }
    public void setDateOfBirth (final Date dateOfBirth) { this.dateOfBirth = dateOfBirth; return; }

    protected Color color;
    public Color getColor () { return this.color; }
    public void setColor (final Color color) { this.color = color; return; }

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
        final Bean1 b = new Bean1 ("Fred", new Date (), Color.RED, null);
        System.out.println (b); 
        return;
    }
}

// EOF