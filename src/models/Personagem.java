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

    public boolean temPoderEspecial(String nomePoder) {
        return poderesEspeciais.containsKey(nomePoder);
    }

    public Map<String, Poder> getPoderesEspeciais() {
        return poderesEspeciais;
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
            return "O herói não pode usar esse poder, falta energia.";
        }
        consumirEnergia(poder.getConsumoDeEnergia());
        return "O herói " + this.nome + " está atacando usando o " + poder.getNome();
    }

    public String aprenderPoder(String nomeDoPoder, Poder poder) {
        if(!poderesEspeciais.containsKey(nomeDoPoder)) {
            poderesEspeciais.put(nomeDoPoder, poder);
            return "O herói " + this.nome + " acabou de aprender o poder especial " + nomeDoPoder + "!";
        } else {
            return "O herói " + this.nome +  " já aprendeu esse poder especial.";
        }
    }
}