import models.Personagem;
import models.Poder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonagemTest {

    private Personagem professorX;
    private Poder poderPsiquico;

    @BeforeEach
    public void setUp() {
        professorX = new Personagem("Professor X");
        poderPsiquico = new Poder("Poder Psiquico", 20, 50);
    }

    @Test
    public void testConsumirEnergia() {
        professorX.consumirEnergia(30);
        assertEquals(70, professorX.getEnergia());
    }

    @Test
    public void testConsumirVida() {
        professorX.consumirVida(40);
        assertEquals(60, professorX.getVida());
    }

    @Test
    public void testUsarPoderComEnergiaInsuficiente() {
        professorX.consumirEnergia(100);

        String resultado = professorX.usarPoder(poderPsiquico);
        assertEquals("O heroi nao pode usar esse poder, falta energia.", resultado);
        assertEquals(0, professorX.getEnergia());
    }

    @Test
    public void testAdicionarPoder() {
        String resultado = professorX.aprenderPoder("Poder Psiquico", poderPsiquico);
        assertEquals("O heroi Professor X acabou de aprender o poder especial Poder Psiquico!", resultado);
    }

    @Test
    public void testAdicionarPoderJaExistente() {
        professorX.aprenderPoder("Poder Psiquico", poderPsiquico);

        String resultado = professorX.aprenderPoder("Poder Psiquico", poderPsiquico);
        assertEquals("O heroi Professor X ja aprendeu esse poder especial.", resultado);
    }

    @Test
    public void testeConsumoDeEnergiaNoLimite() {
        professorX.consumirEnergia(150);
        assertEquals(0, professorX.getEnergia());
    }
}
