import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class PrimeCalculatorTest {

    private final PrimeCalculator PRIME_CALCULATOR = new PrimeCalculator();

    @Test
    public void testFirstPrime() {
        assertThat( PRIME_CALCULATOR.nth( 1 ) ).isEqualTo( 2 );
    }

    @Test
    public void testSecondPrime() {
        assertThat( PRIME_CALCULATOR.nth( 2 ) ).isEqualTo( 3 );
    }

    @Test
    public void testSixthPrime() {
        assertThat( PRIME_CALCULATOR.nth( 6 ) ).isEqualTo( 13 );
    }

    @Test
    public void testBigPrime() {
        assertThat( PRIME_CALCULATOR.nth( 10001 ) ).isEqualTo( 104743 );
    }

    @Test
    public void testUndefinedPrime() {
        assertThrows(
                IllegalArgumentException.class,
                () -> PRIME_CALCULATOR.nth( 0 ) );
    }

}
