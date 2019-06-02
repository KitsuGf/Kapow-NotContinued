package interfac;


import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import user.User;
import java.awt.Font;
import javax.swing.SwingConstants;

import archivetype.Archive;

import java.awt.Color;


/**
 * Interface for MainPanel 
 * 
 * @author Kitsu.
 */

public class MainPane extends JPanel{
	
	/**
	 * MainPanel interface, this panel have buttons for upload comic,
	 * see the profile of the user and see the comics
	 * 
	 *@Ventana @Login @User
	 */
	
	
	private Ventana ventana;
	private User usuario;
	private Login login;
	
	
	public MainPane(Ventana v) {
		super();
		ventana =v;
		setSize(new Dimension(1280, 720));
		setLayout(null);
		
		//JPanel Profile
		JPanel profile = new JPanel();
		profile.setOpaque(false);
		profile.setBounds(10, 13, 252, 286);
		add(profile);
		profile.setLayout(null);
		
		
		//JLabels
		JLabel lblUser = new JLabel();
		lblUser.setForeground(Color.BLACK);
		lblUser.setBackground(new Color(0, 0, 0));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Consolas", Font.BOLD, 35));
		lblUser.setText(v.getUsuario().getnUser());
		lblUser.setBounds(29, 241, 189, 35);
		profile.add(lblUser);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("img\\avatar3.png"));
		label_1.setBounds(0, 0, 252, 286);
		profile.add(label_1);
		
		JPanel colection = new JPanel();
		colection.setOpaque(false);
		colection.setBounds(274, 13, 994, 340);
		add(colection);
		
		//Function array to walk the tree path and find the folders of genres
		File[] genComic = Archive.listarGeneros();
		for (int i = 0; i < genComic.length ; i++) {
			JButton boton = new JButton(genComic[i].getName());
			boton.setVisible(true);
			colection.add(boton);
			colection.revalidate();
			colection.repaint();
		}
		
		
		//A lot of trys of my self to make this work correctly
		/*
		JButton btnMostrarColeccion = new JButton("Mostrar coleccion");
		btnMostrarColeccion.setBounds(431, 23, 158, 25);
		btnMostrarColeccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String path = "./comic/"; 

		        String files;
		        File folder = new File(path);
		        File[] listOfFiles = folder.listFiles(); 

		        or (int i = 0; i < listOfFiles.length; i++)         {

		            if (!listOfFiles[i].isFile())             {
		                files = listOfFiles[i].getName();
		                System.out.println(files);
		                JButton boton = new JButton (listOfFiles[i.getName()]);
		            }
		        }
				
				
				
				/*File[] genComic = Archive.listarGeneros();
				for (int i = 0; i < genComic.length ; i++) {
					JButton boton = new JButton(genComic[i].getName());
					boton.setVisible(true);
					
					colection.add(boton);
					
				}
			}
				
		});*/
		colection.setLayout(null);
		//colection.add(btnMostrarColeccion);
		
		//More Labels
		//Layer for the label comics
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("img\\comics.png"));
		label_3.setBounds(0, 0, 994, 340);
		colection.add(label_3);
		
		JPanel expose = new JPanel();
		expose.setOpaque(false);
		expose.setBounds(274, 367, 994, 340);
		add(expose);
		expose.setLayout(null);
		//Layer for the label comics
		JLabel label_4 = new JLabel("");
		label_4.setBounds(0, 0, 994, 340);
		label_4.setIcon(new ImageIcon("img\\comics.png"));
		expose.add(label_4);
		
		JPanel buttons = new JPanel();
		buttons.setOpaque(false);
		buttons.setBounds(10, 367, 252, 340);
		add(buttons);
		buttons.setLayout(null);
		
		//Button for upload comics and coverpage
		JButton btnSubirArchivo = new JButton("Subir Archivo");
		btnSubirArchivo.setFont(new Font("Consolas", Font.BOLD, 13));
		btnSubirArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				v.setPantallaUploadComic();
			}
		});
		btnSubirArchivo.setBounds(56, 83, 130, 46);
		buttons.add(btnSubirArchivo);
		
		
		//JButton for go back 
		JButton btnVolver = new JButton("Desconectar");
		btnVolver.setFont(new Font("Consolas", Font.BOLD, 13));
		btnVolver.setBounds(56, 249, 130, 46);
		buttons.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.setPantallaLogin();
				
			}
		});

		//Button for showing the profile of the user
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setFont(new Font("Consolas", Font.BOLD, 13));
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.setShowProfile();
			}
		});
		btnPerfil.setBounds(56, 25, 130, 46);
		buttons.add(btnPerfil);
		//Layer for the button
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("img\\buttonera.png"));
		label_2.setBounds(0, 0, 250, 340);
		buttons.add(label_2);
		
		//Background label
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1280, 720);
		label.setIcon(new ImageIcon("img\\wp720.png"));
		add(label);
	}
}
