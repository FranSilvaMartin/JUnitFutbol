package ui;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import mainApp.FutbolApp;
import models.Team;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AddTeamView {

	private JFrame frmAddTeam;

	private FutbolApp futbolApp;
	private JButton closeButton;
	private JLabel ImageLabel;
	private JTextField nameLabel;
	private BufferedImage img;
	private int index;
	private JTextField stadiumLabel;
	private JTextField leagueLabel;
	private JTextField coachLabel;
	private JLabel leagueTitleLabel;
	private JLabel stadiumTitleLabel;
	private JLabel coachTitleLabel;
	private JLabel nameTitleLabel;
	private JButton addButton;
	private JButton deleteButton;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public AddTeamView(FutbolApp futbolApp) {
		this.futbolApp = futbolApp;
		futbolApp.addTeams();
		index = 0;

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
			}
		});
		addButton.setBounds(519, 412, 112, 23);
		frmAddTeam.getContentPane().add(addButton);
		
		deleteButton = new JButton("Cancel");
		deleteButton.setBounds(519, 437, 112, 23);
		frmAddTeam.getContentPane().add(deleteButton);
		
		nameTitleLabel = new JLabel("Name");
		nameTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		nameTitleLabel.setBounds(428, 77, 46, 14);
		frmAddTeam.getContentPane().add(nameTitleLabel);
		
		textField = new JTextField("");
		textField.setBounds(31, 411, 347, 23);
		frmAddTeam.getContentPane().add(textField);
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
