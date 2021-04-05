import java.util.*;

public class Alphametics {
    private final String equation;
    public Alphametics( String equation ){
        this.equation = equation.toUpperCase( Locale.ROOT );
    }

    /**
     * Splits {@link Alphametics#equation} to Sum and its parts
     * @param parts {@link List} of Strings containing parts
     * @return sum {@link String} of the equation
     * */
    private String findSumAndParts( List<String> parts ){
        String sum = null;

        if( parts == null ){
            parts = new ArrayList<>();
        }
        final String EQUALS = " == ";
        int index = this.equation.indexOf( EQUALS );

        if( index < this.equation.length() && index >= 0 ){
            sum = this.equation.substring( index + EQUALS.length() );
            String part = this.equation.substring( 0, index );

            String[] splitParts = part.split( " \\+ " );

            parts.addAll( Arrays.asList( splitParts ) );
        }

        return sum;
    }

    LinkedHashMap<Character, Integer> getChars( String sum, List<String> parts ){
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();

        for( String part : parts ){
            for( char a : part.toCharArray() ){
                if( !hashMap.containsKey( a ) ){
                    hashMap.put( a, 0 );
                }
            }
        }

        for( char a : sum.toCharArray() ){
            if( !hashMap.containsKey( a ) ){
                hashMap.put( a, 0 );
            }
        }

        return hashMap;
    }

    /**
     * Converts the string to sum of values based on pairs
     * @param pairs {@link LinkedHashMap} of character values
     * @param stringToConvert {@link String} that needs converting
     * */
    private Integer stringToSum( String stringToConvert, Map<Character, Integer> pairs ){
        Integer sum = 0;
        char[] charsToConvert = stringToConvert.toCharArray();

        for( char a : charsToConvert ){
            sum += pairs.get( a );
        }

        return sum;
    }

    /**
     * Gets the sum of string values based on character pairs
     * @param pairs {@link LinkedHashMap} of Character - Value
     * @param stringList {@link List} of strings
     * */
    private Integer sumOfStringList( List<String> stringList, Map<Character, Integer> pairs ){
        Integer sum = 0;

        for( String a : stringList ){
            sum += this.stringToSum( a, pairs );
        }

        return sum;
    }

    LinkedHashMap<Character, Integer> solve() throws UnsolvablePuzzleException{
        if( !this.equation.contains( " + " ) && !this.equation.contains( " == " ) ){
            throw new UnsolvablePuzzleException( "Not an equation" );
        }

        List<String> parts = new ArrayList<>();
        String sum = this.findSumAndParts( parts );
        LinkedHashMap<Character, Integer> solutionMap = this.getChars( sum, parts );
        LinkedHashMap<Character,Integer> tempMap = ( LinkedHashMap<Character, Integer> ) solutionMap.clone();

        // Main Algorithm
        solutionMap.put( sum.charAt( 0 ), 1 );
        boolean matchFound = false;
        Iterator<Map.Entry<Character, Integer>> iterator = solutionMap.entrySet().iterator();

        while( !matchFound && iterator.hasNext() ){
            Map.Entry<Character, Integer> key = iterator.next();
            for( int i = 0; i < 10; i++ ) {
                tempMap.put( key.getKey(), i );
            }
            Integer summationSum = this.stringToSum( sum, tempMap );
            Integer partsSum = this.sumOfStringList( parts, tempMap );

            matchFound = ( summationSum.equals( partsSum ) );
        }


        return tempMap;
    }
}