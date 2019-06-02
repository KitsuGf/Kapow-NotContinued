package interfac;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import java.awt.Color;


/**
 * Class for making a load screen after loging.
 * 
 * 
 * @author Kitsu.
 */


public class LoadScreen extends JPanel {
	
	
	/**
	* LoadScreen class
	* 
	* The class make a load screen what show a ProgressBar maked with timer, when the ProgressBar fills full, 
	* loadScreen set the next jpanel to MainPanel.
	* @Ventana @Timer @ActionListener
	*/
	
	
	//Vars needed for make the loadscreen
	private Ventana ventana;
	private Timer t;
	private ActionListener al;
	
	public LoadScreen(Ventana v) {
		super();
		ventana=v;
		setSize(new Dimension(1280, 752));
		setLayout(null);
		
		
		//ProgressBar component in swing
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBorder(null);
		progressBar.setOpaque(true);
		progressBar.setStringPainted(true);
		progressBar.setForeground(new Color(128, 0, 0));
		progressBar.setBounds(290, 664, 700, 44);
		add(progressBar);
		
		
		//Make a new ActionListener
		 al = new ActionListener() {
			 
			@Override
			//ActionPerformed for set the value, get the value, stop and set next Jpanel
			public void actionPerformed(ActionEvent e) {
				//If the progrssBar fill at 100, if the progressBar is less than 100
				//the progressBar set the value with getValue
				//+3 means the intervals to fill the progressbar
				if (progressBar.getValue() < 100) {
					progressBar.setValue(progressBar.getValue()+3);
				}else {
					//If the progressBar is 100, then stop the progressbar and set the next JPanel
					//PantallaMain in this case
					t.stop();
					v.setPantallaMain();
				}
			}

		};
		//Set the timer to get full the progress bar
		t = new Timer(150, al);
		//Timer start
		t.start();
		
		//This label is the loadScreenGif
		JLabel label = new JLabel("");
		label.setLabelFor(this);
		label.setBounds(0, 0, 1280, 720);
		label.setIcon(new ImageIcon("img\\loadScren2.gif"));
		add(label);
	}
}