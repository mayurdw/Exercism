/**
 * Run Length Encoding and Decoding algorithm
 * */
public class RunLengthEncoding {
    /**
     * Encodes the sequence according to the algorithm
     * @param sequence to be encoded
     * */
    public String encode( String sequence ){
        StringBuilder code = new StringBuilder();
        if( sequence != null && !sequence.isEmpty() ) {
            char[] alpha = sequence.toCharArray();
            char currentAlpha = alpha[0];
            int count = 0;

            for ( char letter : alpha ) {
                if ( currentAlpha != letter ) {
                    if ( count > 1 ) {
                        code.append( count );
                    }
                    code.append( currentAlpha );
                    currentAlpha = letter;
                    count = 0;
                } else {
                    count++;
                }
            }
            if( count > 1 ){
                code.append( count );
            }
            code.append( alpha[alpha.length - 1] );
        }

        return code.toString();
    }

    /**
     * Decodes the code
     * @param code to be decoded
     * */
    public String decode( String code ){
        return null;
    }
}