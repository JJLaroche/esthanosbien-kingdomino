import shared.Partida;

import java.io.IOException;

import Graphics.JPantallaElegirCantJugadores;
import Graphics.JPantallaEmpezarJuego;
import Graphics.JPantallaJuego2Jugadores;
import shared.Mazo;
import shared.Mesa;

import java.io.IOException;

import shared.Mazo;
import shared.Mesa;

public class KingDominoGame {

	public static void main(String[] args) throws IOException {
	      
		Mazo mazo = new Mazo();
        Mesa mesa = new Mesa(mazo);
        Partida partidaActual = new Partida(mesa);
        JPantallaEmpezarJuego pantallaInicial = new JPantallaEmpezarJuego(partidaActual);
        pantallaInicial.run();
	}

}
