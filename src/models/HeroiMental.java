package models;

import interfaces.Heroi;

import java.util.HashMap;
import java.util.Map;

public class HeroiMental extends Personagem implements Heroi {
    private Map<String, Poder> poderesEspeciais;

    public HeroiMental(String nome) {
        super(nome);
        this.poderesEspeciais = new HashMap<>();
    }

    public String aprenderPoder(String nomePoder, Poder poder) {
        if (!poderesEspeciais.containsKey(nomePoder)) {
            poderesEspeciais.put(nomePoder, poder);
            System.out.println("O herói " + getNome() + " acabou de aprender o poder especial " + nomePoder + "!");
        } else {
            System.out.println("O herói " + getNome() + " já tem o poder " + nomePoder + ".");
        }
        return nomePoder;
    }

    @Override
    public boolean temSuperPoder(String nomePoder) {
        return poderesEspeciais.containsKey(nomePoder);
    }

    @Override
    public boolean desviar() {
        return true;
    }

    @Override
    public void usarSuperPoder(Poder superPoder) {
        if (temSuperPoder(superPoder.getNome())) {
            if (getEnergia() >= superPoder.getConsumoDeEnergia()) {
                consumirEnergia(superPoder.getConsumoDeEnergia());
            } else {
                System.out.println("O herói " + getNome() + " não tem energia suficiente para usar o poder " + superPoder.getNome() + ".");
            }
        } else {
            System.out.println("O herói " + getNome() + " não tem esse poder.");
        }
    }

}

