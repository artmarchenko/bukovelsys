package bokovelsys.servises;

import bokovelsys.cards.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AccountSystem {

        private List<SkiPass> skiPassList = new LinkedList<>();
        private int lastSkiPassId;
        private int startMonthOfSeason = 9;
        private int endMonthOfSeason = 4;



        private   static class AccountSystemHolder{
            public static final AccountSystem ACCOUNT_SYSTEM_INSTANCE = new AccountSystem();
        }

        public static AccountSystem getAccountingSystem(){
            return AccountSystemHolder.ACCOUNT_SYSTEM_INSTANCE;
        }

        public SkiPass  createHalfDayMorningSkiPass(){

            return new HalfDayMorningSkiPass();
        }

        public SkiPass  createHalfDayAfternoonSkiPass(){

            return new HalfDayAfternoonSkiPass();
        }

        public SkiPass  createDaySkiPass(int days){

            return new DaySkiPass(days);
        }

        public SkiPass  createHolidayHalfDayMorningSkiPass(){

            return new HolidayHalfDayMorningSkiPass();
        }

        public SkiPass  createHolidayHalfDayAfternoonSkiPass(){

            return new HolidayHalfDayAfternoonSkiPass();
        }

        public SkiPass createHolidayDaySkiPass(int days){

            return new HolidayDaySkiPass(days);
        }

        public SkiPass  createSeasonSkiPass(){

            return new SeasonSkiPass();
        }

        public void blockSkiPass(SkiPass skiPass){
            skiPass.setBlocked(true);
        }

        public int getNextId(){
            return ++this.lastSkiPassId;
        }

    public int getStartMonthOfSeason() {
        return startMonthOfSeason;
    }

    public int getEndMonthOfSeason() {
        return endMonthOfSeason;
    }
}
