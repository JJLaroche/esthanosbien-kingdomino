package tests;
 
import static org.junit.Assert.*;
 
import org.junit.Test;

import shared.Mazo;
import shared.Mesa;
 
public class MesaTest {
 
    @Test
    public void testConstructor() {
        Mazo mazo = new Mazo();
        Mesa mesa = new Mesa(mazo);
        assertNotNull(mesa);
    }

    @Test
    public void testObtenerFicha() {
        Mazo mazo = new Mazo();
        Mesa mesa = new Mesa(mazo);
        mesa.desplegarFichasDomino();
        assertNotNull(mesa.obtenerFicha(1));
    }
 
}