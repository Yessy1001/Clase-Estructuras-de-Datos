package pruebas;

import implementaciones.CilindroImp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CilindroImpTest {

    @Test
    public void testConstructorValido() {
        CilindroImp c = new CilindroImp(3, 5);
        assertEquals("Cilindro(3.0, 5.0)", c.toString());
    }

    @Test
    public void testConstructorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CilindroImp(-3, 5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new CilindroImp(3, -5);
        });
    }

    @Test
    public void testArea() {
        CilindroImp c = new CilindroImp(2, 4);
        double esperado = 2 * Math.PI * 2 * (2 + 4); // fórmula
        assertEquals(esperado, c.area(), 0.0001);
    }

    @Test
    public void testVolumen() {
        CilindroImp c = new CilindroImp(2, 4);
        double esperado = Math.PI * 2 * 2 * 4;
        assertEquals(esperado, c.volumen(), 0.0001);
    }
}
