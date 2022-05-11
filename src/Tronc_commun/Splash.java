package Tronc_commun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import GUI.LogInPage;

public class Splash {

	private JFrame frame;
	private JProgressBar progress;
	private Thread thread;

	/**
	 * Create the application.
	 */
	
	public Splash(String imgPath, String message,String icone)
	{
		initialize();
		
	frame = 
                      new JFrame("Chargement");
                frame.setIconImage(
                      Toolkit.getDefaultToolkit().getImage(icone));//icone de la Jframe
                JPanel panel = 
                     new JPanel();
                panel.setBackground(
                          Color.DARK_GRAY);//Couleur de fond du Panel
                panel.setSize(348,160);
                panel.setBounds(0,0,348,14);
	JLabel texte = 
                        new JLabel(message);//Texte de la String 
	texte.setBounds(107, 203, 243, 14);
                texte.setForeground(Color.WHITE);
                JLabel img = 
                       new JLabel();
                img.setBounds(135, 15, 0, 0);
                img.setIcon(
                         new ImageIcon(imgPath));
	progress = new JProgressBar(0, 100); 
	progress.setBackground(Color.DARK_GRAY);
                        
                panel.setBorder(
                    BorderFactory.createLineBorder(Color.BLACK));
                progress.setStringPainted(true);
               panel.setLayout(null);
                        
               //ajout des éléments
               panel.add(img);
               panel.add(texte);
               panel.add(progress); 
               frame.getContentPane().add(BorderLayout.CENTER, panel);
       frame.setSize(440,250);
           //Pour définir le Splash au milieu de l'écran'
                Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation((screen.width - frame.getSize().width)/2,(screen.height - frame.getSize().height)/2);
             // pour que ca ait vraiement l air d un splash
        	frame.setUndecorated(true);
                frame.setVisible(true);
	frame.setResizable(true);
                //Taille de la barre pour qu'elle corresponde a la taille de la frame
	progress.setBounds(new Rectangle(10, 226, 420, 17));
	
	JLabel lblNewLabel = new JLabel("New label");
	lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Serafini Thibault\\Desktop\\Eclipse\\ARMADA 2023\\src\\GUI\\armada logo.png"));
	lblNewLabel.setBounds(0, 0, 440, 250);
	panel.add(lblNewLabel);
	// Création de thread pour afficher la progression de la barre
                             thread =
                                    new Thread(
                                      new Progression());
                                        thread.start();
    //On peut ajouter un Thread d'une classe de traitement qui implemente un Runnable
    //et les switcher.                
                                        
                                       
	}
public class Progression  implements Runnable
	{
	public void run()
		{
			for (int j = 1; j < 100; j++) 
				{
					progress.setValue(j);
                                                progress.setString(j+" %");
					try
					{
					thread.sleep(30);//determination de la rapiditée de la frame
					}
				catch(Exception e)
					{
                                                        e.printStackTrace();
                                                        frame.dispose();//en cas d' erreur pour pas rester bloqué sur le splash
					}
				}

				frame.dispose(); //fermeture de la frame lorsque le chargement est teminé
                                        
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 290);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash window = new  Splash(null,"Chargement en cours...Veuillez patienter","C:\\Users\\Serafini Thibault\\Desktop\\Eclipse\\ARMADA 2023\\src\\GUI\\armada icon real.png");//Path de l'image qu'on veut ,message,ainsi que l icone de la fenetre
					//window.frame.se
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		int second = java.time.LocalTime.now().getSecond();
		int help = second+5;
		do
		{
			second = java.time.LocalTime.now().getSecond();
		}while(second!=help);
		LogInPage LogPag = new LogInPage();
		LogPag.getFrame().setVisible(true);
	}

}
