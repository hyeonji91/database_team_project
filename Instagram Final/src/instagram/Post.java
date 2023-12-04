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

class Post extends JPanel{
	
	Post(){
		
//		JFrame frame = new JFrame("Instagram");
		this.setSize(450, 700);
		this.setLayout(new BorderLayout());    
		
		//인스타그램 로고
		JPanel topPanel = new JPanel();
	    topPanel.setBackground(Color.WHITE);
	    topPanel.setLayout(new BorderLayout());
	    topPanel.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 10));
	    
	    ImageIcon Instagramicon = new ImageIcon("./bin/image/Instagram-Logo.png"); // Replace with your own logo file
	    Image InstagramImg = Instagramicon.getImage();
	    Image InstagramChangeImg=InstagramImg.getScaledInstance(120, 60, Image.SCALE_SMOOTH);
	    ImageIcon InstagramChageIcon = new ImageIcon(InstagramChangeImg);
	    JButton logoLabel = new JButton(InstagramChageIcon);
	    logoLabel.setBorderPainted(false);
	    logoLabel.setBackground(Color.WHITE);
	    logoLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Post();
				setVisible(false);//원래 frame
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
				setVisible(false);//원래 frame
			}
		});
	    
	    topPanel.add(logoLabel, BorderLayout.WEST);
	    topPanel.add(CameraLabel, BorderLayout.EAST);
	    
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
	        JPanel postPanel = new PostPanel(list[i]);
	        centerPanel.add(postPanel);
	    }
		 // Create a JScrollPane and add the center panel to it
	    JScrollPane scrollPane = new JScrollPane(centerPanel);
	    scrollPane.getVerticalScrollBar().setUnitIncrement(30); 
	    scrollPane.setBackground(Color.white);
	    scrollPane.setForeground(Color.white);
	    
	    // Add the top panel and scroll pane to the frame
	    this.add(topPanel, BorderLayout.NORTH);
	    this.add(scrollPane, BorderLayout.CENTER);
	    this.setVisible(true);
	    this.setLocation(500, 150);

	}
//	public static void main(String args[]) throws IOException {
//        new post();
//    }
}
