package contracts;

import shared.FichaDomino;

public interface IJugador {
	   public boolean colocarFichaDomino(int x, int y, int orientacion);
	    public void elegirFicha(int posicionFicha);
	    public boolean descartarFicha();
	    public void elegirColorRey(String color);
	    public String getColorRey();
	    public String getNombreJugador();
	    public FichaDomino verCartaSeleccionada();
	    public void mostrarTableroActivo();
}
