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

    LinkedHashMap<Character, Integer> solve() throws UnsolvablePuzzleException{
        if( !this.equation.contains( " + " ) && !this.equation.contains( " == " ) ){
            throw new UnsolvablePuzzleException( "Not an equation" );
        }

        List<String> parts = new ArrayList<>();
        String sum = this.findSumAndParts( parts );


        return this.getChars( sum, parts );
    }
}