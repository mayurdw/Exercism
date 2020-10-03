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
        boolean found = false;
        int startIndex = 0;
        int endIndex = this.list.size();
        int index = -1;

        // Let's do this first on how I would do this in C.
        while( !found ){
            int mid = ( endIndex + startIndex ) / 2;
            if( value.equals( this.list.get( mid ) ) ){
                index = mid;
                found = true;
            } else if( value > mid ){
                // uh oh I think it is stuck in an infinite loop
                // Yes this goes in an infinite loop
                startIndex = mid + 1;
            } else {
                endIndex = mid - 1;
            }
        }

        return index;
    }
}