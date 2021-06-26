package shared;

import java.util.ArrayList;

import contracts.IDomino;
import contracts.IMazo;

//import java.util.ArrayList;

import contracts.IMesa;

public class Mesa implements IMesa{

	IMazo mazo;
	ArrayList<IDomino> fichasActuales;
	
	public Mesa(IMazo mazo) {
		this.mazo = mazo;
	}
	
	@Override
	public boolean desplegarFichasDomino() {
		this.fichasActuales = new ArrayList<IDomino>();
		for (int i = 0; i < 4 ; i++) {
			this.fichasActuales.add(this.mazo.obtenerFichaMazo());
		}
		return false;
	}
	
	public ArrayList<IDomino> getFichasActuakes() {
		return this.fichasActuales;
	}
	
	public void mostrarMesa() {
		int i=1;
		for (IDomino iDomino : fichasActuales) {
			System.out.print(i+". ");
			i++;
			System.out.println(iDomino);
		}
	}

	@Override
	public boolean descartarFichasDominoInutilizadas(int posicion) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public FichaDomino obtenerFicha(int posicion) {
		return (FichaDomino) this.fichasActuales.get(posicion);
	}

}