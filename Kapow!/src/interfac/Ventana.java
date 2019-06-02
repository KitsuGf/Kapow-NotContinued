package interfac;

import java.awt.Dimension;

import javax.swing.JFrame;

import user.User;


import java.awt.Toolkit;

/**
 * This class is the JFrame for all the JPanel
 * 
 * @author Kitsu.
 */

public class Ventana extends JFrame {
	
	
	/**
	 * This class is the JFrame for all the JPanel
	 * 
	 * The class get all the panels of the app
	 * 
	 * @author Kitsu.
	 */

	//Var for Ventana
	private Login login;
	private Register registro;
	private MainPane mainpanel;
	private CorrectAC registerCorrect;
	private ForgetPass passLoss;
	private UploadComic uploadComic;
	private Profile showProfile;
	private User usuario;
	private LoadScreen loadScreen;
	private Ventana ventana;
	
	
	//Getter for User
	public User getUsuario() {
		return usuario;
	}

	//Setter of USer
	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Ventana() {
		//Set various panels
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\logo.png"));
		setResizable(false);
		setSize(new Dimension(600, 400));
		this.setTitle("Kapow!");
		this.login=new Login(this);
		this.registro=new Register(this);
		this.registerCorrect=new CorrectAC(this);
		this.passLoss = new ForgetPass(this);
		this.uploadComic = new UploadComic(this);
		this.setVisible(true);
		setPantallaLogin();
		
	}
	//Set the JPanel of login screen
	public void setPantallaLogin() {
		this.setSize(new Dimension(600, 400));
		this.registro.setVisible(false);
		this.login.setVisible(true);
		this.setContentPane(this.login);
	}
	//Set the JPanel of register screen
	public void setPantallaRegistro() {
		setSize(new Dimension(899, 610));
		this.login.setVisible(false);
		this.registro.setVisible(true);
		this.setContentPane(this.registro);
	}
	//Set the JPanel of Main screen
	public void setPantallaMain() {
		setSize(new Dimension(1280, 752));
		this.mainpanel=new MainPane(this);
		this.setContentPane(this.mainpanel);
		
	}
	//Set the JPanel of correct register screen
	public void setPantallaRegistroCorrecto() {
		setSize(new Dimension(899, 620));
		this.setContentPane(this.registerCorrect);
		
		
	}
	//Set the JPanel of recover screen
	public void setPantallaRecuperar() {
		setSize(new Dimension(600, 400));
		this.setContentPane(this.passLoss);
		
		
	}
	//Set the JPanel of upload comic screen
	public void setPantallaUploadComic() {
		this.setContentPane(this.uploadComic);
		setSize(new Dimension(899, 647));
		
	}
	//Set the JPanel of showprofile screen
	public void setShowProfile() {
		this.showProfile=new Profile(this);
		setSize(new Dimension(899, 615));
		this.setContentPane(this.showProfile);
		
	}
	
	//Set the JPanel of load screen
	public void setLoadScreen() {
		this.loadScreen = new LoadScreen(this);
		setSize(1280, 752);
		this.login.setVisible(false);
		this.setContentPane(this.loadScreen);
		this.loadScreen.setVisible(true);
		
		
		
	}
}

