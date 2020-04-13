import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare( final int square ) {
        BigInteger value = BigInteger.ONE;
        if( square < 1 || square > 64 )
            throw new IllegalArgumentException( "square must be between 1 and 64" );

        return value.shiftLeft( square - 1 );
    }

    BigInteger grainsOnBoard() {
        return BigInteger.ZERO.setBit( 64 ).subtract( BigInteger.ONE );
    }o

}
