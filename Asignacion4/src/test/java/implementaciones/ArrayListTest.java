package implementaciones;

import excepciones.ListException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;

public class ArrayListTest {

    @Test
    public void testAppend_Integer() {
        ArrayList<Integer> intList = new ArrayList<>(Integer.class, 5);
        intList.append(1);
        intList.append(2);
        assertEquals(2, intList.size());
        assertEquals(1, intList.get(0));
    }

    @Test
    public void testInsert_String() {
        ArrayList<String> strList = new ArrayList<>(String.class, 5);
        strList.insert("A", 0);
        strList.insert("B", 1);
        strList.insert("C", 1);
        assertEquals("[A, C, B]", strList.toString());
    }

    @Test
    public void testGetAndRemove() {
        ArrayList<Integer> intList = new ArrayList<>(Integer.class, 3);
        intList.append(10);
        intList.append(20);
        intList.append(30);
        assertEquals(20, intList.get(1));
        assertEquals(20, intList.remove(1));
        assertEquals("[10, 30]", intList.toString());
    }

    @Test
    public void testEmptyAndSize() {
        ArrayList<String> strList = new ArrayList<>(String.class, 2);
        assertTrue(strList.empty());
        strList.append("X");
        assertFalse(strList.empty());
        assertEquals(1, strList.size());
    }

    @Test
    public void testIterator() {
        ArrayList<Integer> intList = new ArrayList<>(Integer.class, 3);
        intList.append(5);
        intList.append(6);
        Iterator<Integer> it = intList.iterator();
        assertTrue(it.hasNext());
        assertEquals(5, it.next());
    }

    @Test
    public void testExcepciones() {
        ArrayList<Integer> intList = new ArrayList<>(Integer.class, 2);
        intList.append(1);
        intList.append(2);
        assertThrows(ListException.class, () -> intList.append(3));
        assertThrows(ListException.class, () -> intList.get(-1));
        assertThrows(ListException.class, () -> intList.remove(5));
    }
}
