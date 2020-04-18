import java.util.Arrays;
import java.util.stream.IntStream;

class LuhnValidator {
    boolean isValid( String candidate ) {
        if( candidate.length() < 2 )
            return false;

        int[] intCandidate = Arrays.stream( candidate.replaceAll( "[^\\d]", "" ).replace( " ", "" ).split( "" ) ).mapToInt( Integer::parseInt ).toArray();

        for ( int x = intCandidate.length - 2; x >= 0; x -= 2 ) {

            System.out.println( "Value at index " + x + " is " + intCandidate[x] );

            intCandidate[x] *= 2;
            if( intCandidate[x] > 9 )
                intCandidate[x] -= 9;

            System.out.println( "Value at index " + x + " is " + intCandidate[x] );
        }

        return ( ( IntStream.of( intCandidate ).sum() % 10 ) == 0 );
    }

}
