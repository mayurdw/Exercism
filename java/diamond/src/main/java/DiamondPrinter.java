import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {
        List<String> stringList = new ArrayList<>();
        if( Character.isAlphabetic( a ) ) {
            final int LINES_UNTIL_CENTER = Character.toUpperCase( a ) - 'A';
            if( 0 == LINES_UNTIL_CENTER ){
                stringList.add( "A" );
            } else {
                // Number of columns = ( a - 'A' ) * 2 + 1
                // Number of rows = ( a - 'A' ) * 2 + 1
                // Number of spaces = a - 'A'
                final int NUMBER_OF_ROWS = LINES_UNTIL_CENTER * 2 + 1;
                final int NUMBER_OF_COLS = LINES_UNTIL_CENTER * 2 + 1;
                int startingSpaces = LINES_UNTIL_CENTER;
                for( int i = 0; i < NUMBER_OF_ROWS; i++ ){
                    String line = "";
                    String spaces = "";

                    if( startingSpaces > i ) {
                        spaces = " ".repeat( startingSpaces - i );
                    }

                    line = line.concat( spaces );
                    line = line.concat( Character.toString( 'A' + i ) );
                    line = line.concat( spaces );
                    startingSpaces--;

                    stringList.add( line );
                }

            }
        }
        return stringList;
    }

}
