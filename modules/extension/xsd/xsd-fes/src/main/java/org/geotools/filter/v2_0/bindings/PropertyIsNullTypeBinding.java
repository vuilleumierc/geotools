/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2002-2008, Open Source Geospatial Foundation (OSGeo)
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
package org.geotools.filter.v2_0.bindings;

import javax.xml.namespace.QName;
import org.geotools.api.filter.FilterFactory;
import org.geotools.api.filter.PropertyIsNull;
import org.geotools.api.filter.expression.PropertyName;
import org.geotools.filter.v1_0.OGCPropertyIsNullTypeBinding;
import org.geotools.filter.v2_0.FES;

/**
 * Binding object for the type http://www.opengis.net/fes/2.0:PropertyIsNullType.
 *
 * <p>
 *
 * <pre>
 *       <code>
 *  &lt;xsd:complexType name="PropertyIsNullType"&gt;
 *      &lt;xsd:complexContent&gt;
 *          &lt;xsd:extension base="fes:ComparisonOpsType"&gt;
 *              &lt;xsd:sequence&gt;
 *                  &lt;xsd:element minOccurs="0" ref="fes:expression"/&gt;
 *              &lt;/xsd:sequence&gt;
 *          &lt;/xsd:extension&gt;
 *      &lt;/xsd:complexContent&gt;
 *  &lt;/xsd:complexType&gt;
 *
 *        </code>
 *       </pre>
 *
 * @generated
 */
public class PropertyIsNullTypeBinding extends OGCPropertyIsNullTypeBinding {

    public PropertyIsNullTypeBinding(FilterFactory factory) {
        super(factory);
    }

    @Override
    public QName getTarget() {
        return FES.PropertyIsNullType;
    }

    @Override
    public Object getProperty(Object object, QName name) throws Exception {
        PropertyIsNull isNull = (PropertyIsNull) object;
        if (FES.expression.equals(name) && isNull.getExpression() instanceof PropertyName) {
            return isNull.getExpression();
        }
        return super.getProperty(object, name);
    }
}
