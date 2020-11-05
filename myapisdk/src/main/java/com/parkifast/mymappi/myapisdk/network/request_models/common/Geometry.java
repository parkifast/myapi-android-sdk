package com.parkifast.mymappi.myapisdk.network.request_models.common;

/**
 * Determines the format in which the route will be sent in the response as an overview.
 * Implemented possibilities are: encoded polyline (polyline), encoded polyline v6 (polyline6)
 * or geoJSON(geojson).
 */
public enum Geometry {
    polyline,
    polyline6,
    geojson
}
