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
 * referenceID. To accomplish this, this class implements the Comparator
 * interface which allows the NearEarthObjects to be arranged in
 * sorted order based on the value of this member variable.
 */
public class ReferenceIDComparator implements
        java.util.Comparator<NearEarthObject> {
    /**
     * This method is an int compare(NearEarthObject
     * left, NearEarthObject right) method. This method compares the
     * two arguments based on the value of their referenceID.
     * @param left a NearEarthObject
     * @param right a NearEarthObject
     * @return an int 0, 1, or -1, which ultimately sorts the database
     * by referenceID
     */
    public int compare(NearEarthObject left, NearEarthObject right) {
        NearEarthObject nearEarthObjectReference1 = (NearEarthObject) left;
        NearEarthObject nearEarthObjectReference2 = (NearEarthObject) right;
        if (nearEarthObjectReference1.getReferenceID()
                == nearEarthObjectReference2.getReferenceID())
            return 0;
        else if (nearEarthObjectReference1.getReferenceID()
                > nearEarthObjectReference2.getReferenceID())
            return 1;
        else
            return -1;
    }
}
