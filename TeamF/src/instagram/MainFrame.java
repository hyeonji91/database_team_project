package instagram;

import utile.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
	SQL sql = new SQL();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static String my_user_id;

	public MainFrame(String user_id) {
		my_user_id = user_id;
		
		setTitle("instagram");//프레임 제목 설정
		ImageIcon icon = new ImageIcon("./bin/image/logo.png");	    
        setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 700);
		setLocationRelativeTo(null);//화면 중앙에 배치
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel cards = new JPanel(new CardLayout());
		
		JTabbedPane pane = createTabbedPane(user_id);//메뉴

		// CardLayout에 패널들 추가
		cards.add(pane, "TabbedPane");
		CardLayout cl = (CardLayout) cards.getLayout();
		cl.show(cards, "TabbedPane");

		
		// 전체에 추가
		
		
	
		contentPane.add(cards);
		//contentPane.add(pane);
		
		setContentPane(contentPane);
		
		setVisible(true);
	}
	
//    public ProfilePanel profilePanel = null;
//    public PostPanel postPanel = null;
// 
//    public void change(JPanel p) { // 패널 1번과 2번 변경 후 재설정
// 
//    	JFrame frame = new JFrame();
//    	frame.setTitle("instagram");//프레임 제목 설정
//		ImageIcon icon = new ImageIcon("./bin/image/logo.png");	    
//		frame.setIconImage(icon.getImage());
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(450, 700);
//		frame.setLocationRelativeTo(null);//화면 중앙에 배치
//		frame.setResizable(false);
//    	
//		frame.add(p);
//	    frame.setVisible(true);
//
//		
//		
////        getContentPane().removeAll();
////        getContentPane().add(p);
////        revalidate();
////        repaint();
//        
//		
//		
////        if (panelName.equals("profilePanel")) {
////            getContentPane().removeAll();
////            getContentPane().add(profilePanel);
////            revalidate();
////            repaint();
////        } else {
////            getContentPane().removeAll();
////            getContentPane().add(postPanel);
////            revalidate();
////            repaint();
////        }
//    }
	
	
	public JTabbedPane createTabbedPane(String user_id) {
		JTabbedPane pane = new JTabbedPane();
		pane.setTabPlacement(JTabbedPane.BOTTOM);
		Post post = new Post(user_id);
//		pane.addTab("Article", new JLabel("article"));
//		pane.addTab("Profile", new JLabel("profile"));
		pane.addTab("Article", post);
		pane.addTab("Profile", new ProfilePanel(user_id));
		
		return pane;
	}

}
