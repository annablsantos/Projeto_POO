package models;

import interfaces.Heroi;

public class HeroiElemental extends Personagem implements Heroi {
    private Poder poderElemental;

    public HeroiElemental(String nome) {
        super(nome);
    }

    public void aprenderPoderEspecial(String nomePoder, Poder poder) {
        this.poderElemental = poder;
    }

    @Override
    public boolean temSuperPoder(String nomePoder) {
        return poderElemental != null && poderElemental.getNome().equals(nomePoder);
    }

    @Override
    public boolean desviar() {
        return true;
    }

    @Override
    public String usarSuperPoder(Poder superPoder) {
        if (temSuperPoder(superPoder.getNome())) {
            return "O herói " + getNome() + " usou " + superPoder.getNome() + " para atacar!";
        }
        return null;
    }
}
