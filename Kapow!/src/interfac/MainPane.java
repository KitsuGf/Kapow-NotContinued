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




;

/**
 * Class of Common data between Archive and User.
 * This class have the atributes: Name and Date shared with Archive and user.
 * @author Kitsu.
 */

public class MainPane extends JPanel{
	
	private Ventana ventana;
	private User usuario;
	private Login login;
	
	
	public MainPane(Ventana v) {
		super();
		ventana =v;
		setSize(new Dimension(1280, 720));
		setLayout(null);
		
		
		JPanel profile = new JPanel();
		profile.setOpaque(false);
		profile.setBounds(10, 13, 252, 286);
		add(profile);
		profile.setLayout(null);
		
		
		
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
		
		
		File[] genComic = Archive.listarGeneros();
		for (int i = 0; i < genComic.length ; i++) {
			JButton boton = new JButton(genComic[i].getName());
			boton.setVisible(true);
			colection.add(boton);
			colection.revalidate();
			colection.repaint();
		}
		
		
		JButton btnMostrarColeccion = new JButton("Mostrar coleccion");
		btnMostrarColeccion.setBounds(431, 23, 158, 25);
		btnMostrarColeccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*String path = "./comic/"; 

		        String files;
		        File folder = new File(path);
		        File[] listOfFiles = folder.listFiles(); 

		        or (int i = 0; i < listOfFiles.length; i++)         {

		            if (!listOfFiles[i].isFile())             {
		                files = listOfFiles[i].getName();
		                System.out.println(files);
		                JButton boton = new JButton (listOfFiles[i.getName()]);
		            }
		        }*/
				
				
				
				/*File[] genComic = Archive.listarGeneros();
				for (int i = 0; i < genComic.length ; i++) {
					JButton boton = new JButton(genComic[i].getName());
					boton.setVisible(true);
					
					colection.add(boton);
					
				}*/
			}
				
		});
		colection.setLayout(null);
		
		colection.add(btnMostrarColeccion);
		
	
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("img\\comics.png"));
		label_3.setBounds(0, 0, 994, 340);
		colection.add(label_3);
		
		JPanel expose = new JPanel();
		expose.setOpaque(false);
		expose.setBounds(274, 367, 994, 340);
		add(expose);
		expose.setLayout(null);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(0, 0, 994, 340);
		label_4.setIcon(new ImageIcon("img\\comics.png"));
		expose.add(label_4);
		
		JPanel buttons = new JPanel();
		buttons.setOpaque(false);
		buttons.setBounds(10, 367, 252, 340);
		add(buttons);
		buttons.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(56, 242, 130, 40);
		buttons.add(btnVolver);
		
		JButton btnSubirArchivo = new JButton("Subir Archivo");
		btnSubirArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				v.setPantallaUploadComic();
			}
		});
		btnSubirArchivo.setBounds(56, 83, 130, 40);
		buttons.add(btnSubirArchivo);
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(56, 25, 130, 40);
		buttons.add(btnPerfil);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("img\\buttonera.png"));
		label_2.setBounds(0, 0, 250, 340);
		buttons.add(label_2);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.setPantallaLogin();
			}
		});
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1280, 720);
		label.setIcon(new ImageIcon("img\\wp720.png"));
		add(label);
	}
}
