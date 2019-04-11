package bokovelsys.cards;

import bokovelsys.servises.AccountSystem;

public class HolidayHalfDayMorningSkiPass extends SkiPass {
    public HolidayHalfDayMorningSkiPass() {
        this.id = AccountSystem.getAccountingSystem().getNextId();
        this.skiPassType = SkiPassType.HOLIDAY_HALF_DAY_MORNING;
    }
}
