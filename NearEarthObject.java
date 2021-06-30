/*
Debamita Saha
SOLAR ID#: 112494564
debamita.saha@stonybrook.edu
Homework #7
Course: CSE 214
Recitation number: R04
TA's Name: James Finn
*/

package Homework7;

import java.util.Date;

/**
 * This is a fully documented class named NearEarthObject. This class
 * represents a record in the database of asteroids currently tracked
 * by NASA. It should be noted that this class will always be constructed
 * by the BigData library, and serves as a data container for the information
 * that is already hosted by the NeoW API.
 */
public class NearEarthObject {
    private int referenceID;
    private String name;
    private double absoluteMagnitude;
    private double averageDiameter;
    private boolean isDangerous;
    private Date closestApproachDate;
    private double missDistance;
    private String orbitingBody;

    /**
     * A getter for the referenceID
     * @return the unique int ID of the NEO.
     */
    public int getReferenceID() {
        return referenceID;
    }

    /**
     * A setter for the referenceID
     * @param referenceID the unique int ID of the NEO.
     */
    public void setReferenceID(int referenceID) {
        this.referenceID = referenceID;
    }

    /**
     * A getter for the name
     * @return the unique String name of the asteroid or orbital body.
     */
    public String getName() {
        return name;
    }

    /**
     * A setter for the name
     * @param name the unique String name of the asteroid or orbital body.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A getter for the absolute magnitude
     * @return a double value of the absolute brightness of the
     * asteroid or orbital body in the sky.
     */
    public double getAbsoluteMagnitude() {
        return absoluteMagnitude;
    }

    /**
     * A setter for the absolute magnitude
     * @param absoluteMagnitude a double value of the absolute
     *                          brightness of the
     *                          asteroid or orbital body in the sky.
     */
    public void setAbsoluteMagnitude(double absoluteMagnitude) {
        this.absoluteMagnitude = absoluteMagnitude;
    }

    /**
     * A getter for the average diameter
     * @return a double value calculated by summing the minDiameter and
     * the maxDiameter and dividing the result by 2.
     */
    public double getAverageDiameter() {
        return averageDiameter;
    }

    /**
     * A setter for the average diameter
     * @param averageDiameter a double value calculated by summing
     *                       the minDiameter and the maxDiameter and
     *                        dividing the result by 2.
     */
    public void setAverageDiameter(double averageDiameter) {
        this.averageDiameter = averageDiameter;
    }

    /**
     * A getter for the isDangerous value
     * @return Boolean value indicating whether the asteroid
     * or orbital body is a potential impact threat.
     */
    public boolean getIsDangerous() {
        return isDangerous;
    }

    /**
     * A setter for the isDangerous value
     * @param isDangerous a Boolean value indicating whether the asteroid
     * or orbital body is a potential impact threat.
     */
    public void setIsDangerous(boolean isDangerous) {
        this.isDangerous = isDangerous;
    }

    /**
     * A getter for the getClosestApproachDate
     * @return A Date constructed by the long value of the Unix timestamp
     * representing the date of the closest approach
     */
    public Date getClosestApproachDate() {
        return closestApproachDate;
    }

    /**
     * A setter for the getClosestApproachDate
     * @param closestApproachDate A Date constructed by the long
     *                            value of the Unix timestamp
     *                            representing the date of the
     *                            closest approach
     */
    public void setClosestApproachDate(Date closestApproachDate) {
        this.closestApproachDate = closestApproachDate;
    }

    /**
     * A getter for the missDistance
     * @return missDistance A double value of the distance in kilometers
     * at which the asteroid or orbital body will
     * pass by Earth on the date of its closest approach
     */
    public double getMissDistance() {
        return missDistance;
    }

    /**
     * A setter for the missDistance
     * @param missDistance A double value of the distance in kilometers
     * at which the asteroid or orbital body will
     * pass by Earth on the date of its closest approach
     */
    public void setMissDistance(double missDistance) {
        this.missDistance = missDistance;
    }

    /**
     * A getter for the orbitingBody
     * @return A String of the planet or other orbital
     * body which this NEO orbits.
     */
    public String getOrbitingBody() {
        return orbitingBody;
    }

    /**
     * A setter for the orbitingBody
     * @param orbitingBody A String of the planet or other orbital
     * body which this NEO orbits.
     */
    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }

    /**
     * Default constructor of the NearEarthObject class
     */
    public NearEarthObject() {
    }

    /**
     * Brief:
     * This constructor will be used by
     * the BigData library to fetch the NearEarthObject records from
     * the NeoW API.
     * @param referenceID Unique int ID of the NEO.
     * Fetched using the "near_earth_objects/neo_reference_id" identifier.
     * @param name Unique String name of the asteroid or orbital body.
     * Fetched using the "near_earth_objects/name" identifier.
     * @param absoluteMagnitude Double of the absolute brightness of the
     *                          asteroid or orbital body in the sky.
     * Fetched using the "near_earth_objects/absolute_magnitude_h" identifier.
     * @param minDiameter Double value of the estimated minimum diameter of
     *                   the asteroid or orbital body in kilometers. This
     *                    parameter is used in conjunction with the
     *                    maxDiameter parameter to calculate and initialize
     *                    the averageDiameter member variable.
     * Fetched using the "near_earth_objects/estimated_diameter/
     *                    kilometers/estimated_diameter_min" identifier.
     * @param maxDiameter Double value of the estimated maximum diameter
     *                    of the asteroid or orbital body in kilometers.
     *                    This parameter is used in conjunction with the
     *                    minDiameter parameter to calculate and initialize
     *                    the averageDiameter member variable.
     * Fetched using the "near_earth_objects/estimated_diameter/
     *                    kilometers/estimated_diameter_max" identifier.
     * @param isDangerous Boolean value indicating whether the asteroid
     *                    or orbital body is a potential impact threat.
     * Fetched using the "near_earth_objects/is_potentially_
     *                    hazardous_asteroid" identifier.
     * @param closestDateTimestamp Long value of the Unix timestamp
     *                             representing the date of closest
     *                             approach. This is used to directly
     *                             construct the closestApproachDate
     *                             member variable, as the Date class
     *                             provides a constructor taking a
     *                             timestamp as a parameter.
     * Fetched using the "near_earth_objects/close_approach_data/
     *                             epoch_date_close_approach" identifier.
     * @param missDistance Double value of the distance in kilometers
     *                     at which the asteroid or orbital body will
     *                     pass by Earth on the date of its closest approach.
     * Fetched using the "near_earth_objects/close_approach_data/
     *                     miss_distance/kilometers" identifier.
     * @param orbitingBody String of the planet or other orbital
     *                     body which this NEO orbits.
     * Fetched using the "near_earth_objects/close_approach_data/
     *                     orbiting_body" identifier.
     */
    public NearEarthObject(int referenceID, String name,
                           double absoluteMagnitude, double minDiameter,
                           double maxDiameter, boolean isDangerous,
                           long closestDateTimestamp, double missDistance,
                           String orbitingBody) {

    }

    /**
     * A toString method that returns the int referenceID, String name,
     *                            double absoluteMagnitude,
     *                            double averageDiameter,
     *                            boolean isDangerous,
     *                            long closestApproachDate,
     *                            double missDistance, and
     *                            String orbitingBody
     * @return the int referenceID, String name,
     * double absoluteMagnitude, double averageDiameter,
     * boolean isDangerous, long closestApproachDate,
     * double missDistance, and String orbitingBody
     */
    public String toString() {
        return referenceID + " " + name + " " + absoluteMagnitude + " "
        + averageDiameter + " " + isDangerous + " " +
                closestApproachDate + " " + missDistance +
                " " + orbitingBody;
    }
}
