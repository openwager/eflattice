package com.lattice.util;

import com.weaselworks.io.IOUtil;

import java.io.PrintStream;
import java.io.OutputStream;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

public class PropertiedUtil
{
    private
    PropertiedUtil ()
    {
        return;
    }

    public static
    void dump (final Propertied p)
    {
        dump (p, System.out);
        return;
    }

    public static
    void dump (final Propertied p, final OutputStream os)
    {
        final PrintStream out = IOUtil.getPrintStream (os);
        out.println (p);
        return; 
    }
}

// EOF