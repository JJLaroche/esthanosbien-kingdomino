package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import shared.Puntuacion;
import shared.Tablero;

public class PuntuacionTest {

	private char[][] tablero= 
	{{'B','B','G','G','A'},
	{'B','A','A','A','M'},
	{'M','G','C','V','M'},
	{'A','G','T','B','M'},
	{'_','_','V','B','A'}};
		
	private int [][] corona= 
	{{0,1,1,3,0},
	{0,0,0,0,1},
	{0,2,0,0,1},
	{0,2,1,0,0},
	{0,0,0,0,1}};
	
	Tablero tab = new Tablero (corona,tablero);
	Puntuacion punt = new Puntuacion ();
	
	//public int obtenerPuntuacion(Tablero tab) 
	@Test
	public void testObtenerPuntuacion() {
		assertEquals(27,punt.obtenerPuntuacion(tab));
	}
	
}
