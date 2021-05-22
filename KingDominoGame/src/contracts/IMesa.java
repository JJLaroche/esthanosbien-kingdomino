package contracts;

import shared.FichaDomino;

public interface IMesa {
	public void desplegarFichasDomino();
	public boolean descartarFichasDominoInutilizadas(int posicion);
	public FichaDomino obtenerFicha(int posicion);
	public void mostrarMesa();
}
