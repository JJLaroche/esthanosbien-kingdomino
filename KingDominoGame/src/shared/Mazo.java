package shared;

import java.util.ArrayList;
import java.util.HashMap;

import contracts.IMazo;

public class Mazo implements IMazo {
	
	private HashMap<Integer, FichaDomino> mazo;
	private HashMap<Integer, String> coronas;
	
	final String CampoAmarillo_0C = "Img/Fichas/Campo/TipoTerreno_Campo_0R.jpg";
	final String CampoAmarillo_1C = "Img/Fichas/Campo/TipoTerreno_Campo_1R.jpg";
	
	final String MarTurquesa_0C = "Img/Fichas/Mar/TipoTerreno_Mar_0R.jpg";
	final String MarTurquesa_1C = "Img/Fichas/Mar/TipoTerreno_Mar_1R.jpg";
	
	final String CiudadGris_0C = "Img/Fichas/Ciudad/TipoTerreno_Ciudad_0R.jpg";
	final String CiudadGris_2C = "Img/Fichas/Ciudad/TipoTerreno_Ciudad_2R.jpg";
	final String CiudadGris_3C = "Img/Fichas/Ciudad/TipoTerreno_Ciudad_3R.jpg";
	
	final String GlaciarVerdeC_0C = "Img/Fichas/Glaciar/TipoTerreno_Glaciar_0R.jpg";
	final String GlaciarVerdeC_1C = "Img/Fichas/Glaciar/TipoTerreno_Glaciar_1R.jpg";
	final String GlaciarVerdeC_2C = "Img/Fichas/Glaciar/TipoTerreno_Glaciar_2R.jpg";
	
	final String MontanaMarronC_0C = "Img/Fichas/Montana/TipoTerreno_Montana_0R.jpg";
	final String MontanaMarronC_2C = "Img/Fichas/Montana/TipoTerreno_Montana_2R.jpg";
	
	final String CataratasBerdeo_0C = "Img/Fichas/Cataratas/TipoTerreno_Cataratas_0R.jpg";
	final String CataratasBerdeo_1C = "Img/Fichas/Cataratas/TipoTerreno_Cataratas_1R.jpg";
	
	public Mazo() {
		mazo = new HashMap<Integer, FichaDomino>();
		mazo.put(1, new FichaDomino(1, new Terreno("AMARILLO", this.CampoAmarillo_0C), new Terreno("AMARILLO", this.CampoAmarillo_0C), 0, 0));
		mazo.put(2, new FichaDomino(2, new Terreno("AMARILLO", this.CampoAmarillo_0C), new Terreno("AMARILLO", this.CampoAmarillo_0C), 0, 0));
		mazo.put(3, new FichaDomino(3, new Terreno("BERDEO", this.CataratasBerdeo_0C), new Terreno("BERDEO", this.CataratasBerdeo_0C), 0, 0));
		mazo.put(4, new FichaDomino(4, new Terreno("TURQUESA", this.MarTurquesa_0C), new Terreno("TURQUESA", this.MarTurquesa_0C), 0, 0));
		mazo.put(5, new FichaDomino(5, new Terreno("VERDEC", this.GlaciarVerdeC_0C), new Terreno("VERDEC", this.GlaciarVerdeC_0C), 0, 0));
		mazo.put(6, new FichaDomino(6, new Terreno("MARRONC", this.MontanaMarronC_0C), new Terreno("MARRONC", this.MontanaMarronC_0C), 0, 0));
		mazo.put(7, new FichaDomino(7, new Terreno("AMARILLO 1xC", this.CampoAmarillo_1C),  new Terreno("BERDEO", this.CataratasBerdeo_0C), 1, 0));
		mazo.put(8, new FichaDomino(8, new Terreno("AMARILLO 1XC", this.CampoAmarillo_1C), new Terreno("TURQUESA", this.MarTurquesa_0C), 1, 0));
		mazo.put(9, new FichaDomino(9, new Terreno("BERDEO 1XC", this.CataratasBerdeo_1C), new Terreno("AMARILLO", this.CampoAmarillo_0C), 1, 0));
		mazo.put(10, new FichaDomino(10, new Terreno("BERDEO 1XC", this.CataratasBerdeo_1C), new Terreno("AMARILLO", this.CampoAmarillo_0C), 1, 0));
		mazo.put(11, new FichaDomino(11, new Terreno("BERDEO 1XC", this.CataratasBerdeo_1C), new Terreno("TURQUESA", this.MarTurquesa_0C), 1, 0));
		mazo.put(12, new FichaDomino(12, new Terreno("TURQUESA 1XC", this.MarTurquesa_1C), new Terreno("AMARILLO", this.CampoAmarillo_0C), 1, 0));
		mazo.put(13, new FichaDomino(13, new Terreno("TURQUESA 1XC", this.MarTurquesa_1C), new Terreno("AMARILLO", this.CampoAmarillo_0C), 1, 0));
		mazo.put(14, new FichaDomino(14, new Terreno("TURQUESA 1XC", this.MarTurquesa_1C), new Terreno("BERDEO", this.CataratasBerdeo_0C), 1, 0));
		mazo.put(15, new FichaDomino(15, new Terreno("TURQUESA 1XC", this.MarTurquesa_1C), new Terreno("BERDEO", this.CataratasBerdeo_0C), 1, 0));
		mazo.put(16, new FichaDomino(16, new Terreno("AMARILLO", this.CampoAmarillo_0C), new Terreno("VERDEC 1XC", this.GlaciarVerdeC_1C), 0, 1));
		mazo.put(17, new FichaDomino(17, new Terreno("BERDEO", this.CataratasBerdeo_0C), new Terreno("VERDEC 2XC", this.GlaciarVerdeC_2C), 0, 2));
		mazo.put(18, new FichaDomino(18, new Terreno("TURQUESA", this.MarTurquesa_0C), new Terreno("VERDEC 2XC", this.GlaciarVerdeC_2C), 0, 2));
		mazo.put(19, new FichaDomino(19, new Terreno("AMARILLO", this.CampoAmarillo_0C), new Terreno("MARRONC 2XC", this.MontanaMarronC_2C), 0, 2));
		mazo.put(20, new FichaDomino(20, new Terreno("BERDEO", this.CataratasBerdeo_0C), new Terreno("MARRONC 2XC", this.MontanaMarronC_2C), 0, 2));
		mazo.put(21, new FichaDomino(21, new Terreno("VERDEC", this.GlaciarVerdeC_0C), new Terreno("MARRONC 2XC", this.MontanaMarronC_2C), 0, 2));
		mazo.put(22, new FichaDomino(22, new Terreno("GRIS 2xC", this.CiudadGris_2C), new Terreno("BERDEO", this.CataratasBerdeo_0C), 2, 0));
		mazo.put(23, new FichaDomino(23, new Terreno("GRIS 2xC", this.CiudadGris_2C), new Terreno("VERDEC", this.GlaciarVerdeC_0C), 2, 0));
		mazo.put(24, new FichaDomino(24, new Terreno("AMARILLO", this.CampoAmarillo_0C), new Terreno("GRIS 3xC", this.CiudadGris_3C), 0, 3));
		mazo.put(25, new FichaDomino(25, new Terreno("AMARILLO", this.CampoAmarillo_0C), new Terreno("AMARILLO", this.CampoAmarillo_0C), 0, 0));
		mazo.put(26, new FichaDomino(26, new Terreno("AMARILLO", this.CampoAmarillo_0C), new Terreno("AMARILLO", this.CampoAmarillo_0C), 0, 0));
		mazo.put(27, new FichaDomino(27, new Terreno("BERDEO", this.CataratasBerdeo_0C), new Terreno("BERDEO", this.CataratasBerdeo_0C), 0, 0));
		mazo.put(28, new FichaDomino(28, new Terreno("TURQUESA", this.MarTurquesa_0C), new Terreno("TURQUESA", this.MarTurquesa_0C), 0, 0));
		mazo.put(29, new FichaDomino(29, new Terreno("VERDEC", this.GlaciarVerdeC_0C), new Terreno("VERDEC", this.GlaciarVerdeC_0C), 0, 0));
		mazo.put(30, new FichaDomino(30, new Terreno("MARRONC", this.MontanaMarronC_0C), new Terreno("MARRONC", this.MontanaMarronC_0C), 0, 0));
		mazo.put(31, new FichaDomino(31, new Terreno("AMARILLO 1XC", this.CampoAmarillo_1C), new Terreno("BERDEO", this.CataratasBerdeo_0C),1, 0));
		mazo.put(32, new FichaDomino(32, new Terreno("AMARILLO 1XC", this.CampoAmarillo_1C), new Terreno("TURQUESA", this.MarTurquesa_0C),1, 0));
		mazo.put(33, new FichaDomino(33, new Terreno("BERDEO 1XC", this.CataratasBerdeo_1C), new Terreno("AMARILLO", this.CampoAmarillo_0C),1, 0));
		mazo.put(34, new FichaDomino(34, new Terreno("BERDEO 1XC", this.CataratasBerdeo_1C), new Terreno("AMARILLO", this.CampoAmarillo_0C),1, 0));
		mazo.put(35, new FichaDomino(35, new Terreno("BERDEO 1XC", this.CataratasBerdeo_1C), new Terreno("TURQUESA", this.MarTurquesa_0C),1, 0));
		mazo.put(36, new FichaDomino(36, new Terreno("TURQUESA 1XC", this.MarTurquesa_1C), new Terreno("AMARILLO", this.CampoAmarillo_0C),1, 0));
		mazo.put(37, new FichaDomino(37, new Terreno("TURQUESA 1XC", this.MarTurquesa_1C), new Terreno("AMARILLO", this.CampoAmarillo_0C),1, 0));
		mazo.put(38, new FichaDomino(38, new Terreno("TURQUESA 1XC", this.MarTurquesa_1C), new Terreno("BERDEO", this.CataratasBerdeo_0C),1, 0));
		mazo.put(39, new FichaDomino(39, new Terreno("TURQUESA 1XC", this.MarTurquesa_1C), new Terreno("BERDEO", this.CataratasBerdeo_0C),1, 0));
		mazo.put(40, new FichaDomino(40, new Terreno("AMARILLO", this.CampoAmarillo_0C), new Terreno("VERDEC 1XC", this.GlaciarVerdeC_1C),0, 1));
		mazo.put(41, new FichaDomino(41, new Terreno("BERDEO", this.CataratasBerdeo_0C), new Terreno("VERDEC 2XC", this.GlaciarVerdeC_2C), 0, 2));
		mazo.put(42, new FichaDomino(42, new Terreno("TURQUESA", this.MarTurquesa_0C), new Terreno("VERDEC 2XC", this.GlaciarVerdeC_2C), 0, 2));
		mazo.put(43, new FichaDomino(43, new Terreno("AMARILLO", this.CampoAmarillo_0C), new Terreno("MARRONC 2XC", this.MontanaMarronC_2C), 0, 2));
		mazo.put(44, new FichaDomino(44, new Terreno("BERDEO", this.CataratasBerdeo_0C), new Terreno("MARRONC 2XC", this.MontanaMarronC_2C), 0, 2));
		mazo.put(45, new FichaDomino(45, new Terreno("VERDEC", this.GlaciarVerdeC_0C), new Terreno("MARRONC 2XC", this.MontanaMarronC_2C), 0, 2));
		mazo.put(46, new FichaDomino(46, new Terreno("GRIS 2xC", this.CiudadGris_2C), new Terreno("BERDEO", this.CataratasBerdeo_0C), 2, 0));
		mazo.put(47, new FichaDomino(47, new Terreno("GRIS 2xC", this.CiudadGris_2C), new Terreno("VERDEC", this.GlaciarVerdeC_0C), 2, 0));
		mazo.put(48, new FichaDomino(48, new Terreno("AMARILLO", this.CampoAmarillo_0C), new Terreno("GRIS 3xC", this.CiudadGris_3C), 0, 3));
		
		
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