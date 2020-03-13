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
                    final int COLUMN_POSITION = row.indexOf(ROW_MAX);
                    List<Integer> column = this.getColumn(COLUMN_POSITION);
                    final int COLUMN_MIN = Collections.min(column);

                    if( COLUMN_MIN == ROW_MAX ){
                        this.saddlePoints.add(new MatrixCoordinate( rowNumber, COLUMN_POSITION + 1));
                    }
                }
            }
        }
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return saddlePoints;
    }
}
