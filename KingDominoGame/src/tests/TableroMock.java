package tests;

import contracts.IDomino;
import contracts.IMesa;
import contracts.ITablero;

public class TableroMock implements ITablero {
	
	private boolean errorPonerDomino;
	
	TableroMock(boolean errorPonerDomino) {
		this.errorPonerDomino = errorPonerDomino;
	}
	
	public boolean ponerDomino(int x, int y, IDomino domino) {
		return this.errorPonerDomino;
	}

}
