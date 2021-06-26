package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shared.Partida;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JPantallaEmpezarJuego extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public JPantallaEmpezarJuego(Partida partida) {

		// VENTANA
		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("KingDomino ARG - EsThanosBien");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 970, 660);
		getContentPane().setLayout(null);

		// PANEL
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		JButton btEmpezarJuego = new JButton(new ImageIcon("Img/btEmpezarJuego.png"));
		btEmpezarJuego.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
				setVisible(false);
				dispose();
				JPantallaElegirCantJugadores pantalla = new JPantallaElegirCantJugadores(partida);
				pantalla.run();
				}
			}
		});
		btEmpezarJuego.setBounds(315, 493, 317, 43);
		getContentPane().add(btEmpezarJuego);

		btEmpezarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				JPantallaElegirCantJugadores pantalla = new JPantallaElegirCantJugadores(partida);
				pantalla.run();
			}
		});

		JLabel backgroundVentana1 = new JLabel(new ImageIcon("Img/ventana1.jpg"));
		backgroundVentana1.setBounds(0, 0, 960, 620);
		getContentPane().add(backgroundVentana1);

	}

	public void run() {
		try {
			Introduccion intro = new Introduccion();
//	        intro.run();
			ImageIcon imgIcon = new ImageIcon("Img/icono2.png");
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
