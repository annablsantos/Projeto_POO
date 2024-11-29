package models;

import interfaces.Heroi;

import java.util.HashMap;
import java.util.Map;

public class HeroiFisico extends Personagem implements Heroi {
    private Map<String, Poder> poderesEspeciais;

    public HeroiFisico(String nome) {
        super(nome);
        this.poderesEspeciais = new HashMap<>();
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


    public String aprenderPoder(String nomeDoPoder, Poder poder) {
        if (!poderesEspeciais.containsKey(nomeDoPoder)) {
            poderesEspeciais.put(nomeDoPoder, poder);
            return "O herói " + getNome() + " acabou de aprender o poder especial " + nomeDoPoder + "!";
        } else {
            return "O herói " + getNome() + " já aprendeu esse poder especial.";
        }
    }
}
