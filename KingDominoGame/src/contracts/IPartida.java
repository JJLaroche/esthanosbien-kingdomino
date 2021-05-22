package contracts;

import java.util.ArrayList;

import shared.Jugador;

public interface IPartida {
	public void sortearOrdenReyes();
	public boolean iniciarPartida();
	public void finalizarPartida(ArrayList <Jugador> posiciones);
	public ArrayList <Jugador>  calcularGanador();
}
