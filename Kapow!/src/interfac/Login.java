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
 * Class of Common data between Archive and User.
 * This class have the atributes: Name and Date shared with Archive and user.
 * @author Kitsu.
 */

public class Login extends JPanel{
	private Ventana ventana;
	private JTextField textUser;
	private JPasswordField textPass;
	private JLabel lblPassword;
	private JButton textRegister;
	private JLabel lblRegister;
	private JLabel lblForgetPass;
	private JLabel lblBackground;
	
	
	public Login(Ventana v) {
		super();
		ventana=v;
		setSize(new Dimension(594, 365));
		setBackground(Color.LIGHT_GRAY);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
	
		
		JSeparator separator = new JSeparator();
		separator.setBounds(34, 244, 514, 7);
		add(separator);
		
		JLabel lblIconKapow = new JLabel("");
		lblIconKapow.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconKapow.setIcon(new ImageIcon("img\\logo.png"));
		lblIconKapow.setBounds(0, 13, 594, 89);
		add(lblIconKapow);
		
		JButton btnIni = new JButton("Iniciar");
		btnIni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection conn;
				try {
					conn = DriverManager.getConnection(
							"jdbc:mysql://51.158.162.242:3306/Kapow",
							"kitsu", "toor");
				
				
				PreparedStatement loginStatement
                = conn.prepareStatement(
                        "select * from user where nUser=? "
                        + "and nPassword=? ");
				
		String pass = String.copyValueOf(textPass.getPassword());
		String nUser = textUser.getText();
		
		
		
		
        loginStatement.setString(1, nUser);
        loginStatement.setString(2, pass);
        ResultSet foundUser = loginStatement.executeQuery();
        if (foundUser.next()) {
        	
        	 try {
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
	 				
        	String userReg = foundUser.getString("nUser");
        	foundUser.close();
        	
        	//JOptionPane.showMessageDialog(null, "Loged as " +userReg + ", Welcome!");
        	
        	textUser.setText("");
			textPass.setText("");
        	v.setLoadScreen();
        	
        	
		}else {
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
		
		textUser = new JTextField();
		textUser.setBounds(205, 115, 273, 30);
		add(textUser);
		textUser.setColumns(10);
		
		textPass = new JPasswordField();
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
		
		textRegister = new JButton("Registrar");
		textRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUser.setText("");
				textPass.setText("");
				v.setPantallaRegistro();
			}
		});
		textRegister.setFont(new Font("Consolas", Font.BOLD, 13));
		
		
		textRegister.setBounds(371, 264, 106, 22);
		add(textRegister);
		
		JButton textRecu = new JButton("Recuperar");
		textRecu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.setPantallaRecuperar();
			}
		});
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
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("img\\wp600.png"));
		lblBackground.setBounds(0, 0, 594, 365);
		add(lblBackground);
	}
}
