import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import java.util.*;

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

    @Test
    public void testSimpleSplit() throws UnsolvablePuzzleException {
        String sum = "ABC";
        List<String> parts = Arrays.asList( "A", "B", "C" );
        List<String> actualParts = new ArrayList<>();

        assertEquals( sum, AlphameticsHelper.breakStringToSumAndParts( "A + B + C = " + sum, actualParts ) );
        assertEquals( parts, actualParts );
    }


    @Test
    public void basicMapTest() throws UnsolvablePuzzleException {
        LinkedHashMap<Character, Integer> inputMap = new LinkedHashMap<>();
        LinkedHashMap<Character, Integer> expectedMap = new LinkedHashMap<>();

        inputMap.put( 'A', 0 );
        inputMap.put( 'B', 0 );
        expectedMap.put( 'A', 0 );
        expectedMap.put( 'B', 1 );

        assertEquals( expectedMap, AlphameticsHelper.getNextNumberSet( inputMap ) );
        inputMap.clear();
        inputMap.putAll( expectedMap );
        expectedMap.clear();
        expectedMap.put( 'A', 1 );
        expectedMap.put( 'B', 2 );

        assertEquals( expectedMap, AlphameticsHelper.getNextNumberSet( inputMap ) );
    }

    @Test
    public void full() throws UnsolvablePuzzleException {
        LinkedHashMap<Character, Integer> inputMap = new LinkedHashMap<>();
        LinkedHashMap<Character, Integer> expectedMap = new LinkedHashMap<>();

        inputMap.put( 'A', 0 );
        inputMap.put( 'B', 0 );
        inputMap.put( 'C', 0 );
        expectedMap.put( 'A', 8 );
        expectedMap.put( 'B', 9 );
        expectedMap.put( 'C', 0 );

        for( int i = 0; i < 8; i++ ){
            inputMap = AlphameticsHelper.getNextNumberSet( inputMap );
        }

        assertEquals( expectedMap, AlphameticsHelper.getNextNumberSet( inputMap ) );
    }

    @Test
    public void simpleSplitToMap() throws UnsolvablePuzzleException {
        LinkedHashMap<Character, Integer> actualMap = new LinkedHashMap<>();
        Set<Character> expectedKeys = new HashSet<>();
        String stringToSplit = "ABCAHD";

        expectedKeys.add( 'A' );
        expectedKeys.add( 'B' );
        expectedKeys.add( 'C' );
        expectedKeys.add( 'H' );
        expectedKeys.add( 'D' );

        assertEquals( expectedKeys, AlphameticsHelper.splitStringToChars( stringToSplit, actualMap ).keySet() );
    }
}
