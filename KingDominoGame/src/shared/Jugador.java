package shared;

import contracts.IJugador;
 
public class Jugador implements IJugador {
 
    private Tablero tablero;
    private Mesa mesa;
    private int posicionFicha;
    private String colorRey;
    private String nombreJugador;
    private Puntuacion puntos;

    public Jugador(String nombre, Tablero tablero, Mesa mesa) {
        this.nombreJugador = nombre;
        this.tablero = tablero;
        this.mesa = mesa;
        this.puntos = new Puntuacion();
    }
    
    public Puntuacion getPuntos() {
    	return this.puntos;
    }
    public void mostrarTableroActivo() {
    	this.tablero.mostrarTablero();
    }
    
    @Override
    public FichaDomino verCartaSeleccionada() {
    	return this.mesa.obtenerFicha(this.posicionFicha);
    }

    @Override
    public boolean colocarFichaDomino(int x, int y, int orientacion) {
        FichaDomino domino = this.mesa.obtenerFicha(this.posicionFicha);
        return this.tablero.evaluarPosicion(domino, orientacion, x, y);
    }

    @Override
    public void elegirFicha(int posicionFicha) {
        this.posicionFicha = posicionFicha-1;
    }

    public Tablero getTablero() {
		return tablero;
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
