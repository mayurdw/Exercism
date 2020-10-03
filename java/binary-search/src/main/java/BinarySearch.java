import java.util.List;

/**
 * Class which performs binary search
 * */
public class BinarySearch{
    List<Integer> list;
    /**
     * Main constructor
     * @param list {@link List} of {@link Integer} type
     * */
    public BinarySearch( List<Integer> list ){
        this.list = list;
    }

    /**
     * Returns the search result
     * @param value to be found
     * @return index of type long
     * */
    public long indexOf( Integer value ){
        // Let's do this first on how I would do this in C.
        int mid = this.list.size() / 2;
        if( value.equals( this.list.get( mid ) ) ){
            return mid;
        }

        return 0;
    }
}