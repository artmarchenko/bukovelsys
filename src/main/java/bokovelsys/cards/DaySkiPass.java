package bokovelsys.cards;

import bokovelsys.servises.AccountSystem;

import java.time.LocalDate;
import java.util.Date;

public class DaySkiPass extends SkiPass {
    private int dayQuantity;
    private LocalDate lastWriteOffTime;

    public DaySkiPass(int dayQuantity) {
        this.dayQuantity = dayQuantity;
        this.skiPassType = SkiPassType.DAY_LIMIT;
        this.id = AccountSystem.getAccountingSystem().getNextId();
    }

    public int getDayQuantity() {
        return dayQuantity;
    }

    public void setDayQuantity(int dayQuantity) {
        this.dayQuantity = dayQuantity;
    }

    public LocalDate getLastWriteOffTime() {
        return lastWriteOffTime;
    }

    public void setLastWriteOffTime(LocalDate lastWriteOffTime) {
        this.lastWriteOffTime = lastWriteOffTime;
    }
}
