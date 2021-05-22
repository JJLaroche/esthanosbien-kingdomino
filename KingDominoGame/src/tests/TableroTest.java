package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import shared.FichaDomino;
import shared.Tablero;

public class TableroTest {

	Tablero tablero = new Tablero(1);
	FichaDomino ficha = new FichaDomino(48, "AMARILLO", "GRIS 3xC", 0, 3);
	FichaDomino ficha2 = new FichaDomino(46, "GRIS 2xC", "BERDEO", 2, 0);
	
	@Test
	public void testNoSePuedeRey() {
		assertEquals(false, tablero.evaluarPosicion(ficha, 1,4,4));
		assertEquals(false, tablero.evaluarPosicion(ficha, 2,4,4));
		assertEquals(false, tablero.evaluarPosicion(ficha, 3,4,4));
		assertEquals(false, tablero.evaluarPosicion(ficha, 4,4,4));
	}
	
	@Test
	public void testSePuede() {
		assertEquals(true, tablero.evaluarPosicion(ficha, 1,4,5));
		assertEquals(true, tablero.evaluarPosicion(ficha, 1,5,4));
		assertEquals(true, tablero.evaluarPosicion(ficha, 1,3,4));
		assertEquals(true, tablero.evaluarPosicion(ficha, 3,4,3));
	}
	
	@Test
	public void testSePuedeTerreno() {
		tablero.evaluarPosicion(ficha, 1,4,5);
		assertEquals(true, tablero.evaluarPosicion(ficha2, 1,4,7));
		assertEquals(false, tablero.evaluarPosicion(ficha2, 2,4,7));
	}
}
