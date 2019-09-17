import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class NaturalNumber {

    private Classification classification;
    NaturalNumber( int number ){

        if( number <= 0 ){
             throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }

        AtomicInteger sumOfFactors = new AtomicInteger();

        IntStream.range(1, number).filter(x -> number % x == 0).forEach(sumOfFactors::addAndGet);

        if( sumOfFactors.get() == number ){
            this.classification = Classification.PERFECT;
        }
        else if( sumOfFactors.get() > number ){
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
