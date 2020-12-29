import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Nucleotide Counter
 * */
public class NucleotideCounter {
    private final Map<Character, Integer> nucleotideCount =
            Stream.of(
            new AbstractMap.SimpleEntry<>( 'A', 0 ),
            new AbstractMap.SimpleEntry<>( 'C', 0 ),
            new AbstractMap.SimpleEntry<>( 'G', 0 ),
            new AbstractMap.SimpleEntry<>( 'T', 0 )
            )
            .collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    /**
     * Calculates nucleotide counts
     * @param sequence to be counted
     * @throws IllegalArgumentException if sequence is invalid
     * */
    public NucleotideCounter( String sequence ){
        if( sequence != null ){
            for( char nucleotide : sequence.toCharArray() ){
                if( this.nucleotideCount.containsKey( nucleotide ) ){
                    this.nucleotideCount.put( nucleotide,
                            this.nucleotideCount.get( nucleotide ) + 1 );
                } else {
                    throw new IllegalArgumentException( "Invalid arg" );
                }
            }
        }
    }

    /**
     * Returns Nucleotide Counts
     * @return {@link Map} nucleotide counts*/
    Map<Character, Integer> nucleotideCounts() {
        return this.nucleotideCount;
    }
}