import java.util.Arrays;
/**
 * Phone Number class
 * Handles different phone number formatting for
 * North American Numbering Plan countries
 */
public class PhoneNumber {
    /**
     * Stores the raw number
     */
    private String number;

    /**
     * Public & only constructor
     *
     * @param number Formatted phone number string
     * @throws IllegalArgumentException if number is incorrect
     */
    public PhoneNumber( String number ) {
        if( number.toLowerCase().matches( ".*[a-z]+.*" ) ){
            throw new IllegalArgumentException( "letters not permitted" );
        } else if( number.matches( ".*[@:!]+.*" ) ){
            throw new IllegalArgumentException("punctuations not permitted");
        }

        this.number = Arrays.stream( number.split( "" ) ).
                filter( i -> i.matches( "\\d+" ) ).
                collect(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append ).
                toString();

        int length = this.number.length();

        if ( length != 10 ) {
            if ( 11 == length ) {
                if ( !this.number.startsWith( "1" ) ) {
                    throw new IllegalArgumentException( "11 digits must start with 1" );
                } else {
                    this.number = this.number.substring( 1 );
                }
            } else {
                String message = ( length > 11 ) ? "more than 11 digits" : "incorrect number of digits";
                throw new IllegalArgumentException( message );
            }
        }

        this.codeCheck( "area", this.number.charAt( 0 ) );

        this.codeCheck( "exchange", this.number.charAt( 3 ) );
    }

    /**
     * Checks if code is less than 2
     * @param errorMessage Exception message to be used
     * @param code to be checked
     * @throws IllegalArgumentException if code is invalid
     * */
    private void codeCheck( String errorMessage, char code ){
        if( code < '2' ){
            String codeMessage = switch( code ){
                case '0' -> "zero";
                case '1' -> "one";
                default -> "unknown";
            };

            throw new IllegalArgumentException( errorMessage + " code cannot start with " + codeMessage );
        }
    }

    /**
     * Returns the raw number without any formatting
     *
     * @return {@link PhoneNumber#number}
     */
    public String getNumber() {
        return this.number;
    }
}