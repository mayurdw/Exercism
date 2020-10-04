import java.util.*;

/**
 * Database to remember the plants of students
 * */
class KindergartenGarden {
    /**
     * Local database that exists within each object of Kindergarten Garden
     * */
    private final Map<String, List<Plant>> DATABASE = new HashMap<>();

    /**
     * Public constructor used to create the database
     * @param garden string containing the initial of each plant seed
     * */
    KindergartenGarden(String garden) {
        if( garden != null && garden.contains( "\n" ) ){
            final List<String> STUDENTS =
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
            final String[] ROWS = garden.split( "\n" );
            int multiplier = 0;

            for( String student : STUDENTS ) {
                List<Plant> plantList = new ArrayList<>();
                for( String row : ROWS ){
                    int index = STUDENTS.indexOf( student );
                    index += multiplier;
                    if( ( index + 1 ) < row.length() ) {
                        String seeds = row.substring(index, index + 2);
                        plantList.add(Plant.getPlant(seeds.charAt(0)));
                        plantList.add(Plant.getPlant(seeds.charAt(1)));
                    }
                }
                this.DATABASE.put( student, plantList );
                multiplier += 1;
            }
        }
    }

    /**
     * This will check the student against the current database to return the plant list
     * @param student Name of the student
     * @return {@link List} of type {@link Plant}
     * */
    List<Plant> getPlantsOfStudent(String student) {
        return this.DATABASE.getOrDefault( student.toUpperCase(), null );
    }

}
