import java.util.Arrays;

class LargestSeriesProductCalculator {
    int[] inputNumber;

    LargestSeriesProductCalculator( String inputNumber ) {
        if( inputNumber.length() > 0 ) {
            try {
                this.inputNumber = Arrays.stream(
                        inputNumber.split( "" ) ).mapToInt( Integer::parseInt ).toArray();
            } catch ( Exception e ) {
                throw new IllegalArgumentException( "String to search may only contain digits." );
            }
        } else {
            this.inputNumber = new int[0];
        }
    }

    private int multiplyArrayElements( int a[], int n ) {
        // Termination condition
        if( n == 0 )
            return ( a[n] );
        else
            return ( a[n] * multiplyArrayElements( a, n - 1 ) );
    }

    long calculateLargestProductForSeriesLength( int numberOfDigits ) {
        long largestProduct = 0, temp = 0;

        if( numberOfDigits > this.inputNumber.length ) {
            throw new IllegalArgumentException( "Series length must be less than or equal to the length of the string to search." );
        } else if( numberOfDigits < 0 ) {
            throw new IllegalArgumentException( "Series length must be non-negative." );
        } else if( numberOfDigits == 0 ){
            return 1;
        } else {

            for ( int x = 0; x <= this.inputNumber.length - numberOfDigits; x++ ) {

                temp = multiplyArrayElements(
                        Arrays.copyOfRange( this.inputNumber, x, x + numberOfDigits ),
                        numberOfDigits - 1 );

                if( temp > largestProduct )
                    largestProduct = temp;

            }

            System.out.println( "LargesProduct is " + largestProduct );
            return largestProduct;
        }
    }
}
