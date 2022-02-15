package ui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import mainApp.FutbolApp;
import models.Account;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class LoginView {

	private JFrame frmLogin;

	private JButton loginButton, registerButton;
	private JLabel titleLabel, titleError, titleEmail, titlePassword;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private FutbolApp futbolApp;

	/**
	 * Create the application.
	 */
	public LoginView(FutbolApp futbolApp) {
		this.futbolApp = futbolApp;
		futbolApp.getUserDAO().createUsername(new Account("Fran", "1234"));
		futbolApp.getUserDAO().showUsersConsole();
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

		titleLabel = new JLabel("Login account");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		titleLabel.setBounds(124, 23, 269, 23);
		frmLogin.getContentPane().add(titleLabel);

		titleError = new JLabel("");
		titleError.setForeground(Color.RED);
		titleError.setHorizontalAlignment(SwingConstants.LEFT);
		titleError.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		titleError.setBounds(150, 275, 327, 23);
		frmLogin.getContentPane().add(titleError);

		titleEmail = new JLabel("Email");
		titleEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleEmail.setBounds(150, 89, 63, 14);
		frmLogin.getContentPane().add(titleEmail);

		titlePassword = new JLabel("Password");
		titlePassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		titlePassword.setBounds(150, 157, 102, 14);
		frmLogin.getContentPane().add(titlePassword);

		if (futbolApp.getUserDAO().usernameList.isEmpty()) {
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

		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					usernameField.requestFocus();
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					loginButtonAction();
				}
			}
		});

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginButtonAction();
			}
		});

		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.setVisible(false);
				new RegisterView(futbolApp);
			}
		});
	}
	
	public void loginButtonAction() {
		String username = usernameField.getText();
		String password = new String(passwordField.getPassword());
		if (futbolApp.getUserDAO().login(username, password)) {
			frmLogin.dispose();
			futbolApp.setTeamview(new TeamView(futbolApp));
		} else {
			if (futbolApp.getUserDAO().usernameList.isEmpty()) {
				titleError.setText("Not there accounts registered in the database");
			} else {
				titleError.setText("The account or password is incorrect");
			}
		}
	}
}
