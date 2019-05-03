package bokovelsys.servises;

import bokovelsys.cards.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class AccountSystem {

    private List<SkiPass> skiPassList = new LinkedList<>();
    private int lastSkiPassId;
    private int startMonthOfSeason = 9;
    private int endMonthOfSeason = 4;

    private static class AccountSystemHolder {
        public static final AccountSystem ACCOUNT_SYSTEM_INSTANCE = new AccountSystem();
    }

    public static AccountSystem getAccountingSystem() {
        return AccountSystemHolder.ACCOUNT_SYSTEM_INSTANCE;
    }

    public SkiPass createHalfDayMorningSkiPass() {
        HalfDayMorningSkiPass skiPass = new HalfDayMorningSkiPass();
        skiPassList.add(skiPass);
        return skiPass;
    }

    public SkiPass createHalfDayAfternoonSkiPass() {
        HalfDayAfternoonSkiPass skiPass = new HalfDayAfternoonSkiPass();
        skiPassList.add(skiPass);
        return skiPass;
    }

    public SkiPass createDaySkiPass(int days) {
        DaySkiPass skiPass = new DaySkiPass(days);
        skiPassList.add(skiPass);
        return skiPass;
    }

    public SkiPass createHolidayHalfDayMorningSkiPass() {
        HalfDayMorningSkiPass skiPass = new HalfDayMorningSkiPass();
        skiPassList.add(skiPass);
        return skiPass;
    }

    public SkiPass createHolidayHalfDayAfternoonSkiPass() {
        HolidayHalfDayAfternoonSkiPass skiPass = new HolidayHalfDayAfternoonSkiPass();
        skiPassList.add(skiPass);
        return skiPass;
    }

    public SkiPass createHolidayDaySkiPass(int days) {
        HolidayDaySkiPass skiPass = new HolidayDaySkiPass(days);
        skiPassList.add(skiPass);
        return skiPass;
    }

    public SkiPass createSeasonSkiPass(LocalDateTime date) {
        SeasonSkiPass skiPass = new SeasonSkiPass(date);
        skiPassList.add(skiPass);
        return skiPass;
    }

    public void blockSkiPass(SkiPass skiPass) {
        skiPass.setBlocked(true);
    }

    public int getNextId() {
        return ++this.lastSkiPassId;
    }

    public int getStartMonthOfSeason() {
        return startMonthOfSeason;
    }

    public int getEndMonthOfSeason() {
        return endMonthOfSeason;
    }

    public List<SkiPass> getSkiPassList() {
        return skiPassList;
    }
}
