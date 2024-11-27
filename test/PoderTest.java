import models.Poder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PoderTest {
    Poder poder = new Poder("Soco", 10, 5);

    @Test
    public void testSetDanoInvalido() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> poder.setDano(-10)
        );
        String mensagemEsperada = "O dano não pode ser negativo.";
        String mensagemRecebida = exception.getMessage();
        Assertions.assertTrue(mensagemRecebida.contains(mensagemEsperada));
    }

    @Test
    public void testSetConsumoDeEnergiaInvalido() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> poder.setConsumoDeEnergia(-5)
        );
        String mensagemEsperada = "O consumo de energia não pode ser negativo.";
        String mensagemRecebida = exception.getMessage();
        Assertions.assertTrue(mensagemRecebida.contains(mensagemEsperada));
    }
}
