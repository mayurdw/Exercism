class LargestSeriesProductCalculator {
    char[] inputNumber;
    LargestSeriesProductCalculator(String inputNumber) {
        this.inputNumber = inputNumber.toCharArray();
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        long largestProduct = 0, temp = 0;

        temp = Character.getNumericValue( this.inputNumber[0] ) * Character.getNumericValue( this.inputNumber[1] );

        if( temp > largestProduct )
            largestProduct = temp;

        return largestProduct;
    }
}
