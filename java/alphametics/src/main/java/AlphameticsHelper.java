import java.util.Map;

/**
 * Helper class for {@link Alphametics} class
 * */

public class AlphameticsHelper {

    /**
     * Converts a String to a number
     * @param pairs Character value pairs
     * @param stringToSum String that needs to be summed
     * @throws UnsolvablePuzzleException if pairs do not contain all keys
     * */
    public static int getStringSum( String stringToSum, Map<Character, Integer> pairs ) throws UnsolvablePuzzleException{
        StringBuilder summedString = new StringBuilder();

        for( char a : stringToSum.toCharArray() ){
            if( !pairs.containsKey( a ) ){
                throw new UnsolvablePuzzleException( "Doesn't contain all keys" );
            }
            summedString.append( pairs.get( a ) );
        }

        return Integer.parseInt( summedString.toString() );
    }
}