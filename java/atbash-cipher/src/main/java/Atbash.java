import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Atbash cipher algorithm
 */
public class Atbash {
    /**
     * Encodes the string by the algorithm
     *
     * @param rawText to be encoded
     * @return {@link String} cipher
     */
    public String encode( String rawText ) {
        if ( rawText != null && !rawText.isBlank() ) {
            StringBuilder stringBuilder = new StringBuilder();
            int additions = 0;

            char[] chars = rawText.toLowerCase().replaceAll( " ", "" ).toCharArray();

            for ( char aChar : chars ) {
                if ( additions != 0 && additions % 5 == 0 ) {
                    stringBuilder.append( " " );
                    additions = 0;
                }

                if ( Character.isAlphabetic( aChar ) ) {
                    stringBuilder.append( this.shiftChar( aChar ) );
                    additions++;
                } else if ( Character.isDigit( aChar ) ) {
                    stringBuilder.append( aChar );
                    additions++;
                }
            }

            return stringBuilder.toString().trim();
        }
        return null;
    }

    /**
     * Shifts the character
     * @param c character to be shifted
     * */
    private char shiftChar( char c ){
        return ( char )( 'z' - c + 'a' );
    }

    /**
     * Decodes the string by the algorithm
     *
     * @param cipher to be decoded
     * @return {@link String} rawText
     */
    public String decode( String cipher ) {
        char[] code = cipher.replaceAll( " ", "").toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for( char a : code ){
            if( Character.isAlphabetic( a ) ) {
                stringBuilder.append( this.shiftChar( a ) );
            } else {
                stringBuilder.append( a );
            }
        }

        return stringBuilder.toString().trim();
    }
}