import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class AlphameticsHelperTest {

    @Test
    public void testBasicStringToSumConversion() throws UnsolvablePuzzleException {
        Map<Character, Integer> charMap = new LinkedHashMap<>();

        charMap.put( 'A', 1 );
        charMap.put( 'B', 2 );
        charMap.put( 'C', 3 );

        assertEquals( 123, AlphameticsHelper.getStringSum( "ABC", charMap ) );
    }

    @Test
    public void testLargeString() throws UnsolvablePuzzleException {
        Map<Character, Integer> charMap = new LinkedHashMap<>();


        charMap.put( 'A', 1 );
        charMap.put( 'B', 2 );
        charMap.put( 'C', 3 );
        charMap.put( 'D', 4 );
        charMap.put( 'E', 5 );
        charMap.put( 'F', 6 );
        charMap.put( 'G', 7 );
        charMap.put( 'H', 8 );
        charMap.put( 'I', 9 );
        charMap.put( 'J', 0 );

        assertEquals( 1234567890,
                AlphameticsHelper.getStringSum( "ABCDEFGHIJ", charMap ) );
    }
}
