

/**
 * Here it is demonstrated that the algorithm 'findMatchPairs2'
 * is more performant and finds as many matches as 'findMatchPairs1'.
 * For a more obvious difference, add more Single objects.
 * For details check the classes Single, Singles and MatchPair.
 */
public class MatchFinderDemo {
    public static void main(String[] args) throws CloneNotSupportedException {

        Single s1 = new Single("Hans", "Krüger", Gender.MALE, 54, new Gender[]{Gender.FEMALE}, 40, 60);
        Single s2 = new Single("Lisa", "Müller", Gender.FEMALE, 26, new Gender[]{Gender.FEMALE, Gender.DIVERSE}, 22, 40);
        Single s3 = new Single("Hildebrand", "Holzschläger", Gender.FEMALE, 35, new Gender[]{Gender.MALE}, 35, 65);
        Single s4 = new Single("Finn", "Kropp", Gender.MALE, 21, new Gender[]{Gender.MALE}, 22, 29);
        Single s5 = new Single("Wilhelmine", "Kasten", Gender.FEMALE, 45, new Gender[]{Gender.MALE}, 40, 66);
        Single s6 = new Single("Murat", "Kosar", Gender.MALE, 34, new Gender[]{Gender.FEMALE}, 22, 36);
        Single s7 = new Single("Mira", "Kraftschlag", Gender.DIVERSE, 23, new Gender[]{Gender.FEMALE}, 20, 35);
        Single s8 = new Single("Sergej", "Krachbach", Gender.MALE, 29, new Gender[]{Gender.MALE, Gender.FEMALE}, 22, 66);
        Single s9 = new Single("Gönül", "Porcu", Gender.FEMALE, 20, new Gender[]{Gender.MALE}, 19, 30);
        Single s10 = new Single("Pedro", "Mariano", Gender.MALE, 35, new Gender[]{Gender.FEMALE}, 30, 36);

        Singles singles = new Singles(new Single[]{s1, s2, s3, s4, s5, s6, s7, s8, s9, s10});

        final long timeStart1 = System.currentTimeMillis();
        MatchPair[] matchPairs = singles.findMatchPairs1();
        final long timeEnd1 = System.currentTimeMillis();
        final long time1 = timeEnd1 - timeStart1;

        final long timeStart2 = System.currentTimeMillis();
        MatchPair[] matchPairs2 = singles.findMatchPairs2();
        final long timeEnd2 = System.currentTimeMillis();
        final long time2 = timeEnd2 - timeStart2;

        System.out.println("Find MatchPairs with 'findMatchPairs1' (" + time1 + " Milliseconds):" + '\n');
        for (MatchPair matchPair : matchPairs
        ) {
            System.out.println(matchPair);
        }

        System.out.println("_________________________________________" + '\n'
                            + "_________________________________________" +'\n');

        System.out.println("Find MatchPairs with 'findMatchPairs2' (" + time2 + " Milliseconds):" + '\n');
        for (MatchPair matchPair : matchPairs2
        ) {
            System.out.println(matchPair);
        }
    }
}