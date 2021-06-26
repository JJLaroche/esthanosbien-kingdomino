package contracts;

import java.util.ArrayList;

import Graphics.JPantallaJuego2Jugadores;
import shared.Jugador;
import shared.Partida;

public interface IPartida {
	public void sortearOrdenReyes();
	public boolean iniciarPartida();
	public void finalizarPartida(ArrayList <Jugador> posiciones);
	public ArrayList <Jugador>  calcularGanador();
}
