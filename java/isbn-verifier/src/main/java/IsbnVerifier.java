class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        char ArrayString[] = stringToVerify.replace("-","").toUpperCase().toCharArray();
        int Sum = 0;

        if( ArrayString.length != 10 )
            return false;

        for( int i = 0, j = ArrayString.length; i < ArrayString.length; i++, j--){
            if ( ArrayString[i] == 'X' )
            {
                Sum += 10 * j;
            }
            else if( Character.isDigit(ArrayString[i])) {
                    Sum += (Character.getNumericValue(ArrayString[i]) * j);
            }
            else {
            return  false;
            }
        }
        return ( Sum % 11 == 0 );
    }
}
