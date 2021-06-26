package Graphics;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shared.*;

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

public class JPantallaGanador extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public JPantallaGanador(ArrayList<Jugador> posiciones) {

		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("KingDomino ARG - EsThanosBien");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 970, 660);
		getContentPane().setLayout(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGanador = new JLabel(posiciones.get(0).getNombreJugador());
		lblGanador.setForeground(new Color(255, 255, 255));
		lblGanador.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblGanador.setBounds(382, 226, 243, 40);
		getContentPane().add(lblGanador);
		
		JList<Object> lstListaJugadores = new JList<Object>();
		lstListaJugadores.setBackground(Color.WHITE);
		lstListaJugadores.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		lstListaJugadores.setBounds(219, 380, 499, 128);
		getContentPane().add(lstListaJugadores);
		limparJlist(lstListaJugadores);
		
		for(int i = 0; i < posiciones.size(); i++) {
			agregarJugador(lstListaJugadores,i+1 + ". " + posiciones.get(i).getNombreJugador() + " - " + posiciones.get(i).getPuntos().getPuntos() + " PUNTOS");;
		}
		
		
		JButton btnFinalizar = new JButton(new ImageIcon("Img/btFinalizarJuego.png"));
		btnFinalizar.setBounds(250, 544, 217, 33);
		getContentPane().add(btnFinalizar);
		
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		

		
		JButton btnJugarDeNuevo = new JButton(new ImageIcon("Img/btJugarDeNuevo.png"));
		btnJugarDeNuevo.setBounds(499, 544, 219, 33);
		getContentPane().add(btnJugarDeNuevo);
		
		btnJugarDeNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				dispose();
				Mazo mazo = new Mazo();
		        Mesa mesa = new Mesa(mazo);
		        Partida partidaActual = new Partida(mesa);
		        JPantallaEmpezarJuego pantallaInicial = new JPantallaEmpezarJuego(partidaActual);
		        pantallaInicial.run();
				
			}
		});
		
		
		JLabel backgroundVentana5 = new JLabel(new ImageIcon("Img/ventana5.jpg"));
		backgroundVentana5.setBounds(0, 0, 960, 620);
		getContentPane().add(backgroundVentana5);
		
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
	
	
	public DefaultListModel<Object> limparJlist(JList<Object> listaJugadores) {
		
		DefaultListModel<Object> modelo = new DefaultListModel<Object>();
		listaJugadores.setModel(modelo);
		return modelo;
		
	}
	
	public DefaultListModel<Object> agregarJugador(JList<Object> listaJugadores, String nombre){
		
		DefaultListModel<Object> modelo = (DefaultListModel<Object>) listaJugadores.getModel();
		modelo.addElement(nombre);
		return modelo;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
