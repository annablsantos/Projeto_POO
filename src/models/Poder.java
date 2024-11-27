package models;

public class Poder {
    private String nome;
    private int dano;
    private int consumoDeEnergia;

    public SuperPoder(String nome, int dano, int consumoDeEnergia) {
        this.nome = nome;
        this.setDano(dano);
        this.setConsumoDeEnergia(consumoDeEnergia);
    }

    public void setDano(int dano) {
        if (dano < 0)
            throw new IllegalArgumentException("O dano não pode ser negativo.");
        this.dano = dano;
    }

    public void setConsumoDeEnergia(int consumoDeEnergia) {
        if (consumoDeEnergia < 0)
            throw new IllegalArgumentException("O consumo de energia não pode ser negativo.");
        this.consumoDeEnergia = consumoDeEnergia;
    }

    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }

    public int getConsumoDeEnergia() {
        return consumoDeEnergia;
    }
}
