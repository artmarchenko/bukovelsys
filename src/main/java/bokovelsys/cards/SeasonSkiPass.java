package bokovelsys.cards;

import bokovelsys.servises.AccountSystem;

public class SeasonSkiPass extends SkiPass {
    public SeasonSkiPass() {
        this.id = AccountSystem.getAccountingSystem().getNextId();
        this.skiPassType = SkiPassType.SEASON;
    }
}
