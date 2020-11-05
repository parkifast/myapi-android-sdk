package com.parkifast.mymappi.myapisdk.network.request_models.common;

/**
 * Supported route profiles: car, on_foot and bicycle. Any of those can be used for
 * route calculation.
 */
public enum Profile {
    /**
     * For directions via normal vehicle (car, motorbike, etc.)
     */
    car("car"),
    /**
     * For pedestrian routes.
     */
    on_foot("pedestrian"),
    /**
     * For routes by bicycle.
     */
    bicycle("bike");

    private String value;

    Profile(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Override String representation and just return the translated string value.
     * @return          Item's String value.
     */
    @Override
    public String toString() {
        return value;
    }
}
