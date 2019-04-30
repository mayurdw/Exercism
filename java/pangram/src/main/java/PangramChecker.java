public class PangramChecker {

    public boolean isPangram(String input) {
        boolean ret = false;
        if ( input.length() > 0 && input.length() >= 26 ){
            ret = true;
           for( char c = 'a'; c <= 'z' ; c++  ){
               if ( input.toLowerCase().indexOf(c) < 0 ){
                   return false;
               }
            }
        }
        return ret;
    }

}
