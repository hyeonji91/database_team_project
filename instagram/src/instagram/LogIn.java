//package instagram;
package instagram;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LogIn extends JPanel{

    JLabel lblIntro, lblregister, lblAsGuest,lblID,IPassword,IText; 
    JTextField txtUsername, txtID, txtPWD; // Added txtID
    JPasswordField txtPass;
    JButton btnLogin, btnRegister, btnAsGuest;
    JButton btnTogglePassword;
    
    public LogIn(JFrame main){
        //super("Instagram");
        
	    //ImageIcon icon = new ImageIcon("./bin/image/logo.png");	    
        //setIconImage(icon.getImage());
        
        setLayout(null);
        lblIntro = new JLabel("Instagram");
        lblregister = new JLabel("Don't have an account yet?\n");
        IText=new JLabel("-------------------------OR--------------------------");
        lblAsGuest = new JLabel("or continue as Guest");
        lblID = new JLabel("ID:"); // Added lblID
        txtID = new JTextField(20); // Added txtID
        IPassword=new JLabel("Password:");
        txtPass=new JPasswordField(20);
        btnLogin = new JButton("Login");
        btnRegister = new JButton("Register");
        btnTogglePassword = new JButton("비밀번호 표시");
        
        //Size Control
        btnTogglePassword.setBounds(270, 215, 100, 15);//x,y,width,height
        lblIntro.setBounds(175, 40, 200, 50);
        lblID.setBounds(75, 100, 50, 40); // Adjusted position for ID label
        txtID.setBounds(125, 100, 250, 40); // Added txtID position
        IPassword.setBounds(55, 170, 60, 45);
        txtPass.setBounds(125, 170, 250, 40); 
        btnLogin.setBounds(150, 250, 150, 40);
        lblregister.setBounds(135, 300, 210, 18);
        IText.setBounds(110,320,250,20);
        btnRegister.setBounds(150, 365, 150, 40);
        lblAsGuest.setBounds(160, 415, 150, 12);

        //Font
        lblIntro.setFont(new Font("Serif", Font.ITALIC|Font.BOLD, 20));
        lblregister.setFont(new Font("Monospace", Font.PLAIN,15));
        btnTogglePassword.setFont(new Font("Serif",Font.PLAIN,10));
        
        //btn function
//        btnLogin.addActionListener(new ActionListener() {
//        	public void actionPerformed(ActionEvent e) {
//        		String id="Bo";
//        		String pass="1234";
//        		
//        		if(id.equals(txtID.getText())&&pass.equals(txtPass.getText())) {
//        			JOptionPane.showMessageDialog(null, "You have logged in sucessfully");
//        			//setVisible(false);
//        		}
//        		else {
//        			JOptionPane.showConfirmDialog(null, "You failed to log in");
//        		}
//        	}
//        });
        
        // ActionListener for Toggle Password button
        btnTogglePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPasswordDialog(main);
            }
        });
        
        add(lblIntro);
        add(lblID); // Added ID label
        add(txtID); // Added ID text field
        add(IPassword);
        add(txtPass);
        add(btnLogin);
        add(IText);
        add(lblregister);
        add(btnRegister);
        add(lblAsGuest);
        add(btnTogglePassword);
//        addWindowListener(new WindowAdapter(){
//            public void windowClosing(WindowEvent exit){
//                System.exit(0);
//            }
//        });

        setSize(400, 600);
        setVisible(true);
//        setLocationRelativeTo(null);
//        setResizable(false);
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

//    public static void main(String[] args){
//        LogIn login = new LogIn();
//    }
}
