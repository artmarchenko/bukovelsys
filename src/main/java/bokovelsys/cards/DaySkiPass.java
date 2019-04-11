package bokovelsys.cards;

import bokovelsys.servises.AccountSystem;

import java.util.Date;

public class DaySkiPass extends SkiPass {
    private int dayQuantity;

    public DaySkiPass(int dayQuantity) {
        this.dayQuantity = dayQuantity;
        this.skiPassType = SkiPassType.DAY_LIMIT;
        this.id = AccountSystem.getAccountingSystem().getNextId();
    }
}
