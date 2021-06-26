package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import shared.*;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JPantallaElegirNombresJugadores extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public JPantallaElegirNombresJugadores(Partida partida) {

		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("KingDomino ARG - EsThanosBien");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 970, 660);
		getContentPane().setLayout(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		int cantidadJugadores = partida.cantidadJugadores;

		ArrayList<String> nombresJugadores = new ArrayList<String>();

		JLabel lblListaDeJugadores = new JLabel("LISTA DE JUGADORES");
		lblListaDeJugadores.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblListaDeJugadores.setBounds(603, 319, 215, 23);
		getContentPane().add(lblListaDeJugadores);

		JList<Object> lstListaJugadores = new JList<Object>();
		lstListaJugadores.setValueIsAdjusting(true);
		lstListaJugadores.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		lstListaJugadores.setBounds(578, 353, 241, 102);
		getContentPane().add(lstListaJugadores);
		limparJlist(lstListaJugadores);

		JLabel lblIngreseNombreJugador = new JLabel("INGRESE NOMBRE JUGADOR");
		lblIngreseNombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIngreseNombreJugador.setBounds(49, 350, 264, 14);
		getContentPane().add(lblIngreseNombreJugador);
		
		JButton btnEliminarJugador = new JButton("ELIMINAR JUGADOR");
		btnEliminarJugador.setEnabled(false);
		btnEliminarJugador.setBounds(617, 480, 170, 23);
		getContentPane().add(btnEliminarJugador);
		btnEliminarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombresJugadores.remove(lstListaJugadores.getSelectedValue());
				eliminarJugador(lstListaJugadores,(String)lstListaJugadores.getSelectedValue());
			}
		});

		JTextField txtFldNombreJugador = new JTextField();
		txtFldNombreJugador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					agregarJugador(lstListaJugadores, txtFldNombreJugador.getText());
					nombresJugadores.add(txtFldNombreJugador.getText());
					txtFldNombreJugador.setText("");
					btnEliminarJugador.setEnabled(true);
				}
			}
		});
		txtFldNombreJugador.setBounds(49, 387, 241, 20);
		getContentPane().add(txtFldNombreJugador);
		txtFldNombreJugador.setColumns(10);

		JButton btnConfirmarNombre = new JButton("AGREGAR");
		btnConfirmarNombre.setBounds(179, 452, 111, 23);
		getContentPane().add(btnConfirmarNombre);

		btnConfirmarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarJugador(lstListaJugadores, txtFldNombreJugador.getText());
				nombresJugadores.add(txtFldNombreJugador.getText());
				txtFldNombreJugador.setText("");
				btnEliminarJugador.setEnabled(true);
			}
		});

		JButton btnBorrarNombre = new JButton("BORRAR");
		btnBorrarNombre.setBounds(49, 452, 120, 23);
		getContentPane().add(btnBorrarNombre);
		btnBorrarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFldNombreJugador.setText("");
			}
		});

		JButton btnJugar = new JButton("¡ JUGAR !");
		btnJugar.setForeground(new Color(255, 255, 255));
		btnJugar.setBackground(new Color(0, 128, 128));
		btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnJugar.setBounds(238, 515, 272, 46);
		getContentPane().add(btnJugar);

		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nombresJugadores.size() != cantidadJugadores) {
					JOptionPane.showMessageDialog(null,
							"La cantidad de nombres ingresados no coincide con el numero de jugadores elegido");
					return;
				}
				setVisible(false);
				dispose();
				partida.nombrarJugadores(nombresJugadores);
			}
		});

		JLabel backgroundVentana3 = new JLabel(new ImageIcon("Img/ventana3.jpg"));
		backgroundVentana3.setBounds(0, 0, 960, 620);
		getContentPane().add(backgroundVentana3);

	}

	public DefaultListModel<Object> limparJlist(JList<Object> listaJugadores) {

		DefaultListModel<Object> modelo = new DefaultListModel<Object>();
		listaJugadores.setModel(modelo);
		return modelo;
	}

	public DefaultListModel<Object> agregarJugador(JList<Object> listaJugadores, String nombre) {

		DefaultListModel<Object> modelo = (DefaultListModel<Object>) listaJugadores.getModel();
		modelo.addElement(nombre);
		return modelo;

	}

	public DefaultListModel<Object> eliminarJugador(JList<Object> listaJugadores, String nombre) {

		DefaultListModel<Object> modelo = (DefaultListModel<Object>) listaJugadores.getModel();
		modelo.removeElement(nombre);
		return modelo;

	}

	public void run() {
		try {
			ImageIcon imgIcon = new ImageIcon("Img/icono22.png");
			this.setIconImage(imgIcon.getImage());
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}