/**
 * Custom implementation to calculate prime numbers
 * */
class PrimeCalculator {

    /**
     * Calculate nth prime number
     * @param nth the prime number to be calculated
     * @return prime number calculated
     * */
    int nth(int nth) {
        int count = 0;
        int candidate = 2;

        // MW: Using my cpp exercism track solution for this
        // TODO: Third case goes into an infinite loop, figure out why
        while ( count < nth )
        {
            if ( this.isPrimeNumber( nth ) )
            {
                count++;
            }
            candidate++;
        }

        return candidate - 1;
    }

    private boolean isPrimeNumber( int position ){
        // If the number is divisible by 2 or 3, check if it is 2 or 3
        if ( position % 2 == 0 )
            return ( position == 2 );

        if ( position % 3 == 0 )
            return ( position == 3 );

        double max = 0;
        int step = 4;
        // For better explanation: https://stackoverflow.com/questions/9625663/calculating-and-printing-the-nth-prime-number
        // We only have to worry about numbers from 4 onwards
        // Prime numbers usually come in pairs ie number/prime number = prime number
        // or PM = sqrt( number );
        max = Math.floor( Math.sqrt( position ) + 1 );

        for ( int i = 5; i < max; step = 6 - step, i += step )
        {
            if ( position % i == 0 )
            {
                return false;
            }
        }

        return true;
    }

}
