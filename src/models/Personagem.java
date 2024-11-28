package models;

import java.util.HashMap;
import java.util.Map;

public class Personagem {
    private String nome;
    private Map<String, Poder> poderesEspeciais;
    private int energia = 100;
    private int vida = 100;

    public Personagem(String nome) {
        this.nome = nome;
        this.poderesEspeciais = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getVida() {
        return vida;
    }

    public void consumirVida(int dano) {
        this.vida -= dano;
    }

    public void consumirEnergia(int consumo) {
        this.energia -= consumo;
        if (this.energia < 0) {
            this.energia = 0;
        }
    }

    public String usarPoder(Poder poder) {
        if(this.getEnergia() < poder.getConsumoDeEnergia()) {
            this.setEnergia(0);
            return "O heroi nao pode usar esse poder, falta energia.";
        }
        consumirEnergia(poder.getConsumoDeEnergia());
        return "O heroi " + this.nome + " esta atacando usando o " + poder.getNome();
    }

    public String aprenderPoder(String nomeDoPoder, Poder poder) {
        if(!poderesEspeciais.containsKey(nomeDoPoder)) {
            poderesEspeciais.put(nomeDoPoder, poder);
            return "O heroi " + this.nome + " acabou de aprender o poder especial " + nomeDoPoder + "!";
        } else {
            return "O heroi " + this.nome +  " ja aprendeu esse poder especial.";
        }
    }
}