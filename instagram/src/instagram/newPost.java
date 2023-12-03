package instagram;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class newPost{
	newPost(String address){
		JFrame frame = new JFrame("Instagram");
		frame.setSize(450, 700);
		frame.setLayout(new BorderLayout());
		
		//인스타그램 로고
		JPanel topPanel = new JPanel();
	    topPanel.setBackground(Color.WHITE);
	    topPanel.setLayout(new BorderLayout());
	    topPanel.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 0 , 10));
	    topPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
	    
	    ImageIcon Instagramicon = new ImageIcon("./bin/image/Instagram-Logo.png"); // Replace with your own logo file
	    Image InstagramImg = Instagramicon.getImage();
	    Image InstagramChangeImg=InstagramImg.getScaledInstance(120, 60, Image.SCALE_SMOOTH);
	    ImageIcon InstagramChageIcon = new ImageIcon(InstagramChangeImg);
	    JButton logoLabel = new JButton(InstagramChageIcon);
	    logoLabel.setBorderPainted(false);
	    logoLabel.setBackground(Color.WHITE);
	    logoLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
	    topPanel.add(logoLabel, BorderLayout.WEST);
	    
	    logoLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new post();
				frame.setVisible(false);
			}
		});
	    
	    //중간 부분
	    JPanel main = new JPanel();
	    main.setBackground(Color.WHITE);
	    main.setLayout(new FlowLayout());	    
	   
	    
	    
	    //URL 입력창
	    JPanel URLPanel=new JPanel();
	    URLPanel.setBackground(Color.WHITE);
	    URLPanel.setLayout(new FlowLayout());
	    
	    JLabel URL = new JLabel("URL :  ");
	    URL.setPreferredSize(new Dimension(40,40));
	    
	    JTextField URLtf = new JTextField();
	    URLtf.setPreferredSize(new Dimension(360,40));
	    URLPanel.add(URL);
	    URLPanel.add(URLtf);
	    main.add(URLPanel);
	   
	    //이미지 띄워주는 창
	    Image image=null;
	    try {
	    	URL url = new URL(address);
	    	image=ImageIO.read(url);
	    }
	    catch(IOException e) {
	    	e.printStackTrace();
	    	}
	    ImageIcon preimage = new ImageIcon(image);
	    Image ImageImg = preimage.getImage();
	    Image ChangeImg = ImageImg.getScaledInstance(300,300,Image.SCALE_SMOOTH);
	    ImageIcon finalImg = new ImageIcon(ChangeImg);
	    JLabel ImageLabel=new JLabel(finalImg);
	    
	    URLtf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newaddress=URLtf.getText();
				new newPost(newaddress);
				frame.setVisible(false);
			}
		});
	    
	    main.add(ImageLabel);
	    
	    //Comment 입력창
	    JPanel CommentPanel=new JPanel();
	    CommentPanel.setBackground(Color.WHITE);
	    CommentPanel.setLayout(new BorderLayout());
	    
	    JLabel comment = new JLabel("Comment :       ");
	    comment.setPreferredSize(new Dimension(400,30));
	    
	    JTextField commenttf = new JTextField();
	    commenttf.setPreferredSize(new Dimension(400,150));
	    
	    CommentPanel.add(comment, BorderLayout.NORTH);
	    CommentPanel.add(commenttf, BorderLayout.SOUTH);
	    main.add(CommentPanel);
	    
	    
	    //올리기 버튼 만들기
	    JPanel CommitPanel=new JPanel();
	    CommitPanel.setBackground(Color.WHITE);
	    JButton commit = new JButton("commit");
	    commit.setPreferredSize(new Dimension(400,40));
	    CommitPanel.add(commit);
	    
	    commit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new post();
				String commnet=commenttf.getText();
				String url = address;
				//Query
				frame.setVisible(false);
			}
		} );
	    
	    //frame 띄우기
	    frame.add(topPanel, BorderLayout.NORTH);
	    frame.add(main, BorderLayout.CENTER);
	    frame.add(CommitPanel, BorderLayout.SOUTH);
	    frame.setVisible(true);
	    frame.setLocation(500, 150);
	}	
}

