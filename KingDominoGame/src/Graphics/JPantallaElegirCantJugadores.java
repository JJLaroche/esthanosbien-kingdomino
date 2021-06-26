package Graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shared.*;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JPantallaElegirCantJugadores extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public JPantallaElegirCantJugadores(Partida partida) {

		setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("KingDomino ARG - EsThanosBien");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 970, 660);
		getContentPane().setLayout(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
			
			
			JComboBox<Object> comboBoxCantJug = new JComboBox<Object>();
			comboBoxCantJug.setForeground(new Color(0, 128, 128));
			comboBoxCantJug.setBackground(new Color(255, 255, 255));
			comboBoxCantJug.setFont(new Font("Tahoma", Font.PLAIN, 20));
			comboBoxCantJug.setMaximumRowCount(3);
			comboBoxCantJug.setModel(new DefaultComboBoxModel<Object>(new String[] {"2", "3", "4"}));
			comboBoxCantJug.setToolTipText("Cantidad de Jugadores");
			comboBoxCantJug.setBounds(430, 429, 156, 22);
			getContentPane().add(comboBoxCantJug);
			
			JButton btConfirmar = new JButton(new ImageIcon("Img/btConfirmar.png"));
			btConfirmar.setBounds(365, 478, 272, 46);
			getContentPane().add(btConfirmar);
			btConfirmar.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER){
					setVisible(false);
					dispose();
					partida.definirCantidadJugadores(Integer.parseInt(comboBoxCantJug.getSelectedItem().toString()));
					JPantallaElegirNombresJugadores pantallaNombres = new JPantallaElegirNombresJugadores(partida);
					pantallaNombres.run();
					}
				}
			});
			btConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					partida.definirCantidadJugadores(Integer.parseInt(comboBoxCantJug.getSelectedItem().toString()));
					JPantallaElegirNombresJugadores pantallaNombres = new JPantallaElegirNombresJugadores(partida);
					pantallaNombres.run();
				}
			});
			
			JLabel backgroundVentana2 = new JLabel(new ImageIcon("Img/ventana2_v2.jpg"));
			backgroundVentana2.setBounds(0, 0, 960, 620);
			getContentPane().add(backgroundVentana2);

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
