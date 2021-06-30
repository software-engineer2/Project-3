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

/**
 * The assignment requires NearEarthObject instances to be sorted by
 * missDistance. To accomplish this, this class implements the Comparator
 * interface which allows the NearEarthObjects to be arranged in
 * sorted order based on the value of this member variable.
 */
public class MissDistanceComparator implements
        java.util.Comparator<NearEarthObject> {
    /**
     * This method is an int compare(NearEarthObject
     * left, NearEarthObject right) method. This method compares the
     * two arguments based on the value of their missDistance.
     * @param left a NearEarthObject
     * @param right a NearEarthObject
     * @return an int 0, 1, or -1, which ultimately sorts the database
     * by missDistance
     */
    public int compare(NearEarthObject left, NearEarthObject right) {
        NearEarthObject nearEarthObjectDistance1 = (NearEarthObject) left;
        NearEarthObject nearEarthObjectDistance2 = (NearEarthObject) right;
        if (nearEarthObjectDistance1.getMissDistance()
                == nearEarthObjectDistance2.getMissDistance()) {
            return 0;
        }
        else if (nearEarthObjectDistance1.getMissDistance()
                > nearEarthObjectDistance2.getMissDistance()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
