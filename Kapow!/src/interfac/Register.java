package interfac;

import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;

import exception.InvalidGenreException;
import user.User;



/**
 * Class of Common data between Archive and User.
 * This class have the atributes: Name and Date shared with Archive and user.
 * @author Kitsu.
 */

public class Register extends JPanel {
	private JTextField textName;
	private JTextField textLast;
	private JTextField textTele;
	private JTextField textCountry;
	private JTextField textCity;
	private JTextField textCp;
	private JTextField textDni;
	private JTextField textEmail;
	private JTextField textUser;
	private JPasswordField textPass;
	private Ventana ventana;
	String charGenero;
	SimpleDateFormat formDate;

	public Register(Ventana v) {
		super();
		ventana=v;
		setSize(new Dimension(899, 580));
		setLayout(null);
		formDate = new SimpleDateFormat("dd/MM/yyyy");
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		dateChooser.setBounds(141, 225, 143, 27);
		add(dateChooser);
		

		/*									||-------------------------------------------------||		
										    ||		 	   SEPARATORS FOR INTERFACE		   	   ||
										    ||-------------------------------------------------||
		 */

		JSeparator sepVert = new JSeparator();
		sepVert.setOrientation(SwingConstants.VERTICAL);
		sepVert.setForeground(Color.WHITE);
		sepVert.setBackground(Color.WHITE);
		sepVert.setBounds(450, 97, 2, 443);
		add(sepVert);

		JSeparator sepUser = new JSeparator();
		sepUser.setForeground(Color.WHITE);
		sepUser.setBackground(Color.WHITE);
		sepUser.setBounds(498, 49, 373, 12);
		add(sepUser);

		JSeparator sepPer = new JSeparator();
		sepPer.setBackground(Color.WHITE);
		sepPer.setForeground(Color.WHITE);
		sepPer.setBounds(30, 49, 373, 12);
		add(sepPer);



		/*									||-------------------------------------------------||		
										    ||		 PERSONAL DATA FROM REGISTER NEW USER	   ||
										    ||-------------------------------------------------||
		 */

		JLabel lblDatosPersonales = new JLabel("DATOS PERSONALES");
		lblDatosPersonales.setForeground(Color.WHITE);
		lblDatosPersonales.setFont(new Font("Consolas", Font.BOLD, 28));
		lblDatosPersonales.setBounds(86, 13, 240, 34);
		add(lblDatosPersonales);

		JLabel name = new JLabel("Nombre");
		name.setFont(new Font("Consolas", Font.BOLD, 23));
		name.setForeground(Color.WHITE);
		name.setBackground(Color.WHITE);
		name.setBounds(22, 86, 78, 27);
		add(name);

		textName = new JTextField();
		textName.setBounds(141, 85, 272, 27);
		add(textName);
		textName.setColumns(10);


		JLabel lastName = new JLabel("Apellidos");
		lastName.setForeground(Color.WHITE);
		lastName.setFont(new Font("Consolas", Font.BOLD, 23));
		lastName.setBounds(22, 139, 117, 27);
		add(lastName);

		textLast = new JTextField();
		textLast.setColumns(10);
		textLast.setBounds(141, 138, 272, 27);
		add(textLast);

		JLabel tele = new JLabel("Telefono");
		tele.setForeground(Color.WHITE);
		tele.setFont(new Font("Consolas", Font.BOLD, 23));
		tele.setBounds(22, 277, 104, 27);
		add(tele);

		textTele = new JTextField();
		textTele.setColumns(10);
		textTele.setBounds(141, 276, 272, 27);
		add(textTele);

		JLabel country = new JLabel("Pais");
		country.setForeground(Color.WHITE);
		country.setFont(new Font("Consolas", Font.BOLD, 23));
		country.setBounds(22, 330, 52, 27);
		add(country);

		textCountry = new JTextField();
		textCountry.setColumns(10);
		textCountry.setBounds(141, 328, 272, 27);
		add(textCountry);

		JLabel city = new JLabel("Ciudad");
		city.setForeground(Color.WHITE);
		city.setFont(new Font("Consolas", Font.BOLD, 23));
		city.setBounds(22, 379, 78, 27);
		add(city);


		textCity = new JTextField();
		textCity.setColumns(10);
		textCity.setBounds(141, 377, 272, 27);
		add(textCity);

		JLabel cp = new JLabel("CP");
		cp.setForeground(Color.WHITE);
		cp.setFont(new Font("Consolas", Font.BOLD, 23));
		cp.setBounds(22, 427, 26, 27);
		add(cp);

		textCp = new JTextField();
		textCp.setColumns(10);
		textCp.setBounds(141, 425, 272, 27);
		add(textCp);

		JLabel dni = new JLabel("DNI");
		dni.setForeground(Color.WHITE);
		dni.setFont(new Font("Consolas", Font.BOLD, 23));
		dni.setBounds(22, 479, 39, 27);
		add(dni);

		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(141, 477, 272, 27);
		add(textDni);

		JLabel genre = new JLabel("Genero");
		genre.setForeground(Color.WHITE);
		genre.setFont(new Font("Consolas", Font.BOLD, 23));
		genre.setBounds(22, 184, 78, 27);
		add(genre);

		ButtonGroup genero=new ButtonGroup();

		JRadioButton btnM = new JRadioButton("Masculino");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnM.isSelected()) {
					charGenero = "M";
				}
			}
		});
		btnM.setForeground(Color.WHITE);
		btnM.setOpaque(false);
		btnM.setFont(new Font("Consolas", Font.BOLD, 23));
		btnM.setBounds(138, 180, 145, 35);
		add(btnM);
		genero.add(btnM);

		JRadioButton btnFem = new JRadioButton("Femenino");
		btnFem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnFem.isSelected()) {
					charGenero = "F";
				}
			}
		});
		btnFem.setForeground(Color.WHITE);
		btnFem.setOpaque(false);
		btnFem.setFont(new Font("Consolas", Font.BOLD, 23));
		btnFem.setBounds(280, 180, 133, 35);
		add(btnFem);
		genero.add(btnFem);

		JLabel email = new JLabel("Correo");
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Consolas", Font.BOLD, 23));
		email.setBounds(22, 526, 78, 27);
		add(email);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(141, 525, 272, 27);
		add(textEmail);


		JLabel userDate = new JLabel("Fecha Nac");
		userDate.setForeground(Color.WHITE);
		userDate.setFont(new Font("Consolas", Font.BOLD, 23));
		userDate.setBounds(22, 225, 117, 27);
		add(userDate);


		/*									||-------------------------------------------------||		
										    ||		  PASSWORD AND NICKNAME FOR USER		   ||
										    ||-------------------------------------------------||
		 */	

		JLabel user = new JLabel("Usuario");
		user.setForeground(Color.WHITE);
		user.setFont(new Font("Consolas", Font.BOLD, 23));
		user.setBackground(Color.WHITE);
		user.setBounds(472, 86, 91, 27);
		add(user);

		textUser = new JTextField();
		textUser.setColumns(10);
		textUser.setBounds(610, 85, 272, 27);
		add(textUser);

		JLabel password = new JLabel("Contrase\u00F1a");
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Consolas", Font.BOLD, 23));
		password.setBounds(472, 139, 130, 27);
		add(password);

		textPass = new JPasswordField();
		textPass.setColumns(10);
		textPass.setBounds(610, 138, 272, 27);
		add(textPass);

		JLabel dataUser = new JLabel("DATOS USUARIO");
		dataUser.setForeground(Color.WHITE);
		dataUser.setFont(new Font("Consolas", Font.BOLD, 28));
		dataUser.setBounds(585, 13, 195, 34);
		add(dataUser);



		/*									||-------------------------------------------------||		
										    ||		  FUNCTION FOR REGISTER A NEW USER		   ||
										    ||-------------------------------------------------||
		 */		

		JButton btnRegister = new JButton("Registrarse");
		btnRegister.setFont(new Font("Consolas", Font.BOLD, 13));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Statement registerStatement;
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://51.158.162.242:3306/Kapow",
							"kitsu", "toor");
					registerStatement = conn.createStatement();	


					String insert =	"insert into user (firstname,lastname,dateUser,tel,genre,country,city,cp,dni,mail,nuser,npassword)"
							+ " values('" 
							+ textName.getText() + "','"
							+ textLast.getText() + "',"
							+"STR_TO_DATE('"+formDate.format(dateChooser.getDate())+ "','%d/%m/%Y'),"
							+ textTele.getText() + ",'"
							+ charGenero + "','"
							+ textCountry.getText() + "','"
							+ textCity.getText() + "',"	
							+ textCp.getText() + ",'"
							+ textDni.getText() + "','"
							+ textEmail.getText() + "','"
							+ textUser.getText() + "','"
							+ String.copyValueOf(textPass.getPassword()) + "'" 
							+ ");";
					
					try {
						//This is to converse the util.Date to sql.Date in the constructor
						java.util.Date utilDate = dateChooser.getDate();
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
						ventana.setUsuario(new User(textName.getText(), sqlDate, textLast.getText(), Integer.parseInt(textTele.getText()), charGenero.charAt(0), textCountry.getText(), textCity.getText(), Integer.parseInt(textCp.getText()), textDni.getText(), textEmail.getText(), textUser.getText(), String.copyValueOf(textPass.getPassword())));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InvalidGenreException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
					
					registerStatement.executeUpdate(insert);	
					
					registerStatement.close();
					
					
					PreparedStatement foundId = conn
		                    .prepareStatement("select * from user where id=(select max(id) FROM user)");
		            ResultSet foundUser = foundId.executeQuery();
					if (foundUser.next()) {
						textName.setText("");
						textLast.setText("");
						textTele.setText("");
						textCountry.setText("");
						textCity.setText("");
						textCp.setText("");
						textDni.setText("");
						textEmail.setText("");
						textUser.setText("");
						textPass.setText("");
						dateChooser.setCalendar(null);
						genero.clearSelection();
						v.setPantallaRegistroCorrecto();
					}

				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}	

			}

		});
		
		
		btnRegister.setBounds(757, 238, 130, 46);
		add(btnRegister);
		
		/*									||-------------------------------------------------||		
	    									||		  BUTTON FOR BACK TO LOGIN JPANEL		   ||
	    									||-------------------------------------------------||
		 */	

		JButton button = new JButton("Volver");
		button.setFont(new Font("Consolas", Font.BOLD, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textName.setText("");
				textLast.setText("");
				textTele.setText("");
				textCountry.setText("");
				textCity.setText("");
				textCp.setText("");
				textDni.setText("");
				textEmail.setText("");
				textUser.setText("");
				textPass.setText("");
				dateChooser.setCalendar(null);
				genero.clearSelection();	
				v.setPantallaLogin();
			}
			
		});
		button.setBounds(757, 296, 130, 46);
		add(button);

		/*									||-------------------------------------------------||		
										    ||		  LABELS FOR DIFFERENT IMG AND ICON		   ||
										    ||-------------------------------------------------||
		 */		

		JLabel kapowIco = new JLabel("");
		kapowIco.setIcon(new ImageIcon("img\\logo.png"));
		kapowIco.setBounds(540, 255, 123, 90);
		add(kapowIco);

		JLabel deadIcon = new JLabel("");
		deadIcon.setIcon(new ImageIcon("img\\deapool.png"));
		deadIcon.setBounds(551, 211, 331, 456);
		add(deadIcon);

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("img\\900.png"));
		background.setBounds(0, 0, 899, 580);
		add(background);


		/*									||-------------------------------------------------||		
	    									||THIS IF CATCH THE CASE WHEN GENRE ES NOT SELECTED||
	    									||-------------------------------------------------||
		*/	

		btnRegister.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(charGenero == null) {
					JOptionPane.showMessageDialog(null, "You must choose a genre", "Genre Error", JOptionPane.ERROR_MESSAGE);
					}
			}
		});


	}
}
