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

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Calendar;
import java.io.*;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.*;

import big.data.*;
import org.json.*;

/**
 * This is a fully documented class named NeoDatabase which
 * will contain and manage the NearEarthObject records which have
 * been downloaded from the online dataset. The specific data
 * structure used to implement this database is an ArrayList.
 */
public class NeoDatabase {

    ArrayList<NearEarthObject> arrayList = new ArrayList<NearEarthObject>();


    public static final String API_KEY
            = "RrBF9UjFtbfYIruxBkYhF5r0JqR6vKQsXtb8P3zA";
    public static final String API_ROOT
            = "https://api.nasa.gov/neo/rest/v1/neo/browse?";

    /**
     * A getter for the API_KEY
     * @return the String API_KEY
     */
    public String getApiKey() {
        return API_KEY;
    }

    /**
     * Brief:
     * Default Constructor.
     * Postconditions:
     * The database has been constructed and is empty.
     */
    public NeoDatabase() {
    }

    /**
     * Brief:
     * Builds a query URL given a page number.
     * This is a simple method that returns (API_ROOT + "page="
     * + pageNumber + "&api_key=" + API_KEY)
     * Preconditions:
     * 0 ≤ page ≤ 715.
     * @param pageNumber An integer ranging from 0 to 715 indicating
     *                   the page the user wishes to load.
     * @return the String (API_ROOT + "page="
     * + pageNumber + "&api_key=" + API_KEY)
     * @throws IllegalArgumentException Thrown if pageNumber is not
     * in the valid range.
     */
    public String buildQueryURL(int pageNumber) throws
            IllegalArgumentException {
        try {
            if (pageNumber < 0 || pageNumber > 715) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("The page number must be between 0 " +
                    "and 715 inclusive.");
        }
        return API_ROOT + "page=" + pageNumber + "&api_key=" + API_KEY;
    }

    /**
     * Brief:
     * Opens a connection to the data source indicated by queryURL and
     * adds all NearEarthObjects found in the dataset.
     * Preconditions:
     * queryURL is a non-null string representing a valid API
     * request to the NASA NeoW service.
     * Postconditions:
     * All NearEarthObject records returned have been added to
     * the database, or else an IllegalArgumentException has been thrown.
     * @param queryURL A string containing the URL requesting a dataset
     *                 from the NASA NeoW service (this is generated
     *                 by the buildQueryURL() above).
     * @throws IllegalArgumentException Thrown if queryURL is null or
     * could not be resolved by the server.
     */
    public void addAll(String queryURL) throws IllegalArgumentException {
        try {
            if (queryURL == null) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("queryURL was null or it could " +
                    "not be resolved the server.");
        }
        /*
        DataSource ds = DataSource.connectJSON(queryURL);
        ds.load();
        NearEarthObject [] nearEarthObjects = ds.fetchArray(
                "NearEarthObject",
                "near_earth_objects/neo_reference_id",
                "near_earth_objects/name",
                "near_earth_objects/absolute_magnitude_h",
                "near_earth_objects/estimated_diameter/
                kilometers/estimated_diameter_min",
                "near_earth_objects/estimated_diameter/
                kilometers/estimated_diameter_max",
                "near_earth_objects/is_potentially_hazardous_asteroid",
                "near_earth_objects/close_approach_data/
                epoch_date_close_approach",
                "near_earth_objects/close_approach_data/
                miss_distance/kilometers",
                "near_earth_objects/close_approach_data/orbiting_body");
        for(int i = 0; i < nearEarthObjects.length; ++i) {
            arrayList.add(nearEarthObjects[i]);
        }
         */
    }

    /**
     * Brief:
     * Sorts the database using the specified Comparator of NearEarthObjects.
     * Preconditions:
     * comp is not null.
     * Postconditions:
     * The database has been sorted based on the order specified by
     * the indicated Comparator of NearEarthObjects.
     * @param comp the Comparator of NearEarthObjects which will be used
     *             to sort the database. This parameter can be any of the
     *             required Comparator classes.
     * @throws IllegalArgumentException Thrown if comp is null.
     */
    public void sort(Comparator<NearEarthObject> comp) throws
            IllegalArgumentException {
        try {
            if (comp == null) {
                throw new IllegalArgumentException();
            }
            arrayList.sort(comp);
        } catch (IllegalArgumentException e) {
            System.out.println("comp cannot be null");
        }
    }

    /**
     * Brief:
     * Displays the database in a neat, tabular form, listing all
     * member variables for each NearEarthObject. The table
     * is printed in the order specified by the last sort() call.
     * Preconditions:
     * This NeoDatabase is initialized and not null.
     * Postconditions:
     * The table has been printed to the console but remains unchanged.
     */
    public void printTable() {
        System.out.println(
                "   ID   |                  Name                  " +
                        "|  Mag.  | Diameter |  Danger  | Close Date " +
                        "| Miss Dist | Orbits\n" +
                "===================================================" +
                        "==============================================" +
                        "================");
        for (int i = 0; i < arrayList.size(); i++) {
//            DateFormat dateFormat = DateFormat.getDateInstance());
//            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formatter
                    = new SimpleDateFormat("MM-dd-yyyy");
            String strDate
                    = formatter.format
                    (arrayList.get(i).getClosestApproachDate());
            System.out.printf("%-15d%-37s%-9.1f%-11.3f%-10b%-13s%-12.0f%-10s",
                    arrayList.get(i).getReferenceID(),
                    arrayList.get(i).getName(),
                    arrayList.get(i).getAbsoluteMagnitude(),
                    arrayList.get(i).getAverageDiameter(),
                    arrayList.get(i).getIsDangerous(),
                    strDate,
                    arrayList.get(i).getMissDistance(),
                    arrayList.get(i).getOrbitingBody());
            System.out.println();
        }
    }
}
