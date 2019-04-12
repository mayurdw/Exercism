import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProteinTranslator {
    private List<String> translatedProtein = new ArrayList<>();
    private Map<String,String> PROTEINS = new HashMap<String,String>(){{
        put("AUG","Methionine");
        put("UUU","Phenylalanine");
        put("UUC","Phenylalanine");
        put("UUA","Leucine");
        put("UUG","Leucine");
        put("UCU","Serine");
        put("UCC","Serine");
        put("UCA","Serine");
        put("UCG","Serine");
        put("UAU","Tyrosine");
        put("UAC","Tyrosine");
        put("UGU","Cysteine");
        put("UGC","Cysteine");
        put("UGG","Tryptophan");
        put("UAA","");
        put("UAG","");
        put("UGA","");
    }};

    List<String> translate(String rnaSequence) {

        for( int i = 0; i < rnaSequence.length(); i= i+3 ){
            String s = rnaSequence.substring(i, i+3);
            if ( PROTEINS.containsKey(s) ){
                if ( PROTEINS.get(s).length() != 0 ){
                this.translatedProtein.add(PROTEINS.get(s));
                }
                else{
                    break;
                }
            }
        }

        return this.translatedProtein;
    }
}
