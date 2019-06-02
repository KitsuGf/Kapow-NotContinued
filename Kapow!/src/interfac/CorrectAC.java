package interfac;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

;

/**
 * Interface to get an advise for no piracy comics.
 * This class have the atributes: Name and Date shared with Archive and user.
 * @author Kitsu.
 */

public class CorrectAC extends JPanel{
	
	private Ventana ventana;
	
		

	public CorrectAC(Ventana v) {
		super();
		ventana =v;
		setSize(new Dimension(899, 615));
		setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Consolas", Font.BOLD, 13));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				v.setPantallaLogin();
				
			}
		});
		btnVolver.setBounds(24, 523, 130, 40);
		add(btnVolver);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("img\\tv.png"));
		label_2.setBounds(212, 313, 550, 250);
		add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("img\\captain_america.gif"));
		label_1.setBounds(220, 333, 480, 197);
		add(label_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("img\\correcregs.png"));
		label_3.setBounds(86, 0, 750, 300);
		add(label_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img\\900.png"));
		lblNewLabel.setBounds(0, 0, 899, 615);
		add(lblNewLabel);
	}
}