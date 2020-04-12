import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix {
    private List<List<Integer>> values;
    private Set<MatrixCoordinate> saddlePoints = new HashSet<>();

    Matrix( List<List<Integer>> values ) {
        this.values = new ArrayList<>( );
        for( List<Integer> row : values ){
            this.values.add( List.copyOf( row ) );
        }

        determineSaddlePoints();
    }

    private List<Integer> getColumn( Integer columnNumber ) {
        List<Integer> column = new ArrayList<>();

        if( columnNumber >= 0 && !this.values.isEmpty() ) {
            for ( List<Integer> row : this.values ) {
                column.add( row.get( columnNumber ) );
            }
        }

        return column;
    }

    // Get sorted MatrixCoordinates of RowMax
    private Set<MatrixCoordinate> getRowMaxes() {
        Set<MatrixCoordinate> rowMaxes = new HashSet<>(  );
        int rowNumber = 1;

        // Get a single row
        for ( List<Integer> row : this.values ) {
            int columnNumber = 1;
            Integer maxValue = Collections.max( row );

            for( Integer rowValue : row ){
                if( maxValue.equals( rowValue ) ){
                    rowMaxes.add( new MatrixCoordinate( rowNumber, columnNumber ) );
                }
                columnNumber++;
            }

            rowNumber++;
        }

        return rowMaxes;
    }

    // Get sorted MatrixCoordinates of ColumnMin
    private Set<MatrixCoordinate> getColMins(){
        Set<MatrixCoordinate> colMins = new HashSet<>(  );
        int columnNumber = 0;

        for( int columnPos = 0; columnPos < this.values.get(0).size(); columnPos++ ){
            List<Integer> col = this.getColumn( columnNumber++ );
            Integer colMin = Collections.min( col );
            Integer rowPos = 0;

            for( Integer colValue : col ){
                if( colMin.equals( colValue )){
                    colMins.add( new MatrixCoordinate( rowPos + 1, columnPos + 1  ) );
                }
                rowPos++;
            }
        }

        return colMins;
    }

    private void determineSaddlePoints() {
        if( !this.values.isEmpty() ) {

            this.saddlePoints = this.getRowMaxes();
            this.saddlePoints.retainAll( this.getColMins() );

        }
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return saddlePoints;
    }
}
