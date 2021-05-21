package shared;

import java.util.ArrayList;
import java.util.HashMap;

import contracts.IMazo;

public class Mazo implements IMazo {

	// private ArrayList<String> fichasDomino = new ArrayList<String>();
	private HashMap<Integer, FichaDomino> mazo;

	public Mazo() {
		mazo = new HashMap<Integer, FichaDomino>();
		mazo.put(1, new FichaDomino(1, "AMARILLO", "AMARILLO"));
		mazo.put(2, new FichaDomino(2, "AMARILLO", "AMARILLO"));
		mazo.put(3, new FichaDomino(3, "VERDEO", "VERDEO"));
		mazo.put(4, new FichaDomino(4, "AZUL", "AZUL"));
		mazo.put(5, new FichaDomino(5, "VERDEC", "VERDEC"));
		mazo.put(6, new FichaDomino(6, "MARRONC", "MARRONC"));
		mazo.put(7, new FichaDomino(7, "AMARILLO", "VERDEO"));
		mazo.put(8, new FichaDomino(8, "AMARILLO", "AZUL"));
		mazo.put(9, new FichaDomino(9, "VERDEO", "AMARILLO"));
		mazo.put(10, new FichaDomino(10, "VERDEO", "AMARILLO"));
		mazo.put(11, new FichaDomino(11, "VERDEO", "AZUL"));
		mazo.put(12, new FichaDomino(12, "AZUL", "AMARILLO"));
		mazo.put(13, new FichaDomino(13, "AZUL", "AMARILLO"));
		mazo.put(14, new FichaDomino(14, "AZUL", "VERDEO"));
		mazo.put(15, new FichaDomino(15, "AZUL", "VERDEO"));
		mazo.put(16, new FichaDomino(16, "AMARILLO", "VERDEC"));
		mazo.put(17, new FichaDomino(17, "VERDEO", "VERDEC"));
		mazo.put(18, new FichaDomino(18, "AZUL", "VERDEC"));
		mazo.put(19, new FichaDomino(19, "AMARILLO", "MARRONC"));
		mazo.put(20, new FichaDomino(20, "VERDEO", "MARRONC"));
		mazo.put(21, new FichaDomino(21, "VERDEC", "MARRONC"));
		mazo.put(22, new FichaDomino(22, "MARRON", "VERDEO"));
		mazo.put(23, new FichaDomino(23, "MARRON", "VERDEC"));
		mazo.put(24, new FichaDomino(24, "AMARILLO", "MARRON"));
	}

	public FichaDomino obtenerFichaMazo() {
		FichaDomino domino;
		int numeroRandom;
		do {
			numeroRandom = (int) (Math.random() * 24 + 1);
			domino = this.mazo.get(numeroRandom);
		} while (domino == null);
		this.mazo.remove(numeroRandom);
		return domino;
	}

	@Override
	public void mezclarMazo() {
		// TODO Auto-generated method stub
	}

	@Override
	public ArrayList<String> barajarFichasDomino() {
		return null;
	}

}