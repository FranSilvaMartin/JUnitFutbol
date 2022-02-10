package ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import mainApp.FutbolApp;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeamView {

	private JFrame frmTeam;
	
	private FutbolApp futbolApp;
	private JButton closeButton;
	
	
	/**
	 * Create the application.
	 */
	public TeamView(FutbolApp futbolApp) {
		this.futbolApp = futbolApp;
		initialize();
		setListeners();
		frmTeam.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTeam = new JFrame();
		frmTeam.setTitle("Futbol");
		frmTeam.setBounds(100, 100, 538, 380);
		frmTeam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeam.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("TEAMS");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titleLabel.setBounds(121, 31, 269, 23);
		frmTeam.getContentPane().add(titleLabel);
		
		closeButton = new JButton("");
		closeButton.setIcon(new ImageIcon(TeamView.class.getResource("/resources/closeButtonIMG.png")));
		closeButton.setBounds(460, 11, 52, 27);
		closeButton.setBorderPainted(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setFocusPainted(false);
		closeButton.setOpaque(false);
		frmTeam.getContentPane().add(closeButton);
	}
	
	public void setListeners() {
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTeam.dispose();
				new LoginView(futbolApp);
			}
		});
	}
}
