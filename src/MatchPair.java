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
