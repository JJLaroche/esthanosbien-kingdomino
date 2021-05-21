package contracts;
import java.util.ArrayList;

import shared.FichaDomino;


public interface IMazo {

	public void mezclarMazo();
	public ArrayList<String> barajarFichasDomino();
	public FichaDomino obtenerFichaMazo();
	
}