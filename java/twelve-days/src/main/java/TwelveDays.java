class TwelveDays {
    private final String DAYS[] =
            {
                    "first", "second", "third", "fourth",
                    "fifth", "sixth", "seventh", "eighth",
                    "ninth", "tenth", "eleventh", "twelfth"
            };
    private final String FORMAT = "On the %s day of Christmas my true love gave to me: ";
    private final String OBJECTS[] =
            {
                    "a Partridge in a Pear Tree.",
                    "two Turtle Doves, ",
                    "three French Hens, ",
                    "four Calling Birds, ",
                    "five Gold Rings, ",
                    "six Geese-a-Laying, ",
                    "seven Swans-a-Swimming, ",
                    "eight Maids-a-Milking, ",
                    "nine Ladies Dancing, ",
                    "ten Lords-a-Leaping, ",
                    "eleven Pipers Piping, ",
                    "twelve Drummers Drumming, "
            };

    String verse( int verseNumber ) {
        if( ( verseNumber - 1 ) >= OBJECTS.length || ( verseNumber - 1 ) >= DAYS.length )
            throw new IllegalArgumentException( "verseNumber exceeds expectations" );

        String verseString = String.format( FORMAT, DAYS[verseNumber - 1] );

        switch ( verseNumber ){
            case 12: verseString += OBJECTS[11];
            case 11: verseString += OBJECTS[10];
            case 10: verseString += OBJECTS[9];
            case 9: verseString += OBJECTS[8];
            case 8: verseString += OBJECTS[7];
            case 7: verseString += OBJECTS[6];
            case 6: verseString += OBJECTS[5];
            case 5: verseString += OBJECTS[4];
            case 4: verseString += OBJECTS[3];
            case 3: verseString += OBJECTS[2];
            case 2: verseString += OBJECTS[1];
                    verseString += "and ";
            case 1:
            default: verseString += OBJECTS[0]; break;
        }

        verseString += "\n";

        return verseString;
    }

    String verses( int startVerse, int endVerse ) {
        StringBuilder result = new StringBuilder(  );

        for( int x = startVerse; x <= endVerse; x++ ){
            result.append( this.verse( x ) );
            result.append( "\n" );
        }

        result.deleteCharAt( result.length() - 1 );

        return result.toString();
    }

    String sing() {
        return this.verses( 1, 12 );
    }
}
