package bokovelsys;

import bokovelsys.cards.SkiPass;
import bokovelsys.cards.SkiPassType;
import bokovelsys.servises.AccountSystem;
import bokovelsys.servises.Turnstile;

import java.time.LocalDateTime;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        AccountSystem accountSystem = new AccountSystem();

        SkiPass seasonSkiPass1 = accountSystem.createSeasonSkiPass(LocalDateTime.of(2019,8, 1,0,0));
        SkiPass seasonSkiPass2 = accountSystem.createSeasonSkiPass(LocalDateTime.of(2018,8, 1,0,0));

        Turnstile turnstile = new Turnstile();

        System.out.println(turnstile.validate(seasonSkiPass1));
        System.out.println(turnstile.validate(seasonSkiPass2));


    }

}
