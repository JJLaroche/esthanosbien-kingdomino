package tests;

import contracts.IDomino;
import contracts.IMesa;

public class MesaMock implements IMesa {
	
	private IDomino domino;
	private boolean errorDescartarFicha;
	
	
	MesaMock(IDomino domino, boolean errorDescartarFicha) {
		this.domino = domino;
		this.errorDescartarFicha = errorDescartarFicha;
	}
	
	public IDomino obtenerFicha(int posicion) {
		return this.domino;
	}
	
	public boolean descartarFicha(int posicion) {
		return this.errorDescartarFicha;
	}

}
