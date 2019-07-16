import java.util.ArrayList;
import java.util.List;

class Matrix {
    private int[][] matrix;

	Matrix( String matrixAsString ) {
		String[] matrixRows = matrixAsString.split( "\n" );
		this.matrix = new int[matrixRows.length][matrixRows[0].split( " " ).length];

		for ( int i = 0; i < matrixRows.length; i++ ) {
			String[] row = matrixRows[i].split( " " );
			for( int j = 0; j < row.length; j++ ){
				this.matrix[i][j] = Integer.parseInt( row[j] );
			}
		}
	}

	int[] getRow( int rowNumber ) {
		return this.matrix[rowNumber - 1].clone();
	}

	int[] getColumn( int columnNumber ) {
		int[] tempArray = new int[this.matrix.length];
        int x = 0;

        for( ; x < tempArray.length; x++ ){
            tempArray[x] = this.matrix[x][columnNumber - 1];
        }

        return tempArray;
	}
}
