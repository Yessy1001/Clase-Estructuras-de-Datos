package pruebas;

import implementaciones.BolsaImp;
import excepciones.BolsaException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BolsaImpTest {

    @Test
    public void testConstructorValido() {
        BolsaImp b = new BolsaImp(5);
        assertTrue(b.vacia());
        assertEquals(0, b.obtenNumObjetos());
    }

    @Test
    public void testConstructorNegativo() {
        assertThrows(BolsaException.class, () -> new BolsaImp(-1));
    }

    @Test
    public void testAgregarYObtenNumObjetos() {
        BolsaImp b = new BolsaImp(3);
        b.agrega(10);
        b.agrega(20);
        assertEquals(2, b.obtenNumObjetos());
    }

    @Test
    public void testAgregarCuandoLlena() {
        BolsaImp b = new BolsaImp(1);
        b.agrega(10);
        assertThrows(BolsaException.class, () -> b.agrega(20));
    }

    @Test
    public void testRemueveAzar() {
        BolsaImp b = new BolsaImp(3);
        b.agrega(1);
        b.agrega(2);
        b.agrega(3);
        Integer eliminado = b.remueve();
        assertNotNull(eliminado);
        assertEquals(2, b.obtenNumObjetos());
    }

    @Test
    public void testRemuevePorValor() {
        BolsaImp b = new BolsaImp(3);
        b.agrega(5);
        b.agrega(10);
        b.agrega(15);
        Integer eliminado = b.remueve(10);
        assertEquals(10, eliminado);
        assertEquals(2, b.obtenNumObjetos());
        assertNull(b.remueve(99)); // no existe
    }

    @Test
    public void testCuentaYContiene() {
        BolsaImp b = new BolsaImp(5);
        b.agrega(7);
        b.agrega(7);
        b.agrega(8);
        assertEquals(2, b.cuenta(7));
        assertTrue(b.contiene(8));
        assertFalse(b.contiene(99));
    }

    @Test
    public void testLimpia() {
        BolsaImp b = new BolsaImp(3);
        b.agrega(1);
        b.agrega(2);
        b.limpia();
        assertTrue(b.vacia());
    }

    @Test
    public void testObtenObjetos() {
        BolsaImp b = new BolsaImp(3);
        b.agrega(100);
        b.agrega(200);
        Integer[] copia = b.obtenObjetos();
        assertArrayEquals(new Integer[]{100, 200}, copia);
    }
}