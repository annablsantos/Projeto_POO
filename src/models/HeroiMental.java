package models;

import interfaces.Heroi;

public class HeroiMental extends Personagem implements Heroi {
    private Poder poderPsiquico;

    public HeroiMental(String nome) {
        super(nome);
    }

    public void aprenderPoderEspecial(String nomePoder, Poder poder) {
        this.poderPsiquico = poder;
    }

    @Override
    public boolean temSuperPoder(String nomePoder) {
        return poderPsiquico != null && poderPsiquico.getNome().equals(nomePoder);
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
