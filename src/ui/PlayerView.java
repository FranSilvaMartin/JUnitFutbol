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
import models.Player;
import models.Team;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PlayerView {

	public JFrame frmTeam;

	private FutbolApp futbolApp;
	private JButton closeButton;
	private JLabel ImageLabel;
	private JLabel nameLabel;
	private BufferedImage img;
	private int index = 0;
	public int indexTeam = 0;
	private JLabel countryLabel;
	private JLabel yearsLabel;
	private JLabel heightLabel;
	private JLabel yearsTitleLabel;
	private JLabel countryTitleLabel;
	private JLabel heightTitleLabel;
	private JLabel nameTitleLabel;
	private JLabel weightTitleLabel;
	private JLabel weightLabel;
	private JLabel EmptyTeams;
	private JButton previousButton;
	private JButton nextButton;
	private JButton addButton;
	private JButton deleteButton;
	private JLabel ImageErrorTitleLabel;
	private JLabel teamTitleLabel;
	private JLabel teamLabel;
	private JLabel dorsalTitleLabel;
	private JLabel dorsalLabel;

	/**
	 * Create the application.
	 */
	public PlayerView(FutbolApp futbolApp) {
		this.futbolApp = futbolApp;
		indexTeam = futbolApp.getTeamView().index;
		initialize();
		setListeners();
		frmTeam.setVisible(true);
		frmTeam.invalidate();
		frmTeam.validate();
		frmTeam.repaint();

		showPlayer();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmTeam = new JFrame();
		frmTeam.setResizable(false);
		frmTeam.setTitle("Futbol - Player View");
		frmTeam.setBounds(100, 100, 664, 522);
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

		countryLabel = new JLabel("");
		countryLabel.setBounds(438, 239, 187, 17);
		frmTeam.getContentPane().add(countryLabel);

		yearsLabel = new JLabel("");
		yearsLabel.setBounds(438, 196, 146, 14);
		frmTeam.getContentPane().add(yearsLabel);

		heightLabel = new JLabel("");
		heightLabel.setBounds(438, 287, 146, 14);
		frmTeam.getContentPane().add(heightLabel);

		yearsTitleLabel = new JLabel("Years");
		yearsTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		yearsTitleLabel.setBounds(428, 171, 68, 14);
		frmTeam.getContentPane().add(yearsTitleLabel);

		countryTitleLabel = new JLabel("Country");
		countryTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		countryTitleLabel.setBounds(428, 221, 99, 14);
		frmTeam.getContentPane().add(countryTitleLabel);

		heightTitleLabel = new JLabel("Height");
		heightTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		heightTitleLabel.setBounds(428, 267, 46, 14);
		frmTeam.getContentPane().add(heightTitleLabel);

		addButton = new JButton("Add Player");
		addButton.setBounds(448, 419, 125, 23);
		frmTeam.getContentPane().add(addButton);

		deleteButton = new JButton("Delete Player");
		deleteButton.setBounds(448, 449, 125, 23);
		frmTeam.getContentPane().add(deleteButton);

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

		weightTitleLabel = new JLabel("Weight");
		weightTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		weightTitleLabel.setBounds(428, 312, 46, 14);
		frmTeam.getContentPane().add(weightTitleLabel);

		weightLabel = new JLabel("");
		weightLabel.setBounds(438, 337, 146, 14);
		frmTeam.getContentPane().add(weightLabel);

		teamTitleLabel = new JLabel("Team");
		teamTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		teamTitleLabel.setBounds(428, 362, 46, 14);
		frmTeam.getContentPane().add(teamTitleLabel);

		teamLabel = new JLabel("");
		teamLabel.setBounds(438, 387, 146, 14);
		frmTeam.getContentPane().add(teamLabel);
		
		dorsalTitleLabel = new JLabel("Dorsal");
		dorsalTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		dorsalTitleLabel.setBounds(428, 127, 68, 14);
		frmTeam.getContentPane().add(dorsalTitleLabel);
		
		dorsalLabel = new JLabel("");
		dorsalLabel.setBounds(438, 152, 146, 14);
		frmTeam.getContentPane().add(dorsalLabel);
	}

	public void setListeners() {

		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTeam.setVisible(false);
				new AddPlayerView(futbolApp);
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int confirmar = JOptionPane.showConfirmDialog(deleteButton, "Are you sure?");
				if (confirmar == 0) {

					Team team = futbolApp.getTeamDAO().teamList.get(indexTeam);
					Player player = team.getPlayerList().get(index);
					futbolApp.getPlayerDAO().deletePlayer(team, player);

					if (index == 0) {
						showPlayer();
					} else {
						index--;
						showPlayer();
					}
				}
			}
		});

		previousButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				index--;
				if (index < 0) {
					index = futbolApp.getTeamDAO().teamList.get(indexTeam).getPlayerList().size() - 1;
				}
				showPlayer();
			}
		});

		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index++;
				if (index == futbolApp.getTeamDAO().teamList.get(indexTeam).getPlayerList().size()) {
					index = 0;
				}
				showPlayer();
			}
		});

		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTeam.dispose();
				futbolApp.getTeamView().frmTeam.setVisible(true);
			}
		});
	}

	public void showPlayer() {

		if (futbolApp.getTeamDAO().teamList.get(indexTeam).getPlayerList().isEmpty()) {
			showTeamEmpty();
		} else {
			Team team = futbolApp.getTeamDAO().teamList.get(indexTeam);
			dorsalLabel.setText(team.getPlayerList().get(index).getDorsal() + "");
			nameLabel.setText(team.getPlayerList().get(index).getName());
			countryLabel.setText(team.getPlayerList().get(index).getCountry());
			yearsLabel.setText(team.getPlayerList().get(index).getYears() + "");
			heightLabel.setText(team.getPlayerList().get(index).getHeight() + " cm");
			weightLabel.setText(team.getPlayerList().get(index).getWeight() + " kg");
			teamLabel.setText(team.getName());
			EmptyTeams.setText("");
			ImageErrorTitleLabel.setText("");

			checkButtons();

			try {
				ImageLabel.setVisible(true);
				img = ImageIO.read(new URL(team.getPlayerList().get(index).getImg()));
				Image image = new ImageIcon(img).getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT);
				ImageLabel.setIcon(new ImageIcon(image));
			} catch (Exception e2) {
				ImageLabel.setVisible(false);
				ImageErrorTitleLabel.setText("Image not found");
			}
		}
	}

	public void showTeamEmpty() {
		nameLabel.setText("");
		dorsalLabel.setText("");
		countryLabel.setText("");
		yearsLabel.setText("");
		heightLabel.setText("");
		weightLabel.setText("");
		teamLabel.setText("");

		checkButtons();

		EmptyTeams.setText("Empty");
		ImageLabel.setVisible(false);
	}

	public boolean checkButtons() {

		if (futbolApp.getTeamDAO().teamList.get(indexTeam).getPlayerList().isEmpty()) {
			nextButton.setVisible(false);
			previousButton.setVisible(false);
			deleteButton.setVisible(false);
			return false;
		} else {
			if (futbolApp.getTeamDAO().teamList.get(indexTeam).getPlayerList().size() == 1) {
				nextButton.setVisible(false);
				previousButton.setVisible(false);
				deleteButton.setVisible(true);
				return false;
			} else {
				nextButton.setVisible(true);
				previousButton.setVisible(true);
				deleteButton.setVisible(true);
				return true;
			}
		}
	}
}
