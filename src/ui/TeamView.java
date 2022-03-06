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

import mainApp.FutbolApp;
import models.Team;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TeamView {

	public JFrame frmTeam;

	private FutbolApp futbolApp;
	private JLabel ImageLabel, nameLabel, stadiumLabel, leagueLabel, coachLabel, numberPlayersLabel, leagueTitleLabel,
			stadiumTitleLabel, coachTitleLabel, numPlayerTitleLabel, nameTitleLabel, EmptyTeams, ImageErrorTitleLabel;
	private JButton closeButton, previousButton, nextButton, addButton, deleteButton, showPlayerButton;

	private BufferedImage img;
	public int index = 0;

	/**
	 * Create the application.
	 */
	public TeamView(FutbolApp futbolApp) {
		this.futbolApp = futbolApp;
		initialize();
		setListeners();
		frmTeam.setVisible(true);
		frmTeam.invalidate();
		frmTeam.validate();
		frmTeam.repaint();

		index = 0;
		showTeam();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmTeam = new JFrame();
		frmTeam.setResizable(false);
		frmTeam.setTitle("Futbol");
		frmTeam.setBounds(100, 100, 664, 510);
		frmTeam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeam.getContentPane().setLayout(null);

		nameLabel = new JLabel("");
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nameLabel.setBounds(438, 102, 193, 14);
		frmTeam.getContentPane().add(nameLabel);

		closeButton = new JButton("");
		closeButton.setIcon(new ImageIcon(new File("resources/closeButtonIMG.png").getAbsolutePath()));
		closeButton.setBounds(579, 11, 52, 27);
		closeButton.setBorderPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setFocusPainted(false);
		closeButton.setOpaque(false);
		frmTeam.getContentPane().add(closeButton);

		ImageLabel = new JLabel("");
		ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageLabel.setBounds(52, 77, 326, 358);
		frmTeam.getContentPane().add(ImageLabel);

		stadiumLabel = new JLabel("");
		stadiumLabel.setBounds(438, 204, 187, 23);
		frmTeam.getContentPane().add(stadiumLabel);

		leagueLabel = new JLabel("");
		leagueLabel.setBounds(438, 154, 146, 14);
		frmTeam.getContentPane().add(leagueLabel);

		coachLabel = new JLabel("");
		coachLabel.setBounds(438, 263, 146, 14);
		frmTeam.getContentPane().add(coachLabel);

		numberPlayersLabel = new JLabel("");
		numberPlayersLabel.setBounds(438, 313, 46, 14);
		frmTeam.getContentPane().add(numberPlayersLabel);

		leagueTitleLabel = new JLabel("League");
		leagueTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		leagueTitleLabel.setBounds(428, 129, 68, 14);
		frmTeam.getContentPane().add(leagueTitleLabel);

		stadiumTitleLabel = new JLabel("Stadium");
		stadiumTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		stadiumTitleLabel.setBounds(430, 179, 99, 14);
		frmTeam.getContentPane().add(stadiumTitleLabel);

		coachTitleLabel = new JLabel("Coach");
		coachTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		coachTitleLabel.setBounds(428, 238, 46, 14);
		frmTeam.getContentPane().add(coachTitleLabel);

		numPlayerTitleLabel = new JLabel("Number of players");
		numPlayerTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		numPlayerTitleLabel.setBounds(428, 288, 117, 14);
		frmTeam.getContentPane().add(numPlayerTitleLabel);

		addButton = new JButton("Add Team");
		addButton.setBounds(488, 412, 125, 23);
		frmTeam.getContentPane().add(addButton);

		deleteButton = new JButton("Delete Team");
		deleteButton.setBounds(488, 437, 125, 23);
		frmTeam.getContentPane().add(deleteButton);

		showPlayerButton = new JButton("Players");
		showPlayerButton.setBounds(488, 381, 125, 23);
		frmTeam.getContentPane().add(showPlayerButton);

		nameTitleLabel = new JLabel("Name");
		nameTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		nameTitleLabel.setBounds(428, 77, 46, 14);
		frmTeam.getContentPane().add(nameTitleLabel);

		previousButton = new JButton("Previous");
		previousButton.setBounds(55, 24, 89, 23);
		frmTeam.getContentPane().add(previousButton);

		nextButton = new JButton("Next");
		nextButton.setBounds(289, 24, 89, 23);
		frmTeam.getContentPane().add(nextButton);

		EmptyTeams = new JLabel("");
		EmptyTeams.setHorizontalAlignment(SwingConstants.CENTER);
		EmptyTeams.setForeground(Color.RED);
		EmptyTeams.setFont(new Font("Tahoma", Font.PLAIN, 12));
		EmptyTeams.setBounds(52, 194, 266, 14);
		frmTeam.getContentPane().add(EmptyTeams);

		ImageErrorTitleLabel = new JLabel("");
		ImageErrorTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageErrorTitleLabel.setForeground(Color.RED);
		ImageErrorTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ImageErrorTitleLabel.setBounds(75, 239, 266, 14);
		frmTeam.getContentPane().add(ImageErrorTitleLabel);
	}

	/**
	 * Acciones de los botones
	 */
	public void setListeners() {

		showPlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTeam.setVisible(false);
				new PlayerView(futbolApp);
			}
		});

		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTeam.setVisible(false);
				new AddTeamView(futbolApp);
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int confirmar = JOptionPane.showConfirmDialog(deleteButton, "Are you sure?");
				if (confirmar == 0) {
					Team team = futbolApp.getTeamDAO().teamList.get(index);
					futbolApp.getTeamDAO().deleteTeam(team);

					if (index == 0) {
						showTeam();
					} else {
						index--;
						showTeam();
					}
				}
			}
		});

		previousButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				index--;
				if (index < 0) {
					index = futbolApp.getTeamDAO().teamList.size() - 1;
				}
				showTeam();
			}
		});

		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index++;
				if (index == futbolApp.getTeamDAO().teamList.size()) {
					index = 0;
				}
				showTeam();
			}
		});

		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTeam.dispose();
				new LoginView(futbolApp);
			}
		});
	}

	/**
	 * Muestra el equipo
	 */
	public void showTeam() {
		if (futbolApp.getTeamDAO().teamList.isEmpty()) {
			showTeamEmpty();
		} else {
			Team team = futbolApp.getTeamDAO().teamList.get(index);
			nameLabel.setText(team.getName());
			stadiumLabel.setText(team.getStadium());
			leagueLabel.setText(team.getLeague());
			coachLabel.setText(team.getCoach());
			EmptyTeams.setText("");
			ImageErrorTitleLabel.setText("");

			checkButtons();

			if (team.getPlayerList() != null) {
				numberPlayersLabel.setText(team.getPlayerList().size() + "");
			} else {
				numberPlayersLabel.setText("0");
			}

			try {
				ImageLabel.setVisible(true);
				img = ImageIO.read(new URL(futbolApp.getTeamDAO().teamList.get(index).getImg()));
				Image image = new ImageIcon(img).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
				ImageLabel.setIcon(new ImageIcon(image));
			} catch (Exception e2) {
				ImageLabel.setVisible(false);
				ImageErrorTitleLabel.setText("Image not found");
			}
		}
	}

	/**
	 * Muestra el equipo vacio
	 */
	public void showTeamEmpty() {
		nameLabel.setText("");
		stadiumLabel.setText("");
		leagueLabel.setText("");
		coachLabel.setText("");

		checkButtons();

		EmptyTeams.setText("Empty");
		numberPlayersLabel.setText("0");
		ImageLabel.setVisible(false);
	}

	/**
	 * Comprobar si mostrar los botones o no
	 * 
	 * @return Devuelve true o false
	 */
	public boolean checkButtons() {

		if (futbolApp.getTeamDAO().teamList.isEmpty()) {
			nextButton.setVisible(false);
			previousButton.setVisible(false);
			deleteButton.setVisible(false);
			showPlayerButton.setVisible(false);
			return false;
		} else {
			if (futbolApp.getTeamDAO().teamList.size() == 1) {
				nextButton.setVisible(false);
				previousButton.setVisible(false);
				deleteButton.setVisible(true);
				showPlayerButton.setVisible(true);
				return false;
			} else {
				nextButton.setVisible(true);
				previousButton.setVisible(true);
				deleteButton.setVisible(true);
				showPlayerButton.setVisible(true);
				return true;
			}
		}
	}
}
