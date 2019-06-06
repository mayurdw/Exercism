
class Matrix {
    private String matrixAsString;
    private int numberOfRows = 1;

    Matrix(String matrixAsString) {
        int index = 0;
        this.matrixAsString = matrixAsString;
        while ((index = this.matrixAsString.indexOf('\n', index)) != -1) {
            this.numberOfRows++;
        }
    }

    int[] getRow(int rowNumber) {
        int[] rows = new int[this.numberOfRows];

        for (int i = 0; i < this.numberOfRows; i++) {
            String[] subString = this.matrixAsString.split(" ");

            for( String s : subString ){
                rows[i] = Integer.parseInt(s);
            }
        }

        return rows;
    }

    int[] getColumn(int columnNumber) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}
