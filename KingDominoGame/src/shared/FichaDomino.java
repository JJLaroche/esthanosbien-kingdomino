package shared;

import java.util.HashMap;

import contracts.IDomino;

public class FichaDomino implements IDomino {
	private int IdDomino;
	private int Orientacion = 1;
	private String x;
	private String y;

	public FichaDomino(int ID, String x, String y) {
		this.IdDomino = ID;
		this.x = x;
		this.y = y;
	}
	
	public String getX() {
		return x;
	}

	public String getY() {
		return y;
	}

	public int DesplegarOrientacionDisponible() {
		return Orientacion;
	}

	@Override
	public String toString() {
		return "FichaDomino [IdDomino=" + IdDomino + ", x=" + x + ", y=" + y + "]";
	}
}