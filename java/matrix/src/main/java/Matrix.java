import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix {
    private String matrixAsString;
    private List<int[]> matrixRows = new ArrayList<>();
    private List<int[]> matrixColumms = new ArrayList<>();
    private int numberOfRows = 0;
    private int numberOfColumns = 0;

    Matrix(String matrixAsString) {
        this.matrixAsString = matrixAsString;
        this.populateMatrixRows();
        this.getNumberOfColumns();
        this.populateMatrixColumns();
    }

    private void populateMatrixRows(){
        String[] matrixRows = this.matrixAsString.split("\n");

        this.numberOfRows = matrixRows.length;
        for( String s : matrixRows ){
            String[] rowString = s.split(" ");
            int[] rowInt = new int[rowString.length];
            int index = 0;

            for( String s2 : rowString ){
                rowInt[index++] = Integer.parseInt(s2);
            }

            this.matrixRows.add(rowInt);
        }
    }

    private void getNumberOfColumns(){
        int endIndex = 0;
        int x = 0;

        this.numberOfColumns = 0;

        if ( this.matrixAsString.contains("\n")){
            endIndex = this.matrixAsString.indexOf("\n");
        }
        else{
            endIndex = this.matrixAsString.length();
        }

        Pattern P = Pattern.compile(" ", Pattern.LITERAL);
        Matcher m = P.matcher(this.matrixAsString.substring(0, endIndex));

        while(m.find(x)){
            this.numberOfColumns++;
            x = m.start() + 1;
        }
    }

    private void populateMatrixColumns(){

    }

    int[] getRow(int rowNumber) {
        return this.matrixRows.get(rowNumber-1);
    }

    int[] getColumn(int columnNumber) {
        return this.matrixColumms.get(columnNumber - 1);
    }
}
