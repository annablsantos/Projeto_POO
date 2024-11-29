package interfaces;

import models.Poder;

public interface Heroi {
    String getNome();
    int getEnergia();
    int getVida();
    void consumirVida(int dano);
    boolean temSuperPoder(String nomePoder);
    boolean desviar();
    void usarSuperPoder(Poder superPoder);
}