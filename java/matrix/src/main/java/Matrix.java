import java.util.ArrayList;
import java.util.List;

class Matrix {
	private List<int[]> matrix = new ArrayList<>();

	Matrix( String matrixAsString ) {
    	this.populateMatrix(matrixAsString);
	}

	private void populateMatrix( String matrixAsString ) {
	    String[] matrixRows = matrixAsString.split( "\n" );

        for ( String s : matrixRows ) {
            String[] rowString = s.split( " " );
            int[] rowInt = new int[rowString.length];
            int index = 0;

            for ( String s2 : rowString ) {
                rowInt[index++] = Integer.parseInt( s2 );
            }

            this.matrix.add( rowInt.clone() );
        }
	}

	int[] getRow( int rowNumber ) {
		return this.matrix.get( rowNumber - 1 );
	}

	int[] getColumn( int columnNumber ) {
		int[] tempArray = new int[this.matrix.size()];
        int x = 0;

        while( x < tempArray.length ){
            tempArray[x] = this.matrix.get( x )[columnNumber - 1];
            x++;
        }

        return tempArray;
	}
}
