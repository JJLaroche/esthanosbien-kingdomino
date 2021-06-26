package Graphics;

import java.awt.BorderLayout;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Introduccion extends JFrame {

	private JPanel contentPane;

	public Introduccion() throws InterruptedException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 970, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setResizable(false);
		setTitle("KingDomino ARG - EsThanosBien");
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("Img/intro3.gif"));
		getContentPane().setLayout(null);
		lblNewLabel.setBounds(0, 0, 960, 620);
		getContentPane().add(lblNewLabel);
		
	}

	public void run() {
		try {
			ImageIcon imgIcon = new ImageIcon("Img/icono22.png");
			Clip sonido = AudioSystem.getClip();
			sonido.open(AudioSystem.getAudioInputStream(new File("Img/musica.wav")));
			sonido.start();
			this.setIconImage(imgIcon.getImage());
			this.setVisible(true);
			Thread.sleep(20000);
			sonido.stop();
			setVisible(false);
			dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
