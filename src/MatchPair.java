public class MatchPair {

    private final Single single1;
    private final Single single2;

    public MatchPair(Single single1, Single single2) {
        this.single1 = single1;
        this.single2 = single2;
    }

    @Override
    public String toString() {
        return "SinglePair{" +
                "single1=" + single1 +
                ", single2=" + single2 +
                '}';
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
