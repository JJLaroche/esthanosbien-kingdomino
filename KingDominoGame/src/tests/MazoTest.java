package tests;
 
import static org.junit.Assert.*;
 
import org.junit.Test;
 
import shared.Mazo;
 
public class MazoTest {
 
    @Test
    public void testConstructor() {
        Mazo mazo = new Mazo();

        assertNotNull(mazo);
    }

    @Test
    public void testObtenerFichaMazo() {
        Mazo mazo = new Mazo();

        assertNotNull(mazo.obtenerFichaMazo());
    }
 
}