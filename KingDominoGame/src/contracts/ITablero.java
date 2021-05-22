package contracts;

import shared.FichaDomino;

public interface ITablero {
	public boolean evaluarPosicion(FichaDomino ficha,int orientacion,int x,int y);
	public void ponerDomino(int x, int y, FichaDomino ficha, int orientacion);
	public void acotarTablero(int x, int y);
	public void mostrarTablero();
}
