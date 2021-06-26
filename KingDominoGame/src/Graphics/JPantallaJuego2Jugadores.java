package Graphics;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

import shared.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import contracts.IDomino;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseEvent;

public class JPantallaJuego2Jugadores extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Partida partida;
	private ArrayList<IDomino> fichasActuales;
	private JTextField tfNumeroRonda;
	private int orientacionFichaSeleccionada;
	private FichaDomino fichaSeleccionada;
	private int fila;
	private int columna;
	private int indiceFichaSeleccionada;
	private int indiceFichaSelecJug1;
	private int indiceFichaSelecJug2;
	private int turnos = 0;
	JTable tableroJugador1;
	JTable tableroJugador2;
	private int indiceJugador = 0;

	JLabel unionfichas1;
	JLabel lbFicha1Izq;
	JLabel lbFicha1Der;
	JLabel fondoNegro1;

	JLabel unionfichas2;
	JLabel lbFicha2Izq;
	JLabel lbFicha2Der;
	JLabel fondoNegro2;

	JLabel unionfichas3;
	JLabel lbFicha3Izq;
	JLabel lbFicha3Der;
	JLabel fondoNegro3;

	JLabel unionfichas4;
	JLabel lbFicha4Izq;
	JLabel lbFicha4Der;
	JLabel fondoNegro4;

	private JTextField tfPuntajeJugador1;
	private JTextField tfPuntajeJugador2;

	JLabel lbFichaSeleccionadaIzq;
	JLabel lbFichaSeleccionadaDer;
	JLabel unionfichasFichaSelec;
	private JLabel lbFichaSeleccionada2;
	private JLabel lblNewLabel;
	private JTextField tfTurnoJugador;

	public JPantallaJuego2Jugadores(Partida partida) {

		this.partida = partida;
		this.partida.getMesa().desplegarFichasDomino();
		this.fichasActuales = this.partida.getMesa().getFichasActuakes();

		this.partida.sortearOrdenReyes();

		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("KingDomino ARG - EsThanosBien");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 960, 620);
		getContentPane().setLayout(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		/// LOGICA DE TABLA

		ImageIcon imagenFondo = new ImageIcon("Img/madera.jpg");
		Image imagenFondo_1 = imagenFondo.getImage();
		Image imagenFondo_2 = imagenFondo_1.getScaledInstance(23, 23, Image.SCALE_DEFAULT);
		imagenFondo = new ImageIcon(imagenFondo_2);

		ImageIcon imagenCastillo = new ImageIcon("Img/bandera.png");
		Image imagenFondo_3 = imagenCastillo.getImage();
		Image imagenFondo_4 = imagenFondo_3.getScaledInstance(23, 23, Image.SCALE_DEFAULT);
		imagenCastillo = new ImageIcon(imagenFondo_4);

		String[] columnNames = new String[] { "New column", "New column", "New column", "New column", "New column",
				"New column", "New column", "New column", "New column" };

		Object[][] data = {
				{ imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo,
						imagenFondo, imagenFondo },
				{ imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo,
						imagenFondo, imagenFondo },
				{ imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo,
						imagenFondo, imagenFondo },
				{ imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo,
						imagenFondo, imagenFondo },
				{ imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenCastillo, imagenFondo, imagenFondo,
						imagenFondo, imagenFondo },
				{ imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo,
						imagenFondo, imagenFondo },
				{ imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo,
						imagenFondo, imagenFondo },
				{ imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo,
						imagenFondo, imagenFondo },
				{ imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo,
						imagenFondo, imagenFondo }, };

		Object[][] data2 = {
				{ imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo,
						imagenFondo, imagenFondo },
				{ imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo,
						imagenFondo, imagenFondo },
				{ imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo,
						imagenFondo, imagenFondo },
				{ imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo,
						imagenFondo, imagenFondo },
				{ imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenCastillo, imagenFondo, imagenFondo,
						imagenFondo, imagenFondo },
				{ imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo,
						imagenFondo, imagenFondo },
				{ imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo,
						imagenFondo, imagenFondo },
				{ imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo,
						imagenFondo, imagenFondo },
				{ imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo, imagenFondo,
						imagenFondo, imagenFondo }, };

		DefaultTableModel modeloInicio = new DefaultTableModel(data, columnNames) {

			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};

		DefaultTableModel modeloInicio2 = new DefaultTableModel(data2, columnNames) {

			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};

		tableroJugador1 = new JTable(modeloInicio);
		tableroJugador1.setPreferredScrollableViewportSize(tableroJugador1.getPreferredSize());
		tableroJugador1.setRowHeight(22);
		tableroJugador1.setFillsViewportHeight(true);
		tableroJugador1.setBounds(74, 213, 235, 196);
		getContentPane().add(tableroJugador1);

		tableroJugador2 = new JTable(modeloInicio2);
		tableroJugador2.setPreferredScrollableViewportSize(tableroJugador2.getPreferredSize());
		tableroJugador2.setRowHeight(22);
		tableroJugador2.setFillsViewportHeight(true);
		tableroJugador2.setBounds(421, 213, 235, 196);
		getContentPane().add(tableroJugador2);

		setearFichasActuales(this.fichasActuales);

		unionfichasFichaSelec = new JLabel(
				new ImageIcon("Img/unionFichas.png"));
		unionfichasFichaSelec.setBounds(377, 527, 100, 50);
		getContentPane().add(unionfichasFichaSelec);
		unionfichasFichaSelec.setVisible(false);

		lbFichaSeleccionadaIzq = new JLabel();
		lbFichaSeleccionadaIzq.setBounds(377, 527, 50, 50);
		getContentPane().add(lbFichaSeleccionadaIzq);

		lbFichaSeleccionadaDer = new JLabel();
		lbFichaSeleccionadaDer.setBounds(427, 527, 50, 50);
		getContentPane().add(lbFichaSeleccionadaDer);

		JComboBox<Object> cbElegirOrientacion = new JComboBox<Object>();
		cbElegirOrientacion.setForeground(new Color(0, 128, 128));
		cbElegirOrientacion.setBackground(new Color(255, 255, 255));
		cbElegirOrientacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbElegirOrientacion.setMaximumRowCount(4);
		cbElegirOrientacion.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "HORIZONTAL", "HORIZONTAL INVERTIDA", "VERTICAL", "VERTICAL INVERTIDA" }));
		cbElegirOrientacion.setBounds(735, 536, 209, 22);
		getContentPane().add(cbElegirOrientacion);

		JButton btColocarFicha = new JButton("COLOCAR FICHA");
		btColocarFicha.setBackground(new Color(0, 128, 128));
		btColocarFicha.setForeground(new Color(0, 0, 0));
		btColocarFicha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btColocarFicha.setBounds(566, 517, 145, 60);
		getContentPane().add(btColocarFicha);

		JLabel lbFichaSeleccionada = new JLabel("FICHA");
		lbFichaSeleccionada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbFichaSeleccionada.setBackground(Color.WHITE);
		lbFichaSeleccionada.setForeground(Color.BLACK);
		lbFichaSeleccionada.setBounds(265, 532, 84, 22);
		getContentPane().add(lbFichaSeleccionada);
		lbFichaSeleccionada2 = new JLabel("SELECCIONADA");
		lbFichaSeleccionada2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbFichaSeleccionada2.setBackground(Color.WHITE);
		lbFichaSeleccionada2.setForeground(Color.BLACK);
		lbFichaSeleccionada2.setBounds(265, 553, 103, 14);
		getContentPane().add(lbFichaSeleccionada2);

		JLabel lbNombreJugador1 = new JLabel(this.partida.jugadoresActuales.get(0).getNombreJugador());
		lbNombreJugador1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNombreJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		lbNombreJugador1.setBounds(74, 188, 235, 14);
		getContentPane().add(lbNombreJugador1);

		JLabel lbNombreJugador2 = new JLabel(this.partida.jugadoresActuales.get(1).getNombreJugador());
		lbNombreJugador2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNombreJugador2.setBounds(421, 188, 235, 14);
		lbNombreJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lbNombreJugador2);

		tfPuntajeJugador1 = new JTextField();
		tfPuntajeJugador1.setEditable(false);
		tfPuntajeJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		tfPuntajeJugador1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPuntajeJugador1.setBounds(147, 442, 86, 20);
		getContentPane().add(tfPuntajeJugador1);
		tfPuntajeJugador1.setColumns(10);

		tfPuntajeJugador2 = new JTextField();
		tfPuntajeJugador2.setEditable(false);
		tfPuntajeJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		tfPuntajeJugador2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPuntajeJugador2.setBounds(502, 442, 86, 20);
		getContentPane().add(tfPuntajeJugador2);
		tfPuntajeJugador2.setColumns(10);

		tfNumeroRonda = new JTextField();
		tfNumeroRonda.setEditable(false);
		tfNumeroRonda.setFont(new Font("Arial Black", Font.BOLD, 40));
		tfNumeroRonda.setBounds(681, 41, 38, 60);
		getContentPane().add(tfNumeroRonda);
		tfNumeroRonda.setColumns(10);

		tfNumeroRonda.setText(Integer.toString(this.partida.numeroRonda));

		lblNewLabel = new JLabel("TURNO DE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(265, 484, 103, 36);
		getContentPane().add(lblNewLabel);

		tfTurnoJugador = new JTextField();
		tfTurnoJugador.setHorizontalAlignment(SwingConstants.CENTER);
		tfTurnoJugador.setEditable(false);
		tfTurnoJugador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfTurnoJugador.setBounds(361, 485, 116, 36);
		getContentPane().add(tfTurnoJugador);
		tfTurnoJugador.setColumns(10);

		tfTurnoJugador.setText(partida.jugadoresActuales.get(indiceJugador).getNombreJugador());



		btColocarFicha.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				orientacionFichaSeleccionada = determinarNumeroOrientacion(
						(String) cbElegirOrientacion.getSelectedItem());

				switch (indiceJugador) {
				case 0:
					fila = tableroJugador1.getSelectedRow();
					columna = tableroJugador1.getSelectedColumn();
					break;
				case 1:

					fila = tableroJugador2.getSelectedRow();
					columna = tableroJugador2.getSelectedColumn();
					break;
				}

				if (fila < 0) {
					JOptionPane.showMessageDialog(null, "Debe insertar una celda en la matriz");
					return;
				}

				partida.jugadoresActuales.get(indiceJugador).elegirFicha(indiceFichaSeleccionada);
				if (!partida.jugadoresActuales.get(indiceJugador).colocarFichaDomino(fila, columna,
						orientacionFichaSeleccionada)) {
					JOptionPane.showMessageDialog(null, "No se puede insertar la ficha en esa posicion");
					return;
				} else {
					unionfichasFichaSelec.setVisible(false);
					ImageIcon imagenTerreno1 = new ImageIcon(fichaSeleccionada.getPathTerreno1());
					Image imagenTerreno1_1 = imagenTerreno1.getImage();
					Image imagenTerreno1_2 = imagenTerreno1_1.getScaledInstance(23, 23, Image.SCALE_DEFAULT);
					imagenTerreno1 = new ImageIcon(imagenTerreno1_2);

					ImageIcon imagenTerreno2 = new ImageIcon(fichaSeleccionada.getPathTerreno2());
					Image imagenTerreno2_1 = imagenTerreno2.getImage();
					Image imagenTerreno2_2 = imagenTerreno2_1.getScaledInstance(23, 23, Image.SCALE_DEFAULT);
					imagenTerreno2 = new ImageIcon(imagenTerreno2_2);

					switch (indiceJugador) {
					case 0:
						/// FUNCIONA SOLO EN CASO DE QUE SE PONGA EN HORIZONTAL
						switch (orientacionFichaSeleccionada) {
						case 1:// |1|2|
							tableroJugador1.setValueAt(imagenTerreno1, fila, columna);
							tableroJugador1.setValueAt(imagenTerreno2, fila, columna + 1);
							acotarTablero1(fila, columna);
							acotarTablero1(fila, columna + 1);
							break;
						case 2:// |2|1|
							tableroJugador1.setValueAt(imagenTerreno1, fila, columna);
							tableroJugador1.setValueAt(imagenTerreno2, fila, columna - 1);
							acotarTablero1(fila, columna);
							acotarTablero1(fila, columna - 1);

							break;
						// |1|
						case 3:// |2|
							tableroJugador1.setValueAt(imagenTerreno1, fila, columna);
							tableroJugador1.setValueAt(imagenTerreno2, fila + 1, columna);
							acotarTablero1(fila, columna);
							acotarTablero1(fila + 1, columna);

							break;
						// |2|
						case 4:// |1|
							tableroJugador1.setValueAt(imagenTerreno1, fila, columna);
							tableroJugador1.setValueAt(imagenTerreno2, fila - 1, columna);
							acotarTablero1(fila, columna);
							acotarTablero1(fila - 1, columna);
							break;

						}

						break;
					case 1:
						switch (orientacionFichaSeleccionada) {
						case 1:
							tableroJugador2.setValueAt(imagenTerreno1, fila, columna);
							tableroJugador2.setValueAt(imagenTerreno2, fila, columna + 1);
							acotarTablero2(fila, columna);
							acotarTablero2(fila, columna + 1);
							break;

						case 2:
							tableroJugador2.setValueAt(imagenTerreno1, fila, columna);
							tableroJugador2.setValueAt(imagenTerreno2, fila, columna - 1);
							acotarTablero2(fila, columna);
							acotarTablero2(fila, columna - 1);
							break;

						case 3:
							tableroJugador2.setValueAt(imagenTerreno1, fila, columna);
							tableroJugador2.setValueAt(imagenTerreno2, fila + 1, columna);
							acotarTablero2(fila, columna);
							acotarTablero2(fila + 1, columna);
							break;

						case 4:
							tableroJugador2.setValueAt(imagenTerreno1, fila, columna);
							tableroJugador2.setValueAt(imagenTerreno2, fila - 1, columna);
							acotarTablero2(fila, columna);
							acotarTablero2(fila - 1, columna);
							break;
						}
						break;
					}

				}

				switch (indiceJugador) {
				case 0:
					tableroJugador1.clearSelection();
					indiceFichaSelecJug1 = indiceFichaSeleccionada;
					tfPuntajeJugador1
							.setText(partida.jugadoresActuales.get(indiceJugador).getPuntos().obtenerPuntajeParcial(
									partida.jugadoresActuales.get(indiceJugador).getTablero()) + " PUNTOS");
					break;
				case 1:
					tableroJugador2.clearSelection();
					indiceFichaSelecJug2 = indiceFichaSeleccionada;
					tfPuntajeJugador2
							.setText(partida.jugadoresActuales.get(indiceJugador).getPuntos().obtenerPuntajeParcial(
									partida.jugadoresActuales.get(indiceJugador).getTablero()) + " PUNTOS");
					break;
				}

				if (indiceJugador == 1)
					indiceJugador--;
				else if (indiceJugador == 0)
					indiceJugador++;
				turnos++;
				tableroJugador1.repaint();
				tableroJugador2.repaint();

				switch (indiceFichaSeleccionada) {
				case 1:
					unionfichas1.disable();
					fondoNegro1.setVisible(false);
					unionfichas1.setVisible(false);
					lbFicha1Der.setVisible(false);
					lbFicha1Izq.setVisible(false);
					break;
				case 2:
					unionfichas2.disable();
					fondoNegro2.setVisible(false);
					unionfichas2.setVisible(false);
					lbFicha2Der.setVisible(false);
					lbFicha2Izq.setVisible(false);
					break;
				case 3:
					unionfichas3.disable();
					fondoNegro3.setVisible(false);
					unionfichas3.setVisible(false);
					lbFicha3Der.setVisible(false);
					lbFicha3Izq.setVisible(false);
					break;
				case 4:
					unionfichas4.disable();
					fondoNegro4.setVisible(false);
					unionfichas4.setVisible(false);
					lbFicha4Der.setVisible(false);
					lbFicha4Izq.setVisible(false);
					break;
				}

				lbFichaSeleccionadaIzq.setIcon(null);
				lbFichaSeleccionadaDer.setIcon(null);

				indiceFichaSeleccionada = -1;

				if (turnos == partida.cantidadJugadores) {

					partida.numeroRonda++;
					if (partida.numeroRonda <= partida.RONDA_FINAL) {
						partida.getMesa().desplegarFichasDomino();
						fichasActuales = partida.getMesa().getFichasActuakes();
						actualizarFichasActuales(fichasActuales);
						if (indiceFichaSelecJug2 < indiceFichaSelecJug1) {
							indiceJugador = 1;
						} else {
							indiceJugador = 0;
						}

						tfNumeroRonda.setText(Integer.toString(partida.numeroRonda));
						turnos = 0;
					}
				}

				tfTurnoJugador.setText(partida.jugadoresActuales.get(indiceJugador).getNombreJugador());

				if (partida.numeroRonda > partida.RONDA_FINAL) {

					tableroJugador1.repaint();
					tableroJugador2.repaint();

					tfTurnoJugador.setText(" ");
					partida.finalizarPartida(partida.calcularGanador());
				}

			}
		});

		JLabel backgroundVentana1 = new JLabel(new ImageIcon("Img/Ventana4.jpg"));
		backgroundVentana1.setForeground(Color.BLACK);
		backgroundVentana1.setText("");
		backgroundVentana1.setBounds(0, 0, 960, 591);
		getContentPane().add(backgroundVentana1);

	}

	public void run() {
		try {
			ImageIcon imgIcon = new ImageIcon("Img/icono2.png");
			this.setIconImage(imgIcon.getImage());
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	int determinarNumeroOrientacion(String cadena) {

		int resultado = 0;

		switch (cadena) {

		case "HORIZONTAL":
			resultado = 1;
			break;
		case "HORIZONTAL INVERTIDA":
			resultado = 2;
			break;
		case "VERTICAL":
			resultado = 3;
			break;
		case "VERTICAL INVERTIDA":
			resultado = 4;
			break;
		}

		return resultado;

	}

	public void setearFichasActuales(ArrayList<IDomino> fichasActuales) {

		FichaDomino domino1 = (FichaDomino) this.fichasActuales.get(0);
		unionfichas1 = new JLabel(new ImageIcon("Img/unionFichas.png"));
		unionfichas1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				fichaSeleccionada = domino1;
				indiceFichaSeleccionada = 1;

				lbFichaSeleccionadaIzq.setIcon(new ImageIcon(new ImageIcon(fichaSeleccionada.getPathTerreno1())
						.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
				lbFichaSeleccionadaDer.setIcon(new ImageIcon(new ImageIcon(fichaSeleccionada.getPathTerreno2())
						.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
				unionfichasFichaSelec.setVisible(true);
			}
		});
		unionfichas1.setBounds(786, 250, 122, 60);
		getContentPane().add(unionfichas1);

		lbFicha1Izq = new JLabel(new ImageIcon(
				new ImageIcon(domino1.getPathTerreno1()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));
		lbFicha1Izq.setBounds(786, 250, 60, 60);
		getContentPane().add(lbFicha1Izq);

		lbFicha1Der = new JLabel(new ImageIcon(
				new ImageIcon(domino1.getPathTerreno2()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));
		lbFicha1Der.setBounds(847, 250, 60, 60);
		getContentPane().add(lbFicha1Der);

		fondoNegro1 = new JLabel();
		fondoNegro1.setIcon(new ImageIcon("Img/negro.jpg"));
		fondoNegro1.setBounds(784, 248, 126, 64);
		getContentPane().add(fondoNegro1);

		/// FICHA 2
		FichaDomino domino2 = (FichaDomino) this.fichasActuales.get(1);
		unionfichas2 = new JLabel(new ImageIcon("Img/unionFichas.png"));
		unionfichas2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				fichaSeleccionada = domino2;
				indiceFichaSeleccionada = 2;
				lbFichaSeleccionadaIzq.setIcon(new ImageIcon(new ImageIcon(fichaSeleccionada.getPathTerreno1())
						.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
				lbFichaSeleccionadaDer.setIcon(new ImageIcon(new ImageIcon(fichaSeleccionada.getPathTerreno2())
						.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
				unionfichasFichaSelec.setVisible(true);
			}
		});
		unionfichas2.setBounds(786, 320, 122, 60);
		getContentPane().add(unionfichas2);

		lbFicha2Izq = new JLabel(new ImageIcon(
				new ImageIcon(domino2.getPathTerreno1()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));
		lbFicha2Izq.setBounds(786, 320, 60, 60);
		getContentPane().add(lbFicha2Izq);

		lbFicha2Der = new JLabel(new ImageIcon(
				new ImageIcon(domino2.getPathTerreno2()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));
		lbFicha2Der.setBounds(847, 320, 60, 60);
		getContentPane().add(lbFicha2Der);

		fondoNegro2 = new JLabel();
		fondoNegro2.setIcon(new ImageIcon("Img/negro.jpg"));
		fondoNegro2.setBounds(784, 318, 126, 64);
		getContentPane().add(fondoNegro2);

		// FICHA 3
		FichaDomino domino3 = (FichaDomino) this.fichasActuales.get(2);
		unionfichas3 = new JLabel(new ImageIcon("Img/unionFichas.png"));
		unionfichas3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				fichaSeleccionada = domino3;
				indiceFichaSeleccionada = 3;
				lbFichaSeleccionadaIzq.setIcon(new ImageIcon(new ImageIcon(fichaSeleccionada.getPathTerreno1())
						.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
				lbFichaSeleccionadaDer.setIcon(new ImageIcon(new ImageIcon(fichaSeleccionada.getPathTerreno2())
						.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
				unionfichasFichaSelec.setVisible(true);
			}
		});
		unionfichas3.setBounds(786, 390, 122, 60);
		getContentPane().add(unionfichas3);

		lbFicha3Izq = new JLabel(new ImageIcon(
				new ImageIcon(domino3.getPathTerreno1()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));
		lbFicha3Izq.setBounds(786, 390, 60, 60);
		getContentPane().add(lbFicha3Izq);

		lbFicha3Der = new JLabel(new ImageIcon(
				new ImageIcon(domino3.getPathTerreno2()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));
		lbFicha3Der.setBounds(847, 390, 60, 60);
		getContentPane().add(lbFicha3Der);

		fondoNegro3 = new JLabel();
		fondoNegro3.setIcon(new ImageIcon("Img/negro.jpg"));
		fondoNegro3.setBounds(784, 388, 126, 64);
		getContentPane().add(fondoNegro3);

		/// FICHA 4
		FichaDomino domino4 = (FichaDomino) this.fichasActuales.get(3);
		unionfichas4 = new JLabel(new ImageIcon("Img/unionFichas.png"));
		unionfichas4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fichaSeleccionada = domino4;
				indiceFichaSeleccionada = 4;
				lbFichaSeleccionadaIzq.setIcon(new ImageIcon(new ImageIcon(fichaSeleccionada.getPathTerreno1())
						.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
				lbFichaSeleccionadaDer.setIcon(new ImageIcon(new ImageIcon(fichaSeleccionada.getPathTerreno2())
						.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
				unionfichasFichaSelec.setVisible(true);
			}
		});

		unionfichas4.setBounds(786, 460, 122, 60);
		getContentPane().add(unionfichas4);
		lbFicha4Izq = new JLabel(new ImageIcon(
				new ImageIcon(domino4.getPathTerreno1()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));
		lbFicha4Izq.setBounds(786, 460, 60, 60);
		getContentPane().add(lbFicha4Izq);

		lbFicha4Der = new JLabel(new ImageIcon(
				new ImageIcon(domino4.getPathTerreno2()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));
		lbFicha4Der.setBounds(847, 460, 60, 60);
		getContentPane().add(lbFicha4Der);

		fondoNegro4 = new JLabel();
		fondoNegro4.setIcon(new ImageIcon("Img/negro.jpg"));
		fondoNegro4.setBounds(784, 458, 126, 64);
		getContentPane().add(fondoNegro4);

	}

	public void actualizarFichasActuales(ArrayList<IDomino> fichasActuales) {

		unionfichas1.setVisible(true);
		lbFicha1Izq.setVisible(true);
		lbFicha1Der.setVisible(true);
		fondoNegro1.setVisible(true);

		unionfichas2.setVisible(true);
		lbFicha2Der.setVisible(true);
		lbFicha2Izq.setVisible(true);
		fondoNegro2.setVisible(true);

		unionfichas3.setVisible(true);
		lbFicha3Der.setVisible(true);
		lbFicha3Izq.setVisible(true);
		fondoNegro3.setVisible(true);

		unionfichas4.setVisible(true);
		lbFicha4Der.setVisible(true);
		lbFicha4Izq.setVisible(true);
		fondoNegro4.setVisible(true);

		// FICHA 1
		FichaDomino domino1_ = (FichaDomino) this.fichasActuales.get(0);

		unionfichas1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fichaSeleccionada = domino1_;
				indiceFichaSeleccionada = 1;
				lbFichaSeleccionadaIzq.setIcon(new ImageIcon(new ImageIcon(fichaSeleccionada.getPathTerreno1())
						.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
				lbFichaSeleccionadaDer.setIcon(new ImageIcon(new ImageIcon(fichaSeleccionada.getPathTerreno2())
						.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});

		lbFicha1Izq.setIcon(new ImageIcon(
				new ImageIcon(domino1_.getPathTerreno1()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));

		lbFicha1Der.setIcon(new ImageIcon(
				new ImageIcon(domino1_.getPathTerreno2()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));

		/// FICHA 2
		FichaDomino domino2_ = (FichaDomino) this.fichasActuales.get(1);

		unionfichas2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				fichaSeleccionada = domino2_;
				indiceFichaSeleccionada = 2;
				lbFichaSeleccionadaIzq.setIcon(new ImageIcon(new ImageIcon(fichaSeleccionada.getPathTerreno1())
						.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
				lbFichaSeleccionadaDer.setIcon(new ImageIcon(new ImageIcon(fichaSeleccionada.getPathTerreno2())
						.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});

		lbFicha2Izq.setIcon(new ImageIcon(
				new ImageIcon(domino2_.getPathTerreno1()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));

		lbFicha2Der.setIcon(new ImageIcon(
				new ImageIcon(domino2_.getPathTerreno2()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));

		// FICHA 3
		FichaDomino domino3_ = (FichaDomino) this.fichasActuales.get(2);

		unionfichas3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				fichaSeleccionada = domino3_;
				indiceFichaSeleccionada = 3;
				lbFichaSeleccionadaIzq.setIcon(new ImageIcon(new ImageIcon(fichaSeleccionada.getPathTerreno1())
						.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
				lbFichaSeleccionadaDer.setIcon(new ImageIcon(new ImageIcon(fichaSeleccionada.getPathTerreno2())
						.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});

		lbFicha3Izq.setIcon(new ImageIcon(
				new ImageIcon(domino3_.getPathTerreno1()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));
		lbFicha3Der.setIcon(new ImageIcon(
				new ImageIcon(domino3_.getPathTerreno2()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));

		/// FICHA 4
		FichaDomino domino4_ = (FichaDomino) this.fichasActuales.get(3);

		unionfichas4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				fichaSeleccionada = domino4_;
				indiceFichaSeleccionada = 4;
				lbFichaSeleccionadaIzq.setIcon(new ImageIcon(new ImageIcon(fichaSeleccionada.getPathTerreno1())
						.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
				lbFichaSeleccionadaDer.setIcon(new ImageIcon(new ImageIcon(fichaSeleccionada.getPathTerreno2())
						.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
			}
		});

		lbFicha4Izq.setIcon(new ImageIcon(
				new ImageIcon(domino4_.getPathTerreno1()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));

		lbFicha4Der.setIcon(new ImageIcon(
				new ImageIcon(domino4_.getPathTerreno2()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT)));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void setCellsAlignment(JTable table, int alignment) {
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(alignment);

		TableModel tableModel = table.getModel();

		for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
			table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
		}
	}

	public void acotarTablero1(int fila, int columna) {
		ImageIcon negro = new ImageIcon("Img/prohibido.jpeg");
		if (tableroJugador1.getRowCount() == 9) {// tamaño matriz base
			if (columna != 4) {
				for (int i = 0; i < tableroJugador1.getRowCount(); i++)
					tableroJugador1.setValueAt(negro, i, columna > 4 ? columna - 5 : columna + 5);
			}
			if (fila != 4) {
				for (int i = 0; i < tableroJugador1.getRowCount(); i++)
					tableroJugador1.setValueAt(negro, fila > 4 ? fila - 5 : fila + 5, i);
			}
		}
	}

	public void acotarTablero2(int fila, int columna) {
		ImageIcon negro = new ImageIcon("Img/prohibido.jpeg");
		if (tableroJugador2.getRowCount() == 9) {// tamaño matriz base
			if (columna != 4) {
				for (int i = 0; i < tableroJugador2.getRowCount(); i++)
					tableroJugador2.setValueAt(negro, i, columna > 4 ? columna - 5 : columna + 5);
			}
			if (fila != 4) {
				for (int i = 0; i < tableroJugador2.getRowCount(); i++)
					tableroJugador2.setValueAt(negro, fila > 4 ? fila - 5 : fila + 5, i);
			}
		}
	}

}


//tableroJugador1.setEnabled(false);
//tableroJugador2.setEnabled(true);