import java.util.regex.Matcher;

class Scrabble {
    private final String[][] POINTS_ARRAY = {
            {},
            { "A", "E", "I", "O", "U", "L", "N", "R", "S", "T" },
            { "D", "G" },
            { "B", "C", "M", "P" },
            { "F", "H", "V", "W", "Y" },
            { "K" },
            {},
            {},
            { "J", "X" },
            {},
            { "Q", "Z" },
    };
    private String word;
    private int iScore;

    Scrabble(String word) {
        this.word = word.toUpperCase();
    }

    int getScore() {
        for( int i = 1; i < POINTS_ARRAY.length; i++ ) {
            for (int j = 0; j < POINTS_ARRAY[i].length; j++ ) {
                // Subtract the total length minus the length of the word without the string in consideration
                this.iScore += ( word.length() - word.replace(POINTS_ARRAY[i][j], "").length() ) * ( i );
            }
        }
        return this.iScore;
    }
}
