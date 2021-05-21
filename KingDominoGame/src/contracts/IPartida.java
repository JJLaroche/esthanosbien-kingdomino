package contracts;

public interface IPartida {
	public void sortearOrdenReyes();
	public boolean iniciarPartida();
	public boolean finalizarPartida();
	public IJugador calcularGanador();
}
