package interfac;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;

public class LoadScreen extends JPanel {
	
	private Ventana ventana;
	private Timer t;
	private ActionListener al;
	
	public LoadScreen(Ventana v) {
		super();
		ventana=v;
		setSize(new Dimension(1280, 752));
		
		setLayout(null);
		
		/*JLabel lblBienvenido = new JLabel("Bienvenido agente <dynamic>");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setForeground(new Color(128, 0, 0));
		lblBienvenido.setFont(new Font("Yu Gothic Light", Font.PLAIN, 13));
		lblBienvenido.setBounds(0, 37, 1280, 48);
		add(lblBienvenido);*/
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBorder(null);
		progressBar.setOpaque(true);
		progressBar.setStringPainted(true);
		progressBar.setForeground(new Color(128, 0, 0));
		progressBar.setBounds(290, 664, 700, 44);
	
		add(progressBar);
		
		 al = new ActionListener() {
			 
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (progressBar.getValue() < 100) {
					progressBar.setValue(progressBar.getValue()+3);
				}else {
					t.stop();
					v.setPantallaMain();
				}
			}

		};
		
		t = new Timer(150, al);
		t.start();
		
	
		
		JLabel label = new JLabel("");
		label.setLabelFor(this);
		label.setBounds(0, 0, 1280, 720);
		label.setIcon(new ImageIcon("C:\\Users\\Kitsu\\Desktop\\Kapow!\\img\\loadScren2.gif"));
		add(label);
	}
}