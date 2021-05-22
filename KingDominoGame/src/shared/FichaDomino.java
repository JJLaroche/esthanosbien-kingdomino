package shared;

import contracts.IDomino;

public class FichaDomino implements IDomino {
	private int IdDomino;
	private int Orientacion = 1;
	private String terreno1;
	private String terreno2;
	private int coronast1;
	private int coronast2;

	public FichaDomino(int ID, String terreno1, String terreno2, int coronast1,int coronast2) {
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
		return terreno1;
	}

	public String getTerreno2() {
		return terreno2;
	}

	public int DesplegarOrientacionDisponible() {
		return Orientacion;
	}

	@Override
	public String toString() {

		return "|" + terreno1 + "|" + terreno2 + "|";
	}
}