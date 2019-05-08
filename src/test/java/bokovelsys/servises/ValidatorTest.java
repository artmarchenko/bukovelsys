package bokovelsys.servises;

import bokovelsys.cards.DaySkiPass;
import bokovelsys.cards.SkiPass;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

public class ValidatorTest {

    AccountSystem accountSystem = new AccountSystem();
    Validator validator = new Validator();

    @Test
    public void validate() {
    }

    @Test
    public void validateDayLimit() {
        DaySkiPass skiPass1 = new DaySkiPass(5);
        DaySkiPass skiPass2 = new DaySkiPass(5);

        Assert.assertTrue(validator.validateDayLimit(skiPass1));
        Assert.assertEquals(4, skiPass1.getDayQuantity());
        skiPass1.setDayQuantity(0);
        Assert.assertNotNull(skiPass1.getLastWriteOffTime());
        Assert.assertTrue(validator.validateDayLimit(skiPass1));


        skiPass1.setLastWriteOffTime(LocalDateTime.parse("2018-05-05 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        Assert.assertFalse(validator.validateDayLimit(skiPass1));
        skiPass1.setDayQuantity(1);
        Assert.assertTrue(validator.validateDayLimit(skiPass1));
        skiPass1.setDayQuantity(0);
        skiPass1.setLastWriteOffTime(LocalDateTime.parse("2018-05-05 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        Assert.assertFalse(validator.validateDayLimit(skiPass1));




    }

    @Test
    public void validateHalfDayMornig() {
    }

    @Test
    public void validateHalfDayAfternoon() {
    }

    @Test
    public void validateHolidayDayLimit() {
    }

    @Test
    public void validateHolidayHalfDayAfternoon() {
    }

    @Test
    public void validateHolidayHalfDayMorning() {
    }

    @Test
    public void validateSeason() {
        SkiPass seasonSkiPass1 = accountSystem.createSeasonSkiPass(LocalDateTime.of(2019,8, 1,0,0));
        SkiPass seasonSkiPass2 = accountSystem.createSeasonSkiPass(LocalDateTime.of(2018,8, 1,0,0));

        Assert.assertTrue(validator.validateSeason(seasonSkiPass1));
        Assert.assertFalse(validator.validateSeason(seasonSkiPass2));

    }
}