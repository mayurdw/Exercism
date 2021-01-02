import java.util.ArrayList;
import java.util.List;

/**
 * Series Generator class
 * */
public class Series {
    private final String series;
    /**
     * Public constructor
     * @param numbers to be used to generate series from
     * */
    public Series( String numbers){
        this.series = numbers;
    }

    /**
     * Return the sliced series according to the number given
     * @param size of each slice
     * @return {@link List} of slices
     * */
    public List<String> slices( int size ) {
        if ( size > this.series.length() ) {
            throw new IllegalArgumentException( "Slice size is too big." );
        } else if( size <= 0 ){
            throw new IllegalArgumentException( "Slice size is too small." );
        }

        List<String> slices = new ArrayList<>();

        for( int i = 0; ( i + size ) <= this.series.length(); i++ ){
            slices.add( series.substring( i, i + size ) );
        }

        return slices;
    }

}