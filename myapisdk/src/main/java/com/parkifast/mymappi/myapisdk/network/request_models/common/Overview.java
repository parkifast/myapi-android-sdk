package com.parkifast.mymappi.myapisdk.network.request_models.common;

/**
 * Possibilities for route overview. By default it will be simplified (according to highest
 * zoom level it could be displayed on), but it can also be set to full (full intersections list
 * regardless of zoom level) or false (no overview at all)
 */
public enum Overview {

    simplified("simplified"),
    full("full"),
    none("false");

    private String value;

    Overview(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
