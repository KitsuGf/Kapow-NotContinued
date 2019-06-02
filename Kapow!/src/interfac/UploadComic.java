package interfac;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JMenuItem;
import java.awt.Button;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

;

/**
 * This class is an interface for the UploadComic feature, here the user can 
 * Upload a comic with the info of the comic and a cover page 
 * 
 * @author Kitsu.
 */

public class UploadComic extends JPanel{
	
	private Ventana ventana;
	JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	String complete;
	String genSelected;
	SimpleDateFormat formDate;
	private JTextField selecComic;
	private JTextField selecPort;
	
	public UploadComic(Ventana v) {
		
		super();
		setSize(new Dimension(899, 615));
		setLayout(null);
		ventana =v;
		
		
		formDate = new SimpleDateFormat("dd/MM/yyyy");

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.addMouseListener(new MouseAdapter() {
		});
		dateChooser.setBounds(154, 480, 143, 27);
		add(dateChooser);
		
		JTextField textName = new JTextField();
		textName.setBounds(154, 102, 272, 28);
		add(textName);
		
		JTextField textnPag = new JTextField();
		textnPag.setBounds(154, 154, 272, 28);
		add(textnPag);
		
		JTextField textFran = new JTextField();
		textFran.setBounds(154, 264, 272, 28);
		add(textFran);
		
		JTextField textDistro = new JTextField();
		textDistro.setBounds(154, 319, 272, 28);
		add(textDistro);
		
		JTextField textSaga = new JTextField();
		textSaga.setBounds(154, 371, 272, 28);
		add(textSaga);
		
		JTextField textAuthor = new JTextField();
		textAuthor.setBounds(154, 531, 272, 28);
		add(textAuthor);
		
		JLabel lblInfoComic = new JLabel("Datos del Comic");
		lblInfoComic.setForeground(Color.WHITE);
		lblInfoComic.setFont(new Font("Consolas", Font.BOLD, 28));
		lblInfoComic.setBounds(96, 15, 225, 34);
		add(lblInfoComic);
		
		JLabel label_1 = new JLabel("Nombre");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Consolas", Font.BOLD, 23));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(12, 103, 78, 27);
		add(label_1);
		
		JLabel lblPaginas = new JLabel("Paginas");
		lblPaginas.setForeground(Color.WHITE);
		lblPaginas.setFont(new Font("Consolas", Font.BOLD, 23));
		lblPaginas.setBackground(Color.WHITE);
		lblPaginas.setBounds(12, 155, 91, 27);
		add(lblPaginas);
		
		
		
		JLabel lblcompleta = new JLabel("\u00BFCompleta?");
		lblcompleta.setForeground(Color.WHITE);
		lblcompleta.setFont(new Font("Consolas", Font.BOLD, 23));
		lblcompleta.setBackground(Color.WHITE);
		lblcompleta.setBounds(12, 209, 130, 27);
		add(lblcompleta);
		
		JLabel lblFranquicia = new JLabel("Franquicia");
		lblFranquicia.setForeground(Color.WHITE);
		lblFranquicia.setFont(new Font("Consolas", Font.BOLD, 23));
		lblFranquicia.setBackground(Color.WHITE);
		lblFranquicia.setBounds(12, 265, 130, 27);
		add(lblFranquicia);
		
		JLabel lblDistribuidora = new JLabel("Distribuye");
		lblDistribuidora.setForeground(Color.WHITE);
		lblDistribuidora.setFont(new Font("Consolas", Font.BOLD, 23));
		lblDistribuidora.setBackground(Color.WHITE);
		lblDistribuidora.setBounds(12, 320, 130, 27);
		add(lblDistribuidora);
		
		JLabel lblSaga = new JLabel("Saga");
		lblSaga.setForeground(Color.WHITE);
		lblSaga.setFont(new Font("Consolas", Font.BOLD, 23));
		lblSaga.setBackground(Color.WHITE);
		lblSaga.setBounds(12, 372, 52, 27);
		add(lblSaga);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Consolas", Font.BOLD, 23));
		lblGenero.setBackground(Color.WHITE);
		lblGenero.setBounds(12, 428, 78, 27);
		add(lblGenero);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Consolas", Font.BOLD, 23));
		lblFecha.setBackground(Color.WHITE);
		lblFecha.setBounds(12, 480, 65, 27);
		add(lblFecha);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setForeground(Color.WHITE);
		lblAuthor.setFont(new Font("Consolas", Font.BOLD, 23));
		lblAuthor.setBackground(Color.WHITE);
		lblAuthor.setBounds(12, 532, 78, 27);
		add(lblAuthor);
		
		JLabel lblSubirComic = new JLabel("Subir comic");
		lblSubirComic.setForeground(Color.WHITE);
		lblSubirComic.setFont(new Font("Consolas", Font.BOLD, 23));
		lblSubirComic.setBackground(Color.WHITE);
		lblSubirComic.setBounds(647, 87, 143, 27);
		add(lblSubirComic);
		
		JLabel lblSubirPortada = new JLabel("Subir portada");
		lblSubirPortada.setForeground(Color.WHITE);
		lblSubirPortada.setFont(new Font("Consolas", Font.BOLD, 23));
		lblSubirPortada.setBackground(Color.WHITE);
		lblSubirPortada.setBounds(621, 209, 169, 27);
		add(lblSubirPortada);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(27, 62, 373, 12);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(502, 62, 373, 12);
		add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.WHITE);
		separator_2.setBackground(Color.WHITE);
		separator_2.setBounds(454, 116, 2, 443);
		add(separator_2);
		
		JLabel lblSubeTuComic = new JLabel("Sube tu comic");
		lblSubeTuComic.setForeground(Color.WHITE);
		lblSubeTuComic.setFont(new Font("Consolas", Font.BOLD, 28));
		lblSubeTuComic.setBounds(595, 15, 195, 34);
		add(lblSubeTuComic);
		
		Button uploadComic = new Button("...");
		uploadComic.setFont(new Font("Dialog", Font.BOLD, 12));
		uploadComic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				    JFileChooser chooser = new JFileChooser();
				    //chooser.setCurrentDirectory(new File("comic\\"));
				    chooser.getCurrentDirectory();
				    int retrival = chooser.showSaveDialog(null);
				    if (retrival == JFileChooser.APPROVE_OPTION) {
				        try {
				            FileWriter fw = new FileWriter(chooser.getSelectedFile());
				            String sb = chooser.getSelectedFile().toString();
				            fw.write(sb);
				        } catch (Exception ex) {
				            ex.printStackTrace();
				        }
				    }

				
				/*
				
				
				fc.setDialogTitle("Selecciona un comic");
				int returnValue = fc.showOpenDialog(null);
				// int returnValue = jfc.showSaveDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fc.getSelectedFile();
					String pathFile = selectedFile.getAbsolutePath();
					selecComic.setText(pathFile);
					//System.out.println(selectedFile.getAbsolutePath());
				}*/
			}
		});
		uploadComic.setBounds(810, 140, 79, 24);
		add(uploadComic);
		
		
		ButtonGroup comp=new ButtonGroup();
		JRadioButton rdbtnSi = new JRadioButton("Si");
		rdbtnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnSi.isSelected()) {
					complete = "Si";
				}
			}
		});
		rdbtnSi.setForeground(Color.WHITE);
		rdbtnSi.setFont(new Font("Consolas", Font.BOLD, 23));
		rdbtnSi.setOpaque(false);
		rdbtnSi.setBounds(209, 205, 55, 35);
		add(rdbtnSi);
		comp.add(rdbtnSi);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNo.isSelected()) {
					complete = "No";
				}
			}
		});
		
		rdbtnNo.setForeground(Color.WHITE);
		rdbtnNo.setFont(new Font("Consolas", Font.BOLD, 23));
		rdbtnNo.setOpaque(false);
		rdbtnNo.setBounds(286, 205, 55, 35);
		add(rdbtnNo);
		comp.add(rdbtnNo);
		
		
		Button uploadImg = new Button("...");
		uploadImg.setFont(new Font("Dialog", Font.BOLD, 12));
		uploadImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fc.setDialogTitle("Selecciona la portada");
				fc.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Select only PNG, JPEG, JPG", "png", "jpeg", "jpg");
				fc.addChoosableFileFilter(filter);
				int returnValue = fc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					System.out.println(fc.getSelectedFile().getPath());
				}
				String pathPort = fc.getSelectedFile().getPath();
				selecPort.setText(pathPort);
			}
		});
		uploadImg.setBounds(810, 264, 79, 24);
		add(uploadImg);
		
		JButton btnSubirComic = new JButton("Subir comic");
		btnSubirComic.setFont(new Font("Consolas", Font.BOLD, 13));
		btnSubirComic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Statement registerStatement;
					Connection conn = DriverManager.getConnection(
							"jdbc:mysql://51.158.162.242:3306/Kapow",
							"kitsu", "toor");
					registerStatement = conn.createStatement();	
					

					String insert =	"insert into archive (nameC,nPage,sComp,fran,distro,saga,author,genre,dateC)"
							+ " values('" 
							+ textName.getText() + "',"
							+ textnPag.getText() + ",'"
							+ complete + "','"
							+ textFran.getText() + "','"
							+ textDistro.getText() + "','"	
							+ textSaga.getText() + "','"
							+ textAuthor.getText() + "','"
							+ genSelected + "',"
							+ "STR_TO_DATE('"+formDate.format(dateChooser.getDate())+ "','%d/%m/%Y')"
							+ ");";
					registerStatement.executeUpdate(insert);
					
					registerStatement.close();
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}	

			}
		});
		
		
		btnSubirComic.setBounds(647, 323, 130, 46);
		add(btnSubirComic);
		
		selecComic = new JTextField();
		selecComic.setBounds(518, 138, 272, 28);
		add(selecComic);
		
		selecPort = new JTextField();
		selecPort.setBounds(518, 262, 272, 28);
		add(selecPort);
		

		ButtonGroup genresC=new ButtonGroup();
		JRadioButton rdbtnDetectives = new JRadioButton("Detectives");
		rdbtnDetectives.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnDetectives.isSelected()) {
					genSelected = "Detectives";
				}
			}
		});
		rdbtnDetectives.setForeground(Color.WHITE);
		rdbtnDetectives.setFont(new Font("Consolas", Font.BOLD, 17));
		rdbtnDetectives.setOpaque(false);
		rdbtnDetectives.setBounds(146, 428, 119, 29);
		add(rdbtnDetectives);
		genresC.add(rdbtnDetectives);
		
		JRadioButton radioHumor = new JRadioButton("Humor");
		radioHumor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioHumor.isSelected()) {
					genSelected = "Humor";
				}
			}
		});
		radioHumor.setForeground(Color.WHITE);
		radioHumor.setFont(new Font("Consolas", Font.BOLD, 17));
		radioHumor.setOpaque(false);
		radioHumor.setBounds(262, 428, 73, 29);
		add(radioHumor);
		genresC.add(radioHumor);
		
		JRadioButton radioShero = new JRadioButton("SuperHeroe");
		radioShero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioShero.isSelected()) {
					genSelected = "SuperHeroe";
				}
			}
		});
		radioShero.setForeground(Color.WHITE);
		radioShero.setFont(new Font("Consolas", Font.BOLD, 17));
		radioShero.setOpaque(false);
		radioShero.setBounds(334, 428, 119, 29);
		add(radioShero);
		genresC.add(radioShero);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Consolas", Font.BOLD, 13));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				v.setPantallaMain();
			}
		});
		btnVolver.setBounds(757, 556, 130, 46);
		add(btnVolver);
		
		
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img\\900.png"));
		label.setBounds(0, 0, 899, 615);
		add(label);
		
		
		
		
	}
	}
	
	