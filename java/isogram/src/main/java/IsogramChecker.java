import java.util.HashSet;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        HashSet Set = new HashSet();

        phrase = phrase.toLowerCase();
        for ( int i = 0; i < phrase.length(); i++ )
            {
                if ( phrase.charAt(i) != ' ' && phrase.charAt(i) != '-' )
                {
                    if (!Set.add(phrase.charAt(i)))
                        return false;
                }
            }

        return true;
    }

}
