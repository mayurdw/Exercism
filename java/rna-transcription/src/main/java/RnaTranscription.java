class RnaTranscription {

    String transcribe(String dnaStrand) {
        final String[] PROTEINS = {"G","C","T","A"};
        final String[] PAIRS = {"C","G","A","U"};
        StringBuilder ret = new StringBuilder();
        String[] dnaStringArray = dnaStrand.split("");

        for ( int i = 0; i < dnaStringArray.length; i++ ){
            boolean Found = false;
            for( int j = 0; j < PROTEINS.length && !Found; j++ ){
                if ( dnaStringArray[i].equals(PROTEINS[j])){
                    Found = true;
                    ret.append(PAIRS[j]);
                }
            }
            if( !Found ){
                return "";
            }
        }
        return ret.toString();
    }

}
