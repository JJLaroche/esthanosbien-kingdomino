package shared;

import java.util.*;
import java.util.Map.Entry;

import Graphics.JPantallaGanador;
import Graphics.JPantallaJuego2Jugadores;
import contracts.*;

import java.io.*;

public class Partida implements IPartida {

	public int cantidadJugadores;
	String idPartida;
	public ArrayList<Jugador> jugadoresActuales;
	public HashMap<Integer, Jugador> ordenJugadores;
	public HashMap<Jugador, Tablero> tablerosJugadores;
	public int numeroRonda;
	Mesa mesa;
	public final int RONDA_FINAL = 5;

	public Partida(Mesa mesa) {
		this.mesa = mesa;
		this.numeroRonda = 1;
	}
	
	public Mesa getMesa() {
		return this.mesa;
	}

	public void definirCantidadJugadores(int cantJugadores){
		
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

	public void nombrarJugadores(ArrayList<String> nombresJugadores) {
		jugadoresActuales = new ArrayList<Jugador>();

		String nombre = "";
		for (int i = 0; i < this.cantidadJugadores; i++) {
			nombre = nombresJugadores.get(i);
			Jugador jugador = new Jugador(nombre, new Tablero(1), this.mesa);
			jugadoresActuales.add(jugador);
		}
		
		
		JPantallaJuego2Jugadores pantallaJuego = new JPantallaJuego2Jugadores(this);
		pantallaJuego.run();
		
		//iniciarPartida();
		
	}

	public void mostrarGanador(String nombre, double puntaje) {
		System.out.println(
				"El ganador de esta partida es " + nombre + "./nSu puntaje final fue de " + puntaje + "puntos.");
	}

	@Override
	public void sortearOrdenReyes() {
			Collections.shuffle(this.jugadoresActuales);
			this.ordenJugadores = new HashMap<Integer, Jugador>(this.cantidadJugadores);
			for (int i = 0; i < this.jugadoresActuales.size(); i++) {
				this.ordenJugadores.put(i + 1, this.jugadoresActuales.get(i));
		} 
	}
	
	public void seleccionarOrdenJugadores (int[] Disponibyorden)
	{
		Integer a = 1; 
		for (int i : Disponibyorden) {
			if(i!=0)
				this.ordenJugadores.put(a++, this.jugadoresActuales.get(i-1));
		}
	}
	
	@Override
	public boolean iniciarPartida() {
		
		
		int posicionC;
		int posicionF;
		int orientacion;
		
		this.sortearOrdenReyes();
		while (numeroRonda <= RONDA_FINAL) {

			System.out.println("Ronda: " + numeroRonda);

			this.mesa.desplegarFichasDomino();
			int [] Disponibyorden = {0,0,0,0};
			for (Entry<Integer, Jugador> jugador : this.ordenJugadores.entrySet()) {
				System.out.println("\n" + jugador.getValue().getNombreJugador() + " seleccione una ficha: ");
				this.mesa.mostrarMesa();
				System.out.print("->");
				int posicionCarta = -1;
				Scanner teclado = new Scanner(System.in);
				do {
				posicionCarta = teclado.nextInt();
				if(Disponibyorden[posicionCarta-1]!=0)//vector
					System.out.println("Carta ya elegida por otro jugador. Elija otra.");
				if(posicionCarta>4||posicionCarta<1)
					System.out.println("Carta invalida.\nJugador " + jugador.getKey() + " seleccione una ficha nuevamente.");
				}while((posicionCarta>4||posicionCarta<1)||(Disponibyorden[posicionCarta-1]!=0));
				jugador.getValue().elegirFicha(posicionCarta);
				Disponibyorden[posicionCarta-1]=jugador.getKey();
				System.out.println();
				System.out.print("La carta seleccionada fue: ");
				System.out.print(jugador.getValue().verCartaSeleccionada());
				System.out.println();
				
				jugador.getValue().mostrarTableroActivo();
				do {
				System.out.print("Ingrese Fila: ");
				posicionF = teclado.nextInt();
				System.out.print("Ingrese Columna: ");
				posicionC = teclado.nextInt();
				System.out.print("Ingrese orientacion: \n1-Horizontal \n2-Horizontal Invertida \n3-Vertical \n4-Vertical Invertida\n-> ");
				orientacion = teclado.nextInt();
				}while((posicionF<0 || posicionF>8) || (posicionC<0 || posicionC>8) || ! (jugador.getValue().colocarFichaDomino(posicionF, posicionC, orientacion)));
			}
			numeroRonda++;
			seleccionarOrdenJugadores(Disponibyorden);
		}
		for (Jugador jugador : jugadoresActuales) {
			jugador.mostrarTableroActivo();
		}
		finalizarPartida(calcularGanador());
		
		
		return true;
	}

	@Override
	public void finalizarPartida(ArrayList <Jugador> posiciones) {
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		JPantallaGanador pantallaGanador = new JPantallaGanador(posiciones);
		pantallaGanador.run();
		
	}

	@Override
	public ArrayList <Jugador> calcularGanador() {
		ArrayList <Jugador> posiciones = new ArrayList <Jugador>();
		for (Jugador jugador : jugadoresActuales) {
			posiciones.add(jugador);
		}
		posiciones.sort(new Comparator_Puntaje());
		return posiciones;
	}
	
	@Override
	public String toString() {
		return "Partida [jugadoresActuales=" + jugadoresActuales + "]";
	}
}
