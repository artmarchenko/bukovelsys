package bokovelsys;

import bokovelsys.cards.SkiPass;
import bokovelsys.cards.SkiPassType;
import bokovelsys.servises.AccountSystem;
import bokovelsys.servises.Turnstile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime past = LocalDateTime.parse("2018-05-05 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.println(past);
        System.out.println(ChronoUnit.DAYS.between(now, past));



    }

}
