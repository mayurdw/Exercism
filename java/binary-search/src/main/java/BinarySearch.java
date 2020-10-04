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
    public long indexOf( Integer value ) throws ValueNotFoundException {
        boolean found = false;
        int startIndex = 0;
        int endIndex = this.list.size();
        int index = -1;

        while( !found ){
            int mid = ( endIndex + startIndex ) / 2;
            if( mid >= this.list.size() ){
                break;
            } else {
                int indexValue = this.list.get( mid );

                if (value.equals(indexValue)) {
                    index = mid;
                    found = true;
                } else if( startIndex == endIndex ) {
                    // we haven't found the match. it doesn't exist
                    break;
                } else if (value > indexValue) {
                    startIndex = mid + 1;
                } else {
                    endIndex = mid - 1;
                }
            }
        }

        if( !found ){
            throw new ValueNotFoundException( "Value not in array" );
        }

        return index;
    }
}