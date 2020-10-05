class CollatzCalculator {
    /**
     * Takes any positive integer n.
     * If n is even, divide n by 2 to get n / 2.
     * If n is odd, multiply n by 3 and add 1 to get 3n + 1
     * @param start the positive integer
     * @return number of steps
     * */
    int computeStepCount(int start) {
        int steps = 0;

        if( start <= 0 ){
            throw new IllegalArgumentException( "Only natural numbers are allowed" );
        }

        while( start > 1 ){
            if( 0 == start % 2 ){
                start /= 2;
            } else {
                start = ( 3 * start ) + 1;
            }
            steps++;
        }
        return steps;
    }

}
