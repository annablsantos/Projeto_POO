package services;

import interfaces.Heroi;
import models.Poder;

public class Luta {
    private final Heroi primeiroHeroi;
    private final Heroi segundoHeroi;

    public Luta(Heroi primeiroHeroi, Heroi segundoHeroi) {
        this.primeiroHeroi = primeiroHeroi;
        this.segundoHeroi = segundoHeroi;
    }

    public String determinarPrimeiroMovimento() {
        double resultado = Math.floor(Math.random() * 2);
        Heroi heroiQueComeca;
        if (resultado == 1)
            heroiQueComeca = primeiroHeroi;
        else
            heroiQueComeca = segundoHeroi;

        return "O primeiro movimento é do heroi " + heroiQueComeca.getNome() + "!";
    }

    public String lutar(Heroi atacante, Poder superPoder, Heroi defensor, boolean tentouDesviar) {
        if (atacante.getEnergia() < superPoder.getConsumoDeEnergia()) {
            return "O heroi " + atacante.getNome() + " nao tem energia suficiente para usar o poder " + superPoder.getNome() + ".";
        }

        try {
            verificarSeHeroiTemSuperPoder(atacante, superPoder);
        } catch (Exception e) {
            return e.getMessage();
        }

        atacante.usarSuperPoder(superPoder);
        StringBuilder sb = new StringBuilder("O heroi ").append(atacante.getNome()).append(" usou ").append(superPoder.getNome()).append(" para atacar!");

        if (tentouDesviar) {
            if (defensor.desviar()) {
                sb.append("\nO heroi ").append(defensor.getNome()).append(" desviou!");
                verificarStatus(sb, atacante);
                verificarStatus(sb, defensor);
                return sb.toString();
            }
            sb.append("\nO heroi ").append(defensor.getNome()).append(" nao conseguiu desviar!");
        }

        defensor.consumirVida(superPoder.getDano());
        sb.append("\nO heroi ").append(defensor.getNome()).append(" levou ").append(superPoder.getDano()).append(" de dano!");

        verificarStatus(sb, atacante);
        verificarStatus(sb, defensor);
        return sb.toString();
    }

    public void verificarStatus(StringBuilder msg, Heroi heroi) {
        if (heroi.getEnergia() == 0) {
            msg.append("\nO heroi ")
                    .append(heroi.getNome())
                    .append(" tem energia insuficiente para continuar o combate.");
        }
        if (heroi.getVida() == 0) {
            msg.append("\nO heroi ")
                    .append(heroi.getNome())
                    .append(" nao tem mais vida para continuar a luta.");
        }
    }

    public void verificarSeHeroiTemSuperPoder(Heroi atacante, Poder superPoder) {
        if (!atacante.temSuperPoder(superPoder.getNome())) {
            String msg = "O heroi " + atacante.getNome() + " nao possui o superpoder " + superPoder.getNome() + ".";
            throw new IllegalArgumentException(msg);
        }
    }
}