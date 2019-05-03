package bokovelsys.servises;

import bokovelsys.cards.DaySkiPass;
import bokovelsys.cards.HolidayDaySkiPass;
import bokovelsys.cards.SkiPass;
import bokovelsys.cards.SkiPassType;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Validator {

    public boolean validate(SkiPass skiPass) {
        LocalDate date = LocalDate.now();
        if (skiPass.getSkiPassType() == SkiPassType.DAY_LIMIT) {
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) return false;
            else {
                DaySkiPass sp = (DaySkiPass) skiPass;
                if (sp.getLastWriteOffTime() == null) {
                    sp.setActivationDate(LocalDate.now());
                    sp.setDayQuantity(sp.getDayQuantity() - 1);
                    sp.setLastWriteOffTime(LocalDate.now());
                    return true;
                }
                if (sp.getDayQuantity() >= 0 && ChronoUnit.DAYS.between(date, sp.getLastWriteOffTime()) < 1)
                    return true;
                if (sp.getDayQuantity() > 0 && ChronoUnit.DAYS.between(date, sp.getLastWriteOffTime()) >= 1) {
                    sp.setDayQuantity(sp.getDayQuantity() - 1);
                    sp.setLastWriteOffTime(LocalDate.now());
                    return true;
                }

                if (sp.getDayQuantity() == 0 && ChronoUnit.DAYS.between(date, sp.getLastWriteOffTime()) >= 1)
                    return false;

            }
        }

        if (skiPass.getSkiPassType() == SkiPassType.HALF_DAY_MORNING) {


        }

        if (skiPass.getSkiPassType() == SkiPassType.HALF_DAY_AFTERNOON) {

        }

        if (skiPass.getSkiPassType() == SkiPassType.HOLIDAY_DAY_LIMIT) {
            HolidayDaySkiPass sp = (HolidayDaySkiPass) skiPass;
            if (sp.getLastWriteOffTime() == null) {
                sp.setActivationDate(LocalDate.now());
                sp.setDayQuantity(sp.getDayQuantity() - 1);
                sp.setLastWriteOffTime(LocalDate.now());
                return true;
            }
            if (sp.getDayQuantity() >= 0 && ChronoUnit.DAYS.between(date, sp.getLastWriteOffTime()) < 1)
                return true;
            if (sp.getDayQuantity() > 0 && ChronoUnit.DAYS.between(date, sp.getLastWriteOffTime()) >= 1) {
                sp.setDayQuantity(sp.getDayQuantity() - 1);
                sp.setLastWriteOffTime(LocalDate.now());
                return true;
            }

            if (sp.getDayQuantity() == 0 && ChronoUnit.DAYS.between(date, sp.getLastWriteOffTime()) >= 1)
                return false;



        }

        if (skiPass.getSkiPassType() == SkiPassType.HOLIDAY_HALF_DAY_AFTERNOON) {

        }

        if (skiPass.getSkiPassType() == SkiPassType.HOLIDAY_HALF_DAY_MORNING) {

        }

        if (skiPass.getSkiPassType() == SkiPassType.SEASON) {

        }
        return false;
    }
}
