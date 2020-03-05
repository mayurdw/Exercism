import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

class Matrix {
    private List<List<Integer>> values;
    private Set<MatrixCoordinate> saddlePoints = Collections.emptySet();

    Matrix(List<List<Integer>> values) {
        this.values = values;
        determineSaddlePoints();
    }

    private void determineSaddlePoints(){
        if( !values.isEmpty()) {
            final int NUMBER_OF_ROWS    = values.size();
            final int NUMBER_OF_COLUMNS = values.get(0).size();

            // Get the max in a row
            // Get the min in a column
            // Compare the max & min positions

        }
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return saddlePoints;
    }
}
