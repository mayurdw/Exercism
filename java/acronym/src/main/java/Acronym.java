class Acronym {
    StringBuilder Tla = new StringBuilder();
    Acronym(String phrase) {
        String[] words = phrase.toUpperCase().replace('_','-').split("[\\s ,-]+");
        for( String S : words )
        {
            this.Tla.append(S.charAt(0));
        }
    }

    String get() {
        return this.Tla.toString();
    }

}
