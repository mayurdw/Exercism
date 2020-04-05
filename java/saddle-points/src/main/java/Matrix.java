import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix {
    private List<List<Integer>> values;
    private Set<MatrixCoordinate> saddlePoints = new HashSet<>();
    private final int NUMBER_OF_COLUMNS;

    Matrix(List<List<Integer>> values) {
        this.values = values;
        this.NUMBER_OF_COLUMNS = ( !this.values.isEmpty() ) ? values.get(0).size() : 0;
        determineSaddlePoints();
    }

    private List<Integer> getColumn( Integer columnNumber ){
        List<Integer> column = new ArrayList<>();

        if( columnNumber >= 0 && !this.values.isEmpty() && this.NUMBER_OF_COLUMNS != 0){
            for( List<Integer> row : this.values ){
                column.add(row.get(columnNumber));
            }
        }

        return column;
    }

    private void determineSaddlePoints(){
        if( !this.values.isEmpty() ) {
            int rowNumber = 0;

            for( List<Integer> row : this.values ){
                rowNumber++;
                if( !row.isEmpty()){
                    final int ROW_MAX = Collections.max(row);
                    for( int x = 0; x < row.size(); x++ ) {
                        if ( row.get(x) == ROW_MAX && ( Collections.min(this.getColumn(x)) == row.get(x) ) ) {
                            this.saddlePoints.add(new MatrixCoordinate(rowNumber, x + 1));
                        }
                    }
                }
            }
        }
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return saddlePoints;
    }
}
