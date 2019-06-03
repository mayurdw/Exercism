import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.*;

class HandshakeCalculator {
    final static int REVERSE_HANDSHAKE = 16;

    List<Signal> calculateHandshake(int number) {
        List<Signal> handshake = new ArrayList<>();

        for (Signal signal : Signal.values()) {
            if (signal.hasBitNumber(number)) {
                handshake.add(signal);
            }
        }

        if ((number & REVERSE_HANDSHAKE) == REVERSE_HANDSHAKE) {
            Collections.reverse(handshake);
        }

        return handshake;
    }

}
