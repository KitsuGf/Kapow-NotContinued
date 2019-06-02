package interfac;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import exception.InvalidGenreException;
import user.User;


import javax.swing.JSeparator;

/**
 * Login interface with connection to user in database
 * 
 * @author Kitsu.
 */

public class Login extends JPanel{
	
	
	/**
	* Login class
	* 
	* This is the interface from user login, here have the connection to
	* dataBase for login the user
	* 
	* @Ventana 
	*/
	
	//Vars for class Login
	private Ventana ventana;
	private JTextField textUser;
	private JPasswordField textPass;
	private JLabel lblPassword;
	private JButton textRegister;
	private JLabel lblRegister;
	private JLabel lblForgetPass;
	private JLabel lblBackground;
	
	//The login start
	public Login(Ventana v) {
		super();
		ventana=v;
		setSize(new Dimension(594, 365));
		setBackground(Color.LIGHT_GRAY);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
	
		//Component separator 
		JSeparator separator = new JSeparator();
		separator.setBounds(34, 244, 514, 7);
		add(separator);
		//Component label for select the logo icon
		JLabel lblIconKapow = new JLabel("");
		lblIconKapow.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconKapow.setIcon(new ImageIcon("img\\logo.png"));
		lblIconKapow.setBounds(0, 13, 594, 89);
		add(lblIconKapow);
		
		//JButton for connect to database with the user and password registered
		JButton btnIni = new JButton("Iniciar");
		btnIni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Connection to Database
				Connection conn;
				try {
					conn = DriverManager.getConnection(
							"jdbc:mysql://51.158.162.242:3306/Kapow",
							"kitsu", "toor");
				
				//loginStatement get the query of database
				PreparedStatement loginStatement
                = conn.prepareStatement(
                        "select * from user where nUser=? "
                        + "and nPassword=? ");
		//This string copy the value of the password		
		String pass = String.copyValueOf(textPass.getPassword());
		//This String get the text of the textlabel
		String nUser = textUser.getText();

		//The login statement get nUser and pass vars
        loginStatement.setString(1, nUser);
        loginStatement.setString(2, pass);
        //Resulset foundUser save the Result of the query execute
        ResultSet foundUser = loginStatement.executeQuery();
        
        //If the user is registered in the database and the foundUser find it then
        //make the next:
        if (foundUser.next()) {
        	
        	 try {
        		//Set the data finded in the database to the constructor
        		//Usuario and get the parameters from database
				ventana.setUsuario(new User(foundUser.getString("firstname"),
						 				foundUser.getDate("dateUser"),
						 				foundUser.getString("lastname"),
						 				foundUser.getInt("tel"),
						 				foundUser.getString("genre").charAt(0),
						 				foundUser.getString("country"),
						 				foundUser.getString("city"),
						 				foundUser.getInt("cp"),
						 				foundUser.getString("dni"),
						 				foundUser.getString("mail"),
						 				foundUser.getString("nUser"),
						 				foundUser.getString("nPassword")));
			} catch (InvalidGenreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 				
        	//close the foundUser statement
        	foundUser.close();
        	
        	//this setText if for making the textLabel white again
        	//its like erase the label
        	textUser.setText("");
			textPass.setText("");
			//If the user log correctly, load the next JPanel
        	v.setLoadScreen();
        //If the username or password is not in the database the app calls an ShowMessageDialog with error
		}else{
			JOptionPane.showMessageDialog(null, "Username or Password wrong, ty again.", "Login Error", JOptionPane.ERROR_MESSAGE);
		}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
		});
		
		
		btnIni.setFont(new Font("Consolas", Font.BOLD, 13));
		btnIni.setBounds(286, 201, 106, 30);
		add(btnIni);
		//JTextFields for username and password
		textUser = new JTextField();
		textUser.setBounds(205, 115, 273, 30);
		add(textUser);
		textUser.setColumns(10);
		
		//This passwordfield have an actionlistener to do a "buttonclick". This allows you can press "Enter key"
		//For login
		textPass = new JPasswordField();
		textPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnIni.doClick();
			}
		});
		textPass.setBounds(205, 159, 272, 30);
		add(textPass);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		
		lblUsuario.setFont(new Font("Consolas", Font.BOLD, 23));
		lblUsuario.setBounds(102, 119, 91, 27);
		add(lblUsuario);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Consolas", Font.BOLD, 23));
		lblPassword.setBounds(89, 163, 104, 27);
		add(lblPassword);
		
		//Button register, this one set the JPanel with register fields
		textRegister = new JButton("Registrar");
		textRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This clear the textlabel
				textUser.setText("");
				textPass.setText("");
				//Next JPanel in this case is RegisterPanel
				v.setPantallaRegistro();
			}
		});
		textRegister.setFont(new Font("Consolas", Font.BOLD, 13));
		textRegister.setBounds(371, 264, 106, 22);
		add(textRegister);
		
		//Button for go to the panel RecoverPassword
		JButton textRecu = new JButton("Recuperar");
		textRecu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Set the panel to the recoverPassword
				v.setPantallaRecuperar();
			}
		});
		
		//More labels of the interface
		textRecu.setFont(new Font("Consolas", Font.BOLD, 13));
		textRecu.setBounds(371, 306, 106, 22);
		add(textRecu);
		
		lblRegister = new JLabel("Registrate");
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setFont(new Font("Consolas", Font.BOLD, 17));
		lblRegister.setBounds(269, 264, 90, 21);
		this.add(lblRegister);
		
		lblForgetPass = new JLabel("\u00BFOlvidaste tu contrase\u00F1a?");
		lblForgetPass.setForeground(Color.WHITE);
		lblForgetPass.setFont(new Font("Consolas", Font.BOLD, 17));
		lblForgetPass.setBounds(134, 307, 225, 21);
		add(lblForgetPass);
		
		//Label with background of the JPanel
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("img\\wp600.png"));
		lblBackground.setBounds(0, 0, 594, 365);
		add(lblBackground);
	}
}
