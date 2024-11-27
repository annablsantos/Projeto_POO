package services;

import models.HeroiElemental;
import models.HeroiFisico;
import models.Poder;

public class LutaEntreHeroisMain {
    public static void main(String[] args) {
        HeroiElemental thor = new HeroiElemental("Homem de Ferro");
        HeroiFisico hulk = new HeroiFisico("Hulk");

        Poder chute = new Poder("Chute", 10, 5);
        Poder soco = new Poder("Soco", 5, 0);

        thor.aprenderPoderEspecial(chute.getNome(), chute);
        hulk.aprenderPoderEspecial(soco.getNome(), soco);

        Luta luta = new Luta(thor, hulk);

        System.out.println(luta.determinarPrimeiroMovimento());

        System.out.println(luta.lutar(thor, chute, hulk, false));
        System.out.println(luta.lutar(hulk, soco, thor, true));
    }
}