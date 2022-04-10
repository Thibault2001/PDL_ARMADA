package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import GUI.Zone.ZoneGUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ErrorSaisie {

	private JFrame frameErrorSaisie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErrorSaisie window = new ErrorSaisie();
					window.frameErrorSaisie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ErrorSaisie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameErrorSaisie = new JFrame();
		frameErrorSaisie.setBounds(100, 100, 450, 300);
		frameErrorSaisie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameErrorSaisie.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Erreur de saisie !\r\n");
		lblNewLabel.setBounds(267, 10, 91, 22);
		frameErrorSaisie.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Serafini Thibault\\Desktop\\Eclipse\\ARMADA 2023\\src\\GUI\\Attention.png"));
		lblNewLabel_1.setBounds(10, 10, 199, 253);
		frameErrorSaisie.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Veuillez v\u00E9rifier votre saisie !!");
		lblNewLabel_2.setBounds(250, 106, 142, 13);
		frameErrorSaisie.getContentPane().add(lblNewLabel_2);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameErrorSaisie.dispose();
			}
		});
		btnOk.setBounds(300, 201, 85, 21);
		frameErrorSaisie.getContentPane().add(btnOk);
	}
}
