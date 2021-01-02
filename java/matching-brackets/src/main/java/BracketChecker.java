import java.util.ArrayList;
import java.util.List;

/**
 * Matching bracket checker
 */
public class BracketChecker {
    private final boolean areBracketsCorrect;

    /**
     * Public constructor
     *
     * @param brackets to be checked
     */
    public BracketChecker( String brackets ) {
        this.areBracketsCorrect = this.checkBrackets( brackets );
    }

    /**
     * @return true if constructor was given correct brackets
     */
    public boolean areBracketsMatchedAndNestedCorrectly() {
        return this.areBracketsCorrect;
    }

    /**
     * Checks brackets
     *
     * @param brackets to be checked
     * @return true if brackets are correct
     */
    private boolean checkBrackets( String brackets ) {
        if ( brackets != null && !brackets.isBlank() ) {
            char[] bracketsArray = brackets.toCharArray();
            List<Character> seenBrackets = new ArrayList<>();

            for ( char c : bracketsArray ) {
                if ( '[' == c || '{' == c || '(' == c ) {
                    seenBrackets.add( c );
                } else if ( ']' == c || '}' == c || ')' == c ) {
                    char charToRemove;
                    if( ']' == c ){
                        charToRemove = '[';
                    } else if( '}' == c ){
                        charToRemove = '{';
                    } else {
                        charToRemove = '(';
                    }

                    int index = seenBrackets.lastIndexOf( charToRemove );
                    int lastIndex = seenBrackets.size() - 1;
                    if( index >= 0 && ( index == lastIndex ) ) {
                        seenBrackets.remove( index );
                    } else {
                        seenBrackets.add( c );
                    }
                }
            }

            return ( 0 == seenBrackets.size() );

        }
        // If no brackets, send true
        return true;
    }
}