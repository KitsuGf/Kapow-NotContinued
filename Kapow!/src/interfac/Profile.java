package interfac;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Interface for Profile
 * 
 * @author Kitsu.
 */



public class Profile extends JPanel {
	
	
	
	/**
	 * Profile shows the profile of the user Logged
	 * 
	 * 
	 *@Ventana 
	 */
	
	
	//Var for Profile
	private Ventana ventana;
	
	public Profile(Ventana v) {
		super();
		ventana=v;
		setSize(new Dimension(899, 647));
		setLayout(null);
		
		//More labels
		JLabel lblDatosPersonales = new JLabel("Datos Personales");
		lblDatosPersonales.setForeground(Color.WHITE);
		lblDatosPersonales.setFont(new Font("Consolas", Font.BOLD, 28));
		lblDatosPersonales.setBounds(95, 15, 240, 34);
		add(lblDatosPersonales);
		
		//Separators
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(30, 49, 373, 12);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(498, 49, 373, 12);
		add(separator_1);
		
		//Labels
		JLabel lblDatosUsuario = new JLabel("Datos Usuario");
		lblDatosUsuario.setForeground(Color.WHITE);
		lblDatosUsuario.setFont(new Font("Consolas", Font.BOLD, 28));
		lblDatosUsuario.setBounds(585, 15, 195, 34);
		add(lblDatosUsuario);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.WHITE);
		separator_2.setBackground(Color.WHITE);
		separator_2.setBounds(450, 97, 2, 443);
		add(separator_2);
		
		//This labels get info of the user
		//This label get the user First name
		JLabel label_3 = new JLabel("Nombre_ " + v.getUsuario().getName());
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Consolas", Font.BOLD, 23));
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(22, 97, 416, 27);
		add(label_3);
		//This label get the user LastName
		JLabel label_4 = new JLabel("Apellidos_ " + v.getUsuario().getLastName());
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Consolas", Font.BOLD, 23));
		label_4.setBounds(22, 150, 416, 27);
		add(label_4);
		//This label get the user Genre
		JLabel label_5 = new JLabel("Genero_ "+ v.getUsuario().getGenre());
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Consolas", Font.BOLD, 23));
		label_5.setBounds(23, 195, 415, 27);
		add(label_5);
		//This label get the user Date
		JLabel label_6 = new JLabel("Fecha Nac_ " + v.getUsuario().getDateUser());
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Consolas", Font.BOLD, 23));
		label_6.setBounds(22, 236, 416, 27);
		add(label_6);
		//This label get the user Telephone
		JLabel label_7 = new JLabel("Telefono_ " + v.getUsuario().getTele());
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Consolas", Font.BOLD, 23));
		label_7.setBounds(22, 288, 416, 27);
		add(label_7);
		//This label get the user Country
		JLabel label_8 = new JLabel("Pais_ " + v.getUsuario().getCountry());
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Consolas", Font.BOLD, 23));
		label_8.setBounds(22, 341, 416, 27);
		add(label_8);
		//This label get the user City
		JLabel label_9 = new JLabel("Ciudad_ " + v.getUsuario().getCity());
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Consolas", Font.BOLD, 23));
		label_9.setBounds(22, 390, 415, 27);
		add(label_9);
		//This label get the user PostalCode
		JLabel label_10 = new JLabel("CP_ " + v.getUsuario().getCp());
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Consolas", Font.BOLD, 23));
		label_10.setBounds(22, 438, 416, 27);
		add(label_10);
		//This label get the user DNI
		JLabel label_11 = new JLabel("DNI_ " + v.getUsuario().getDni());
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Consolas", Font.BOLD, 23));
		label_11.setBounds(22, 490, 416, 27);
		add(label_11);
		//This label get the user Email
		JLabel label_12 = new JLabel("Correo_ " + v.getUsuario().getMail());
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Consolas", Font.BOLD, 23));
		label_12.setBounds(473, 390, 416, 27);
		add(label_12);
		//End of the user personal info
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBounds(558, 74, 252, 286);
		add(panel);
		//This is an special label with a layer for the user and shows the NickNameUser
		JLabel label_1 = new JLabel(v.getUsuario().getnUser());
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Consolas", Font.BOLD, 35));
		label_1.setBackground(Color.BLACK);
		label_1.setBounds(28, 243, 189, 35);
		panel.add(label_1);
		//Profile Layer
		JLabel label_2 = new JLabel();
		label_2.setIcon(new ImageIcon("img\\avatar3.png"));
		label_2.setBounds(0, 0, 252, 286);
		panel.add(label_2);
		//Anocher backbutton
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Consolas", Font.BOLD, 13));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.setPantallaMain();
			}
		});
		btnVolver.setBounds(757, 521, 130, 46);
		add(btnVolver);
		//Labels
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 899, 580);
		label.setIcon(new ImageIcon("img\\900.png"));
		add(label);
	}
}
