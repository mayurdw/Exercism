class SumOfMultiples {
    private int sum = 0;

    SumOfMultiples(int number, int[] set) {
        for( int i = 1; i < number; i++ ){
            // loop through the set
            for( int x : set ){
                if( x!= 0 && i % x == 0 ){
                    sum += i;
                    break;
                }
            }
        }
    }

    int getSum() {
        return this.sum;
    }

}
