import java.util.ArrayList;
import java.util.List;

/**
 * Calculates prime factors
 */
public class PrimeFactorsCalculator {
    /**
     * Calculates prime factors of the number passed
     *
     * @param number whose prime factors need to be calculated
     * @return {@link List} of prime factors
     */
    public List<Long> calculatePrimeFactorsOf( Long number ) {
        List<Long> factors = new ArrayList<>();

        for ( Long i = 2L; i <= number; i++ ) {
            while ( number % i == 0 ) {
                factors.add( i );
                number /= i;
            }
        }

        return factors;
    }
}