package shared;

import java.util.ArrayList;
import java.util.HashMap;

import contracts.IMazo;

public class Mazo implements IMazo {
	
	private HashMap<Integer, FichaDomino> mazo;
	private HashMap<Integer, String> coronas;
	
	public Mazo() {
		mazo = new HashMap<Integer, FichaDomino>();
		mazo.put(1, new FichaDomino(1, "AMARILLO", "AMARILLO", 0, 0));
		mazo.put(2, new FichaDomino(2, "AMARILLO", "AMARILLO", 0, 0));
		mazo.put(3, new FichaDomino(3, "BERDEO", "BERDEO", 0, 0));
		mazo.put(4, new FichaDomino(4, "TURQUESA", "TURQUESA", 0, 0));
		mazo.put(5, new FichaDomino(5, "VERDEC", "VERDEC", 0, 0));
		mazo.put(6, new FichaDomino(6, "MARRONC", "MARRONC", 0, 0));
		mazo.put(7, new FichaDomino(7, "AMARILLO 1xC", "BERDEO", 1, 0));
		mazo.put(8, new FichaDomino(8, "AMARILLO 1xC", "TURQUESA", 1, 0));
		mazo.put(9, new FichaDomino(9, "BERDEO 1xC", "AMARILLO", 1, 0));
		mazo.put(10, new FichaDomino(10, "BERDEO 1xC", "AMARILLO", 1, 0));
		mazo.put(11, new FichaDomino(11, "BERDEO 1xC", "TURQUESA", 1, 0));
		mazo.put(12, new FichaDomino(12, "TURQUESA 1xC", "AMARILLO", 1, 0));
		mazo.put(13, new FichaDomino(13, "TURQUESA 1xC", "AMARILLO", 1, 0));
		mazo.put(14, new FichaDomino(14, "TURQUESA 1xC", "BERDEO", 1, 0));
		mazo.put(15, new FichaDomino(15, "TURQUESA 1xC", "BERDEO", 1, 0));
		mazo.put(16, new FichaDomino(16, "AMARILLO", "VERDEC 1xC", 0, 1));
		mazo.put(17, new FichaDomino(17, "BERDEO", "VERDEC 2xC", 0, 2));
		mazo.put(18, new FichaDomino(18, "TURQUESA", "VERDEC 2xC", 0, 2));
		mazo.put(19, new FichaDomino(19, "AMARILLO", "MARRONC 2xC", 0, 2));
		mazo.put(20, new FichaDomino(20, "BERDEO", "MARRONC 2xC", 0, 2));
		mazo.put(21, new FichaDomino(21, "VERDEC", "MARRONC 2xC", 0, 2));
		mazo.put(22, new FichaDomino(22, "GRIS 2xC", "BERDEO", 2, 0));
		mazo.put(23, new FichaDomino(23, "GRIS 2xC", "VERDEC", 2, 0));
		mazo.put(24, new FichaDomino(24, "AMARILLO", "GRIS 3xC", 0, 3));
		mazo.put(25, new FichaDomino(25, "AMARILLO", "AMARILLO", 0, 0));
		mazo.put(26, new FichaDomino(26, "AMARILLO", "AMARILLO", 0, 0));
		mazo.put(27, new FichaDomino(27, "BERDEO", "BERDEO", 0, 0));
		mazo.put(28, new FichaDomino(28, "TURQUESA", "TURQUESA", 0, 0));
		mazo.put(29, new FichaDomino(29, "VERDEC", "VERDEC", 0, 0));
		mazo.put(30, new FichaDomino(30, "MARRONC", "MARRONC", 0, 0));
		mazo.put(31, new FichaDomino(31, "AMARILLO 1xC", "BERDEO",1, 0));
		mazo.put(32, new FichaDomino(32, "AMARILLO 1xC", "TURQUESA",1, 0));
		mazo.put(33, new FichaDomino(33, "BERDEO 1xC", "AMARILLO",1, 0));
		mazo.put(34, new FichaDomino(34, "BERDEO 1xC", "AMARILLO",1, 0));
		mazo.put(35, new FichaDomino(35, "BERDEO 1xC", "TURQUESA",1, 0));
		mazo.put(36, new FichaDomino(36, "TURQUESA 1xC", "AMARILLO",1, 0));
		mazo.put(37, new FichaDomino(37, "TURQUESA 1xC", "AMARILLO",1, 0));
		mazo.put(38, new FichaDomino(38, "TURQUESA 1xC", "BERDEO",1, 0));
		mazo.put(39, new FichaDomino(39, "TURQUESA 1xC", "BERDEO",1, 0));
		mazo.put(40, new FichaDomino(40, "AMARILLO", "VERDEC 1xC",0, 1));
		mazo.put(41, new FichaDomino(41, "BERDEO", "VERDEC 2xC", 0, 2));
		mazo.put(42, new FichaDomino(42, "TURQUESA", "VERDEC 2xC", 0, 2));
		mazo.put(43, new FichaDomino(43, "AMARILLO", "MARRONC 2xC", 0, 2));
		mazo.put(44, new FichaDomino(44, "BERDEO", "MARRONC 2xC", 0, 2));
		mazo.put(45, new FichaDomino(45, "VERDEC", "MARRONC 2xC", 0, 2));
		mazo.put(46, new FichaDomino(46, "GRIS 2xC", "BERDEO", 2, 0));
		mazo.put(47, new FichaDomino(47, "GRIS 2xC", "VERDEC", 2, 0));
		mazo.put(48, new FichaDomino(48, "AMARILLO", "GRIS 3xC", 0, 3));
		
		
		coronas = new HashMap<Integer, String>();
		coronas.put(1,"0/0");
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
	}

	@Override
	public ArrayList<String> barajarFichasDomino() {
		return null;
	}

}