class ResistorColorDuo {
    private enum ResistorCode
    {
        BLACK(0, "black"),
        BROWN( 1, "brown"),
        RED(2, "red"),
        ORANGE(3, "orange"),
        YELLOW(4, "yellow"),
        GREEN(5, "green"),
        BLUE( 6, "blue"),
        VIOLET(7, "violet"),
        GREY(8, "grey"),
        WHITE(9, "white");

        int value;
        String name;

        ResistorCode( int value, String name ){
            this.value = value;
            this.name = name;
        }
    };

    int value(String[] colors) {
        if( colors.length < 2 )
            return -1;

        ResistorCode tensPlace = ResistorCode.valueOf(colors[0].toLowerCase());
        ResistorCode unitsPlace = ResistorCode.valueOf(colors[1].toLowerCase());

        return ( tensPlace.value * 10 + unitsPlace.value);
    }
}
