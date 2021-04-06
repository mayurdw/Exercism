import java.util.*;

public class Alphametics {
    private final String equation;
    public Alphametics( String equation ){
        this.equation = equation.toUpperCase( Locale.ROOT );
    }

    LinkedHashMap<Character, Integer> solve() throws UnsolvablePuzzleException{
        if( !this.equation.contains( " + " ) && !this.equation.contains( " == " ) ){
            throw new UnsolvablePuzzleException( "Not an equation" );
        }

        return null;
    }
}