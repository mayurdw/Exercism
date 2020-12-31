import java.util.ArrayList;
import java.util.List;

/**
 * Handles allergies
 * */
public class Allergies {
    private final List<Allergen> allergenList = new ArrayList<>();

    /**
     * Public constructor
     * @param number the total score of all allergies
     * */
    public Allergies( int number ){
        for( Allergen a : Allergen.values() ){
            if( ( number & a.getScore() ) != 0 ){
                this.allergenList.add( a );
            }
        }
    }

    public boolean isAllergicTo( Allergen allergen ){
        return this.allergenList.contains( allergen );
    }

    List<Allergen> getList() {
        return this.allergenList;
    }
}