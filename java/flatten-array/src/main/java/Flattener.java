import java.util.ArrayList;
import java.util.List;

public class Flattener {
    public Flattener() {
    }
    public <Object> List<Object> flatten( List<Object> list ){
        List<Object> flatList = new ArrayList<>();

        for( Object element : list ){
            if( element instanceof String || element instanceof Integer || element instanceof Character ){
                flatList.add( element );
            }
            else if( element instanceof List ){
            }
        }

        return flatList;
    }
}
