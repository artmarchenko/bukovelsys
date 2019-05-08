package bokovelsys.servises;

import bokovelsys.cards.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Validator {

    public boolean validate(SkiPass skiPass) {
        LocalDateTime date = LocalDateTime.now();
        if (skiPass.getSkiPassType() == SkiPassType.DAY_LIMIT) {
            validateDayLimit(skiPass);
        }

        if (skiPass.getSkiPassType() == SkiPassType.HALF_DAY_MORNING) {
            validateHalfDayMornig(skiPass);
        }

        if (skiPass.getSkiPassType() == SkiPassType.HALF_DAY_AFTERNOON) {
            validateHalfDayAfternoon(skiPass);
        }

        if (skiPass.getSkiPassType() == SkiPassType.HOLIDAY_DAY_LIMIT) {
            validateHolidayDayLimit(skiPass);
        }

        if (skiPass.getSkiPassType() == SkiPassType.HOLIDAY_HALF_DAY_AFTERNOON) {
           validateHolidayHalfDayAfternoon(skiPass);
        }

        if (skiPass.getSkiPassType() == SkiPassType.HOLIDAY_HALF_DAY_MORNING) {
            validateHolidayHalfDayMorning(skiPass);
        }

        if (skiPass.getSkiPassType() == SkiPassType.SEASON) {
            validateSeason(skiPass);
        }

        return false;
    }

    public boolean validateDayLimit(SkiPass skiPass){
        LocalDateTime date = LocalDateTime.now();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) return false;
        else {
            DaySkiPass sp = (DaySkiPass) skiPass;
            if (sp.getLastWriteOffTime() == null) {
                sp.setActivationDate(LocalDateTime.now());
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

        return false;
    }

    public boolean validateHalfDayMornig(SkiPass skiPass){
        LocalDateTime date = LocalDateTime.now();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) return false;

        else {
            HalfDayMorningSkiPass sp = (HalfDayMorningSkiPass) skiPass;
            LocalDateTime controlTime = LocalDateTime.now();
            controlTime.withHour(13).withMinute(0);
            if (sp.getActivationDate() == null) {
                if (date.isBefore(controlTime)) {
                    sp.setActivationDate(LocalDateTime.now());
                    return true;
                }
            }

            if (sp.getActivationDate() != null && sp.getActivationDate().isBefore(controlTime)) {
                return true;
            }

            return false;
        }
    }

    public boolean validateHalfDayAfternoon(SkiPass skiPass){
        LocalDateTime date = LocalDateTime.now();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) return false;

        else {
            HalfDayAfternoonSkiPass sp = (HalfDayAfternoonSkiPass) skiPass;
            LocalDateTime controlTime = LocalDateTime.now();
            controlTime.withHour(13).withMinute(0);
            if (sp.getActivationDate() == null) {
                if (date.isAfter(controlTime)) {
                    sp.setActivationDate(LocalDateTime.now());
                    return true;
                }
            }

            if (sp.getActivationDate() != null && sp.getActivationDate().isAfter(controlTime)) {
                return true;
            }

            return false;
        }
    }

    public boolean validateHolidayDayLimit(SkiPass skiPass){
        LocalDateTime date = LocalDateTime.now();
        HolidayDaySkiPass sp = (HolidayDaySkiPass) skiPass;
        if (sp.getLastWriteOffTime() == null) {
            sp.setActivationDate(LocalDateTime.now());
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
        return false;
    }

    public boolean validateHolidayHalfDayAfternoon(SkiPass skiPass){
        LocalDateTime date = LocalDateTime.now();
        HolidayHalfDayAfternoonSkiPass sp = (HolidayHalfDayAfternoonSkiPass) skiPass;
        LocalDateTime controlTime = LocalDateTime.now();
        controlTime.withHour(13).withMinute(0);
        if (sp.getActivationDate() == null) {
            if (date.isAfter(controlTime)) {
                sp.setActivationDate(LocalDateTime.now());
                return true;
            }
        }
        if (sp.getActivationDate() != null && sp.getActivationDate().isAfter(controlTime)) {
            return true;
        }
        return false;
    }

    public boolean validateHolidayHalfDayMorning(SkiPass skiPass){
        LocalDateTime date = LocalDateTime.now();
        HalfDayMorningSkiPass sp = (HalfDayMorningSkiPass) skiPass;
        LocalDateTime controlTime = LocalDateTime.now();
        controlTime.withHour(13).withMinute(0);
        if (sp.getActivationDate() == null) {
            if (date.isBefore(controlTime)) {
                sp.setActivationDate(LocalDateTime.now());
                return true;
            }
        }

        if (sp.getActivationDate() != null && sp.getActivationDate().isBefore(controlTime)) {
            return true;
        }
        return false;
    }

    public boolean validateSeason(SkiPass skiPass){
        LocalDateTime date = LocalDateTime.now();
        SeasonSkiPass sp = (SeasonSkiPass) skiPass;
        if (date.isBefore(sp.getExpirationDate())){
            return true;
        }
        else return false;
    }
}
