package shared;

import contracts.IDomino;

public class FichaDomino implements IDomino {
	private int IdDomino;
	private int Orientacion = 1;
	private Terreno terreno1;
	private Terreno terreno2;
	private int coronast1;
	private int coronast2;

	public FichaDomino(int ID, Terreno terreno1, Terreno terreno2, int coronast1, int coronast2) {
		
		this.IdDomino = ID;
		this.terreno1 = terreno1;
		this.terreno2 = terreno2;
		this.coronast1 = coronast1;
		this.coronast2 = coronast2;
		
	}
	
	public int getIdDomino() {
		return IdDomino;
	}

	public void setIdDomino(int idDomino) {
		IdDomino = idDomino;
	}

	public int getCoronast1() {
		return coronast1;
	}

	public int getCoronast2() {
		return coronast2;
	}

	public String getTerreno1() {
		return terreno1.getCodigoColor();
	}
	
	public String getPathTerreno1() {
		return terreno1.getPathTerreno();
	}

	public String getTerreno2() {
		return terreno2.getCodigoColor();
	}
	
	public String getPathTerreno2() {
		return terreno2.getPathTerreno();
	}

	public int DesplegarOrientacionDisponible() {
		return Orientacion;
	}

	@Override
	public String toString() {

		return "|" + terreno1.getCodigoColor() + "|" + terreno2.getCodigoColor() + "|";
	}
}