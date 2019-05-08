package bokovelsys.cards;

import bokovelsys.servises.AccountSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class DaySkiPass extends SkiPass {
    private int dayQuantity;
    private LocalDateTime lastWriteOffTime;

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

    public LocalDateTime getLastWriteOffTime() {
        return lastWriteOffTime;
    }

    public void setLastWriteOffTime(LocalDateTime lastWriteOffTime) {
        this.lastWriteOffTime = lastWriteOffTime;
    }
}
