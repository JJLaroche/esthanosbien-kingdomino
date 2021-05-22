package shared;

public class Puntuacion {
	private int puntos=0;
	private int cantidadCoronasTotales=0;
	private int terrenoMasExtenso=0;
	
	

	public int getPuntos() {
		return puntos;
	}

	public int getCantidadCoronasTotales() {
		return cantidadCoronasTotales;
	}

	public int getTerrenoMasExtenso() {
		return terrenoMasExtenso;
	}

	public int recorrerTerreno(int fila, int columna, char tipoTerreno, int[] cantCoronas, int[][] corona, char [][]tablero) {

		if ((fila < 0 || fila >= tablero.length) || (columna < 0 || columna >= tablero[0].length)
				|| tablero[fila][columna] != tipoTerreno || tablero[fila][columna] == 'Z')
			return 0;
		tablero[fila][columna] = 'Z';

		cantCoronas[0] += corona[fila][columna];

		return 1 + recorrerTerreno(fila - 1, columna, tipoTerreno, cantCoronas,corona,tablero) // ARRIBA
				+ recorrerTerreno(fila, columna + 1, tipoTerreno, cantCoronas,corona,tablero) // DERECHA
				+ recorrerTerreno(fila + 1, columna, tipoTerreno, cantCoronas,corona,tablero) // ABAJO
				+ recorrerTerreno(fila, columna - 1, tipoTerreno, cantCoronas,corona,tablero); // IZQUIERDA

	}

	public int obtenerPuntuacion(Tablero tab) {

		int puntuacionTotal = 0;
		int extensionTerrenoMayor = 0;
		int extensionTerrenoActual;
		int[] cantCoronas = {0};
		
		char[][] tablero=new char [tab.getTablero().length][tab.getTablero().length];
		tablero = tab.getTablero();
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				if (tablero[i][j] != 'X' && tablero[i][j] != 'Z' && tablero[i][j] != '©') {

					puntuacionTotal += (extensionTerrenoActual = (this.recorrerTerreno(i, j, tablero[i][j],
							cantCoronas,tab.getCorona(),tablero)) * cantCoronas[0]);
					if (extensionTerrenoActual > extensionTerrenoMayor)
						extensionTerrenoMayor = extensionTerrenoActual;
					this.cantidadCoronasTotales += cantCoronas[0];
					cantCoronas[0] = 0;
				}
			}
		}
		this.terrenoMasExtenso = extensionTerrenoMayor;
		this.puntos = puntuacionTotal;
		return puntuacionTotal;
	}
}
