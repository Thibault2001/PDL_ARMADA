package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErrorWindowsRegisteringForm {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErrorWindowsRegisteringForm window = new ErrorWindowsRegisteringForm();
					Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
					window.frame.setLocation((screen.width - window.frame.getSize().width)/2,(screen.height - window.frame.getSize().height)/2);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Applies the feature "Quitter"
	 */
	private void Ok() {
		try {
			frame.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public ErrorWindowsRegisteringForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 525, 189);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Veuillez vous assurer que tous les champs ont bien \u00E9t\u00E9 compl\u00E9t\u00E9s s'il vous pla\u00EEt");
		lblNewLabel.setBounds(18, 36, 491, 58);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //Fermeture de la fenetre 
				Ok();
			}
		});
		btnNewButton.setBounds(212, 111, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}