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

    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return saddlePoints;
    }
}
