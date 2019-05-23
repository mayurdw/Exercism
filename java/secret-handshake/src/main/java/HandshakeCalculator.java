import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> Handshake = new ArrayList<>();
        final int INCLUDE_WINK = 1;
        final int INCLUDE_DOUBLE_BLINK = 2;
        final int INCLUDE_CLOSE_YOUR_EYES = 4;
        final int INCLUDE_JUMP = 8;
        final int REVERSE_HANDSHAKE = 16;

        if ( ( number & INCLUDE_WINK ) == INCLUDE_WINK ){
            Handshake.add( Signal.WINK );
        }

        if( ( number & INCLUDE_DOUBLE_BLINK ) == INCLUDE_DOUBLE_BLINK ){
            Handshake.add( Signal.DOUBLE_BLINK );
        }

        if( ( number & INCLUDE_CLOSE_YOUR_EYES ) == INCLUDE_CLOSE_YOUR_EYES ){
            Handshake.add( Signal.CLOSE_YOUR_EYES );
        }

        if( ( number & INCLUDE_JUMP ) == INCLUDE_JUMP ){
            Handshake.add( Signal.JUMP );
        }

        if( ( number & REVERSE_HANDSHAKE ) == REVERSE_HANDSHAKE ){
            Collections.reverse( Handshake );
        }

        return Handshake;
    }

}
