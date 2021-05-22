import shared.Partida;

import java.io.IOException;

import shared.Mazo;
import shared.Mesa;

public class KingDominoGame {

	public static void main(String[] args) throws IOException {
	      
			Mazo mazo = new Mazo();
	        Mesa mesa = new Mesa(mazo);
	        Partida partidaActual = new Partida(mesa);
	        partidaActual.definirCantidadJugadores();
	        partidaActual.nombrarJugadores();
	        partidaActual.iniciarPartida();
	}

}
