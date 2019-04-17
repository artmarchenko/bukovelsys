package bokovelsys;

import bokovelsys.cards.SkiPass;
import bokovelsys.cards.SkiPassType;
import bokovelsys.servises.AccountSystem;
import bokovelsys.servises.Turnstile;

public class Main {
    public static void main(String[] args) {

        AccountSystem accountSystem = new AccountSystem();

        SkiPass daySkiPass = accountSystem.createDaySkiPass(5);
        SkiPass daySkiPass2 = accountSystem.createDaySkiPass(5);

//        System.out.println(accountSystem.getSkiPassList().size());
//
//
//        System.out.println(daySkiPass.getId());
//        System.out.println(daySkiPass2.getId());
        Turnstile turnstile = new Turnstile();
        turnstile.getStat(SkiPassType.SEASON);

    }

}
