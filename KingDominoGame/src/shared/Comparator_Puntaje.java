package shared;

import java.util.Comparator;

public class Comparator_Puntaje implements Comparator<Jugador> {

	@Override
	public int compare(Jugador o2, Jugador o1) {
		int resultado = 0;
		int puntos1=o1.getPuntos().obtenerPuntuacion(o1.getTablero());
		int puntos2=o2.getPuntos().obtenerPuntuacion(o2.getTablero());
		if(puntos1 != puntos2) {
			resultado = puntos1 - puntos2; 
		}else if(o1.getPuntos().getTerrenoMasExtenso() != o2.getPuntos().getTerrenoMasExtenso()) {
			resultado = o1.getPuntos().getTerrenoMasExtenso() - o2.getPuntos().getTerrenoMasExtenso();
		}else {
			resultado = o1.getPuntos().getCantidadCoronasTotales() - o2.getPuntos().getCantidadCoronasTotales();
		}
		return resultado;
	}
}
