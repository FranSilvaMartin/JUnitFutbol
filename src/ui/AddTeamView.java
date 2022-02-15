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

public class AddTeamView {

	private JFrame frmAddTeam;

	private FutbolApp futbolApp;
	private JButton closeButton;
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

	/**
	 * Create the application.
	 */
	public AddTeamView(FutbolApp futbolApp) {
		this.futbolApp = futbolApp;
		futbolApp.addTeams();

		initialize();
		setListeners();
		frmAddTeam.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmAddTeam = new JFrame();
		frmAddTeam.setTitle("Futbol");
		frmAddTeam.setBounds(100, 100, 664, 510);
		frmAddTeam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddTeam.getContentPane().setLayout(null);

		nameLabel = new JTextField("");
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		nameLabel.setBounds(438, 102, 193, 27);
		frmAddTeam.getContentPane().add(nameLabel);

		closeButton = new JButton("");
		closeButton.setIcon(new ImageIcon(AddTeamView.class.getResource("/resources/closeButtonIMG.png")));
		closeButton.setBounds(579, 11, 52, 27);
		closeButton.setBorderPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setFocusPainted(false);
		closeButton.setOpaque(false);
		frmAddTeam.getContentPane().add(closeButton);

		ImageLabel = new JLabel("");
		ImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageLabel.setBounds(52, 42, 326, 358);
		frmAddTeam.getContentPane().add(ImageLabel);

		stadiumLabel = new JTextField("");
		stadiumLabel.setBounds(438, 215, 187, 23);
		frmAddTeam.getContentPane().add(stadiumLabel);

		leagueLabel = new JTextField("");
		leagueLabel.setBounds(438, 158, 146, 23);
		frmAddTeam.getContentPane().add(leagueLabel);

		coachLabel = new JTextField("");
		coachLabel.setBounds(438, 275, 146, 23);
		frmAddTeam.getContentPane().add(coachLabel);

		leagueTitleLabel = new JLabel("League");
		leagueTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		leagueTitleLabel.setBounds(426, 140, 68, 14);
		frmAddTeam.getContentPane().add(leagueTitleLabel);

		stadiumTitleLabel = new JLabel("Stadium");
		stadiumTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		stadiumTitleLabel.setBounds(428, 192, 99, 14);
		frmAddTeam.getContentPane().add(stadiumTitleLabel);

		coachTitleLabel = new JLabel("Coach");
		coachTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		coachTitleLabel.setBounds(428, 249, 46, 14);
		frmAddTeam.getContentPane().add(coachTitleLabel);

		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TeamDAO teamdao = futbolApp.getTeamDAO();

				boolean existsTeam = teamdao.checkTeamName(nameLabel.getText());
				boolean existsCoach = teamdao.checkTeamName(coachLabel.getText());
				boolean existsStadium = teamdao.checkStadiumName(stadiumLabel.getText());

				if (!existsTeam && !existsCoach && !existsStadium) {
					ArrayList<Player> playerList = new ArrayList<Player>();
					futbolApp.getTeamDAO().teamList.add(new Team(nameLabel.getText(), stadiumLabel.getText(), leagueLabel.getText(),
							coachLabel.getText(), playerList, imageTextLabel.getText()));
					
					JOptionPane.showMessageDialog(frmAddTeam, "Team created");
					
					frmAddTeam.dispose();
					futbolApp.getTeamview().frmTeam.setVisible(true);
				}

				if (existsTeam) {
					JOptionPane.showMessageDialog(frmAddTeam, "Already exists with this name");
				}

				if (existsCoach) {
					JOptionPane.showMessageDialog(frmAddTeam, "Already exists this name coach");
				}

				if (existsStadium) {
					JOptionPane.showMessageDialog(frmAddTeam, "Already exists this name stadium");
				}
			}
		});
		addButton.setBounds(519, 412, 112, 23);
		frmAddTeam.getContentPane().add(addButton);

		deleteButton = new JButton("Cancel");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddTeam.dispose();
				futbolApp.getTeamview().frmTeam.setVisible(true);
			}
		});
		deleteButton.setBounds(519, 437, 112, 23);
		frmAddTeam.getContentPane().add(deleteButton);

		nameTitleLabel = new JLabel("Name");
		nameTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		nameTitleLabel.setBounds(428, 77, 46, 14);
		frmAddTeam.getContentPane().add(nameTitleLabel);

		imageTextLabel = new JTextField("");
		imageTextLabel.setBounds(31, 411, 347, 23);
		frmAddTeam.getContentPane().add(imageTextLabel);

		JButton showImageButton = new JButton("Show image");
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
		showImageButton.setBounds(279, 437, 99, 23);
		frmAddTeam.getContentPane().add(showImageButton);

		errorImageTitleLabel = new JLabel("Image not found");
		errorImageTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorImageTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		errorImageTitleLabel.setForeground(Color.RED);
		errorImageTitleLabel.setBounds(52, 193, 326, 14);
		frmAddTeam.getContentPane().add(errorImageTitleLabel);
	}

	public void setListeners() {
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddTeam.dispose();
				new TeamView(futbolApp);
			}
		});
	}
}
