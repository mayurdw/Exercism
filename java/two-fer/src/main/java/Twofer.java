class Twofer {
    String twofer(String name) {
        return "One for " + 
                ( ( name != null && name.length() != 0 ) ? name : "you" ) + 
                ", one for me.";
    }
}
