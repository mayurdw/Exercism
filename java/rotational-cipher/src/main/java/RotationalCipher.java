import java.util.Arrays;

class RotationalCipher {
     private final int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = ( shiftKey < 0 || shiftKey > 25 ) ? 0 : shiftKey;
    }

    String rotate(String data) {
        String ret;

        if( this.shiftKey != 0 ){
            char[] alphabets = data.toCharArray();

            for( int i = 0; i < alphabets.length; i++ ){
                if( Character.isAlphabetic(alphabets[i])) {
                    boolean isLowerCase = Character.isLowerCase(alphabets[i]);
                    alphabets[i] = (char) ((int) alphabets[i] + this.shiftKey);
                    if( isLowerCase && alphabets[i] > 'z' ){
                        alphabets[i] -= 26;
                    }
                    else if( !isLowerCase && alphabets[i] > 'Z' ){
                        alphabets[i] -= 26;
                    }
                    else{
                        // do nothing
                    }
                }
            }
            ret = new String(alphabets);
        }
        else{
            ret = data;
        }

        return ret;
    }

}
