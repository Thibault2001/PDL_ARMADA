import javax.swing.*;
import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JTextField;

import DAO.*;
import Lot1.*;;

public class SupprimerZone 
{

	private JFrame frameSupprimerZone;
	private JTextField textFieldNumZone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					SupprimerZone window = new SupprimerZone();
					window.frameSupprimerZone.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SupprimerZone() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frameSupprimerZone = new JFrame();
		frameSupprimerZone.setTitle("Supprimer une zone");
		frameSupprimerZone.setBounds(100, 100, 812, 697);
		frameSupprimerZone.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSupprimerZone.getContentPane().setLayout(null);
		
		JButton btn_retour = new JButton("Retour");
		btn_retour.setForeground(Color.BLACK);
		btn_retour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_retour.setBackground(Color.BLACK);
		btn_retour.setBounds(44, 607, 175, 27);
		btn_retour.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ZoneGUI nextpage = new ZoneGUI();
				nextpage.main(null);
				frameSupprimerZone.dispose();
			}
		});
		frameSupprimerZone.getContentPane().add(btn_retour);
		
		textFieldNumZone = new JTextField();
		textFieldNumZone.setBounds(500, 148, 262, 27);
		frameSupprimerZone.getContentPane().add(textFieldNumZone);
		textFieldNumZone.setColumns(10);
		
		JButton btn_valider = new JButton("Valider");
		btn_valider.setForeground(Color.BLACK);
		btn_valider.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_valider.setBackground(Color.BLACK);
		btn_valider.setBounds(587, 607, 175, 27);
		btn_valider.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textFieldNumZone.getText().length()>0 && textFieldTailleZone.getText().length()>0 && textFieldRiveZone.getText().length()>0)
				{
					Zone Zone = new Zone(textFieldNumZone.getText(),textFieldTailleZone.getText(),textFieldRiveZone.getText());
					new ZoneDAO().delete(Zone);
					
					Supprimer_Zone_fin_GUI nextpage = new Supprimer_Zone_fin_GUI();
					nextpage.main(null);
					frameSupprimerZone.dispose();
				}
				else
				{
					Supprimer_Zone_erreur_GUI nextpage = new Supprimer_Zone_erreur_GUI();
					nextpage.main(null);
					frameSupprimerZone.dispose();
				}
			}
		});
		frameSupprimerZone.getContentPane().add(btn_valider);
		
		JLabel lblSupprimerUnZone = new JLabel("Supprimer une zone");
		lblSupprimerUnZone.setFont(new Font("Engravers MT", Font.PLAIN, 25));
		lblSupprimerUnZone.setBounds(138, 45, 539, 46);
		frameSupprimerZone.getContentPane().add(lblSupprimerUnZone);
		
		JLabel labelNumeroZone = new JLabel("Nom de la zone :");
		labelNumeroZone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelNumeroZone.setBounds(44, 156, 189, 19);
		frameSupprimerZone.getContentPane().add(labelNumeroZone);
	}
}
