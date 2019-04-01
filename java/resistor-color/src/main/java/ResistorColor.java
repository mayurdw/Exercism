import java.util.*;

class ResistorColor {
    String[] ListofColors = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white" };
    int colorCode(String color) {

        return Arrays.asList(ListofColors).indexOf(color);
    }

    String[] colors() {
        return ListofColors;
    }
}
