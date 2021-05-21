package shared;

import contracts.IDomino;
import contracts.ITablero;

public class Tablero implements ITablero{
	
	private String[][] mapa;
	private int columnas;
	
	public Tablero(int tipo)
	{
		
			columnas = tipo;
			mapa = new String[columnas][columnas];
		
		
	}
	
	public void inicializarTablero()
	{
		for(int i = 0; i<columnas; i++)
		{
			for(int j = 0; j<columnas; j++)
			{
				mapa[i][j] = "vacio";
			}
		}
	}

	public void mostrarTablero()
	{
		for(int i = 0; i<columnas; i++)
		{
			System.out.println("---------------------------------------------------------");

			for(int j = 0; j<columnas; j++)
			{
				if(mapa[i][j] != "0")
					System.out.print(" |" + mapa[i][j] + "| ");
				else
					System.out.print(" |/t| ");
			}
			System.out.println("");
		}
	}

	@Override
	public boolean ponerDomino(int x, int y, IDomino domino) {
		// TODO Auto-generated method stub
		return false;
	}
	
}