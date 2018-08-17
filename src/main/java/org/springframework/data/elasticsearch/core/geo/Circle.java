/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.elasticsearch.core.geo;

import org.geojson.GeoJsonObject;
import org.geojson.GeoJsonObjectVisitor;
import org.geojson.LngLatAlt;

/**
 * @author: Val Crettaz
 */
public class Circle extends GeoJsonObject {

    private LngLatAlt coordinates;
    private Double radius;

    public Circle() {
    }

    public Circle(LngLatAlt coordinates) {
        this.coordinates = coordinates;
    }

    public Circle(double longitude, double latitude) {
        this.coordinates = new LngLatAlt(longitude, latitude);
    }

    public Circle(double longitude, double latitude, double altitude) {
        this.coordinates = new LngLatAlt(longitude, latitude, altitude);
    }

    public Circle(double longitude, double latitude, double altitude, double radius) {
        this.coordinates = new LngLatAlt(longitude, latitude, altitude);
        this.radius = radius;
    }

    public LngLatAlt getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(LngLatAlt coordinates) {
        this.coordinates = coordinates;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public <T> T accept(GeoJsonObjectVisitor<T> geoJsonObjectVisitor) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Circle)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Circle circle = (Circle)o;
        boolean coordMatch = !(coordinates != null ? !coordinates.equals(circle.coordinates) : circle.coordinates != null);
        boolean radiusMatch = !(radius != null ? !radius.equals(circle.radius) : circle.radius != null);
        return coordMatch && radiusMatch;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        result = 31 * result + (radius != null ? radius.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Circle{" + "coordinates=" + coordinates + ", radius= " + radius + "} " + super.toString();
    }
}