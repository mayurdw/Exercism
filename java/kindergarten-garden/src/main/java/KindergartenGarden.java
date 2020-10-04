import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Database to remember the plants of students
 * */
class KindergartenGarden {
    private final String GARDEN;
    // Can use tuples here to make a database
    // Or I can use a map of initial vs index
    // lets write down the name of the students
    private final List<String> STUDENTS =
            Arrays.asList("ALICE",
                    "BOB",
                    "CHARLIE",
                    "DAVID",
                    "EVE",
                    "FRED",
                    "GINNY",
                    "HARRIET",
                    "ILEANA",
                    "JOSEPH",
                    "KINCAID",
                    "LARRY");
    /**
     * Public constructor used to create the database
     * @param garden string containing the initial of each plant seed
     * */
    KindergartenGarden(String garden) {
        this.GARDEN = garden;
    }

    /**
     * This will check the student against the current database to return the plant list
     * @param student Name of the student
     * @return {@link List} of type {@link Plant}
     * */
    List<Plant> getPlantsOfStudent(String student) {
        List<Plant> plantList = new ArrayList<>();

        if ( student != null && this.STUDENTS.contains( student.toUpperCase() ) ){
            // Student is not null
            int index = this.STUDENTS.indexOf( student.toUpperCase() );
            // extract the garden to get the value.
            String[] rows = this.GARDEN.split("\n" );
            for( String row : rows ){
                String seeds = row.substring( index, index + 2 );
                plantList.add( Plant.getPlant( seeds.charAt( 0 ) ) );
                plantList.add( Plant.getPlant( seeds.charAt( 1 ) ) );
            }
        }

       return plantList;
    }

}
