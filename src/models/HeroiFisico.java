package models;

import interfaces.Heroi;

public class HeroiFisico extends Personagem implements Heroi {
    private Poder poderFisico;

    public HeroiFisico(String nome) {
        super(nome);
    }

    public void aprenderPoderEspecial(String nomePoder, Poder poder) {
        this.poderFisico = poder;
    }

    @Override
    public boolean temSuperPoder(String nomePoder) {
        return poderFisico != null && poderFisico.getNome().equals(nomePoder);
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
