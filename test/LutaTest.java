import interfaces.Heroi;
import models.HeroiFisico;
import models.HeroiMental;
import models.Poder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.Luta;

import static org.junit.jupiter.api.Assertions.*;

public class LutaTest {

    private HeroiMental professorX;
    private HeroiFisico wolverine;
    private Poder poderPsiquico;
    private Poder soco;
    private Luta luta;

    @BeforeEach
    public void setUp() {
        professorX = new HeroiMental("Professor X");
        wolverine = new HeroiFisico("Wolverine");
        poderPsiquico = new Poder("Poder psiquico", 10, 5);
        soco = new Poder("Soco", 5, 0);
        professorX.aprenderPoderEspecial(poderPsiquico.getNome(), poderPsiquico);
        wolverine.aprenderPoderEspecial(soco.getNome(), soco);
        luta = new Luta(professorX, wolverine);
    }

    @Test
    public void testDeterminarPrimeiroMovimento() {
        String resultado = luta.determinarPrimeiroMovimento();
        assertTrue(resultado.contains("O primeiro movimento é do heroi Professor X!") || resultado.contains("O primeiro movimento é do heroi Wolverine!"));
    }

    @Test
    public void testLutarEDesviarComSucesso() {
        Heroi atacante = professorX;
        Heroi defensor = wolverine;
        boolean tentouDesviar = true;
        String resultado = luta.lutar(atacante, poderPsiquico, defensor, tentouDesviar);

        assertTrue(resultado.contains("O heroi Wolverine desviou!"));
        assertTrue(resultado.contains("O heroi Professor X usou Poder psiquico para atacar!"));
    }

    @Test
    public void testLutarSemPossuirPoder() {
        Heroi atacante = professorX;
        Heroi defensor = wolverine;
        Poder poderEspecial = new Poder("Poder especial", 10, 100);
        String resultado = luta.lutar(atacante, poderEspecial, defensor, false);

        assertTrue(resultado.contains("O heroi Professor X nao possui o superpoder Poder especial."));
    }
}

