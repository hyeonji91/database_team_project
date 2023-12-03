package instagram;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.net.URL;

class struct{
	private int like_num;
	private String username;
	private String context;
	private int Article_num;
	private String URL;
	private String profileURL;
	public void set(int like, String user, String con, int article, String url, String profile){
		like_num=like;
		username=user;
		context=con;
		Article_num=article;
		URL=url;
		profileURL=profile;
	}
	public int getLike_num() {
		return like_num;
	}
	public String getUsername() {
		return username;
	}
	public String getContext() {
		return context;
	}
	public int getArticle_num() {
		return Article_num;
	}
	public String getURL() {
		return URL;
	}
	public String getProfileURL() {
		return profileURL;
	}
}

class post extends JPanel{
	
	post(){
		
		JFrame frame = new JFrame("Instagram");
		frame.setSize(450, 700);
		frame.setLayout(new BorderLayout());    
		
		//인스타그램 로고
		//JPanel this = new JPanel();
	    this.setBackground(Color.WHITE);
	    this.setLayout(new BorderLayout());
	    this.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 10));
	    
	    ImageIcon Instagramicon = new ImageIcon("./bin/image/Instagram-Logo.png"); // Replace with your own logo file
	    Image InstagramImg = Instagramicon.getImage();
	    Image InstagramChangeImg=InstagramImg.getScaledInstance(120, 60, Image.SCALE_SMOOTH);
	    ImageIcon InstagramChageIcon = new ImageIcon(InstagramChangeImg);
	    JButton logoLabel = new JButton(InstagramChageIcon);
	    logoLabel.setBorderPainted(false);
	    logoLabel.setBackground(Color.WHITE);
	    logoLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new post();
				frame.setVisible(false);
			}
		});
	    
		//카메라올리기		    
	    ImageIcon Cameraicon = new ImageIcon("./bin/image/camera.png"); // Replace with your own logo file
	    Image CameraImg = Cameraicon.getImage();
	    Image CameraChangeImg=CameraImg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	    ImageIcon CameraChageIcon = new ImageIcon(CameraChangeImg);
	    JButton CameraLabel = new JButton(CameraChageIcon);
	    CameraLabel.setBackground(Color.white);
	    CameraLabel.setBorderPainted(false);
	    CameraLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new newPost("https://mblogthumb-phinf.pstatic.net/MjAyMDA5MDNfMjk0/MDAxNTk5MTI1ODQzMTAy.vvvvkfj2ujzZx1TXfyHk6lcXsyWuptP1OcRUXfUnYUcg.tUDit1T4ppM07McaG4-8g1Uc3TRSOeQwGhQ79bRtjqkg.PNG.shshspdla/16%EB%8C%8010.png?type=w800");
				frame.setVisible(false);
			}
		});
	    
	    this.add(logoLabel, BorderLayout.WEST);
	    this.add(CameraLabel, BorderLayout.EAST);
	    
	    // 스크롤 창 부분
	    JPanel centerPanel = new JPanel();
	    centerPanel.setBackground(Color.WHITE);
	    centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
	    
	    
	    
	    //Query
	    
	    //Test set
	    struct[] list = new struct[5];
	    for(int i=0;i<list.length;i++) {
	    	list[i]=new struct();
	    	list[i].set(0,"Kang","Context",123,"https://blog.kakaocdn.net/dn/0mySg/btqCUccOGVk/nQ68nZiNKoIEGNJkooELF1/img.jpg","./bin/image/user.png");
	    }

	    // Create and add the post panels
	    for (int i = 0; i < list.length; i++) {
	        // Create the post panel
	        JPanel postPanel = new JPanel();
	        postPanel.setPreferredSize(new Dimension(300, 550));
	        postPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
	        postPanel.setBackground(Color.WHITE);

	        JPanel userInfo = new JPanel();
	        userInfo.setPreferredSize(new Dimension(400, 60));
	        userInfo.setBackground(Color.WHITE);
	        
	        //유저의 프로필
	        ImageIcon UserIcon = new ImageIcon(list[i].getProfileURL());
	        Image UserImg = UserIcon.getImage();
	        Image UserChangeImg=UserImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	        ImageIcon UserChangeIcon=new ImageIcon(UserChangeImg);
		   
	        //글 누가 쓴지
	        JLabel UserLabel = new JLabel(UserChangeIcon);
	       
	        //글의 유저 이름
	        String username =list[i].getUsername();
	        JLabel UserName = new JLabel("  "+username);
	        UserName.setFont(new Font("Arial",Font.BOLD, 14));
		        
	        //글의 그림
	        JPanel Post = new JPanel();
	        Post.setLayout(new BorderLayout());
	        Post.setBackground(Color.WHITE);
		    
	        Image image=null;
	        try {
	        	URL url =  new URL(list[i].getURL());
	        	image=ImageIO.read(url);
	        }
	        catch(IOException e) {
	        	e.printStackTrace();
	        }
	        ImageIcon PostImage = new ImageIcon(image);
	        Image PostImg = PostImage.getImage();
	        Image PostChangeImg = PostImg.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
	        ImageIcon PostChangeIcon = new ImageIcon(PostChangeImg);
	        JLabel PostLabel = new JLabel(PostChangeIcon);
			   
	        Post.add(PostLabel,BorderLayout.NORTH);
		        
	        //글의 내용
	        String postContext = list[i].getContext();
	        JLabel context = new JLabel("  "+postContext);
	        context.setFont(new Font("Arial", Font.BOLD,17));
	        
	        Post.add(context, BorderLayout.SOUTH);
		        
	        //댓글, 좋아요
	        JPanel UnderPanel = new JPanel();
	        UnderPanel.setPreferredSize(new Dimension(400, 60));
	        UnderPanel.setBackground(Color.WHITE);
		        
	        //좋아요
	        ImageIcon Likeicon = new ImageIcon("./bin/image/like.png"); // Replace with your own logo file
		    Image LikeImg = Likeicon.getImage();
		    Image LikeChangeImg=LikeImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		    ImageIcon LikeChageIcon = new ImageIcon(LikeChangeImg);
		    JButton LikeLabel = new JButton(LikeChageIcon);
		    LikeLabel.setPreferredSize(new Dimension(30,30));
		    LikeLabel.setBackground(Color.WHITE);
		    LikeLabel.setBorderPainted(false);

			    
		    //댓글
		    ImageIcon commenticon = new ImageIcon("./bin/image/comment.png"); // Replace with your own logo file
		    Image commentImg = commenticon.getImage();
		    Image commentChangeImg=commentImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		    ImageIcon commentChageIcon = new ImageIcon(commentChangeImg);
		    JButton commentLabel = new JButton(commentChageIcon);
		    commentLabel.setBackground(Color.WHITE);
		    commentLabel.setBorderPainted(false);
		    UnderPanel.add(commentLabel, BorderLayout.WEST);
		    
		    //댓글창 열기
		    commentLabel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Comment();
				}
			});
		    
		    //좋아요 수
	        int like_num = list[i].getLike_num();
	        JLabel like_label = new JLabel("  "+"like"+"  "+like_num);
	        like_label.setFont(new Font("Arial",Font.BOLD, 14));
	        
	        //좋아요 추가
	        LikeLabel.addActionListener(new ActionListener() {
	        	int likes = like_num;
	            public void actionPerformed(ActionEvent e) {
	                likes++;
	                //Query
	                like_label.setText("  "+"like"+"  "+likes);
	            }
	        });
	        	
	        
	        //추가
	        userInfo.setLayout(new BoxLayout(userInfo, BoxLayout.X_AXIS));
	        UnderPanel.setLayout(new BoxLayout(UnderPanel, BoxLayout.X_AXIS));
	        userInfo.add(UserLabel);
	        userInfo.add(UserName);
	        postPanel.add(userInfo);
	        postPanel.add(Post);
		    UnderPanel.add(commentLabel);
		    UnderPanel.add(LikeLabel);
		    UnderPanel.add(like_label);
		    postPanel.add(UnderPanel);
	        centerPanel.add(postPanel);
	    }
		 // Create a JScrollPane and add the center panel to it
	    JScrollPane scrollPane = new JScrollPane(centerPanel);
	    scrollPane.getVerticalScrollBar().setUnitIncrement(30); 
	    scrollPane.setBackground(Color.white);
	    scrollPane.setForeground(Color.white);
	    
	    // Add the top panel and scroll pane to the frame
	    frame.add(this, BorderLayout.NORTH);
	    frame.add(scrollPane, BorderLayout.CENTER);
	    frame.setVisible(true);
	    frame.setLocation(500, 150);

	}
//	public static void main(String args[]) throws IOException {
//        new post();
//    }
}
