import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

class Gigasecond {
    LocalDateTime moment;
    static final int iGigasecond = 1_000_000_000;
    
    Gigasecond(LocalDate moment) {
        this( moment.atStartOfDay());
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment;
    }

    LocalDateTime getDateTime() {
        return this.moment.plusSeconds(iGigasecond);
    }

}
