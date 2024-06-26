/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2003-2008, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.data;

import java.io.IOException;
import java.util.NoSuchElementException;
import org.geotools.api.data.FeatureWriter;
import org.geotools.api.feature.simple.SimpleFeature;
import org.geotools.api.feature.simple.SimpleFeatureType;

/**
 * Represents an Empty, Typed, FeatureWriter.
 *
 * @author Jody Garnett, Refractions Research
 */
public class EmptyFeatureWriter implements FeatureWriter<SimpleFeatureType, SimpleFeature> {
    SimpleFeatureType featureType;

    /** An Empty FeatureWriter of the provided <code>featureType</code>. */
    public EmptyFeatureWriter(SimpleFeatureType featureType) {
        this.featureType = featureType;
    }

    /** @see FeatureWriter#getFeatureType() */
    @Override
    public SimpleFeatureType getFeatureType() {
        return featureType;
    }

    /**
     * Throws NoSuchElementException as this is an Empty FeatureWriter.
     *
     * @return Does not return
     * @see FeatureWriter#next()
     */
    @Override
    public SimpleFeature next() throws NoSuchElementException {
        throw new NoSuchElementException("FeatureWriter is empty");
    }

    /** @see FeatureWriter#remove() */
    @Override
    public void remove() throws IOException {
        throw new IOException("FeatureWriter is empty and does not support remove()");
    }

    /** @see FeatureWriter#remove() */
    @Override
    public void write() throws IOException {
        throw new IOException("FeatureWriter is empty and does not support write()");
    }

    /**
     * There is no next Feature.
     *
     * @return <code>false</code>
     * @see FeatureWriter#hasNext()
     */
    @Override
    public boolean hasNext() {
        return false;
    }

    /**
     * Cleans up after Empty FeatureWriter.
     *
     * @see FeatureWriter#close()
     */
    @Override
    public void close() {
        featureType = null;
    }
}
