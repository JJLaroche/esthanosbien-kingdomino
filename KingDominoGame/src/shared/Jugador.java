package shared;
import contracts.IDomino;
import contracts.IJugador;
import contracts.IMesa;
import contracts.ITablero;
 
public class Jugador implements IJugador {
 
    private ITablero tablero;
    private IMesa mesa;
    private int posicionFicha;
    private String colorRey;
    private String nombreJugador;

    public Jugador(String nombre, ITablero tablero, IMesa mesa) {
        this.nombreJugador = nombre;
        this.tablero = tablero;
        this.mesa = mesa;
    }
    
    @Override
    public FichaDomino verCartaSeleccionada() {
    	return this.mesa.obtenerFicha(this.posicionFicha);
    }

    @Override
    public boolean colocarFichaDomino(int x, int y) {
        IDomino domino = this.mesa.obtenerFicha(this.posicionFicha);
        return this.tablero.ponerDomino(x, y, domino);
    }

    @Override
    public void elegirFicha(int posicionFicha) {
        this.posicionFicha = posicionFicha;
    }

    @Override
    public boolean descartarFicha() {
        this.posicionFicha = -1;
        return this.mesa.descartarFichasDominoInutilizadas(this.posicionFicha);
    }

    @Override
    public void elegirColorRey(String color) {
        this.colorRey = color;
    }

    public String getColorRey() {
        return this.colorRey;
    }

    public String getNombreJugador() {
        return this.nombreJugador;
    }

	@Override
	public String toString() {
		return "Jugador [nombreJugador=" + nombreJugador + "]";
	}
    
    
}
