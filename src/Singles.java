import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class wraps an ArrayList<Single> and provides methods which find
 * potential couples from a set of Single objects, as well as the methods:
 * getHeteros, getNonHeteros, getDiverse, getWoman, getMales, getAllSingles, addSingle.
 */
public class Singles {

    private ArrayList<Single> singles;

    public Singles() {
        this.singles = new ArrayList<Single>();
    }

    public Singles(Single[] singles) {
        this.singles = new ArrayList<Single>(Arrays.asList(singles));
    }


    @Override
    public String toString() {
        return "Singles= " + singles ;
    }

    /**
     * This method is a first attempt to find as many
     * potential couples as possible from a set of single objects.
     * All singles from the array are compared with each other one after the other.
     * Singles for which a match has been found are no longer taken into account in the algorithm.
     * @return an Array of MatchPair objects
     */
    public MatchPair[] findMatchPairs1(){

        if(this.singles.size() < 2){
            return new MatchPair[] {};
        }

        // indices of the 'Single' objects in the array 'singles'
        // for which a match has been found during the algorithm
        ArrayList<Integer> indicesFoundMatch = new ArrayList<Integer>();

        ArrayList<MatchPair> matches = new ArrayList<MatchPair>();

        for (int i = 0; i < this.singles.size() - 1; i++) {
            if(indicesFoundMatch.contains(i)){
                continue;
            }
            for (int j = i+1; j < this.singles.size(); j++) {
                if(!indicesFoundMatch.contains(j)
                        && this.singles.get(i).matchWith(this.singles.get(j))){
                    matches.add(new MatchPair(this.singles.get(i), this.singles.get(j)));
                    indicesFoundMatch.add(i);
                    indicesFoundMatch.add(j);
                    break;
                }
            }
        }
        return matches.toArray(new MatchPair[0]);
    }

    /**
     * This method finds as many matches as the 'findMatchPairs1' method with a better performance.
     * Non-hetero singles are handed into the 'findMatchPairs1' method. The hetero singles are
     * divided into females and males. In the further algorithm no singles of the same sex are compared.
     * @return an Array of MatchPair objects
     */
    public MatchPair[] findMatchPairs2(){
        if(this.singles.size() < 2){
            return new MatchPair[] {};
        }

        Singles nonHeteros = new Singles(this.getNonHeteros());
        MatchPair[] nonHeteroMatches = nonHeteros.findMatchPairs1();

        Singles heteros = new Singles(this.getHeteros());
        Single[] heteroMales = heteros.getMales();
        Single[] heteroWoman = heteros.getWoman();

        /*
        In this algorithm, each woman goes through the group of men and picks the first one
        that resulted in a match (this will be saved as a MatchPair). Because of that we only
        need to remember the indices of the MEN (who already had a match).
         */
        ArrayList<Integer> indicesMalesFoundMatch = new ArrayList<Integer>();

        ArrayList<MatchPair> heteroMatches = new ArrayList<MatchPair>();

        for (int i = 0; i < heteroWoman.length; i++) {
            for (int j = 0; j < heteroMales.length; j++) {
                if(!indicesMalesFoundMatch.contains(j)
                && heteroWoman[i].matchWith(heteroMales[j])){
                    heteroMatches.add(new MatchPair(heteroWoman[i], heteroMales[j]));
                    indicesMalesFoundMatch.add(j);
                    break;
                }
            }
        }

        ArrayList<MatchPair> allMatches = heteroMatches;
        allMatches.addAll(Arrays.asList(nonHeteroMatches));

        return allMatches.toArray(new MatchPair[0]);
    }

    public Single[] getHeteros(){
        ArrayList<Single> heteros = new ArrayList<Single>();

        for (Single single: this.singles
             ) {
            if(single.isHetero()){
                heteros.add(single);
            }
        }

        return heteros.toArray(new Single[0]);
    }

    public Single[] getNonHeteros(){
        ArrayList<Single> nonHeteros = new ArrayList<Single>();

        for (Single single: this.singles
        ) {
            if(!single.isHetero()){
                nonHeteros.add(single);
            }
        }

        return nonHeteros.toArray(new Single[0]);
    }

    public Single[] getWoman(){
        ArrayList<Single> woman = new ArrayList<Single>();

        for (Single single: this.singles
        ) {
            if(single.getGender() == Gender.FEMALE){
                woman.add(single);
            }
        }

        return woman.toArray(new Single[0]);
    }

    public Single[] getMales(){
        ArrayList<Single> males = new ArrayList<Single>();

        for (Single single: this.singles
        ) {
            if(single.getGender() == Gender.MALE){
                males.add(single);
            }
        }

        return males.toArray(new Single[0]);
    }

    public Single[] getDiverse(){
        ArrayList<Single> diverse = new ArrayList<Single>();

        for (Single single: this.singles
        ) {
            if(single.getGender() == Gender.DIVERSE){
                diverse.add(single);
            }
        }

        return diverse.toArray(new Single[0]);
    }

    public Single[] getAllSingles() {
        return this.singles.toArray(new Single[0]);
    }

    public void addSingle(Single single){
        this.singles.add(single);
    }
}
