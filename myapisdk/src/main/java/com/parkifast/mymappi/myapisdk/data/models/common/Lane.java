package com.parkifast.mymappi.myapisdk.data.models.common;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * A {@link Lane} represents a turn lane at the corresponding turn location.
 */
public class Lane {

    //region Attributes
    /**
     * An indication (e.g. marking on the road) specifying the turn lane. A road can have multiple
     * indications (e.g. an arrow pointing straight and left). The indications are given in a
     * list, each containing one of the following types.
     * Further indications might be added on without an API version change.
     * <table>
     * <thead>
     * <tr>
     * <th><code>value</code></th>
     * <th>Description</th>
     * </tr>
     * </thead>
     * <tbody>
     * <tr>
     * <td><code>none</code></td>
     * <td>No dedicated indication is shown.</td>
     * </tr>
     * <tr>
     * <td><code>uturn</code></td>
     * <td>An indication signaling the possibility to reverse (i.e. fully bend arrow).</td>
     * </tr>
     * <tr>
     * <td><code>sharp right</code></td>
     * <td>An indication indicating a sharp right turn (i.e. strongly bend arrow).</td>
     * </tr>
     * <tr>
     * <td><code>right</code></td>
     * <td>An indication indicating a right turn (i.e. bend arrow).</td>
     * </tr>
     * <tr>
     * <td><code>slight right</code></td>
     * <td>An indication indicating a slight right turn (i.e. slightly bend arrow).</td>
     * </tr>
     * <tr>
     * <td><code>straight</code></td>
     * <td>No dedicated indication is shown (i.e. straight arrow).</td>
     * </tr>
     * <tr>
     * <td><code>slight left</code></td>
     * <td>An indication indicating a slight left turn (i.e. slightly bend arrow).</td>
     * </tr>
     * <tr>
     * <td><code>left</code></td>
     * <td>An indication indicating a left turn (i.e. bend arrow).</td>
     * </tr>
     * <tr>
     * <td><code>sharp left</code></td>
     * <td>An indication indicating a sharp left turn (i.e. strongly bend arrow).</td>
     * </tr>
     * </tbody>
     * </table>
     */
    @SerializedName("indications")
    private List<String> indications;

    /**
     * A boolean flag indicating whether the lane is a valid choice in the current maneuver.
     */
    @SerializedName("valid")
    private boolean valid;
    //endregion

    //region Getters and setters

    public List<String> getIndications() {
        return indications;
    }

    public void setIndications(List<String> indications) {
        this.indications = indications;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    //endregion

    //region Constructors

    /**
     * Empty constructor.
     */
    public Lane() {
        this.indications = new ArrayList<>();
        this.valid = false;
    }

    /**
     * Full constructor.
     * @param indications
     * @param valid
     */
    public Lane(List<String> indications, boolean valid) {
        this.indications = indications;
        this.valid = valid;
    }

    //endregion

    //region Exposed API
    //endregion

    //region Public helpers
    /**
     * String representation of current instance.
     * @return      String representation of current instance.
     */
    @Override
    public String toString() {
        return "Lane{" +
                "indications=" + indications +
                ", valid=" + valid +
                '}';
    }

    /**
     * Compares two instances.
     * @param o     Another instance to compare to
     * @return      {@code true} when all fields are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lane)) return false;

        Lane lane = (Lane) o;

        if (isValid() != lane.isValid()) return false;
        return getIndications().equals(lane.getIndications());
    }

    /**
     * Hashing algorithm.
     * @return      Uniquely identifies current instance.
     */
    @Override
    public int hashCode() {
        int result = getIndications().hashCode();
        result = 31 * result + (isValid() ? 1 : 0);
        return result;
    }
    //endregion

    //region Private helpers
    //endregion

}
