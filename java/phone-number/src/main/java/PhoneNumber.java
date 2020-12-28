import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Phone Number class
 * Handles different phone number formatting for NANP countries
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
     */
    public PhoneNumber( String number ) {
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
    }

    /**
     * Returns the raw number without any formatting
     *
     * @return phone number
     */
    public String getNumber() {
        return this.number;
    }
}