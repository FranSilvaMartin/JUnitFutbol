package ui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;

import dao.UserDAO;
import mainApp.FutbolApp;
import models.Account;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class RegisterView extends UserDAO {

	private JFrame frmRegister;

	private JButton registerButton, closeButton;
	private JLabel titleLabel, titleEmail, titlePassword;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JPasswordField passwordField2;
	private FutbolApp futbolApp;
	private JTextArea titleError;

	/**
	 * Create the application.
	 */
	public RegisterView(FutbolApp futbolApp) {
		this.futbolApp = futbolApp;
		initialize();
		setListeners();
		frmRegister.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegister = new JFrame();
		frmRegister.setResizable(false);
		frmRegister.setTitle("Futbol");
		frmRegister.setBounds(100, 100, 538, 441);
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegister.getContentPane().setLayout(null);

		closeButton = new JButton("");
		closeButton.setIcon(new ImageIcon(new File("resources/closeButtonIMG.png").getAbsolutePath()));
		closeButton.setOpaque(false);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setBorderPainted(false);
		closeButton.setBounds(460, 13, 52, 27);
		frmRegister.getContentPane().add(closeButton);

		registerButton = new JButton("Register");
		registerButton.setBounds(215, 258, 89, 23);
		frmRegister.getContentPane().add(registerButton);

		emailField = new JTextField();
		emailField.setBounds(163, 96, 195, 23);
		frmRegister.getContentPane().add(emailField);
		emailField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(163, 155, 195, 23);
		frmRegister.getContentPane().add(passwordField);
		passwordField.setColumns(10);

		titleLabel = new JLabel("Register account");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		titleLabel.setBounds(124, 11, 269, 23);
		frmRegister.getContentPane().add(titleLabel);

		titleEmail = new JLabel("Email");
		titleEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleEmail.setBounds(150, 71, 63, 14);
		frmRegister.getContentPane().add(titleEmail);

		titlePassword = new JLabel("Password");
		titlePassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		titlePassword.setBounds(150, 130, 102, 14);
		frmRegister.getContentPane().add(titlePassword);

		JLabel lblRepeatPassword = new JLabel("Repeat password");
		lblRepeatPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRepeatPassword.setBounds(150, 189, 154, 23);
		frmRegister.getContentPane().add(lblRepeatPassword);

		passwordField2 = new JPasswordField();
		passwordField2.setColumns(10);
		passwordField2.setBounds(163, 214, 195, 23);
		frmRegister.getContentPane().add(passwordField2);

		titleError = new JTextArea();
		titleError.setForeground(Color.RED);
		titleError.setBounds(163, 295, 195, 96);
		titleError.setEditable(false);
		titleError.setLineWrap(true);
		titleError.setBackground(null);
		frmRegister.getContentPane().add(titleError);

	}

	/**
	 * Acciones de los botones
	 */
	public void setListeners() {

		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = emailField.getText();
				String password = new String(passwordField.getPassword());
				String password2 = new String(passwordField2.getPassword());
				registerAccount(email, password, password2);
			}
		});

		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegister.dispose();
				new LoginView(futbolApp);
			}
		});

		emailField.addKeyListener(new KeyAdapter() {
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
				if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_DOWN) {
					passwordField2.requestFocus();
				}

				if (e.getKeyCode() == KeyEvent.VK_UP) {
					emailField.requestFocus();
				}
			}
		});

		passwordField2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String email = emailField.getText();
					String password = new String(passwordField.getPassword());
					String password2 = new String(passwordField2.getPassword());
					registerAccount(email, password, password2);
				}

				if (e.getKeyCode() == KeyEvent.VK_UP) {
					passwordField.requestFocus();
				}
			}
		});
	}

	/**
	 * Registrar una cuneta
	 * 
	 * @param email     Email
	 * @param password  Contraseña
	 * @param password2 Contraseña2
	 */
	public void registerAccount(String email, String password, String password2) {

		boolean emptyFields = email.equals("") || password.equals("") || password2.equals("");
		boolean requirementsEmail = futbolApp.getUserDAO().checkRequirementsEmail(email);
		boolean requirementsPassword = futbolApp.getUserDAO().checkRequirementsPassword(password);
		boolean samePassword = password.equals(password2);

		if (!emptyFields) {
			if (requirementsEmail && requirementsPassword && samePassword) {
				futbolApp.getUserDAO().createUsername(new Account(email, password));
				titleError.setText("Successfully registered");
			}

			if (!requirementsEmail) {
				titleError
						.setText("Requierements Email\n 1. constains @\n 2. constains(.com, .es, .net)\n 3. No exists");
			} else if (!samePassword) {
				titleError.setText("Same Password");
			} else if (!requirementsPassword) {
				titleError.setText(
						"Requirements Password\n 1. min 8 characters\n 2. constains Uppercase\n 3. constains Lowercase\n 4. constains Digit\n 5. constains Characters specials");
			}
		} else {
			titleError.setText("Empty Fields");
		}
	}
}
