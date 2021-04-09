import java.util.*;

/**
 * Helper class for {@link Alphametics} class
 * */

public class AlphameticsHelper {
    static Character currentKey = '0';
    static Integer currentValue = -1;

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

    public static String breakStringToSumAndParts( String stringToBreak, List<String> parts ) throws UnsolvablePuzzleException{
        final String PLUS = "+";
        final String EQUALS = "=";

        if( stringToBreak == null || !stringToBreak.contains( PLUS ) || !stringToBreak.contains( EQUALS ) ){
            throw new UnsolvablePuzzleException( "String to break is not valid" );
        }

        if( parts == null ){
            parts = new ArrayList<>();
        }
        stringToBreak = stringToBreak.toUpperCase( Locale.ROOT ).replaceAll( " ", "" );
        int equalsIndex = stringToBreak.indexOf( EQUALS );

        parts.addAll( Arrays.asList( stringToBreak.substring( 0, equalsIndex ).split( "\\+" ) ) );

        return stringToBreak.substring( equalsIndex + 1 ).trim();
    }

    public static LinkedHashMap<Character, Integer> getNextNumberSet( LinkedHashMap<Character, Integer> charIntMap ) throws UnsolvablePuzzleException{
        if( charIntMap == null || charIntMap.size() <= 1 ){
            throw new UnsolvablePuzzleException( "Cannot get next number set" );
        }

        LinkedHashMap<Character, Integer> newMap = new LinkedHashMap<>();


        if( AlphameticsHelper.currentKey.equals( '0' ) ){
            // Uninitialised
            AlphameticsHelper.currentKey = charIntMap.keySet().toArray( new Character[0] )[0];
            AlphameticsHelper.currentValue = -1;
        } else if( AlphameticsHelper.currentValue >= 9 ){
            List<Character> list = Arrays.asList( charIntMap.keySet().toArray( new Character[0] ) );
            int index = list.indexOf( currentKey );
            if( ++index == list.size() ){
                throw new UnsolvablePuzzleException( "Cannot solve this" );
            }

            AlphameticsHelper.currentKey = list.get( index );
            AlphameticsHelper.currentValue = -1;
        }

        AlphameticsHelper.currentValue++;
        Set<Integer> currentValues = new HashSet<>( charIntMap.size() );


        currentValues.add( AlphameticsHelper.currentValue );

        for( Map.Entry<Character, Integer> entry : charIntMap.entrySet() ){
            Integer newValue;
            if( !entry.getKey().equals( AlphameticsHelper.currentKey ) ){
                newValue = entry.getValue();
                while( currentValues.contains( newValue ) ){
                    newValue++;

                    if( newValue > 9 ){
                        newValue = 0;
                    }
                }

            } else {
                newValue = AlphameticsHelper.currentValue;
            }
            currentValues.add( newValue );
            newMap.put( entry.getKey(), newValue );
        }
        return newMap;
    }

    public static LinkedHashMap<Character, Integer> splitStringToChars( String stringToSplit, LinkedHashMap<Character, Integer> currentMap ) throws UnsolvablePuzzleException{
        if( stringToSplit == null || ( stringToSplit.length() == 0 && currentMap == null ) ){
            throw new UnsolvablePuzzleException( "String is empty" );
        }

        if( currentMap == null ){
            currentMap = new LinkedHashMap<>();
        }

        char[] chars = stringToSplit.trim().toUpperCase( Locale.ROOT ).toCharArray();

        for( char a : chars ){
            if ( !currentMap.containsKey( a ) ) {
                currentMap.put( a, ( int ) ( Math.random() * 9 ) );
            }
        }

        return currentMap;
    }
}