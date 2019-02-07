class RaindropConverter {

    String convert(int number) {
        boolean bNotFound = true;
        String sRet = "";

        if ( number % 3 == 0 )
        {
            sRet = "Pling";
            bNotFound = false; 
        }

        if ( number % 5 == 0 )
        {
            sRet += "Plang";
            bNotFound = false;
        }

        if ( number % 7 == 0 )
        {
            sRet += "Plong";
            bNotFound = false;
        }

        if(bNotFound)
        {
            sRet = Integer.toString(number);
        }

        return sRet;
    }

}
