package ui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class LoginView {

	private JFrame frmFutbol;
	private JButton loginButton;
	private JTextField usernameField;
	private JTextField passwordField;
	
	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
		frmFutbol.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFutbol = new JFrame();
		frmFutbol.setTitle("Futbol");
		frmFutbol.setBounds(100, 100, 538, 380);
		frmFutbol.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFutbol.getContentPane().setLayout(null);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(272, 180, 89, 23);
		frmFutbol.getContentPane().add(loginButton);
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(163, 180, 89, 23);
		frmFutbol.getContentPane().add(registerButton);
		
		usernameField = new JTextField();
		usernameField.setBounds(163, 84, 195, 23);
		frmFutbol.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(163, 132, 195, 23);
		frmFutbol.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		JLabel titleLabel = new JLabel("Inicio de sesión");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titleLabel.setBounds(121, 31, 269, 23);
		frmFutbol.getContentPane().add(titleLabel);
	}
}
