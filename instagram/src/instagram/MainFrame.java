package instagram;

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

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
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
		
		JTabbedPane pane = createTabbedPane(this);//메뉴
		LogIn login = new LogIn(this);

		// CardLayout에 패널들 추가
		cards.add(login, "login");
		cards.add(pane, "TabbedPane");
		CardLayout cl = (CardLayout) cards.getLayout();

		login.btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String id="Bo";
        		String pass="1234";
        		
        		if(id.equals(login.txtID.getText())&&pass.equals(login.txtPass.getText())) {
        			JOptionPane.showMessageDialog(null, "You have logged in sucessfully");
        			cl.show(cards, "TabbedPane");
        		}
        		else {
        			JOptionPane.showConfirmDialog(null, "You failed to log in");
        		}
        	}
        });
		
		
		// 전체에 추가
		
		
	
		contentPane.add(cards);
		//contentPane.add(pane);
		
		setContentPane(contentPane);
	}
	
    public ProfilePanel profilePanel = null;
    public PostPanel postPanel = null;
 
    public void change(JPanel p) { // 패널 1번과 2번 변경 후 재설정
 
    	JFrame frame = new JFrame();
    	frame.setTitle("instagram");//프레임 제목 설정
		ImageIcon icon = new ImageIcon("./bin/image/logo.png");	    
		frame.setIconImage(icon.getImage());
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 700);
		frame.setLocationRelativeTo(null);//화면 중앙에 배치
		frame.setResizable(false);
    	
		frame.add(p);
	    frame.setVisible(true);

		
		
//        getContentPane().removeAll();
//        getContentPane().add(p);
//        revalidate();
//        repaint();
        
		
		
//        if (panelName.equals("profilePanel")) {
//            getContentPane().removeAll();
//            getContentPane().add(profilePanel);
//            revalidate();
//            repaint();
//        } else {
//            getContentPane().removeAll();
//            getContentPane().add(postPanel);
//            revalidate();
//            repaint();
//        }
    }
	
	
	public JTabbedPane createTabbedPane(MainFrame frame) {
		JTabbedPane pane = new JTabbedPane();
		pane.setTabPlacement(JTabbedPane.BOTTOM);
		
//		pane.addTab("Article", new JLabel("article"));
//		pane.addTab("Profile", new JLabel("profile"));
		pane.addTab("Article", new post(frame));
		pane.addTab("Profile", new ProfilePanel(frame));
		
		return pane;
	}

}
