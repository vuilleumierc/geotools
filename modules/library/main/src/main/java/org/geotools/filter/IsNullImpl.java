/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2006-2008, Open Source Geospatial Foundation (OSGeo)
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
package org.geotools.filter;

import org.geotools.api.filter.FilterVisitor;
import org.geotools.api.filter.PropertyIsNull;
import org.geotools.api.filter.expression.Expression;

public class IsNullImpl extends CompareFilterImpl implements PropertyIsNull {

    public IsNullImpl(org.geotools.api.filter.expression.Expression expression) {
        super(expression, null);
    }

    @Override
    public boolean evaluate(Object feature) {
        Expression expr = getExpression();
        Object value = eval(expr, feature);
        return value == null;
    }

    @Override
    public Object accept(FilterVisitor visitor, Object extraData) {
        return visitor.visit(this, extraData);
    }

    @Override
    public Expression getExpression() {
        return getExpression1();
    }

    public void setExpression(Expression expression) {
        super.setExpression1(expression);
    }
}
