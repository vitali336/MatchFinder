import java.util.ArrayList;
import java.util.Arrays;

/**
 * Objects of this class represent a pair of 'Single' objects that matches each other.
 * The 'match' method is implemented and described in the class 'Single'.
 */
public class MatchPair {

    private final Single single1;
    private final Single single2;

    public MatchPair(Single single1, Single single2) {
        this.single1 = single1;
        this.single2 = single2;
    }

    /**
     * This method is a first attempt to find as many
     * potential couples as possible from a set of single objects.
     * All singles from the array are compared with each other one after the other.
     * Singles for which a match has been found are no longer taken into account in the algorithm.
     * @param singles an Array of Single objects
     * @return an Array of MatchPair objects
     */
    public static MatchPair[] findMatchPairs1(Single[] singles){

        if(singles.length < 2){
            return new MatchPair[] {};
        }

        // indices of the 'Single' objects in the array 'singles'
        // for which a match has been found during the algorithm
        ArrayList<Integer> indicesFoundMatch = new ArrayList<Integer>();

        ArrayList<MatchPair> matches = new ArrayList<MatchPair>();

        for (int i = 0; i < singles.length - 1; i++) {
            if(indicesFoundMatch.contains(i)){
                continue;
            }
            for (int j = i+1; j < singles.length; j++) {
                if(!indicesFoundMatch.contains(j)
                        && Single.match(singles[i], singles[j])){
                    matches.add(new MatchPair(singles[i], singles[j]));
                    indicesFoundMatch.add(i);
                    indicesFoundMatch.add(j);
                    break;
                }
            }
        }
        return matches.toArray(new MatchPair[0]);
    }

    @Override
    public String toString() {
        return "MatchPair:" + '\n' +
                "Single 1: " + single1 + '\n' +
                "Single 2: " + single2 + '\n';
    }

    public Single getSingle1() {
        try {
            return single2.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public Single getSingle2() {
        try {
            return single2.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
