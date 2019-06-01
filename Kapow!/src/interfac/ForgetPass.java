package interfac;

/**
 * This class is an interface for recover the password with email integration
 * 
 * This class have the atributes: Name and Date shared with Archive and user.
 * @author Kitsu.
 */


import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import mail.Mailer;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Cursor;

public class ForgetPass extends JPanel{
	private Ventana ventana;
	private JTextField textEmail;
	private JButton btnRecuperar;
	//This is the var to the usermail
	String d; 
	//This is the asunto
    String a = "Recuperar contraseña.";
    //The text in the email
    String c;

    
    //Start for forgetPass
	public ForgetPass(Ventana v) {
	super();
	ventana =v;
	setSize(new Dimension(594, 365));
	setLayout(null);
	
	textEmail = new JTextField();
	textEmail.setForeground(Color.BLACK);
	textEmail.setBounds(205, 160, 272, 30);
	add(textEmail);
	textEmail.setColumns(10);
	
	
	//BackButton for back to the login JPanel
	JButton btnVolver = new JButton("Volver");
	btnVolver.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			textEmail.setText("");
			v.setPantallaLogin();
		}
	});
	btnVolver.setBounds(431, 260, 97, 25);
	add(btnVolver);
	
	//Recover button and action for getting the recovery email
	btnRecuperar = new JButton("Recuperar");
	btnRecuperar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	btnRecuperar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			//Connection to the database for Kapow
			Connection conn;
			try {
				conn = DriverManager.getConnection(
						"jdbc:mysql://51.158.162.242:3306/Kapow",
						"kitsu", "toor");
			
			
			PreparedStatement loginStatement
            = conn.prepareStatement(
                    "select nPassword, nUser from user where mail=? ");

			
	String d = textEmail.getText();

    loginStatement.setString(1, textEmail.getText());
    ResultSet foundUser = loginStatement.executeQuery();
    if (foundUser.next()) {
    	
    	//Compose the email
    	String nUser = foundUser.getString("nUser");
    	String nPassword = foundUser.getString("nPassword");
    	String c = "Vaya vaya...Veo que "+nUser+" ha perdido su contraseña. \nPero no te preocupes, DrStrange retrocedera en el tiempo para devolvertela. \n\nTu contraseña es: " +nPassword+ " \n\nConsideralo un regalo de DrStrange. \n\nKapow!" ;
    	
    	//Wait cursor, this appears when the button is pressed and the email was sended, the WAIT_CURSOR start when the email is sended
    	//And stop when the email is correctly sended
    	btnRecuperar.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    	//Call to the fuction Mailer
    	Mailer.sendMail(d, a, c);
    	
    	//This is for leave the JTextField void
    	textEmail.setText("");
    	
    	//When the email is correctly sended, show an a dialog 
    	JOptionPane.showMessageDialog(null, "Sent message successfully");
    	
    	//The cursor back to the DEFAULT_CURSOR when the email was sended correctly
    	btnRecuperar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}else {
		//When the email is not correct or not appear in the database appears a JOptionPaneErrorMessage
		JOptionPane.showMessageDialog(null, "Wrong email, try again", "Email error", JOptionPane.ERROR_MESSAGE);
	}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	});
	btnRecuperar.setBounds(296, 202, 97, 25);
	add(btnRecuperar);
	
	
	//Interface components
	//Separator
	JSeparator separator = new JSeparator();
	separator.setBounds(34, 244, 514, 7);
	add(separator);
	
	//Interface Labels
	JLabel lblquieresVolverA = new JLabel("\u00BFQuieres volver a la pantalla de inicio?");
	lblquieresVolverA.setForeground(Color.WHITE);
	lblquieresVolverA.setFont(new Font("Consolas", Font.BOLD, 17));
	lblquieresVolverA.setBounds(59, 264, 360, 21);
	add(lblquieresVolverA);
	
	JLabel lblIntroduceElCorreo = new JLabel("Introduce el correo con el que te registraste");
	lblIntroduceElCorreo.setForeground(Color.WHITE);
	lblIntroduceElCorreo.setFont(new Font("Consolas", Font.BOLD, 17));
	lblIntroduceElCorreo.setBounds(87, 127, 414, 21);
	add(lblIntroduceElCorreo);
	
	JLabel logo = new JLabel("");
	logo.setIcon(new ImageIcon("img\\logo.png"));
	logo.setHorizontalAlignment(SwingConstants.CENTER);
	logo.setBounds(0, 13, 594, 89);
	add(logo);
	
	JLabel lblCorreo = new JLabel("Correo");
	lblCorreo.setForeground(Color.WHITE);
	lblCorreo.setFont(new Font("Consolas", Font.BOLD, 23));
	lblCorreo.setBounds(115, 161, 78, 27);
	add(lblCorreo);
	
	JLabel background = new JLabel("");
	background.setBounds(0, 0, 594, 365);
	background.setIcon(new ImageIcon("img\\wp600.png"));
	add(background);
	}
}
