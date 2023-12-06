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
import java.util.Arrays;
import java.util.List;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.LineBorder;

import utile.*;

public class ProfilePanel extends JPanel {
	private static SQL sql = new SQL();
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
	public ProfilePanel(String user_id) {
		String[] following = sql.findFollowing(user_id);
		String[] follower = sql.findFollower(user_id);
		UserStruct user = sql.getUser(user_id);
		ArticleStruct[] article = sql.getUserArticle(user_id);
		
		setLayout(new GridLayout(0, 1, 0, 0));
		JPanel cards = new JPanel(new CardLayout());
		
		
		//프로필 수정 화면
		JPanel editProfilePanel = new JPanel();
		editProfilePanel.setLayout(null);//AbsoluteLayout : 배치관리자가 없는 컨테이너로 설정
		editProfilePanel.setBackground(Color.WHITE);
		
		//수정 확인 버튼
		JButton editBtn = new JButton("확인");
		editBtn.setBounds(330, 10, 60, 23);
		editBtn.setFont(defaultFont);
		editProfilePanel.add(editBtn);
		
		//취소 버튼 (나가기)
		JButton exitBtn = new JButton("취소");
		exitBtn.setBounds(60, 10, 60, 23);
		exitBtn.setFont(defaultFont);
		editProfilePanel.add(exitBtn);
		
		//프로필 이미지 세팅
		ImageIcon editProfileImgicon = null;
		try {
		    URL imageUrl = new URL("https://github.com/hyeonji91/database_team_project/assets/112065014/db0fbf09-d522-40ef-ad0b-7c802ecd455c");
		    editProfileImgicon = new ImageIcon(imageUrl);
		    editProfileImgicon = utile.ImageIconResize.resizeImage(editProfileImgicon, 80, 80);//resize
		} catch (Exception e) {
		    e.printStackTrace();
		}
		JLabel ImgLabel = new JLabel("");
		ImgLabel.setBackground(new Color(255, 255, 255));
		ImgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImgLabel.setIcon(editProfileImgicon);
		ImgLabel.setBounds(185, 57, 80, 80);
		editProfilePanel.add(ImgLabel);
		
		//프로필 이미지 수정 버튼
		JButton editImgBtn = new JButton("사진 수정");
		editImgBtn.setFont(defaultFont);
		editImgBtn.setBounds(177, 147, 93, 23);
		editProfilePanel.add(editImgBtn);
		
		
		editImgBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame imgFrame = new JFrame("instagram");
				ImageIcon icon = new ImageIcon("./bin/image/logo.png");	    
				imgFrame.setIconImage(icon.getImage());
				imgFrame.setSize(450, 700);
				imgFrame.setLocationRelativeTo(null);//화면 중앙에 배치
				imgFrame.setResizable(false);
		    	imgFrame.setLayout(new GridLayout(0, 1));
				
				JPanel imgPanel = new JPanel();
				imgPanel.setLayout(null);
				
				//url입력
				JLabel URL = new JLabel("URL :  ");
				URL.setBounds(25, 200, 40, 40);
				//url입력 textfield
			    JTextField URLtf = new JTextField();
			    URLtf.setBounds(65, 200, 350, 40);

			    imgPanel.add(URL);
			    imgPanel.add(URLtf);

			    //이미지 등록 버튼
			    JButton commit = new JButton("commit");
			    commit.setPreferredSize(new Dimension(400,40));
			    commit.setBounds(25, 260, 400, 40);

			    commit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//url가져오기
						String url = URLtf.getText();
						System.out.println("url : "+url);
						
						
						//프로필 이미지 세팅
						ImageIcon editProfileImgicon = null;
						try {
						    URL imageUrl = new URL(url);
						    editProfileImgicon = new ImageIcon(imageUrl);
						    editProfileImgicon = utile.ImageIconResize.resizeImage(editProfileImgicon, 80, 80);//resize
						} catch (Exception e2) {
						    e2.printStackTrace();
						}
						ImgLabel.setIcon(editProfileImgicon);
						//editProfilePanel다시그리기
						editProfilePanel.repaint();
						sql.changeProfileImg(url, user_id);
						
						imgFrame.setVisible(false);
					}
				} );
			    imgPanel.add(commit);
			    
			    imgFrame.add(imgPanel);
				imgFrame.setVisible(true);
			}
		});
		
		
		//이름 수정
		JLabel nameLabel = new JLabel("이름");
		nameLabel.setFont(defaultFont);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(60, 190, 50, 15);
		editProfilePanel.add(nameLabel);
		//이름 수정 textField
		nameTF = new JTextField();
		nameTF.setFont(defaultFont);
		nameTF.setBounds(120, 187, 270, 21);
		editProfilePanel.add(nameTF);
		nameTF.setColumns(10);
		
		//비밀번호 수정
		JLabel pwdLabel = new JLabel("비밀번호");
		pwdLabel.setFont(defaultFont);
		pwdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pwdLabel.setBounds(60, 220, 50, 15);
		editProfilePanel.add(pwdLabel);
		//비밀번호 수정 passwordField
		pwdPF = new JPasswordField();
		pwdPF.setFont(defaultFont);
		pwdPF.setBounds(120, 217, 270, 21);
		editProfilePanel.add(pwdPF);
		
		//생일 수정
		JLabel birthLabel = new JLabel("생일");
		birthLabel.setFont(defaultFont);
		birthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		birthLabel.setBounds(60, 250, 50, 15);
		editProfilePanel.add(birthLabel);
		//생일 수정 passwordField
		birthTF = new JTextField();
		birthTF.setFont(defaultFont);
		birthTF.setColumns(10);
		birthTF.setBounds(120, 247, 270, 21);
		editProfilePanel.add(birthTF);
		
		//성별 수정
		JLabel genderLabel = new JLabel("성별");
		genderLabel.setFont(defaultFont);
		genderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		genderLabel.setBounds(60, 280, 50, 15);
		editProfilePanel.add(genderLabel);
		//성별 수정 passwordField
		genderTF = new JTextField();
		genderTF.setFont(defaultFont);
		genderTF.setColumns(10);
		genderTF.setBounds(120, 277, 270, 21);
		editProfilePanel.add(genderTF);
		
		//핸드폰 번호 수정
		JLabel phoneLabel = new JLabel("phone");
		phoneLabel.setFont(defaultFont);
		phoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phoneLabel.setBounds(60, 310, 50, 15);
		editProfilePanel.add(phoneLabel);
		//핸드폰 번호 수정 passwordField
		phoneTF = new JTextField();
		phoneTF.setFont(defaultFont);
		phoneTF.setColumns(10);
		phoneTF.setBounds(120, 307, 270, 21);
		editProfilePanel.add(phoneTF);
		
		//주소 수정
		JLabel addressLabel = new JLabel("주소");
		addressLabel.setFont(defaultFont);
		addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addressLabel.setBounds(60, 340, 50, 15);
		editProfilePanel.add(addressLabel);
		//주소 수정 passwordField
		addressTF = new JTextField();
		addressTF.setFont(defaultFont);
		addressTF.setColumns(10);
		addressTF.setBounds(120, 337, 270, 43);
		editProfilePanel.add(addressTF);
		//add(followingPanel, "FollowingPanel");
		
		//Event
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameTF.getText();
				String password = pwdPF.getText();
				String birth = birthTF.getText();
				String gender = genderTF.getText();
				String phone = phoneTF.getText();
				String address = addressTF.getText();
				
				if (name =="") name = user.getName();
				if (password=="") password = user.getPassword();
				if(birth=="")birth=user.getBirth();
				if(gender=="")gender=user.getGender();
				if(phone=="")phone=user.getPhone_number();
				if(address=="")address=user.getAddress();
				
				UserStruct temp = new UserStruct(user_id,name,password,birth,gender,phone,address);
				sql.changeUser(temp);
			}
		});
		
		
		
		//프로필 화면========================================================================================
		JPanel profileMainPanel = new JPanel();
		GridBagConstraints gbc= new GridBagConstraints();
		
		profileMainPanel.setBackground(Color.WHITE);
		profileMainPanel.setBounds(0, 0, 350, 680);
		
		//프로필 이미지
		ImageIcon ProfileImgIcon = null;
		try {
		    URL imageUrl = new URL(sql.getProfileImg(user_id));
		    ProfileImgIcon = new ImageIcon(imageUrl);
		    ProfileImgIcon = utile.ImageIconResize.resizeImage(ProfileImgIcon, 70, 70);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		//데이터 담는 것
	    struct[] articleData = new struct[article.length];
	    for(int i=0;i<articleData.length;i++) {
	    	articleData[i]=new struct();
	    	articleData[i].set(article[i].getLike_num(),sql.getNickname(article[i].getUser_id()),article[i].getContext(),article[i].getArticle_id(),sql.getImage(article[i].getArticle_id()),sql.getProfileImg(article[i].getUser_id()));
	    }
	    
        // 그 데이터로 만든 판넬 ArticleScrollItemPanel에 붙이기
        JLabel[] articles = new JLabel[articleData.length];
        
      //scroll 안에 넣을 판넬
		JPanel ArticleScrollItemPanel = new JPanel();
		ArticleScrollItemPanel.setBackground(Color.WHITE);
		ArticleScrollItemPanel.setLayout(new GridLayout(0,3,5,5));
        try {
        	for (int i = 0; i < articleData.length; i++) {
        		URL imageUrl = new URL(articleData[i].getURL());
        		ImageIcon articleImgIcon = new ImageIcon(imageUrl);
    		    articleImgIcon = utile.ImageIconResize.resizeImage(articleImgIcon, 133, 133);
        		
        	    articles[i] = new JLabel();
        	    articles[i].setIcon(articleImgIcon);
        	    ArticleScrollItemPanel.add(articles[i]);

        	    int finalI = i;  // effectively final로 만들어주기 위해 새로운 변수에 할당
        	    
        	    articles[i].addMouseListener(new MouseAdapter() {
    	        public void mouseClicked(MouseEvent e) {
    				System.out.println("click articleImg");
    				JPanel post = new PostPanel(articleData[finalI], user_id);
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
						JLabel idLabel = new JLabel(user_id);
						idLabel.setFont(boldFont);
						idLabel.setBounds(60, 10, 200, 15);
						profilePanel.add(idLabel);
						JLabel profileImgLabel = new JLabel("");
						profileImgLabel.setFont(defaultFont);
						profileImgLabel.setHorizontalAlignment(SwingConstants.CENTER);
						profileImgLabel.setBounds(60, 35, 70, 70);
						profileImgLabel.setIcon(ProfileImgIcon);
						profilePanel.add(profileImgLabel);
						
						//게시물 수
						JLabel articleNumLabel = new JLabel(""+article.length);
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
						JLabel followerNumLabel = new JLabel(""+follower.length);
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
						JLabel followingNumLabel = new JLabel(""+following.length);
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
						JLabel nameLabel2 = new JLabel(user.getName());
						nameLabel2.setFont(defaultFont);
						nameLabel2.setBounds(60, 115, 150, 15);
						profilePanel.add(nameLabel2);
						
						//프로필 편집 버튼
						JButton profileEditBtn = new JButton("프로필 편집");
						profileEditBtn.setFont(defaultFont);
						profileEditBtn.setBounds(267, 114, 100, 23);
						profilePanel.add(profileEditBtn);
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
        String[] followerData = getData(user_id, 1);// 데이터를 담은 리스트[임시]
        // 그 데이터 만든 판넬 followerScrollItemPanel에 붙이기
        for(int i=0;i<followerData.length;i++) {
        	followerScrollItemPanel.add(new FollowPanelItem(followerData[i]));
        }
				
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
        String[] followingData = getData(user_id, 0);// 데이터를 담은 리스트[임시]
        // 그 데이터 만든 판넬 followerScrollItemPanel에 붙이기
        for(int i=0;i<followingData.length;i++) {
        	followingScrollItemPanel.add(new FollowPanelItem(followingData[i]));
        }
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
		cards.add(editProfilePanel, "editProfilePanel");

		cards.add(followerPanel, "followerPanel");
		cards.add(followingPanel, "followingPanel");
		
		
		
		// 전체에 추가
		add(cards);
		
		
		//클릭 설정
		// 화면 레이아웃 가져오기
		CardLayout cl = (CardLayout) cards.getLayout();
		
		//[profileMainPanel] 프로필 편집 버튼 클릭 
		profileEditBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(cards, "editProfilePanel");
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
		//[editProfilePanel] 취소 버튼 클릭
		exitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(cards, "profileMainPanel");
			}
		});
		//[editProfilePanel] 수정 확인 버튼 클릭
		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(cards, "profileMainPanel");
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
	

	// mode = 0 -> following / mode = 1 -> follower
    public static String[] getData(String user_id, int mode) {
    	String[] data = null;
        if(mode == 1)	data = sql.findFollower(user_id);
        else			data = sql.findFollowing(user_id);
        

        return data;
    }
}
