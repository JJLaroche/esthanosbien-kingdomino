package shared;

import java.util.*;
import java.util.Map.Entry;

import contracts.*;
import shared.Jugador;
import shared.Mazo;
import shared.Mesa;

import java.util.Scanner;

import java.io.*;

public class Partida implements IPartida {

	int cantidadJugadores;
	String idPartida;
	ArrayList<IJugador> jugadoresActuales;
	HashMap<Integer, IJugador> ordenJugadores;
	HashMap<IJugador, Tablero> tablerosJugadores;
	int numeroRonda;
	private IMesa mesa;
	final int RONDA_FINAL = 2;

	public Partida(IMesa mesa) {
		this.mesa = mesa;
		this.numeroRonda = 1;
	}

	public void definirCantidadJugadores() throws IOException {

		int cantJugadores;
		Scanner teclado = new Scanner(System.in);

		System.out.print("Ingrese cuantos jugadores participaran(de 2 a 4): ");

		cantJugadores = teclado.nextInt();

		while (cantJugadores < 2 || cantJugadores > 4) {
			System.out.print("Ingrese nuevamente: ");
			cantJugadores = teclado.nextInt();
		}

		this.cantidadJugadores = cantJugadores;

	}

	public int modoDeJuego(int cantJugadores) throws IOException {
		int tipo = 5;
		if (cantJugadores == 2) {
			System.out.println("Desea jugar el modo de juego EXTENDIDO? SI(1)/NO(0)");
			if ((System.in.read()) == 1)
				tipo = 7;
		}
		return tipo;
	}

	public void nombrarJugadores() {
		jugadoresActuales = new ArrayList<IJugador>();

		String nombre = "";
		Scanner teclado = new Scanner(System.in);

		System.out.flush();

		for (int i = 0; i < this.cantidadJugadores; i++) {
			System.out.print("Ingrese nombre Jugador " + (i + 1) + ": ");
			nombre = teclado.nextLine();

			Jugador jugador = new Jugador(nombre, new Tablero(5), this.mesa);
			jugadoresActuales.add(jugador);
		}

		System.out.println(jugadoresActuales);

	}

	public void mostrarGanador(String nombre, double puntaje) {
		System.out.println(
				"El ganador de esta partida es " + nombre + "./nSu puntaje final fue de " + puntaje + "puntos.");
	}

	@Override
	public void sortearOrdenReyes() {
		if (numeroRonda == 1) {
			Collections.shuffle(this.jugadoresActuales);
			this.ordenJugadores = new HashMap<Integer, IJugador>(this.cantidadJugadores);
			for (int i = 0; i < this.jugadoresActuales.size(); i++) {
				this.ordenJugadores.put(i + 1, this.jugadoresActuales.get(i));
			}
		} else {

		}

	}

	@Override
	public boolean iniciarPartida() {

		this.sortearOrdenReyes();
		while (numeroRonda <= RONDA_FINAL) {

			System.out.println("Turno: " + numeroRonda);

			this.mesa.desplegarFichasDomino();
			
			for (Entry<Integer, IJugador> jugador : this.ordenJugadores.entrySet()) {
				this.mesa.mostrarMesa();
				int posicionCarta = -1;
				Scanner teclado = new Scanner(System.in);
				posicionCarta = teclado.nextInt();
				jugador.getValue().elegirFicha(posicionCarta);
				
				System.out.println(jugador.getValue().verCartaSeleccionada());
			}

			numeroRonda++;
		}
		return true;
	}

	@Override
	public boolean finalizarPartida() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IJugador calcularGanador() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "Partida [jugadoresActuales=" + jugadoresActuales + "]";
	}

}
