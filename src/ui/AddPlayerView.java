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

import dao.PlayerDAO;
import mainApp.FutbolApp;
import models.Player;
import models.Team;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
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
	private JTextField weightLabel;
	private JTextField yearsLabel;
	private JLabel errorImageTitleLabel;
	private JTextField heightLabel;
	private JLabel leagueTitleLabel;
	private JLabel stadiumTitleLabel;
	private JLabel coachTitleLabel;
	private JLabel nameTitleLabel;
	private JButton addButton;
	private JButton cancelButton;
	private JTextField imageTextLabel;
	private JLabel lblCountry;
	private JTextField countryLabel;

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
		frmAddPlayer.setResizable(false);
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

		weightLabel = new JTextField("");
		weightLabel.setBounds(438, 191, 46, 23);
		frmAddPlayer.getContentPane().add(weightLabel);

		yearsLabel = new JTextField("");
		yearsLabel.setBounds(438, 129, 46, 23);
		frmAddPlayer.getContentPane().add(yearsLabel);

		heightLabel = new JTextField("");
		heightLabel.setBounds(438, 250, 46, 23);
		frmAddPlayer.getContentPane().add(heightLabel);

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
		addButton.setBounds(519, 412, 112, 23);
		frmAddPlayer.getContentPane().add(addButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(519, 437, 112, 23);
		frmAddPlayer.getContentPane().add(cancelButton);

		nameTitleLabel = new JLabel("Name");
		nameTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		nameTitleLabel.setBounds(428, 42, 46, 14);
		frmAddPlayer.getContentPane().add(nameTitleLabel);

		imageTextLabel = new JTextField("");
		imageTextLabel.setBounds(31, 411, 347, 23);
		frmAddPlayer.getContentPane().add(imageTextLabel);

		showImageButton = new JButton("Show image");
		showImageButton.setBounds(258, 437, 120, 23);
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

		countryLabel = new JTextField("");
		countryLabel.setBounds(438, 312, 149, 23);
		frmAddPlayer.getContentPane().add(countryLabel);
	}

	public void setListeners() {

		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPlayer();
			}
		});

		showImageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showImage();
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddPlayer.dispose();
				new PlayerView(futbolApp);
			}
		});

		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddPlayer.dispose();
				new PlayerView(futbolApp);
			}
		});
	}

	private void showImage() {
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
	
	private void addPlayer() {

		try {
			int indexTeam = futbolApp.getTeamview().index;
			PlayerDAO playerdao = futbolApp.getPlayerDAO();
			Team team = futbolApp.getTeamDAO().teamList.get(indexTeam);

			boolean emptyFields = nameLabel.getText().isEmpty() || imageTextLabel.getText().isEmpty()
					|| yearsLabel.getText().isEmpty() || weightLabel.getText().isEmpty()
					|| heightLabel.getText().isEmpty() || countryLabel.getText().isEmpty();

			boolean existsPlayer = playerdao.checkPlayerNameTeam(team, nameLabel.getText());

			if (!emptyFields && !existsPlayer) {

				String name = nameLabel.getText();
				int years = Integer.parseInt(yearsLabel.getText());
				float weight = Float.parseFloat(weightLabel.getText());
				float height = Float.parseFloat(heightLabel.getText());
				String country = countryLabel.getText();
				String img = imageTextLabel.getText();

				team.getPlayerList().add(new Player(name, years, weight, height, country, img));

				JOptionPane.showMessageDialog(frmAddPlayer, "Player added to squad");

				frmAddPlayer.dispose();
				new PlayerView(futbolApp);
			}

			if (emptyFields) {
				JOptionPane.showMessageDialog(frmAddPlayer, "Empty fields");
			}

			if (existsPlayer) {
				JOptionPane.showMessageDialog(frmAddPlayer, "Already exists with this name");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(frmAddPlayer, "ERROR - Check the fields");
		}
	}
}
