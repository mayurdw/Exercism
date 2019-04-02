class Darts {
    double x;
    double y;
    
    Darts(double x, double y) {
        this.x = x;
        this.y = y;
    }

    int score() {
        int iRet = 0;
        double distance = Math.hypot(0 - this.x, 0 - this.y);

        if ( distance <= 10 ){
            iRet = 1;
            if ( distance <=5 ){
                iRet += 4;
                if ( distance <= 1 ){
                    iRet += 5;
                }
            }
        }

        return iRet;
    }

}
