import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Sieve {
    Integer maxPrime;
    List<Integer> primes = new ArrayList<>();

    Sieve( int maxPrime ) {
        this.maxPrime = maxPrime;
        calculatePrime();
    }

    private void calculatePrime() {
        List<Integer> candidates = Arrays.stream( IntStream.rangeClosed( 2, this.maxPrime ).toArray() ).boxed().collect( Collectors.toList() );

        while ( !candidates.isEmpty() ) {
            Integer next = candidates.get( 0 );
            candidates.remove( next );
            this.primes.add( next );
            Predicate<Integer> divisible = d -> d % next == 0;

            candidates.removeIf( divisible );
        }

    }

    List<Integer> getPrimes() {
        return this.primes;
    }
}
