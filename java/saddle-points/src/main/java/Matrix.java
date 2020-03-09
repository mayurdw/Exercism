import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

class Matrix {
    private List<List<Integer>> values;
    private Set<MatrixCoordinate> saddlePoints = Collections.emptySet();
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
            int rowPosition, columnPosition, rowMax, columnMin;
            // Get the max in a row
            for( List<Integer> row : this.values ){
                Integer temp = row.get(0);
                columnPosition = 0;
                for( Integer rowValue : row ){
                    if( temp < rowValue){
                        temp = rowValue;
                    }
                    columnPosition++;
                }
                rowMax = temp;
                rowPosition = 0;
                // Get the min in a column
                List<Integer> columns = getColumn(columnPosition);
                temp = columns.get(0);
                for( Integer columnValue : columns ){
                    if( temp > columnValue){
                        temp = columnValue;
                    }
                    rowPosition++;
                }
                columnMin = temp;

                // Compare the max & min values
                if( rowMax == columnMin ){
                    this.saddlePoints.add(new MatrixCoordinate(rowPosition, columnPosition));
                }
            }
        }
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return saddlePoints;
    }
}
