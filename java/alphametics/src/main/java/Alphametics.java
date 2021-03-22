import java.util.LinkedHashMap;

public class Alphametics {
    private final String equation;
    public Alphametics( String equation ){
        this.equation = equation;
    }

    LinkedHashMap<Character, Integer> solve() throws UnsolvablePuzzleException{
        if( !this.equation.contains( "+" ) ){
            throw new UnsolvablePuzzleException( "Not an equation" );
        }

        return null;
    }
}