package instagram;

import utile.SQL;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LogIn extends JFrame{
	SQL sql = new SQL();
    JLabel lblIntro, lblSignUp,lblID,IPassword; 
    JTextField txtUsername, txtID, txtPWD; // Added txtID
    JPasswordField txtPass;
    JButton btnLogin, btnSignUp, btnAsGuest;
    JButton btnTogglePassword;
    
    public LogIn(){
		setTitle("instagram");//프레임 제목 설정
		ImageIcon icon = new ImageIcon("./bin/image/logo.png");	    
        setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);//화면 중앙에 배치
		setResizable(false);
		
        setLayout(null);
        lblIntro = new JLabel("Instagram");
        lblSignUp = new JLabel("Don't have an account yet?\n");
        lblID = new JLabel("ID:"); // Added lblID
        txtID = new JTextField(20); // Added txtID
        IPassword=new JLabel("Password:");
        txtPass=new JPasswordField(20);
        btnLogin = new JButton("Login");
        btnSignUp = new JButton("SignUp");
        btnTogglePassword = new JButton("Show Password");
        
        //Size Control
        btnTogglePassword.setBounds(240, 215, 100, 15);//x,y,width,height
        lblIntro.setBounds(145, 40, 200, 50);
        lblID.setBounds(70, 100, 50, 40); // Adjusted position for ID label
        txtID.setBounds(95, 100, 250, 40); // Added txtID position
        IPassword.setBounds(25, 170, 65, 45);
        txtPass.setBounds(95, 170, 250, 40); 
        btnLogin.setBounds(120, 250, 150, 40);
        lblSignUp.setBounds(110,330,250,20);
        btnSignUp.setBounds(120, 365, 150, 40);

        //Font
        lblIntro.setFont(new Font("Serif", Font.ITALIC|Font.BOLD, 20));
        lblSignUp.setFont(new Font("Monospace", Font.PLAIN,15));
        btnTogglePassword.setFont(new Font("Serif",Font.PLAIN,10));
        
        // ActionListener for Toggle Password button
        btnTogglePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPasswordDialog(null);
            }
        });
        
        add(lblIntro);
        add(lblID); // Added ID label
        add(txtID); // Added ID text field
        add(IPassword);
        add(txtPass);
        add(btnLogin);
        add(lblSignUp);
        add(btnSignUp);
        add(btnTogglePassword);
        
		//Query
		btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(sql.checkPassword(txtID.getText(),txtPass.getText())) {
        		    JOptionPane.showMessageDialog(null, "You have logged in sucessfully");
        			setVisible(false);
        		    new MainFrame(txtID.getText());
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "You failed to log in");
        		}
        	}
        });
		
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignUp();
				setVisible(false);
			}
		});

        setSize(400, 600);
        setVisible(true);
        
    }
    private void showPasswordDialog(JFrame main) {
        JDialog passwordDialog = new JDialog(main, "Password Display", true);
        passwordDialog.setLayout(new FlowLayout());
        
        // 비밀번호 텍스트를 표시할 JLabel
        JLabel lblPassword = new JLabel("Password: " + new String(txtPass.getPassword()));
        
        // 확인 버튼
        JButton btnOK = new JButton("OK");
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordDialog.dispose();
            }
        });

        passwordDialog.add(lblPassword);
        passwordDialog.add(btnOK);

        passwordDialog.setSize(160, 80);
        passwordDialog.setLocationRelativeTo(this);
        passwordDialog.setVisible(true);
    }
    
    public static void main(String[] args) {
    	new LogIn();
    }
}

