package com.lattice.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

abstract public class PropertiedSupport
    implements Propertied
{
    public
    PropertiedSupport ()
    {
        this (new HashMap<String, String>());
        return;
    }

    public
    PropertiedSupport (final Map<String, String> props)
    {
        setProperties (props);
        return;
    }

    protected Map<String, String> props;

    public
    Map<String, String> getProperties ()
    {
        return this.props;
    }

    public
    void setProperties (final Map<String, String> props)
    {
        this.props = props;
        return;
    }

    public
    String getProperty (String key)
    {
        return props.get (key);
    }

    public
    void setProperty (String key, String value)
    {
        props.put (key, value);
        return;
    }

    public
    void removeProperty (final String key)
    {
        props.remove (key);
        return;
    }

    public
    boolean hasProperty (String key)
    {
        return props.containsKey (key);
    }

    @Override
    public
    String toString ()
    {
        StringBuffer buf = new StringBuffer ();
        buf.append (getClass ().getName ());
        buf.append ('[');
        paramString (buf);
        buf.append (']');
        return buf.toString ();
    }

    protected
    void paramString (final StringBuffer buf)
    {
        buf.append ("props=" + props);
        return;
    }
}

// EOF