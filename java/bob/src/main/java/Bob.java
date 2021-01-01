/**
 * Bob Answering Code
 * */
public class Bob {
    /**
     * Bob answers to text spoken
     * @param text spoke
     * */
    public String hey( String text ){
        if( text != null && !text.isEmpty() && !text.isBlank() ){
            boolean isQuestion = text.trim().endsWith( "?" );
            boolean isYelling = ( this.isYelling( text ) && text.equals( text.toUpperCase() ) );

            if( isQuestion && isYelling ){
                return "Calm down, I know what I'm doing!";
            } else if ( isYelling ){
                return "Whoa, chill out!";
            } else if( isQuestion ){
                return "Sure.";
            } else return "Whatever.";
        }
        return "Fine. Be that way!";
    }

    /**
     * Determine if the alpha text is capitals
     * */
    private boolean isYelling( String text ){
        boolean isYelling = false;
        char[] texts = text.toCharArray();

        for ( char c : texts ) {
            if ( Character.isAlphabetic( c ) ) {
                isYelling = ( Character.isUpperCase( c ) );
            }
        }

        return isYelling;
    }
}