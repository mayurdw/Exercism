import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Say {

    private static final List<Magnitude> supportedMagnitudes = Arrays.asList(
            Magnitude.BILLIONS, Magnitude.MILLIONS,
            Magnitude.THOUSANDS, Magnitude.ONES);

    private enum Magnitude {
        TRILLIONS(1_000_000_000_000L, "trillion"),
        BILLIONS(1_000_000_000, "billion"),
        MILLIONS(1_000_000, "million"),
        THOUSANDS(1_000, "thousand"),
        ONES(1, "one");

        private final long number;
        private final String inEnglish;

        Magnitude(long number, String inEnglish) {
            this.number = number;
            this.inEnglish = inEnglish;
        }

        public long getNumber() {
            return number;
        }

        public String inEnglish() {
            return inEnglish;
        }
    }

    public String say(long number) {
        if (number < 0 || number >= Magnitude.TRILLIONS.getNumber()) {
            throw new IllegalArgumentException("input out of range");
        }
        List<Part> parts = new ArrayList<>();
        for (Magnitude magnitude: supportedMagnitudes) {
            double quoziente = Math.floor(number / magnitude.getNumber());
            Part part = new Part((int) quoziente, magnitude);
            if (part.getDigits() > 0 || (part.getMagnitude().equals(Magnitude.ONES) && parts.size() == 0)) {
                parts.add(part);
            }
            number =   number % magnitude.getNumber();
        }

        return parts.stream().map( Part::say ).collect( Collectors.joining( " " ) );
    }

    private static class Part {
        private final int digits;
        private final Magnitude magnitude;

        public Part(int digits, Magnitude magnitude) {
            this.digits = digits;
            this.magnitude = magnitude;
        }

        private static final String[] untilTwenty = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eigth",
                "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "seventeen", "eighteen",
                "nineteen" };

        public int getDigits() {
            return digits;
        }

        public Magnitude getMagnitude() {
            return magnitude;
        }

        private String convertTens(long digit) {
            return switch ( ( int ) digit ) {
                case 2 -> "twenty";
                case 3 -> "thirty";
                case 4 -> "forty";
                case 5 -> "fifty";
                case 6 -> "sixty";
                case 7 -> "seventy";
                case 8 -> "eighty";
                case 9 -> "ninety";
                default -> throw new IllegalArgumentException( "not supported value" );
            };
        }

        private String say() {
            StringBuilder stringBuilder = new StringBuilder();
            int hundreds = digits / 100;
            int tens = digits % 100;
            if (hundreds > 0) {
                stringBuilder.append(untilTwenty[hundreds]).append(" hundred");
            }

            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }

            if (tens >= 20) {
                stringBuilder.append(convertTens(tens / 10));
                if (tens % 10 > 0) {
                    stringBuilder.append("-").append(untilTwenty[tens % 10]);
                }
            } else {
                stringBuilder.append(untilTwenty[tens]);
            }

            if (!magnitude.equals(Magnitude.ONES)) {
                stringBuilder.append(" ").append(magnitude.inEnglish());
            }

            return stringBuilder.toString().replace(" zero", "");
        }
    }
}

