import java.nio.charset.StandardCharsets;
import java.util.Arrays;

class MicroBlog {
    public String truncate( String input ) {
        byte[] encoded_input = StandardCharsets.UTF_8.encode( input ).array();
        int maxLen = Math.min( encoded_input.length, 5 );

        return new String( Arrays.copyOf(encoded_input, maxLen), StandardCharsets.UTF_8 );
    }
}
