import java.util.HashMap;
import java.util.Map;

class Proverb {
    private String[] Words;
    private final String LAST_LINE = "And all for the want of a ";
    private final String BEGINNING = "For want of a ";
    private final String END = " was lost.\n";
    private final String THE = " the ";

    Proverb(String[] words) {
        this.Words = words;
    }

    String recite() {
        StringBuilder Proverb = new StringBuilder(200);

        if ( this.Words.length > 0 ) {
            for (int i = 0; i < this.Words.length - 1; i++) {
                Proverb.append(this.BEGINNING);
                Proverb.append(Words[i]);
                Proverb.append(this.THE);
                Proverb.append(Words[i+1]);
                Proverb.append(this.END);
            }
            this.AppendLastLine(Proverb);
        }
        return Proverb.toString();
    }

    private void AppendLastLine( StringBuilder Proverb ){
        final String PERIOD = ".";

        Proverb.append(this.LAST_LINE);
        Proverb.append(this.Words[0]);
        Proverb.append(PERIOD);

    }
}
