import java.util.Arrays;

class RotationalCipher {
     private final int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = ( shiftKey < 0 || shiftKey > 26 ) ? 0 : shiftKey;
    }

    String rotate(String data) {
        char[] cypher = new char[data.length()];

        for( int x = 0; x < data.length(); x++ ){
            cypher[x] = (char)(data.charAt(x) - this.shiftKey);
        }

        return Arrays.toString(cypher);
    }

}
