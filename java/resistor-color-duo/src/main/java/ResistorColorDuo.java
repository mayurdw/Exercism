class ResistorColorDuo {
    private enum ResistorCode {
        BLACK( 0 ),
        BROWN( 1 ),
        RED( 2 ),
        ORANGE( 3 ),
        YELLOW( 4 ),
        GREEN( 5 ),
        BLUE( 6 ),
        VIOLET( 7 ),
        GREY( 8 ),
        WHITE( 9 );

        private int value;

        ResistorCode( int value ) {
            this.value = value;
        }
    }

    int value( String[] colors ) {
        if( colors.length < 2 )
            return -1;

        ResistorCode tensPlace = ResistorCode.valueOf( colors[0].toUpperCase() );
        ResistorCode unitsPlace = ResistorCode.valueOf( colors[1].toUpperCase() );

        return ( tensPlace.value * 10 + unitsPlace.value );
    }
}
