package com.lattice.util;

import java.util.Map;

/**
 * Comment goes here.
 *
 * @author Lee Crawford (lee.crawford@gmail.com)
 * @copyright Copyright (c) 2009, All Rights Reserved.
 */

public interface Propertied
{
    public
    Map<String, String> getProperties ();

    public
    String getProperty (String key);

    public
    void setProperty (String key, String value);

    public
    void removeProperty (String key); 

    public
    boolean hasProperty (String key);
}

// EOF