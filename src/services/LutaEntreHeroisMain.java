package services;

import models.HeroiElemental;
import models.HeroiFisico;
import models.Poder;

public class LutaEntreHeroisMain {
    public static void main(String[] args) {
        HeroiElemental thor = new HeroiElemental("Thor");
        HeroiFisico hulk = new HeroiFisico("Hulk");

        Poder chute = new Poder("Chute", 10, 5);
        Poder soco = new Poder("Soco", 5, 0);

        System.out.println(thor.aprenderPoder("Chute", chute));
        System.out.println(hulk.aprenderPoder("Soco", soco));

        Luta luta = new Luta(thor, hulk);

        System.out.println(luta.determinarPrimeiroMovimento());

        System.out.println(luta.lutar(thor, chute, hulk, false));
        System.out.println(luta.lutar(hulk, soco, thor, true));
    }
}