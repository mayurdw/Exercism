import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knapsack {
    public int maximumValue( int maxWeight, ArrayList<Item> items ){
        if( items.isEmpty() )
            return 0;
        List<Item> itemCopy = new ArrayList<>( items );

        itemCopy.removeIf( item -> item.getWeight() > maxWeight );

        if( itemCopy.isEmpty() ){
            return 0;
        }

        return 1;
    }
}