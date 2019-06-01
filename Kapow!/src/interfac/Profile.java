package interfac;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Profile extends JPanel {
	
	private Ventana ventana;
	
	public Profile(Ventana v) {
		super();
		ventana=v;
		setSize(new Dimension(899, 615));
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 899, 615);
		label.setIcon(new ImageIcon("C:\\Users\\Kitsu\\Desktop\\Kapow!\\img\\900.png"));
		add(label);
	}

}
