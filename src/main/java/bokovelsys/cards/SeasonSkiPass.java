package bokovelsys.cards;

import bokovelsys.servises.AccountSystem;

import java.time.LocalDateTime;

public class SeasonSkiPass extends SkiPass {
    public SeasonSkiPass(LocalDateTime date) {
        this.id = AccountSystem.getAccountingSystem().getNextId();
        this.skiPassType = SkiPassType.SEASON;
        this.expirationDate = date;
    }
}
