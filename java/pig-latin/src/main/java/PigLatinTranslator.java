/**
 * Pig Latin Translator<br>
 * Read: http://en.wikipedia.org/wiki/Pig_latin
 * */
public class PigLatinTranslator{
    private static final String AY = "ay";
    /**
     * Translates word into Pig Latin
     * @param word to be translated
     * */
    public String translate( String word ){

        if( word != null ){
            return switch ( word.toUpperCase().charAt( 0 ) ) {
                case 'A', 'E', 'I', 'O', 'U' -> this.attachAy( word );
                default -> this.flipAndAttach( word );
            };
        }
        return "";
    }

    /**
     * Attaches {@link PigLatinTranslator#AY} as suffix
     * @param word to be attached to
     * */
    private String attachAy( String word ){
        return word + PigLatinTranslator.AY;
    }

    /**
     * Flips first character & attaches {@link PigLatinTranslator#AY}
     * @param word to be flipped
     * */
    private String flipAndAttach( String word ){
        return this.attachAy( word.substring( 1 ) + word.charAt( 0 ) );
    }
}
