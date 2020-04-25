import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public Map<String, Integer> phrase( String sentence ) {
        String[] words = sentence.split( "[\\W&&[^']]" );
        Map<String, Integer> wordCount = new HashMap<>( );

        for( String word : words ){
            if( word.length() > 0 ) {
                if( word.indexOf( "'" ) == 0 && ( word.lastIndexOf( "'" ) == word.length() - 1 ) ) {
                    word = word.substring( 1, word.length() - 1 );
                }
                wordCount.merge( word.toLowerCase(), 1, Integer::sum );
            }
        }

        return wordCount;
    }

}