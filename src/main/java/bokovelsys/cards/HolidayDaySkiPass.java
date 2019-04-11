package bokovelsys.cards;

import bokovelsys.servises.AccountSystem;

import java.util.Date;

public class HolidayDaySkiPass extends SkiPass {
    private int dayQuantity;

    public HolidayDaySkiPass(int dayQuantity) {
        this.dayQuantity = dayQuantity;
        this.skiPassType = SkiPassType.HOLIDAY_DAY_LIMIT;
        this.id = AccountSystem.getAccountingSystem().getNextId();

    }
}
