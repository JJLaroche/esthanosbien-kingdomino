package tests;
 
import static org.junit.Assert.*;
 
import org.junit.Test;
 
import shared.Jugador;
import shared.Mazo;
import shared.Mesa;
import shared.Tablero;
 
public class JugadorTest {
 
    @Test
    public void testConstructor() {

        Jugador jugador = new Jugador("Franco", new Tablero(5), new Mesa(new Mazo()));
        assertEquals("Franco", jugador.getNombreJugador());
    }

    @Test
    public void testGetPuntos() {
        Jugador jugador = new Jugador("Franco", new Tablero(5), new Mesa(new Mazo()));
        assertEquals(0, jugador.getPuntos().getPuntos());
    }

    @Test
    public void verCartaSeleccionada() {
        Mazo mazo = new Mazo();
        Mesa mesa = new Mesa(mazo);
        mesa.desplegarFichasDomino();
        Jugador jugador = new Jugador("Franco", new Tablero(5), mesa);

        jugador.elegirFicha(1);

        assertNotNull(jugador.verCartaSeleccionada());
    }

    @Test
    public void testcolocarFichaDomino() {
        Mazo mazo = new Mazo();
        Mesa mesa = new Mesa(mazo);
        mesa.desplegarFichasDomino();
        Jugador jugador = new Jugador("Franco", new Tablero(5), mesa);

        jugador.elegirFicha(1);

        assertFalse(jugador.colocarFichaDomino(1, 1, 1));
    }

}