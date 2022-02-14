package ui;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import mainApp.FutbolApp;
import models.Team;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.event.ActionEvent;

public class TeamView {

	private JFrame frmTeam;

	private FutbolApp futbolApp;
	private JButton closeButton;
	private JLabel ImageLabel;
	private JLabel nameLabel;
	private BufferedImage img;
	private int index;
	private JLabel stadiumLabel;
	private JLabel leagueLabel;
	private JLabel coachLabel;
	private JLabel numberPlayersLabel;
	private JLabel leagueTitleLabel;
	private JLabel stadiumTitleLabel;
	private JLabel coachTitleLabel;
	private JLabel lblNewLabel;
	private JLabel nameTitleLabel;
	private JButton previousButton;
	private JButton nextButton;
	private JButton addButton;
	private JButton deleteButton;
	private JButton showPlayerButton;

	/**
	 * Create the application.
	 */
	public TeamView(FutbolApp futbolApp) {
		this.futbolApp = futbolApp;
		futbolApp.addTeams();
		index = 0;

		initialize();
		setListeners();
		frmTeam.setVisible(true);
		showTeam();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmTeam = new JFrame();
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
		closeButton.setIcon(new ImageIcon(TeamView.class.getResource("/resources/closeButtonIMG.png")));
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

		lblNewLabel = new JLabel("Number of players");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(428, 288, 117, 14);
		frmTeam.getContentPane().add(lblNewLabel);

		addButton = new JButton("Add Team");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTeam.dispose();
				new AddTeamView(futbolApp);
			}
		});
		addButton.setBounds(448, 412, 125, 23);
		frmTeam.getContentPane().add(addButton);

		deleteButton = new JButton("Delete Team");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Team team = futbolApp.getTeamDAO().teamList.get(index);
				futbolApp.getTeamDAO().deleteTeam(team);
				showTeam();
			}
		});
		deleteButton.setBounds(448, 437, 125, 23);
		frmTeam.getContentPane().add(deleteButton);

		showPlayerButton = new JButton("Show players");
		showPlayerButton.setBounds(448, 378, 125, 23);
		frmTeam.getContentPane().add(showPlayerButton);

		nameTitleLabel = new JLabel("Name");
		nameTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		nameTitleLabel.setBounds(428, 77, 46, 14);
		frmTeam.getContentPane().add(nameTitleLabel);

		previousButton = new JButton("Previous");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index--;
				if (index < 0) {
					index = futbolApp.getTeamDAO().teamList.size() - 1;
				}
				showTeam();
			}
		});
		previousButton.setBounds(55, 24, 89, 23);
		frmTeam.getContentPane().add(previousButton);

		nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index++;
				if (index == futbolApp.getTeamDAO().teamList.size()) {
					index = 0;
				}
				showTeam();
			}
		});
		nextButton.setBounds(289, 24, 89, 23);
		frmTeam.getContentPane().add(nextButton);
	}

	public void setListeners() {
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTeam.dispose();
				new LoginView(futbolApp);
			}
		});
	}

	public void showTeam() {
		Team team = futbolApp.getTeamDAO().teamList.get(index);
		nameLabel.setText(team.getName());
		stadiumLabel.setText(team.getStadium());
		leagueLabel.setText(team.getLeague());
		coachLabel.setText(team.getCoach());

		if (team.getPlayerList() != null) {
			numberPlayersLabel.setText(team.getPlayerList().size() + "");
		} else {
			numberPlayersLabel.setText("0");
		}

		try {
			img = ImageIO.read(new URL(futbolApp.getTeamDAO().teamList.get(index).getImg()));
			Image image = new ImageIcon(img).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
			ImageLabel.setIcon(new ImageIcon(image));
		} catch (Exception e2) {
			ImageLabel.setVisible(false);
			// lblTituloError.setText("ERROR: No existe una imagen");
		}

	}
}
