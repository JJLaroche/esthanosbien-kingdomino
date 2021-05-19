package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import contracts.IDomino;
import contracts.IJugador;
import contracts.IMesa;
import contracts.ITablero;
import shared.Jugador;

public class JugadorTest {
	  
	@Test
	public void testConstructor() {
		
		ITablero tableroMock = new TableroMock(false);
		IDomino dominoMock = new DominoMock();
		IMesa mesaMock = new MesaMock(dominoMock, false);
		
		IJugador jugador = new Jugador("Franco", tableroMock, mesaMock);
		
		 assertEquals("Franco", jugador.getNombreJugador());
		 assertFalse(jugador.colocarFichaDomino(1, 2));
	}
	
	@Test
	public void testcolocarFichaDominoNoError() {
		
		ITablero tableroMock = new TableroMock(false);
		IDomino dominoMock = new DominoMock();
		IMesa mesaMock = new MesaMock(dominoMock, false);
		
		IJugador jugador = new Jugador("Franco", tableroMock, mesaMock);
		
		 assertFalse(jugador.colocarFichaDomino(1, 2));
	}
	
	@Test
	public void testcolocarFichaDominoError() {
		
		ITablero tableroMock = new TableroMock(true);
		IDomino dominoMock = new DominoMock();
		IMesa mesaMock = new MesaMock(dominoMock, false);
		
		IJugador jugador = new Jugador("Franco", tableroMock, mesaMock);
		
		 assertTrue(jugador.colocarFichaDomino(1, 2));
	}
	
	
	@Test
	public void testdescartarFichaNoError() {
		
		ITablero tableroMock = new TableroMock(true);
		IDomino dominoMock = new DominoMock();
		IMesa mesaMock = new MesaMock(dominoMock, false);
		
		IJugador jugador = new Jugador("Franco", tableroMock, mesaMock);
		
		 assertFalse(jugador.descartarFicha());
	}
	
	@Test
	public void testdescartarFichaError() {
		
		ITablero tableroMock = new TableroMock(true);
		IDomino dominoMock = new DominoMock();
		IMesa mesaMock = new MesaMock(dominoMock, true);
		
		IJugador jugador = new Jugador("Franco", tableroMock, mesaMock);
		
		 assertTrue(jugador.descartarFicha());
	}
	
	@Test
	public void testGetColorRey() {
		
		ITablero tableroMock = new TableroMock(true);
		IDomino dominoMock = new DominoMock();
		IMesa mesaMock = new MesaMock(dominoMock, true);
		
		IJugador jugador = new Jugador("Franco", tableroMock, mesaMock);
		
		jugador.elegirColorRey("Rojo");
		
		 assertEquals("Rojo", jugador.getColorRey());
	}
	
	@Test
	public void testGetColorReyNoSelected() {
		
		ITablero tableroMock = new TableroMock(true);
		IDomino dominoMock = new DominoMock();
		IMesa mesaMock = new MesaMock(dominoMock, true);
		
		IJugador jugador = new Jugador("Franco", tableroMock, mesaMock);
				
		 assertNull(jugador.getColorRey());
	}

}
