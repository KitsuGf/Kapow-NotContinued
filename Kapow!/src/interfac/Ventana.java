package interfac;

import java.awt.Dimension;

import javax.swing.JFrame;

import user.User;
import user.UserReg;

import java.awt.Toolkit;

/**
 * Class of Common data between Archive and User.
 * This class have the atributes: Name and Date shared with Archive and user.
 * @author Kitsu.
 */

public class Ventana extends JFrame {

	private Login login;
	private Register registro;
	private MainPane mainpanel;
	private CorrectAC registerCorrect;
	private ForgetPass passLoss;
	private UploadComic uploadComic;
	private Profile showProfile;
	private User usuario;
	private UserReg usuarioRegistrado;
	private LoadScreen loadScreen;
	private Ventana ventana;
	
	
	public UserReg getUsuarioReg() {
		return usuarioRegistrado;
		
	}
	public void setUsuarioReg(UserReg usuarioReg) {
		this.usuarioRegistrado = usuarioReg;
	}
	
	
	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Ventana() {
		
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
	
	public void setPantallaLogin() {
		this.setSize(new Dimension(600, 400));
		this.registro.setVisible(false);
		this.login.setVisible(true);
		this.setContentPane(this.login);
	}
	
	public void setPantallaRegistro() {
		setSize(new Dimension(899, 615));
		this.login.setVisible(false);
		this.registro.setVisible(true);
		this.setContentPane(this.registro);
	}
	
	public void setPantallaMain() {
		setSize(new Dimension(1280, 752));
		this.mainpanel=new MainPane(this);
		this.setContentPane(this.mainpanel);
		
	}
	
	public void setPantallaRegistroCorrecto() {
		setSize(new Dimension(1280, 752));
		this.setContentPane(this.registerCorrect);
		
		
	}
	
	public void setPantallaRecuperar() {
		setSize(new Dimension(600, 400));
		this.setContentPane(this.passLoss);
		
		
	}
	
	public void setPantallaUploadComic() {
		this.setContentPane(this.uploadComic);
		setSize(new Dimension(899, 615));
		
	}
	
	public void setShowProfile() {
		this.setContentPane(this.showProfile);
		this.showProfile=new Profile(this);
		setSize(new Dimension(899, 615));
		
	}
	
	public void setLoadScreen() {
		this.loadScreen = new LoadScreen(this);
		setSize(1280, 752);
		this.login.setVisible(false);
		this.setContentPane(this.loadScreen);
		this.loadScreen.setVisible(true);
		
		
		
	}
}

