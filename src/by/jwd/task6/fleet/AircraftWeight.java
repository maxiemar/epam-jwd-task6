package by.jwd.task6.fleet;

import by.jwd.task6.util.HashUtil;

import java.io.Serializable;
import java.util.Comparator;

import static by.jwd.task6.fleet.AbstractAircraftModel.FINITE_POSITIVE_PREDICATE;
import static by.jwd.task6.fleet.AbstractAircraftModel.INVALID_WEIGHT_PROPERTY_MESSAGE;

public class AircraftWeight implements Serializable {

    /**
     * Aircraft weight comparators.
     */
    public final static Comparator<AircraftWeight> EMPTY_WEIGHT_COMPARATOR =
            Comparator.comparing(AircraftWeight::getEmptyWeight);
    public final static Comparator<AircraftWeight> FUEL_CAPACITY_COMPARATOR =
            Comparator.comparing(AircraftWeight::getFuelCapacity);
    public final static Comparator<AircraftWeight> LANDING_WEIGHT_COMPARATOR =
            Comparator.comparing(AircraftWeight::getLandingWeight);
    public final static Comparator<AircraftWeight> TAKEOFF_WEIGHT_COMPARATOR =
            Comparator.comparing(AircraftWeight::getTakeoffWeight);

    private float emptyWeight;
    private float fuelCapacity;
    private float landingWeight;
    private float takeoffWeight;

    public AircraftWeight(float emptyWeight, float fuelCapacity, float landingWeight, float takeoffWeight)
            throws IllegalArgumentException {
        ValidationHelper.validateArgument(emptyWeight, FINITE_POSITIVE_PREDICATE, INVALID_WEIGHT_PROPERTY_MESSAGE);
        ValidationHelper.validateArgument(fuelCapacity, FINITE_POSITIVE_PREDICATE, INVALID_WEIGHT_PROPERTY_MESSAGE);
        ValidationHelper.validateArgument(landingWeight, FINITE_POSITIVE_PREDICATE, INVALID_WEIGHT_PROPERTY_MESSAGE);
        ValidationHelper.validateArgument(takeoffWeight, FINITE_POSITIVE_PREDICATE, INVALID_WEIGHT_PROPERTY_MESSAGE);
        this.emptyWeight = emptyWeight;
        this.fuelCapacity = fuelCapacity;
        this.landingWeight = landingWeight;
        this.takeoffWeight = takeoffWeight;
    }

    public AircraftWeight() {
    }

    public float getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(float emptyWeight) {
        ValidationHelper.validateArgument(emptyWeight, FINITE_POSITIVE_PREDICATE, INVALID_WEIGHT_PROPERTY_MESSAGE);
        this.emptyWeight = emptyWeight;
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(float fuelCapacity) {
        ValidationHelper.validateArgument(fuelCapacity, FINITE_POSITIVE_PREDICATE, INVALID_WEIGHT_PROPERTY_MESSAGE);
        this.fuelCapacity = fuelCapacity;
    }

    public float getLandingWeight() {
        return landingWeight;
    }

    public void setLandingWeight(float landingWeight) {
        ValidationHelper.validateArgument(landingWeight, FINITE_POSITIVE_PREDICATE, INVALID_WEIGHT_PROPERTY_MESSAGE);
        this.landingWeight = landingWeight;
    }

    public float getTakeoffWeight() {
        return takeoffWeight;
    }

    public void setTakeoffWeight(float takeoffWeight) {
        ValidationHelper.validateArgument(takeoffWeight, FINITE_POSITIVE_PREDICATE, INVALID_WEIGHT_PROPERTY_MESSAGE);
        this.takeoffWeight = takeoffWeight;
    }

    @Override
    public int hashCode() {
        return HashUtil.hashFrom(emptyWeight, fuelCapacity, landingWeight, takeoffWeight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AircraftWeight that = (AircraftWeight) o;
        return that.emptyWeight == emptyWeight
               && that.fuelCapacity == fuelCapacity
               && that.landingWeight == landingWeight
               && that.takeoffWeight == takeoffWeight;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
               "emptyWeight=" + emptyWeight +
               ", fuelCapacity=" + fuelCapacity +
               ", landingWeight=" + landingWeight +
               ", takeoffWeight=" + takeoffWeight +
               '}';
    }
}