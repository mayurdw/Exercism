class Robot {
    private static Integer[] stringIndices = { 0, 0 };
    private static Integer numSuffix = 0;
    private String name;

    Robot(){
        this.name = this.generateName();
    }

    private String generateName() {
        final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final Integer LETTER_COUNT = LETTERS.length();
        final Integer MAX_SUFFIX = 999;

        if( numSuffix > MAX_SUFFIX ) {
            if( stringIndices[1] > LETTER_COUNT ) {
                if( stringIndices[0] > LETTER_COUNT ) {
                    // Throw exception, not sure which one
                    throw new IndexOutOfBoundsException();
                } else {
                    stringIndices[1] = stringIndices[0];
                    stringIndices[0]++;
                }
            } else {
                stringIndices[1]++;
            }

            numSuffix = 0;
        }

        return String.format( "%c%c%03d", LETTERS.charAt( stringIndices[0] ), LETTERS.charAt( stringIndices[1] ), numSuffix++ );
    }

    String getName() {
        return this.name;
    }

    void reset() {
        this.name = this.generateName();
    }
}