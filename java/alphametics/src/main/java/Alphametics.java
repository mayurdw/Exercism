import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class Alphametics {
    private final String equation;
    public Alphametics( String equation ){
        this.equation = equation;
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

    LinkedHashMap<Character, Integer> solve() throws UnsolvablePuzzleException{
        if( !this.equation.contains( " + " ) && !this.equation.contains( " == " ) ){
            throw new UnsolvablePuzzleException( "Not an equation" );
        }

        List<String> additions = new ArrayList<>();
        String sum = this.findSumAndParts( additions );



        return null;
    }
}