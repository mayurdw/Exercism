class LuhnValidator {
    boolean isValid( String candidate ) {
        Integer sum = 0;
        Integer digitCount = 0;
        char[] charCandidate = candidate.replaceAll( " ", "" ).toCharArray();

        if( charCandidate.length < 2 )
            return false;

        for ( int x = charCandidate.length; x > 0; x-- ) {
            if( Character.isDigit( charCandidate[x - 1] ) ) {
                Integer temp = charCandidate[x - 1] - '0';
                digitCount++;

                System.out.println( "Value at index " + ( x - 1 ) + " is " + temp );
                if( digitCount % 2 == 0 ) {
                    temp *= 2;
                    if( temp > 9 ) {
                        temp -= 9;
                    }
                    System.out.println( "Value after luhn-ing is " + temp );
                }
                sum += temp;
            } else{
                return false;
            }
        }

        return ( ( sum % 10 ) == 0 );
    }

}
