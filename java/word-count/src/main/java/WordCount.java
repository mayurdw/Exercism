import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public Map<String, Integer> phrase( String sentence ) {
        String[] words = sentence.split( "[^a-zA-Z]" );
        Map<String, Integer> wordCount = new HashMap<>( );

        for( String word : words ){
            wordCount.merge( word, 1, Integer::sum );
        }

        return wordCount;
    }

}