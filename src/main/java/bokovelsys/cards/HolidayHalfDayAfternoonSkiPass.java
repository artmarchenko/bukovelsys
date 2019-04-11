package bokovelsys.cards;

import bokovelsys.servises.AccountSystem;

public class HolidayHalfDayAfternoonSkiPass extends SkiPass
{
    public HolidayHalfDayAfternoonSkiPass() {
        this.id = AccountSystem.getAccountingSystem().getNextId();
        this.skiPassType = SkiPassType.HOLIDAY_HALF_DAY_AFTERNOON;
    }
}
