import java.util.List;

class NaturalNumber {

    private Classification classification;
    NaturalNumber( int number ){
        int sumOfFactors = 0;

        for( int x = 1; x <  number; x++ ){
            if( number % x == 0 ){
                sumOfFactors+=x;
            }
        }

        if( sumOfFactors == number ){
            this.classification = Classification.PERFECT;
        }
        else if( sumOfFactors > number ){
            this.classification = Classification.ABUNDANT;
        }
        else{
            this.classification = Classification.DEFICIENT;
        }
    }

    Classification getClassification(){
        return this.classification;
    }

}
