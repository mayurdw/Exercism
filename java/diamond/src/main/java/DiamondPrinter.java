import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DiamondPrinter {

    /**
     * Replaces chars at multiple indices with the replacement character
     * @param originalString {@link String} object
     * @param index1 first index
     * @param index2 second index. Can be same as first index
     * @param replacement character which will replace character at indices supplied
     * */
    private String replaceCharAtIndex( String originalString, int index1, int index2, char replacement ){
        if( originalString == null || index1 < 0 || index2 >= originalString.length() ){
            return null;
        }

        char[] chars = originalString.toCharArray();
        chars[index1] = replacement;
        if( index2 != index1 ){
            chars[index2] = replacement;
        }

        return String.valueOf( chars );
    }

    /**
     * Generates a diamond with the center being character supplied
     * @param a Character in the center
     * @return {@link List} of {@link String} objects making a diamond
     * */
    List<String> printToList(char a) {
        List<String> stringList = new ArrayList<>();
        if( Character.isAlphabetic( a ) ) {
            final int LINES_UNTIL_CENTER = Character.toUpperCase( a ) - 'A';
            if( 0 == LINES_UNTIL_CENTER ){
                stringList.add( "A" );
            } else {
                // Each line will be ( LINES_UNTIL_CENTER * 2 ) + 1 spaces
                final String LINE_SPACES = " ".repeat( ( LINES_UNTIL_CENTER * 2 + 1 ) );
                // Start position will b LINES_UNTIL_CENTER
                int leftStart = LINES_UNTIL_CENTER;
                int rightStart = LINES_UNTIL_CENTER;
                int i = 0;

                // First populate the upper half of the diamond until center
                for( ; ( i <= LINES_UNTIL_CENTER && leftStart >= 0 && rightStart < LINE_SPACES.length() ); i++ ){
                    String line = this.replaceCharAtIndex( LINE_SPACES, leftStart, rightStart, ( char )( i + 'A' ) );

                    stringList.add( line );
                    leftStart--;
                    rightStart++;
                }

                // Go the the index before the center & add lines in descending order
                i -= 2;
                while( i >= 0 ){
                    stringList.add( stringList.get( i ) );
                    i--;
                }
            }
        }
        return stringList;
    }

}
