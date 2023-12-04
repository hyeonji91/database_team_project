package instagram;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FollowPanelItem extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 12);

	/**
	 * Create the panel.
	 */
	//매개변수에 데이터 적기:지금 있는 건 임시

	public FollowPanelItem(String d) {
		this.setBackground(Color.WHITE);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{ 0.0, 1.0};
		gbl_panel.rowWeights = new double[] {0.0, 0.0};
		this.setLayout(gbl_panel);
		
		ImageIcon profileImgicon = null;
		try {
		    URL imageUrl = new URL("https://github.com/hyeonji91/database_team_project/assets/112065014/db0fbf09-d522-40ef-ad0b-7c802ecd455c");
		    profileImgicon = new ImageIcon(imageUrl);
		    profileImgicon = utile.ImageIconResize.resizeImage(profileImgicon, 50, 50);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		JLabel followProfileImg = new JLabel("");
		followProfileImg.setHorizontalAlignment(SwingConstants.LEFT);
		followProfileImg.setIcon(profileImgicon);
		followProfileImg.setBounds(0, 0, 5, 5);
		GridBagConstraints gbc_followProfileImg = new GridBagConstraints();
		gbc_followProfileImg.anchor = GridBagConstraints.WEST;
		gbc_followProfileImg.gridheight = 2;
		gbc_followProfileImg.insets = new Insets(5, 0, 5, 5);
		gbc_followProfileImg.gridx = 0;
		gbc_followProfileImg.gridy = 0;
		this.add(followProfileImg, gbc_followProfileImg);
		
		JLabel followIdLabel = new JLabel("gachon");
		followIdLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		GridBagConstraints gbc_followIdLabel = new GridBagConstraints();
		gbc_followIdLabel.anchor = GridBagConstraints.WEST;
		gbc_followIdLabel.insets = new Insets(5, 5, 5, 0);
		gbc_followIdLabel.gridx = 1;
		gbc_followIdLabel.gridy = 0;
		this.add(followIdLabel, gbc_followIdLabel);
		
		JLabel followNameLabel = new JLabel("가천");
		followNameLabel.setFont(defaultFont);
		GridBagConstraints gbc_followNameLabel = new GridBagConstraints();
		gbc_followNameLabel.anchor = GridBagConstraints.WEST;
		gbc_followNameLabel.insets = new Insets(0, 5, 5, 0);
		gbc_followNameLabel.gridx = 1;
		gbc_followNameLabel.gridy = 1;
		this.add(followNameLabel, gbc_followNameLabel);
		
		//누르면 프로필 화면으로 전환
		this.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	System.out.println("click profile");

	    	    JPanel profilePanel = new ProfilePanel();
				new CreateFrameWithPanel(profilePanel);
	        }
		});
		
	}
	

}
