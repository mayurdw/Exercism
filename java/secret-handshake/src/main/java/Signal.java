enum Signal {

    WINK(1),
    DOUBLE_BLINK(2),
    CLOSE_YOUR_EYES(4),
    JUMP(8);

    private int bitNumber;

    Signal( int bitNumber){
        this.bitNumber = bitNumber;
    }
    public int getBitNumber(){ return this.bitNumber; }
    public boolean hasBitNumber( int number ) {
        return ( ( number & this.getBitNumber() ) == this.getBitNumber() );
    }
}
