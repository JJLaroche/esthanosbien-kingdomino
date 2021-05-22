package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import shared.Jugador;
import shared.Mazo;
import shared.Mesa;
import shared.Partida;
import shared.Tablero;

public class PartidaTest {

	@Test
	public void validarCalcularGanador_test() {

		Mazo mazo = new Mazo();
		Mesa mesa = new Mesa(mazo);
		Partida partida1 = new Partida(mesa);

		char[][] tablero = { { 'B', 'B', 'G', 'G', 'A' }, { 'B', 'A', 'A', 'A', 'M' }, { 'M', 'G', 'C', 'V', 'M' },
				{ 'A', 'G', 'T', 'B', 'M' }, { '_', '_', 'V', 'B', 'A' } };

		int[][] corona = { { 0, 1, 1, 3, 0 }, { 0, 0, 0, 0, 1 }, { 0, 2, 0, 0, 1 }, { 0, 2, 1, 0, 0 },
				{ 0, 0, 0, 0, 1 } };

		char[][] tablero2 = { { 'B', 'V', 'G', 'A', 'B' }, { 'B', 'A', 'A', 'A', 'M' }, { 'B', 'M', 'C', 'V', 'A' },
				{ 'A', 'A', 'T', 'B', 'M' }, { '_', '_', 'V', 'B', 'A' } };

		Tablero table = new Tablero(corona, tablero);
		Tablero table2 = new Tablero(corona, tablero2);

		Jugador jugador1 = new Jugador("Ivan", table, mesa);
		Jugador jugador2 = new Jugador("Mica", table2, mesa);

		partida1.setJugador(jugador2);
		partida1.setJugador(jugador1);

		ArrayList<Jugador> jugs = new ArrayList<Jugador>();

		jugs = partida1.calcularGanador();

		assertEquals(jugador1.getNombreJugador(), jugs.get(0).getNombreJugador());
		assertNotEquals(jugador2.getNombreJugador(), jugs.get(0).getNombreJugador());
	}
}