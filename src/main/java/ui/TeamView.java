package ui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import dao.UsernameDAO;
import models.Username;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class TeamView {

	private JFrame frmFutbol;
	private JButton loginButton;
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	private UsernameDAO userDAO = new UsernameDAO();
	
	/**
	 * Create the application.
	 */
	public TeamView() {
		userDAO.createUsername(new Username("Fran", "1234"));
		initialize();
		setListeners();
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
		
		userDAO.showUsersConsole();
		
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(163, 132, 195, 23);
		frmFutbol.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		JLabel titleLabel = new JLabel("Inicio de sesión");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titleLabel.setBounds(121, 31, 269, 23);
		frmFutbol.getContentPane().add(titleLabel);
	}
	
	public void setListeners() {
		usernameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_DOWN) {
					passwordField.requestFocus();	
				}
			}
		});
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				if (userDAO.login(username,password)) {
					
				}
				
			}
		});
	}
}
