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

import java.lang.ref.Reference;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.*;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Calendar;
import java.text.*;

/**
 * This is a fully-documented class named NeoViewer which allows
 * a user to view datasets obtained from the NASA NeoW API. This class
 * contains a main() method which creates a database and prompts
 * the user to add a page to the database, sort the current database,
 * and display the database.
 */
public class NeoViewer {

    /**
     * Brief:
     * The main method runs a menu driven application which
     * creates a NeoDatabase instance and then prompts the user for a
     * menu command selecting the operation. The required information
     * is then requested from the user based on the selected operation.
     * Following is the list of menu options and their required information:
     * A sample menu is provided below indicating the functionality
     * that the NeoViewer program supports:
     *     A) Add a page to the database
     *     S) Sort the database
     *        // Sub-menu
     *         R) Sort by referenceID
     *         D) Sort by diameter
     *         A) Sort by approach date
     *         M) Sort by miss distance
     *     P) Print the database as a table.
     *     Q) Quit
     * @param args contains the supplied command-line arguments
     *             as an array of String objects
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        NeoDatabase neoDatabase = new NeoDatabase();
        ArrayList<NearEarthObject> nearEarthObjectArrayList
                = new ArrayList<>();

        System.out.println("Welcome to NEO Viewer!\n");
        boolean flag = true;
        while (flag) {
                System.out.print(
                        "Option Menu:\n" +
                        "   A) Add a page to the database\n" +
                        "   S) Sort the database \n" +
                        "   P) Print the database as a table.\n" +
                        "   Q) Quit\n" +
                        "\n" +
                        "Select a menu option: ");

                String s = scanner.nextLine();
                if (s.equalsIgnoreCase("q")) {
                    flag = false;
                }
                switch (s.toUpperCase()) {
                    case "A":
                        System.out.print("Enter the page to load: ");
                        int pageNum = scanner.nextInt();
                        scanner.nextLine();



                        try {
                            DateFormat Dformat
                                    = DateFormat.getDateInstance();
                            Calendar cal = Calendar.getInstance();

                            JSONObject data;
                            neoDatabase.addAll
                                    (neoDatabase.buildQueryURL(pageNum));
                            /*
                            IF ANYTHING GOES WRONG, CHANGE THIS LINE


                            THIS LINE
                            LOOK UP

                             */
                            URL getRequest = new URL
                                    (neoDatabase.buildQueryURL(pageNum));
                            //Creates a URL object from the URL string
//                            System.out.println("getRequest " + getRequest);
                            JSONTokener tokener = new JSONTokener
                                    (getRequest.openStream());
//                            System.out.println("tokener " + tokener);
                            JSONObject root = new JSONObject(tokener);
//                            System.out.println("root " + root);

                            //look into the JSONObject methods to
                            // figure out how to extract
                            // each piece of the JSON

                            //prints all the NearEarthObjects as a string

                            //System.out.println("neoDatabase.getApiKey() "
                            // + neoDatabase.getApiKey());

                            JSONArray arr = root.getJSONArray
                                    ("near_earth_objects");



                            for (int i = 0; i < arr.length(); i++) {
                                NearEarthObject neo
                                        = new NearEarthObject
                                        (0,null,
                                                0.0,
                                                0.0,
                                                0.0,
                                                false,
                                                0,
                                                0,
                                                null);
                                data = (JSONObject) arr.get(i);
//                                System.out.println("data " + data);
                                int dataReferenceID = data.getInt
                                        ("neo_reference_id");
//                                System.out.println("dataReferenceID "
//                                + dataReferenceID);
                                neo.setReferenceID(dataReferenceID);

                                String dataName = data.getString("name");
//                                System.out.println("dataName " + dataName);
                                neo.setName(dataName);

                                double dataAbsoluteMagnitude = data.
                                        getDouble("absolute_magnitude_h");
//                                System.out.println("dataAbsoluteMagnitude "
//                                + dataAbsoluteMagnitude);
                                neo.setAbsoluteMagnitude
                                        (dataAbsoluteMagnitude);

                                JSONObject JSONEstimatedDiameter
                                        = data.
                                        getJSONObject("estimated_diameter");
                                JSONObject JSONEKilometers
                                        = JSONEstimatedDiameter.
                                        getJSONObject("kilometers");
                                double dataMinDiameter = JSONEKilometers.
                                        getDouble
                                                ("estimated_diameter_min"
                                                );
//                                System.out.println("dataMinDiameter "
//                                + dataMinDiameter);


                                double dataMaxDiameter
                                        = JSONEKilometers.
                                        getDouble("estimated_" +
                                                "diameter_max");
//                                System.out.println("dataMaxDiameter "
//                                + dataMaxDiameter);
                                neo.setAverageDiameter((dataMaxDiameter
                                        + dataMinDiameter) / 2);

                                boolean dataIsDangerous
                                        = data.getBoolean("is_" +
                                        "potentially_hazardous_" +
                                        "asteroid");
//                               System.out.println("dataIsDangerous "
//                               + dataIsDangerous);
                                neo.setIsDangerous(dataIsDangerous);

                                long dataClosestDateTimestamp
                                        = data.getJSONArray
                                        ("close_approach_data").
                                        getJSONObject(0).
                                                getLong("epoch_date_" +
                                                        "close_approach");
//                                String dataClosestDateTimestamp2
//                                = data.getJSONArray("close_approach_data")
//                                .getJSONObject(0).getString
//                                ("close_approach_date");
//                              String year = dataClosestDateTimestamp2
//                              .substring(2,4);
//                              String month = dataClosestDateTimestamp2
//                              .substring(5,7);
//                                String day = dataClosestDateTimestamp2
//                                .substring(8);
//                                System.out.println("data
//                                ClosestDateTimestamp " + dataClosest
//                                DateTimestamp);
//                                System.out.println("dataClosest
//                                DateTimestamp2 " + dataClosest
//                                DateTimestamp2);


//                                mm/dd/yy
//                                1909-Sep-01 16
                                neo.setClosestApproachDate
                                        (new Date
                                                (dataClosestDateTimestamp));
//                                SimpleDateFormat formatter
//                                = new SimpleDateFormat("MM-dd-yyyy");
//                                String strDate = formatter.
//                                format(neo.getClosestApproachDate());
//                                System.out.println(strDate);


                                double dataMissDistance
                                        = data.getJSONArray
                                        ("close_approach_data").
                                        getJSONObject(0).
                                        getJSONObject("miss_distance").
                                        getDouble("kilometers");
//                                double dataMissDistance1
//                                = data.getJSONArray
//                                ("close_approach_data").
//                                getJSONObject(i).
//                                getJSONObject("miss_distance").
//                                getDouble("kilometers");
//                                System.out.println
//                                ("dataMissDistance "
//                                + dataMissDistance);
//                                System.out.println
//                                ("dataMissDistance1 "
//                                + dataMissDistance1);
                                neo.setMissDistance(dataMissDistance);

                                String dataOrbitingBody
                                        = data.getJSONArray
                                        ("close_approach_data").
                                        getJSONObject(0).
                                        getString("orbiting_body");
//                                String dataOrbitingBody3
//                                = data.getJSONArray
//                                ("close_approach_data").
//                                getJSONObject(0).
//                                getString("orbiting_body");
//                                System.out.println
//                                ("dataOrbitingBody3 "
//                                + dataOrbitingBody3);
                                neo.setOrbitingBody(dataOrbitingBody);

//
                                neoDatabase.arrayList.add(neo);
                                //System.out.println(neo);
                            }
                            System.out.println
                                    ("\nPage loaded successfully!");

                        } catch(IOException ex) {
                            System.out.println("IOException in A case.");
                        } catch(JSONException ex) {
                            System.out.println(ex);
                            System.out.println("JSONException in A case.");
                        }
                        break;
                    case "S":
                            System.out.print(
                                    "R) Sort by referenceID\n" +
                                    "D) Sort by diameter\n" +
                                    "A) Sort by approach date\n" +
                                    "M) Sort by miss distance\n" +
                                    "\n" +
                                    "Select a menu option: ");
                            String sorting = scanner.nextLine();

                            switch (sorting.toUpperCase()) {
                                case "R":
                                    neoDatabase.sort
                                            (new ReferenceIDComparator());
                                    System.out.println("Table sorted " +
                                            "by referenceID.");
                                    break;
                                case "D":
                                    neoDatabase.sort
                                            (new DiameterComparator());
                                    System.out.println("Table sorted " +
                                            "by diameter.");
                                    break;
                                case "A":
                                    neoDatabase.sort
                                            (new ApproachDateComparator());
                                    System.out.println("Table sorted " +
                                            "on approach date.");
                                    break;
                                case "M":
                                    neoDatabase.sort
                                            (new MissDistanceComparator());
                                    System.out.println("Table sorted " +
                                            "on miss distance.");
                                    break;
                            }

                        break;
                    case "P":
                        neoDatabase.printTable();
                        break;

                }
        }
    }
}
