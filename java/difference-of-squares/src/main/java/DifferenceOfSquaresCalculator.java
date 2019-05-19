class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        //Formula: https://trans4mind.com/personal_development/mathematics/series/sumNaturalNumbers.htm
        int square = ( input * ( input + 1 ) / 2 );

        return ( square * square );
    }

    int computeSumOfSquaresTo(int input) {
        // Formula: https://www.math-only-math.com/sum-of-the-squares-of-first-n-natural-numbers.html
        return ( input * ( input + 1 ) * ( 2 * input + 1 ) / 6 );
    }

    int computeDifferenceOfSquares(int input) {
        final int SUM_OF_SQUARE = computeSumOfSquaresTo(input);
        final int SQUARE_OF_SUM = computeSquareOfSumTo(input);

        return SQUARE_OF_SUM - SUM_OF_SQUARE;
    }

}
