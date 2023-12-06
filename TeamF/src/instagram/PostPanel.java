package instagram;

import utile.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PostPanel extends JPanel{
	
	PostPanel(struct list, String user_id){
		SQL sql = new SQL();
//		JPanel this = new JPanel();
        this.setPreferredSize(new Dimension(300, 550));
        this.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        this.setBackground(Color.WHITE);

        JPanel userInfo = new JPanel();
        userInfo.setPreferredSize(new Dimension(400, 60));
        userInfo.setBackground(Color.WHITE);
        
        //유저의 프로필
        ImageIcon UserChangeIcon=null;
        try {
        	URL imageURL = new URL(list.getProfileURL());
            ImageIcon UserIcon = new ImageIcon(imageURL);
            UserChangeIcon=ImageIconResize.resizeImage(UserIcon,50,50);
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
        
        //글 누가 쓴지
        JLabel UserLabel = new JLabel(UserChangeIcon);
       
        //글의 유저 이름
        String username =list.getUsername();
       // JLabel UserName = new JLabel("  "+username);
        JLabel UserName = new JLabel("  "+ user_id);

        UserName.setFont(new Font("Arial",Font.BOLD, 14));
	    
        UserName.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	System.out.println("click userName");
				JPanel profilePanel = new OtherUserProfilePanel(sql.nameToID(username));
				new CreateFrameWithPanel(profilePanel);
				System.out.println("click userName -> profile!");
	        }
		});
        
        //글의 그림
        JPanel Post = new JPanel();
        Post.setLayout(new BorderLayout());
        Post.setBackground(Color.WHITE);
	    
        Image image=null;
        
        try {
        	System.out.println(list.getURL());
        	URL url = new URL(list.getURL());
        	image=ImageIO.read(url);
            ImageIcon PostImage = new ImageIcon(image);
            Image PostImg = PostImage.getImage();
            Image PostChangeImg = PostImg.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            ImageIcon PostChangeIcon = new ImageIcon(PostChangeImg);
            JLabel PostLabel = new JLabel(PostChangeIcon);
    		   
            Post.add(PostLabel,BorderLayout.NORTH);
        }
        catch(IOException e) {
        	e.printStackTrace();
        }
        catch(NullPointerException e) {
        	try {
        		String re = "https://mblogthumb-phinf.pstatic.net/MjAyMDA5MDNfMjk0/MDAxNTk5MTI1ODQzMTAy.vvvvkfj2ujzZx1TXfyHk6lcXsyWuptP1OcRUXfUnYUcg.tUDit1T4ppM07McaG4-8g1Uc3TRSOeQwGhQ79bRtjqkg.PNG.shshspdla/16%EB%8C%8010.png?type=w800";
        		URL rea = new URL(re);
        		image= ImageIO.read(rea);
        		ImageIcon PostImage = new ImageIcon(image);
                Image PostImg = PostImage.getImage();
                Image PostChangeImg = PostImg.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
                ImageIcon PostChangeIcon = new ImageIcon(PostChangeImg);
                JLabel PostLabel = new JLabel(PostChangeIcon);
        		   
                Post.add(PostLabel,BorderLayout.NORTH);
        	}
        	catch(Exception e2) {
        		e2.printStackTrace();
        	}
        }


        //글의 내용
        String postContext = list.getContext();
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
				new Comment(user_id, list.getArticle_num());
			}
		});
	    
	    //좋아요 수
        int like_num = list.getLike_num();
        JLabel like_label = new JLabel("  "+"like"+"  "+like_num);
        like_label.setFont(new Font("Arial",Font.BOLD, 14));
        
        //좋아요 추가
        LikeLabel.addActionListener(new ActionListener() {
        	int likes = like_num;
            public void actionPerformed(ActionEvent e) {
                likes++;
                sql.upLike(list.getArticle_num());
                like_label.setText("  "+"like"+"  "+likes);
            }
        });
        	
        
        //추가
        userInfo.setLayout(new BoxLayout(userInfo, BoxLayout.X_AXIS));
        UnderPanel.setLayout(new BoxLayout(UnderPanel, BoxLayout.X_AXIS));
        userInfo.add(UserLabel);
        userInfo.add(UserName);
        this.add(userInfo);
        this.add(Post);
	    UnderPanel.add(commentLabel);
	    UnderPanel.add(LikeLabel);
	    UnderPanel.add(like_label);
	    this.add(UnderPanel);
//        centerPanel.add(this);
	}
}
