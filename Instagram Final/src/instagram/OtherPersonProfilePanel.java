package instagram;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.*;

public class OtherPersonProfilePanel extends JPanel {

	public static final Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 12);
	public static final Font boldFont = new Font("맑은 고딕", Font.BOLD, 12);
	private String imagePath = "";

	private static final long serialVersionUID = 1L;
	private JTextField nameTF;
	private JTextField idTF;
	private JPasswordField pwdPF;
	private JTextField birthTF;
	private JTextField genderTF;
	private JTextField phoneTF;
	private JTextField addressTF;

	/**
	 * Create the panel.
	 */
	public OtherPersonProfilePanel() {
		setLayout(new GridLayout(0, 1, 0, 0));
		JPanel cards = new JPanel(new CardLayout());
		
		
	
		
		
		
		//프로필 화면========================================================================================
		JPanel profileMainPanel = new JPanel();
		GridBagConstraints gbc= new GridBagConstraints();
		
		profileMainPanel.setBackground(Color.WHITE);
		profileMainPanel.setBounds(0, 0, 350, 680);
		
		//프로필 이미지
		ImageIcon ProfileImgIcon = null;
		try {
		    URL imageUrl = new URL("https://github.com/hyeonji91/database_team_project/assets/112065014/db0fbf09-d522-40ef-ad0b-7c802ecd455c");
		    ProfileImgIcon = new ImageIcon(imageUrl);
		    ProfileImgIcon = utile.ImageIconResize.resizeImage(ProfileImgIcon, 70, 70);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		//임시 게시글 이미지--여긴 삭제하고 받아온 데이터 안에 이미지 사용할 것
		ImageIcon articleImgIcon = null;
		try {
		    URL imageUrl = new URL("https://blog.kakaocdn.net/dn/0mySg/btqCUccOGVk/nQ68nZiNKoIEGNJkooELF1/img.jpg");
		    articleImgIcon = new ImageIcon(imageUrl);
		    articleImgIcon = utile.ImageIconResize.resizeImage(articleImgIcon, 133, 133);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		// 데이터를 담은 리스트[임시]
	    struct[] articleData = new struct[9];
	    for(int i=0;i<articleData.length;i++) {
	    	articleData[i]=new struct();
	    	articleData[i].set(0,"Kang","Context",123,"https://blog.kakaocdn.net/dn/0mySg/btqCUccOGVk/nQ68nZiNKoIEGNJkooELF1/img.jpg","./bin/image/user.png");
	    }
	    
        // 그 데이터로 만든 판넬 ArticleScrollItemPanel에 붙이기
        JLabel[] articles = new JLabel[articleData.length];
        
      //scroll 안에 넣을 판넬
		JPanel ArticleScrollItemPanel = new JPanel();
		ArticleScrollItemPanel.setBackground(Color.WHITE);
		ArticleScrollItemPanel.setLayout(new GridLayout(0,3,5,5));
        try {
        	for (int i = 0; i < articleData.length; i++) {
        	    articles[i] = new JLabel();
        	    articles[i].setIcon(articleImgIcon);
        	    ArticleScrollItemPanel.add(articles[i]);

        	    int finalI = i;  // effectively final로 만들어주기 위해 새로운 변수에 할당
        	    
        	    articles[i].addMouseListener(new MouseAdapter() {
    	        public void mouseClicked(MouseEvent e) {
    				System.out.println("click articleImg");
    				JPanel post = new PostPanel(articleData[finalI]);
    				new CreateFrameWithPanel(post);
    				System.out.println("click articleImg -> post!");
    	        }
    		});
        	}
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        }
				GridBagLayout gbl_profileMainPanel = new GridBagLayout();
				gbl_profileMainPanel.columnWidths = new int[] {350};
				gbl_profileMainPanel.rowHeights = new int[] {166, 166};
				gbl_profileMainPanel.columnWeights = new double[]{1.0};
				gbl_profileMainPanel.rowWeights = new double[]{0.0, 1.0};
				profileMainPanel.setLayout(gbl_profileMainPanel);
						
						
						
						
		JScrollPane scrollPane = new JScrollPane();
		//		scrollPane.setBounds(0, 0, 360, 200);
				scrollPane.setViewportView(ArticleScrollItemPanel);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
				gbc_scrollPane.gridx = 0;
				gbc_scrollPane.gridy = 1;
				profileMainPanel.add(scrollPane, gbc_scrollPane);
				
				
						JPanel profilePanel = new JPanel();
						profilePanel.setLayout(null);
						profilePanel.setBackground(Color.WHITE);
						//profilePanel.setBounds(0,0,350,250);
						
						//id
						JLabel idLabel = new JLabel("id");
						idLabel.setFont(boldFont);
						idLabel.setBounds(60, 10, 50, 15);
						profilePanel.add(idLabel);
						JLabel profileImgLabel = new JLabel("");
						profileImgLabel.setFont(defaultFont);
						profileImgLabel.setHorizontalAlignment(SwingConstants.CENTER);
						profileImgLabel.setBounds(60, 35, 70, 70);
						profileImgLabel.setIcon(ProfileImgIcon);
						profilePanel.add(profileImgLabel);
						
						//게시물 수
						JLabel articleNumLabel = new JLabel("10");
						articleNumLabel.setFont(boldFont);
						articleNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
						articleNumLabel.setBounds(170, 50, 50, 15);
						profilePanel.add(articleNumLabel);
						//게시물 라벨
						JLabel articleLabel = new JLabel("게시물");
						articleLabel.setFont(defaultFont);
						articleLabel.setHorizontalAlignment(SwingConstants.CENTER);
						articleLabel.setBounds(170, 75, 50, 15);
						profilePanel.add(articleLabel);
						
						//팔로워 수
						JLabel followerNumLabel = new JLabel("10");
						followerNumLabel.setFont(boldFont);
						followerNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
						followerNumLabel.setBounds(240, 50, 50, 15);
						profilePanel.add(followerNumLabel);
						//팔로워 라벨
						JLabel followerLabel = new JLabel("팔로워");
						followerLabel.setFont(defaultFont);
						followerLabel.setHorizontalAlignment(SwingConstants.CENTER);
						followerLabel.setBounds(240, 75, 50, 15);
						profilePanel.add(followerLabel);
						
						//팔로잉 수
						JLabel followingNumLabel = new JLabel("10");
						followingNumLabel.setFont(boldFont);
						followingNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
						followingNumLabel.setBounds(310, 50, 50, 15);
						profilePanel.add(followingNumLabel);
						//팔로잉 라벨
						JLabel followingLabel = new JLabel("팔로잉");
						followingLabel.setFont(defaultFont);
						followingLabel.setHorizontalAlignment(SwingConstants.CENTER);
						followingLabel.setBounds(310, 75, 50, 15);
						profilePanel.add(followingLabel);
						
						//이름라벨
						JLabel nameLabel2 = new JLabel("이름");
						nameLabel2.setFont(defaultFont);
						nameLabel2.setBounds(60, 115, 50, 15);
						profilePanel.add(nameLabel2);
						
						//프로필 편집 버튼
						JButton followBtn = new JButton("팔로우");
						followBtn.setFont(defaultFont);
						followBtn.setBounds(267, 114, 100, 23);
						followBtn.setBackground(Color.blue);
						profilePanel.add(followBtn);
						GridBagConstraints gbc_profilePanel = new GridBagConstraints();
						gbc_profilePanel.fill = GridBagConstraints.BOTH;
						gbc_profilePanel.gridx = 0;
						gbc_profilePanel.gridy = 0;
						profileMainPanel.add(profilePanel, gbc_profilePanel);
						

		
		
		
		
		
		
		
		//팔로워 화면 =====================================================================
		JPanel followerPanel = new JPanel();
		followerPanel.setBackground(Color.WHITE);

		//gridbaglayout설정
		GridBagLayout gbl_followerPanel = new GridBagLayout();
		gbl_followerPanel.columnWidths = new int[] {0, 0, 0};
		gbl_followerPanel.rowHeights = new int[]{0, 0, 0};
		gbl_followerPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_followerPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		followerPanel.setLayout(gbl_followerPanel);
		
		//뒤로가기 버튼
		JButton followerBackBtn = new JButton("back");
		followerBackBtn.setFont(defaultFont);
		followerBackBtn.setHorizontalAlignment(SwingConstants.LEFT);
		//뒤로가기 버튼 있는 칸에 제약조건 설정
		GridBagConstraints gbc_followerBackBtn = new GridBagConstraints();
		gbc_followerBackBtn.anchor = GridBagConstraints.WEST;//서쪽으로 정렬
		gbc_followerBackBtn.insets = new Insets(0, 0, 5, 5);//위, 왼, 아래, 오 : 아래쪽 5px 여백
		gbc_followerBackBtn.gridx = 0; //첫번째 열
		gbc_followerBackBtn.gridy = 0; //첫번째 행이라는 뜻
		followerPanel.add(followerBackBtn, gbc_followerBackBtn);
		
		//타이틀 라벨
		JLabel followerTitleLabel = new JLabel("FOLLOWER");
		GridBagConstraints gbc_followerTitleLabel = new GridBagConstraints();
		gbc_followerTitleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_followerTitleLabel.gridx = 1;
		gbc_followerTitleLabel.gridy = 0;
		followerPanel.add(followerTitleLabel, gbc_followerTitleLabel);
	
		//scroll 안에 넣을 판넬
		JPanel followerScrollItemPanel = new JPanel();
		followerScrollItemPanel.setLayout(new BoxLayout(followerScrollItemPanel, BoxLayout.Y_AXIS));
        List<String> data = getData();// 데이터를 담은 리스트[임시]
        // 그 데이터 만든 판넬 followerScrollItemPanel에 붙이기
		data.stream().forEach(d -> followerScrollItemPanel.add(new FollowPanelItem(d)));
				
		//팔로워목록이 들어갈 스클롤 팬
		JScrollPane followerScrollPane = new JScrollPane(followerScrollItemPanel);
		followerScrollPane.setBackground(Color.WHITE);
		GridBagConstraints gbc_followerScrollPane = new GridBagConstraints();
		gbc_followerScrollPane.anchor = GridBagConstraints.NORTH;
		gbc_followerScrollPane.gridwidth = 2;
		gbc_followerScrollPane.fill = GridBagConstraints.HORIZONTAL;//꽉 채우기
		gbc_followerScrollPane.gridx = 0;
		gbc_followerScrollPane.gridy = 1;
		followerPanel.add(followerScrollPane, gbc_followerScrollPane);
		
		
		
		
		//팔로잉 화면=======================================================================
		JPanel followingPanel = new JPanel();
		followingPanel.setBackground(Color.WHITE);

		//gridbaglayout설정
		GridBagLayout gbl_followingPanel = new GridBagLayout();
		gbl_followingPanel.columnWidths = new int[]{0, 348, 0};
		gbl_followingPanel.rowHeights = new int[]{0, 0, 0};
		gbl_followingPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_followingPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		followingPanel.setLayout(gbl_followingPanel);
		
		//scroll 안에 넣을 판넬
		JPanel followingScrollItemPanel = new JPanel();
		followingScrollItemPanel.setLayout(new BoxLayout(followingScrollItemPanel, BoxLayout.Y_AXIS));
        List<String> followingData = getData();// 데이터를 담은 리스트[임시]
        // 그 데이터 만든 판넬 followerScrollItemPanel에 붙이기
        followingData.stream().forEach(d -> followingScrollItemPanel.add(new FollowPanelItem(d)));
		
        //뒤로가기 버튼
		JButton followingBackBtn = new JButton("back");
		GridBagConstraints gbc_followingBackBtn = new GridBagConstraints();
		gbc_followingBackBtn.anchor = GridBagConstraints.WEST;
		gbc_followingBackBtn.insets = new Insets(0, 0, 5, 5);
		gbc_followingBackBtn.gridx = 0;
		gbc_followingBackBtn.gridy = 0;
		followingPanel.add(followingBackBtn, gbc_followingBackBtn);
	
		//타이틀 라벨
		JLabel followingTitleLabel = new JLabel("FOLLOWING");
		GridBagConstraints gbc_followingTitleLabel = new GridBagConstraints();
		gbc_followingTitleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_followingTitleLabel.gridx = 1;
		gbc_followingTitleLabel.gridy = 0;
		followingPanel.add(followingTitleLabel, gbc_followingTitleLabel);
	
		//스크롤 판넬
		JScrollPane followingScrollPane = new JScrollPane(followingScrollItemPanel);
		followingScrollPane.setBackground(Color.WHITE);
		GridBagConstraints gbc_followingScrollPane = new GridBagConstraints();
		gbc_followingScrollPane.anchor = GridBagConstraints.NORTH;
		gbc_followingScrollPane.gridwidth = 2;
		gbc_followingScrollPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_followingScrollPane.gridx = 0;
		gbc_followingScrollPane.gridy = 1;
		followingPanel.add(followingScrollPane, gbc_followingScrollPane);
		
		

		
		// CardLayout에 패널들 추가

		cards.add(profileMainPanel, "profileMainPanel");

		cards.add(followerPanel, "followerPanel");
		cards.add(followingPanel, "followingPanel");
		
		
		
		// 전체에 추가
		add(cards);
		
		
		//클릭 설정
		// 화면 레이아웃 가져오기
		CardLayout cl = (CardLayout) cards.getLayout();
		
		//[profileMainPanel] 프로필 편집 버튼 클릭 
		followBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//cl.show(cards, "editProfilePanel");
				followBtn.setBackground(Color.WHITE);
			}
		});
		//[profileMainPanel] 팔로워 수 라벨 클릭
		followerNumLabel.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent e) {
				cl.show(cards, "followerPanel");
}
		});
		//[profileMainPanel] 팔로잉 수 라벨 클릭 
		followingNumLabel.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent e) {
				cl.show(cards, "followingPanel");
}
		});
		
		//[followerPanel] 뒤로가기 버튼
		followerBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(cards, "profileMainPanel");
			}
		});
		
		//[followingPanel] 뒤로가기 버튼
		followingBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(cards, "profileMainPanel");
			}
		});
		
		
	}
	

	// 테스트를 위한 더미 데이터 생성
    public static List<String> getData() {
        List<String> data = new ArrayList<>();
        data.add("Data 1");
        data.add("Data 2");
        data.add("Data 3");
        data.add("Data 4");
        data.add("Data 5");


        return data;
    }
}
