package bokovelsys.servises;

import bokovelsys.cards.SkiPassType;

import java.util.HashMap;
import java.util.Map;

public class Turnstile {
    private Map<SkiPassType,Integer> counterPassed = new HashMap<>();
    private Map<SkiPassType,Integer> counterCanceled = new HashMap<>();

    public Turnstile() {
        for (SkiPassType skiPassType : SkiPassType.values()){
            counterPassed.put(skiPassType, 0);
        }

        for (SkiPassType skiPassType : SkiPassType.values()){
            counterCanceled.put(skiPassType, 0);
        }

    }

    public Map<SkiPassType, Integer> getCounterPassed() {
        return counterPassed;
    }

    public void setCounterPassed(Map<SkiPassType, Integer> counterPassed) {
        this.counterPassed = counterPassed;
    }

    public Map<SkiPassType, Integer> getCounterCanceled() {
        return counterCanceled;
    }

    public void setCounterCanceled(Map<SkiPassType, Integer> counterCanceled) {
        this.counterCanceled = counterCanceled;
    }

    public void getStat(){
        int counterPass = 0;
        int counterCansel = 0;

        for (Map.Entry<SkiPassType,Integer> entry : counterPassed.entrySet()){
            counterPass = counterPass + entry.getValue();
        }

        for (Map.Entry<SkiPassType,Integer> entry : counterCanceled.entrySet()){
            counterCansel = counterCansel + entry.getValue();
        }

        System.out.println("Total passed: " + counterPass + ". " + "Total canceled: " + counterCansel );
    }

    public void getStat(SkiPassType skiPassType){

        switch (skiPassType){
            case SEASON:
                System.out.println("Total passed SEASON Skipass: " + counterPassed.get(skiPassType) + ". " + "Total canceled SEASON Skipass: " + counterCanceled.get(skiPassType) );
                break;

            case DAY_LIMIT:
                System.out.println("Total passed Daylimit Skipass: " + counterPassed.get(skiPassType) + ". " + "Total canceled Daylimit Skipass: " + counterCanceled.get(skiPassType) );
                break;

            case HOLIDAY_DAY_LIMIT:
                System.out.println("Total passed HOLIDAY_DAY_LIMIT Skipass: " + counterPassed.get(skiPassType) + ". " + "Total canceled HOLIDAY_DAY_LIMIT Skipass: " + counterCanceled.get(skiPassType) );
                break;

            case HALF_DAY_AFTERNOON:
                System.out.println("Total passed Ha HALF_DAY_AFTERNOON Skipass: " + counterPassed.get(skiPassType) + ". " + "Total canceled HALF_DAY_AFTERNOON Skipass: " + counterCanceled.get(skiPassType) );
                break;

            case HALF_DAY_MORNING:
                System.out.println("Total passed Ha HALF_DAY_MORNING Skipass: " + counterPassed.get(skiPassType) + ". " + "Total canceled HALF_DAY_MORNING Skipass: " + counterCanceled.get(skiPassType) );
                break;

            case HOLIDAY_HALF_DAY_MORNING:
                System.out.println("Total passed Ha HOLIDAY_HALF_DAY_MORNING Skipass: " + counterPassed.get(skiPassType) + ". " + "Total canceled HOLIDAY_HALF_DAY_MORNING Skipass: " + counterCanceled.get(skiPassType) );
                break;

            case HOLIDAY_HALF_DAY_AFTERNOON:
                System.out.println("Total passed Ha HOLIDAY_HALF_DAY_AFTERNOON Skipass: " + counterPassed.get(skiPassType) + ". " + "Total canceled HOLIDAY_HALF_DAY_AFTERNOON Skipass: " + counterCanceled.get(skiPassType) );
                break;
        }



    }
}
