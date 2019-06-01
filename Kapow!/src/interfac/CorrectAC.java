package interfac;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setSize(new Dimension(1280, 720));
		setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				v.setPantallaLogin();
				
			}
		});
		btnVolver.setBounds(12, 660, 97, 25);
		add(btnVolver);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Kitsu\\Desktop\\Kapow!\\img\\wp720.png"));
		label.setBounds(0, 0, 1280, 720);
		add(label);
	}
}