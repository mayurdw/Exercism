import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public Map<String, Integer> phrase( String sentence ) {
        String[] words = sentence.split( "[^a-zA-Z\\d]" );
        Map<String, Integer> wordCount = new HashMap<>( );

        for( String word : words ){
            System.out.println( "Word = " + word );
            if( word.length() > 0 ) {
                wordCount.merge( word.toLowerCase(), 1, Integer::sum );
            }
        }

        return wordCount;
    }

}