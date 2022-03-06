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
import dao.TeamDAO;
import mainApp.FutbolApp;
import models.Player;
import models.Team;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class AddPlayerView {

	private JFrame frmAddPlayer;

	private FutbolApp futbolApp;
	private JButton closeButton, showImageButton;
	private JLabel ImageLabel, errorImageTitleLabel, leagueTitleLabel, stadiumTitleLabel, coachTitleLabel,
			nameTitleLabel, lblCountry;
	private JTextField nameLabel, weightLabel, ageLabel, heightLabel, imageTextLabel, countryLabel, dorsalNumberLabel;
	private JButton addButton, cancelButton;

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

		closeButton.setIcon(new ImageIcon(new File("resources/closeButtonIMG.png").getAbsolutePath()));
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
		weightLabel.setBounds(438, 238, 46, 23);
		frmAddPlayer.getContentPane().add(weightLabel);

		ageLabel = new JTextField("");
		ageLabel.setBounds(438, 179, 46, 23);
		frmAddPlayer.getContentPane().add(ageLabel);

		heightLabel = new JTextField("");
		heightLabel.setBounds(438, 297, 46, 23);
		frmAddPlayer.getContentPane().add(heightLabel);

		leagueTitleLabel = new JLabel("Years");
		leagueTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		leagueTitleLabel.setBounds(426, 163, 68, 14);
		frmAddPlayer.getContentPane().add(leagueTitleLabel);

		stadiumTitleLabel = new JLabel("Weight");
		stadiumTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		stadiumTitleLabel.setBounds(429, 213, 99, 14);
		frmAddPlayer.getContentPane().add(stadiumTitleLabel);

		coachTitleLabel = new JLabel("Height");
		coachTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		coachTitleLabel.setBounds(429, 272, 46, 14);
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
		lblCountry.setBounds(428, 331, 99, 14);
		frmAddPlayer.getContentPane().add(lblCountry);

		countryLabel = new JTextField("");
		countryLabel.setBounds(438, 356, 149, 23);
		frmAddPlayer.getContentPane().add(countryLabel);

		dorsalNumberLabel = new JTextField("");
		dorsalNumberLabel.setBounds(438, 133, 46, 23);
		frmAddPlayer.getContentPane().add(dorsalNumberLabel);

		JLabel dorsalNumberTitleLabel = new JLabel("Dorsal number");
		dorsalNumberTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		dorsalNumberTitleLabel.setBounds(426, 114, 141, 14);
		frmAddPlayer.getContentPane().add(dorsalNumberTitleLabel);
	}

	/**
	 * Acciones de los botones
	 */
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

	/**
	 * Muestra la imagen
	 */
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

	/**
	 * Agrega un jugador
	 */
	private void addPlayer() {

		try {
			int indexTeam = futbolApp.getTeamView().index;
			PlayerDAO playerdao = futbolApp.getPlayerDAO();
			TeamDAO teamdao = futbolApp.getTeamDAO();
			Team team = futbolApp.getTeamDAO().teamList.get(indexTeam);

			boolean emptyFields = nameLabel.getText().isEmpty() || imageTextLabel.getText().isEmpty()
					|| ageLabel.getText().isEmpty() || weightLabel.getText().isEmpty()
					|| heightLabel.getText().isEmpty() || countryLabel.getText().isEmpty();

			boolean existsPlayer = playerdao.existsPlayerNameTeam(team, nameLabel.getText());
			boolean exceedsPlayerName = playerdao.exceedsPlayerName(nameLabel.getText());
			boolean checkPlayerDorsal = playerdao.existsPlayerDorsal(team,
					Integer.parseInt(dorsalNumberLabel.getText()));
			boolean exceedsPlayerDorsal = playerdao.exceedsPlayerDorsal(Integer.parseInt(dorsalNumberLabel.getText()));
			boolean exceedsPlayerNumbers = teamdao.exceedsPlayerNumbers(team);

			if (!emptyFields && !existsPlayer && !exceedsPlayerName && !checkPlayerDorsal && !exceedsPlayerDorsal
					&& !exceedsPlayerNumbers) {

				String name = nameLabel.getText();
				int dorsal = Integer.parseInt(dorsalNumberLabel.getText());
				int years = Integer.parseInt(ageLabel.getText());
				float weight = Float.parseFloat(weightLabel.getText());
				float height = Float.parseFloat(heightLabel.getText());
				String country = countryLabel.getText();
				String img = imageTextLabel.getText();

				playerdao.addPlayer(team, new Player(name, dorsal, years, weight, height, country, img));

				JOptionPane.showMessageDialog(frmAddPlayer, "Player added to team");

				frmAddPlayer.dispose();
				new PlayerView(futbolApp);
			}

			if (emptyFields) {
				JOptionPane.showMessageDialog(frmAddPlayer, "Empty fields");
			}

			if (existsPlayer) {
				JOptionPane.showMessageDialog(frmAddPlayer, "Already exists with this name");
			}

			if (exceedsPlayerName) {
				JOptionPane.showMessageDialog(frmAddPlayer, "The name cannot be longer than 30 characters");
			}

			if (exceedsPlayerDorsal) {
				JOptionPane.showMessageDialog(frmAddPlayer, "The number must be between 1 and 99");
			}

			if (exceedsPlayerNumbers) {
				JOptionPane.showMessageDialog(frmAddPlayer, "There can be no more than 11 players on the team");
			}

			if (checkPlayerDorsal) {
				JOptionPane.showMessageDialog(frmAddPlayer, "This number already exists in the team");
			}

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(frmAddPlayer, "ERROR - Check the fields");
		}
	}
}
