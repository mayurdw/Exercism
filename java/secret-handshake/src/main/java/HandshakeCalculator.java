import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {
    private List<Signal> Handshake = new ArrayList<>();

    List<Signal> calculateHandshake(int number) {
 /*       int Position = 1;
        while( number != 0 ){
            if( ( number & 1 ) == 1 ){
                switch (Position){
                    case 1:
                        this.Handshake.add(Signal.WINK);
                        break;
                    case 3:
                        this.Handshake.add(Signal.DOUBLE_BLINK);
                        break;
                    case 5:
                        this.Handshake.add(Signal.CLOSE_YOUR_EYES);
                        break;

                }
            }
            Position++;
            number = number >>> 1;
        }
*/
        /*if( number % 2 == 1 ){
            this.Handshake.add(Signal.WINK);

            if( number >= 32){
                // Remove excess
                number -= 16;
            }

            if( number >= 3 ){
                this.Handshake.add(Signal.DOUBLE_BLINK);
            }

            if(number >= 5 && number % 5 == 0 ){
                this.Handshake.add(Signal.CLOSE_YOUR_EYES);
            }

            if(number >= 15 && number % 15 == 0){
                this.Handshake.add(Signal.JUMP);
            }

            if( number >= 16 ){
                Collections.reverse(this.Handshake);
            }
        }
        else {
            switch( number / 2 ){
                case 1:
                    this.Handshake.add(Signal.DOUBLE_BLINK);
                    break;
                case 2:
                    this.Handshake.add(Signal.CLOSE_YOUR_EYES);
                    break;
                case 12:
                case 4:
                    this.Handshake.add(Signal.JUMP);
                    break;
                case 8:
                    Collections.reverse(this.Handshake);
                default:
                    break;
            }

        }*/

        return this.Handshake;
    }

}
