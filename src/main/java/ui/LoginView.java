package ui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import dao.UserDAO;
import models.Account;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class LoginView extends UserDAO {

	private JFrame frmLogin;

	private JButton loginButton, registerButton;
	private JLabel titleLabel, titleError, titleEmail, titlePassword;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public LoginView() {
		createUsername(new Account("Fran", "1234"));

		initialize();
		setListeners();
		frmLogin.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Futbol");
		frmLogin.setBounds(100, 100, 538, 380);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		showUsersConsole();

		loginButton = new JButton("Login");
		loginButton.setBounds(269, 230, 89, 23);
		frmLogin.getContentPane().add(loginButton);

		registerButton = new JButton("Register");
		registerButton.setBounds(163, 230, 89, 23);
		frmLogin.getContentPane().add(registerButton);

		usernameField = new JTextField();
		usernameField.setBounds(163, 114, 195, 23);
		frmLogin.getContentPane().add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(163, 182, 195, 23);
		frmLogin.getContentPane().add(passwordField);
		passwordField.setColumns(10);

		titleLabel = new JLabel("Inicio de sesión");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		titleLabel.setBounds(124, 11, 269, 23);
		frmLogin.getContentPane().add(titleLabel);

		titleError = new JLabel("");
		titleError.setForeground(Color.RED);
		titleError.setHorizontalAlignment(SwingConstants.LEFT);
		titleError.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		titleError.setBounds(150, 243, 327, 23);
		frmLogin.getContentPane().add(titleError);

		titleEmail = new JLabel("Email");
		titleEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleEmail.setBounds(150, 89, 63, 14);
		frmLogin.getContentPane().add(titleEmail);

		titlePassword = new JLabel("Password");
		titlePassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		titlePassword.setBounds(150, 157, 102, 14);
		frmLogin.getContentPane().add(titlePassword);

		if (usernameList.isEmpty()) {
			titleError.setText("Not there accounts registered in the database");
			loginButton.setVisible(false);
			registerButton.setBounds(215, 182, 89, 23);
		}

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
				if (login(username, password)) {
					frmLogin.dispose();
					new TeamView();
				} else {
					if (usernameList.isEmpty()) {
						titleError.setText("Not there accounts registered in the database");
					} else {
						titleError.setText("The account or password is incorrect");
					}
				}
			}
		});
	}
}
