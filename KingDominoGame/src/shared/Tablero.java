package shared;

import contracts.ITablero;

public class Tablero implements ITablero{
	private int ancho;
	private int alto;
	private char[][] tablero;
	private int [][] corona;
	
	
	public Tablero(int [][]coronas,char [][]tablero) {
		this.tablero=new char [tablero.length][tablero.length]; 
		this.tablero=tablero;
		this.corona=new int [coronas.length][coronas.length]; 
		this.corona=coronas;
	}

	// MODO 2 = Duelo de poder (7x7)
	public Tablero(int Modo) {
		super();
		if (Modo == 2) {
			alto = 13;
			ancho = 13;
			tablero = new char[alto][ancho];
			corona = new int[alto][ancho];
			for (int i = 0; i < ancho; i++)
				for (int j = 0; j < alto; j++) {
					tablero[i][j] = '_';
					corona[i][j] = 0;
				}
			tablero[6][6] = '©';
		} else {
			alto = 9;
			ancho = 9;
			tablero = new char[alto][ancho];
			corona = new int[alto][ancho];
			for (int i = 0; i < ancho; i++)
				for (int j = 0; j < alto; j++) {
					tablero[i][j] = '_';
					corona[i][j] = 0;
				}
			tablero[4][4] = '©';

		}
	}

	public boolean evaluarPosicion(FichaDomino ficha,int orientacion,int fila,int columna) {
		char terreno1 = ficha.getTerreno1().charAt(0);
		char terreno2 = ficha.getTerreno2().charAt(0);
		if(tablero[fila][columna]=='_')
			if((orientacion==1 && tablero[fila][columna+1]=='_') ||
			   (orientacion==2 && tablero[fila][columna-1]=='_') ||
			   (orientacion==3 && tablero[fila+1][columna]=='_') ||
			   (orientacion==4 && tablero[fila-1][columna]=='_')) 
				
				if((tablero[fila+1][columna]==terreno1 || tablero[fila+1][columna]=='©')||
		   	 	   (tablero[fila-1][columna]==terreno1 || tablero[fila-1][columna]=='©')|| 
				   (tablero[fila][columna+1]==terreno1 || tablero[fila][columna+1]=='©')|| 
				   (tablero[fila][columna-1]==terreno1 || tablero[fila][columna-1]=='©'))   
				{
					this.ponerDomino(fila,columna,ficha,orientacion);
					
					return true;
				}else if(  (tablero[fila+1][columna]==terreno2 || tablero[fila+1][columna]=='©')||
				   	 	   (tablero[fila-1][columna]==terreno2 || tablero[fila-1][columna]=='©')|| 
						   (tablero[fila][columna+1]==terreno2 || tablero[fila][columna+1]=='©')|| 
						   (tablero[fila][columna-1]==terreno2 || tablero[fila][columna-1]=='©'))					
				{
					this.ponerDomino(fila,columna,ficha,orientacion);
					return true;
				}
		System.out.println("No es posible colocar la ficha. Elija nuevamente.");
		return false;
		
		//recibe ficha y un lugar elegido por el usuario
		//devuelve true o false segun se pueda -> si se puede, establece ficha
	}
	
	public void ponerDomino(int fila, int columna, FichaDomino ficha, int orientacion) {
		tablero[fila][columna]=ficha.getTerreno1().charAt(0);
		corona[fila][columna]=ficha.getCoronast1();
		this.acotarTablero(fila, columna);
		switch(orientacion)
		{	
		case 1://|1|2|
			tablero[fila][columna+1]=ficha.getTerreno2().charAt(0);
			corona[fila][columna+1]=ficha.getCoronast2();
			this.acotarTablero(fila, columna+1);
			break;
			
		case 2://|2|1|
			tablero[fila][columna-1]=ficha.getTerreno2().charAt(0);
			corona[fila][columna-1]=ficha.getCoronast2();
			this.acotarTablero(fila, columna-1);
			break;
			
			//|1|
		case 3://|2|
			tablero[fila+1][columna]=ficha.getTerreno2().charAt(0);
			corona[fila+1][columna]=ficha.getCoronast2();
			this.acotarTablero(fila+1, columna);
			break;
			
			//|2|
		case 4://|1|
			tablero[fila-1][columna]=ficha.getTerreno2().charAt(0);
			corona[fila-1][columna]=ficha.getCoronast2();
			this.acotarTablero(fila-1, columna);
			break;
		}
	}

	public void acotarTablero(int fila, int columna) {
		if (tablero.length == 9) {// tamaño matriz base
			if (columna != 4) {
				for (int i = 0; i < tablero.length; i++)
					tablero[i][columna > 4 ? columna - 5 : columna + 5] = 'X';
			}
			if (fila != 4) {
				for (int i = 0; i < tablero.length; i++)
					tablero[fila > 4 ? fila - 5 : fila + 5][i] = 'X';
			}
		}

		// Por cada ficha que pongo para arriba, acoto de abajo
		//Por cada ficha que pongo para abajo, acoto de arriba
		//Por cada ficha que pongo para derecha, acoto de izquierda
		//Por cada ficha que pongo para izquierda, acoto de derecha
		
		
		else {//tamaño matriz modo2
			for (int i = 0; i < tablero.length; i++)
				tablero[fila > 6 ? fila - 7 : fila + 7][i] = 'X';

			for (int i = 0; i < tablero.length; i++)
				tablero[i][columna > 6 ? columna - 7 : columna + 7] = 'X';
		}
	}

	
	public char[][] getTablero() {
		return tablero;
	}

	public int[][] getCorona() {
		return corona;
	}

	public void mostrarTablero() {
		System.out.println("  _ _ _ _ _ _ _ _ _");
		for (int i = 0; i < tablero.length; i++) {
			System.out.print(i+"|");
			for (int j = 0; j < tablero[i].length; j++) {
					System.out.print(tablero[i][j]);
				if (j != tablero[i].length - 1)
					System.out.print("|");
			}
			System.out.println("|");
		}
		System.out.println("  0 1 2 3 4 5 6 7 8");
		
	}
	
}





// cada jugador tiene un tablero de 7x7 (expandible para considerar que el castillo
// no este en el centro. Para que sea de 7x7, tiene que tener un alto y ancho de
// 13x13 considerando que es estatica (castillo y 6 para cada lado).
//    _ _ _ _ _ _ _ _ _ _ _ _ _   _ _ _ _ _ _ _ _ _ _ _ _ _
//  0|_|_|_|_|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|_|_|_|_| 0
//  1|_|_|_|_|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|_|_|_|_| 1
//  2|_|_|_|_|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|_|_|_|_| 2
//  3|_|_|_|_|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|_|_|_|_| 3
//  4|_|_|_|_|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|_|_|_|_| 4
//  5|_|_|_|_|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|_|_|_|_| 5
//  6|_|_|_|_|_|_|C|_|_|_|_|_|_| |_|_|_|_|_|_|C|_|_|_|_|_|_| 6
//  7|_|_|_|_|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|_|_|_|_| 7
//  8|_|_|_|_|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|_|_|_|_| 8
//  9|_|_|_|_|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|_|_|_|_| 9
// 10|_|_|_|_|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|_|_|_|_|10
// 11|_|_|_|_|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|_|_|_|_|11
// 12|_|_|_|_|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|_|_|_|_|12 

// en caso de jugar mas de 2, el tablero es de 5x5 para cada jugador (idem
// expandible). Para que sea de 5x5, tiene que tener un alto y ancho de 9x9
// considerando que es estatica (castillo y 4 para cada lado)
//   _ _ _ _ _ _ _ _ _   _ _ _ _ _ _ _ _ _
// 0|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|0
// 1|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|1
// 2|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|2
// 3|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|3
// 4|_|_|_|_|C|a|g|_|_| |_|_|_|_|C|_|_|_|_|4
// 5|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|5
// 6|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|6
// 7|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|7
// 8|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|8
//   0 1 2 3 4 5 6 7 8   1 2 3 4 5 6 7 8 9 
//   _ _ _ _ _ _ _ _ _   _ _ _ _ _ _ _ _ _
// 0|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|0
// 1|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|1
// 2|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|2
// 3|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|3
// 4|_|_|_|_|C|_|_|_|_| |_|_|_|_|C|_|_|_|_|4
// 5|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|5
// 6|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|6
// 7|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|7
// 8|_|_|_|_|_|_|_|_|_| |_|_|_|_|_|_|_|_|_|8
//   0 1 2 3 4 5 6 7 8   1 2 3 4 5 6 7 8 9 


//Por cada ficha que pongo para arriba, acoto de abajo
//Por cada ficha que pongo para abajo, acoto de arriba
//Por cada ficha que pongo para derecha, acoto de izquierda
//Por cada ficha que pongo para izquierda, acoto de derecha
