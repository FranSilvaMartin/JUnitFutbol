package ui;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import dao.TeamDAO;
import mainApp.FutbolApp;
import models.Player;
import models.Team;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class AddPlayerView {

	private JFrame frmAddPlayer;

	private FutbolApp futbolApp;
	private JButton closeButton;
	private JButton showImageButton;
	private JLabel ImageLabel;
	private JTextField nameLabel;
	private JTextField stadiumLabel;
	private JTextField leagueLabel;
	private JLabel errorImageTitleLabel;
	private JTextField coachLabel;
	private JLabel leagueTitleLabel;
	private JLabel stadiumTitleLabel;
	private JLabel coachTitleLabel;
	private JLabel nameTitleLabel;
	private JButton addButton;
	private JButton deleteButton;
	private JTextField imageTextLabel;
	private JLabel lblCountry;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public AddPlayerView(FutbolApp futbolApp) {
		this.futbolApp = futbolApp;
		initialize();
		setListeners();
		frmAddPlayer.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmAddPlayer = new JFrame();
		frmAddPlayer.setTitle("Futbol - Add Player");
		frmAddPlayer.setBounds(100, 100, 664, 510);
		frmAddPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddPlayer.getContentPane().setLayout(null);

		nameLabel = new JTextField("");
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nameLabel.setBounds(438, 66, 193, 27);
		frmAddPlayer.getContentPane().add(nameLabel);

		closeButton = new JButton("");
		closeButton.setIcon(new ImageIcon(AddPlayerView.class.getResource("/resources/closeButtonIMG.png")));
		closeButton.setBounds(579, 11, 52, 27);
		closeButton.setBorderPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setFocusPainted(false);
		closeButton.setOpaque(false);
		frmAddPlayer.getContentPane().add(closeButton);

		ImageLabel = new JLabel("");
		ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageLabel.setBounds(52, 42, 326, 358);
		frmAddPlayer.getContentPane().add(ImageLabel);

		stadiumLabel = new JTextField("");
		stadiumLabel.setBounds(438, 191, 46, 23);
		frmAddPlayer.getContentPane().add(stadiumLabel);

		leagueLabel = new JTextField("");
		leagueLabel.setBounds(438, 129, 46, 23);
		frmAddPlayer.getContentPane().add(leagueLabel);

		coachLabel = new JTextField("");
		coachLabel.setBounds(438, 250, 46, 23);
		frmAddPlayer.getContentPane().add(coachLabel);

		leagueTitleLabel = new JLabel("Years");
		leagueTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		leagueTitleLabel.setBounds(428, 104, 68, 14);
		frmAddPlayer.getContentPane().add(leagueTitleLabel);

		stadiumTitleLabel = new JLabel("Weight");
		stadiumTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		stadiumTitleLabel.setBounds(428, 166, 99, 14);
		frmAddPlayer.getContentPane().add(stadiumTitleLabel);

		coachTitleLabel = new JLabel("Height");
		coachTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		coachTitleLabel.setBounds(428, 225, 46, 14);
		frmAddPlayer.getContentPane().add(coachTitleLabel);

		addButton = new JButton("Add Player");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeamDAO teamdao = futbolApp.getTeamDAO();
				int indexTeam = futbolApp.getTeamview().index;
				teamdao.teamList.get(indexTeam).getPlayerList().add(new Player("Fran", indexTeam, indexTeam, indexTeam, null, null));
			}
		});
		addButton.setBounds(519, 412, 112, 23);
		frmAddPlayer.getContentPane().add(addButton);

		deleteButton = new JButton("Cancel");
		deleteButton.setBounds(519, 437, 112, 23);
		frmAddPlayer.getContentPane().add(deleteButton);

		nameTitleLabel = new JLabel("Name");
		nameTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		nameTitleLabel.setBounds(428, 42, 46, 14);
		frmAddPlayer.getContentPane().add(nameTitleLabel);

		imageTextLabel = new JTextField("");
		imageTextLabel.setBounds(31, 411, 347, 23);
		frmAddPlayer.getContentPane().add(imageTextLabel);

		showImageButton = new JButton("Show image");
		showImageButton.setBounds(279, 437, 99, 23);
		frmAddPlayer.getContentPane().add(showImageButton);

		errorImageTitleLabel = new JLabel("Image not found");
		errorImageTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorImageTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		errorImageTitleLabel.setForeground(Color.RED);
		errorImageTitleLabel.setBounds(52, 193, 326, 14);
		frmAddPlayer.getContentPane().add(errorImageTitleLabel);

		lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCountry.setBounds(428, 287, 99, 14);
		frmAddPlayer.getContentPane().add(lblCountry);

		textField = new JTextField("");
		textField.setBounds(438, 312, 149, 23);
		frmAddPlayer.getContentPane().add(textField);
	}

	public void setListeners() {

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddPlayer.dispose();
				new PlayerView(futbolApp);
			}
		});

		showImageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedImage img = ImageIO.read(new URL(imageTextLabel.getText()));
					Image image = new ImageIcon(img).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
					ImageLabel.setIcon(new ImageIcon(image));
					errorImageTitleLabel.setVisible(false);
				} catch (Exception e2) {
					ImageLabel.setVisible(false);
					errorImageTitleLabel.setVisible(true);
				}
			}
		});

		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddPlayer.dispose();
				new PlayerView(futbolApp);
			}
		});
	}
}
