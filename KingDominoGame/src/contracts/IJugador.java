package contracts;

public interface IJugador {
	public boolean colocarFichaDomino(int x, int y);
	public void elegirFicha(int posicionFicha);
	public boolean descartarFicha();
	public void elegirColorRey(String color);
	public String getColorRey();
	public String getNombreJugador();
}
