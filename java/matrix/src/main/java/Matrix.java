import java.util.ArrayList;
import java.util.List;

class Matrix {
	private String matrixAsString;
	private List<int[]> matrix = new ArrayList<>();

	Matrix( String matrixAsString ) {
		this.matrixAsString = matrixAsString;
		this.populateMatrix();
	}

	private void populateMatrix() {
	    String[] matrixRows = this.matrixAsString.split( "\n" );

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
		return new int[0];
	}
	/*
	private void populateMatrixRows() {
		String[] matrixRows = this.matrixAsString.split( "\n" );

		this.numberOfRows = matrixRows.length;
		for ( String s : matrixRows ) {
			String[] rowString = s.split( " " );
			int[] rowInt = new int[rowString.length];
			int index = 0;

			for ( String s2 : rowString ) {
				rowInt[index++] = Integer.parseInt( s2 );
			}

			this.matrixRows.add( rowInt.clone() );
		}
	}

	private void getNumberOfColumns() {
		int endIndex = 0;
		int x = 0;

		this.numberOfColumns = 1;

		if ( this.matrixAsString.contains( "\n" ) ) {
			endIndex = this.matrixAsString.indexOf( "\n" );
		} else {
			endIndex = this.matrixAsString.length();
		}

		Pattern P = Pattern.compile( " ", Pattern.LITERAL );
		Matcher m = P.matcher( this.matrixAsString.substring( 0, endIndex ) );

		while ( m.find( x ) ) {
			this.numberOfColumns++;
			x = m.start() + 1;
		}
	}

	private void populateMatrixColumns() {
		String[] matrixArray = this.matrixAsString.replaceAll( "\n", " " ).split( " " );
		int x = 0, y = 0;
		int[] tempArray = new int[this.numberOfRows];

		while ( y < this.numberOfColumns ) {
			while ( x < this.numberOfRows ) {
				tempArray[x] = Integer.parseInt( matrixArray[y + ( x * this.numberOfColumns )] );
				x++;
			}
			this.matrixColumns.add( tempArray.clone() );
			y++;
			x = 0;
		}
	}
	*/
}
