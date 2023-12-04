package instagram;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SignUp {
	 public SignUp(){
	     JFrame frame = new JFrame("Instagram");
		 ImageIcon icon = new ImageIcon("./src/Image/logo.png");
	     frame.setIconImage(icon.getImage());
	     frame.setLayout(new FlowLayout());
	     frame.setBackground(Color.WHITE);
	     frame.setSize(400, 600);
	     
	     ImageIcon img = new ImageIcon("./src/Image/Instagram-Logo.png");
	     JLabel instagram = new JLabel(img);
	     
	     JLabel user = new JLabel("User ID : ");
	     JLabel name = new JLabel("Name : ");
	     JLabel password = new JLabel("Password : ");
	     JLabel passwordcheck = new JLabel("Password Check : ");
	     JLabel birth = new JLabel("Birth : ");
	     JLabel gender = new JLabel("Gender : ");
	     JLabel phone_number = new JLabel("Phone : ");
	     JLabel address = new JLabel("Address : ");
	     //JLabel nickname = new JLabel("Nickname : ");
	     
	     JTextField user_tf = new JTextField();
	     JTextField name_tf = new JTextField();
	     JPasswordField password_tf = new JPasswordField();
	     JPasswordField passwordcheck_tf = new JPasswordField();
	     JTextField birth_tf = new JTextField();
	     JPanel gender_tf = new JPanel();
	     ButtonGroup g = new ButtonGroup();
	     JRadioButton male = new JRadioButton("male");
	     JRadioButton female = new JRadioButton("female");
	     JTextField phone_number_tf = new JTextField();
	     JTextField address_tf = new JTextField();
	     //JTextField nickname_tf = new JTextField();
	     
	     gender_tf.add(male);
	     gender_tf.add(female);
	     g.add(female);
	     g.add(male);
	     
	     JPanel user_pn = new JPanel();
	     JPanel name_pn = new JPanel();
	     JPanel password_pn = new JPanel();
	     JPanel passwordcheck_pn = new JPanel();
	     JPanel birth_pn = new JPanel();
	     JPanel gender_pn = new JPanel();
	     JPanel phone_number_pn = new JPanel();
	     JPanel address_pn = new JPanel();
	    //JPanel nickname_pn = new JPanel();
	     
	     user_tf.setPreferredSize(new Dimension(150, 20));
	     name_tf.setPreferredSize(new Dimension(150, 20));
	     password_tf.setPreferredSize(new Dimension(150, 20));
	     passwordcheck_tf.setPreferredSize(new Dimension(150,20));
	     birth_tf.setPreferredSize(new Dimension(150, 20));
	     phone_number_tf.setPreferredSize(new Dimension(150, 20));
	     address_tf.setPreferredSize(new Dimension(150, 20));
	     //nickname_tf.setPreferredSize(new Dimension(150, 20));
	     
	     user_pn.setLayout(new BorderLayout());
	     name_pn.setLayout(new BorderLayout());
	     password_pn.setLayout(new BorderLayout());
	     passwordcheck_pn.setLayout(new BorderLayout());
	     birth_pn.setLayout(new BorderLayout());
	     phone_number_pn.setLayout(new BorderLayout());
	     gender_pn.setLayout(new BorderLayout());
	     address_pn.setLayout(new BorderLayout());
	    // nickname_pn.setLayout(new BorderLayout());
	     
	     user_pn.setPreferredSize(new Dimension(300, 20));
	     name_pn.setPreferredSize(new Dimension(300, 20));
	     password_pn.setPreferredSize(new Dimension(300, 20));
	     passwordcheck_pn.setPreferredSize(new Dimension(300,20));
	     birth_pn.setPreferredSize(new Dimension(300, 20));
	     phone_number_pn.setPreferredSize(new Dimension(300,20));
	     gender_pn.setPreferredSize(new Dimension(300,40));
	     address_pn.setPreferredSize(new Dimension(300, 20)); 
	    // nickname_pn.setPreferredSize(new Dimension(300, 20));
	     
	     gender_pn.setBorder(BorderFactory.createEmptyBorder(-10,0,0,0));
	     
	     user_pn.add(user, BorderLayout.WEST);
	     name_pn.add(name, BorderLayout.WEST);
	     password_pn.add(password, BorderLayout.WEST);
	     passwordcheck_pn.add(passwordcheck, BorderLayout.WEST);
	     birth_pn.add(birth, BorderLayout.WEST);
	     phone_number_pn.add(phone_number, BorderLayout.WEST);
	     gender_pn.add(gender, BorderLayout.WEST);
	     address_pn.add(address, BorderLayout.WEST);
	     //nickname_pn.add(nickname, BorderLayout.WEST);
	     
	     user_pn.add(user_tf, BorderLayout.EAST);
	     name_pn.add(name_tf, BorderLayout.EAST);
	     password_pn.add(password_tf, BorderLayout.EAST);
	     passwordcheck_pn.add(passwordcheck_tf, BorderLayout.EAST);
	     birth_pn.add(birth_tf, BorderLayout.EAST);
	     phone_number_pn.add(phone_number_tf, BorderLayout.EAST);
	     gender_pn.add(gender_tf, BorderLayout.EAST);
	     address_pn.add(address_tf, BorderLayout.EAST);
	     //nickname_pn.add(nickname_tf, BorderLayout.EAST);
	     
	     JButton ok = new JButton("SignUp");
	     JButton cancel = new JButton("Go Login");
	     JPanel select = new JPanel();
	     select.add(ok);
	     select.add(cancel);
	     
	     frame.add(instagram);
	     frame.add(user_pn);
	     frame.add(name_pn);
	     //frame.add(nickname_pn);
	     frame.add(password_pn);
	     frame.add(passwordcheck_pn);
	     frame.add(birth_pn);
	     frame.add(phone_number_pn);
	     frame.add(address_pn);
	     frame.add(gender_pn);
	     frame.add(select);
		 frame.setLocation(500, 150);

	     cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame login = new MainFrame();
				login.setVisible(true);
				frame.setVisible(false);
			}
		});
	     
	     ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int error=-1;
				//Query로 id 들고 오기
				for(int i=0;i<8;i++) {
					//if(user_tf.getText()==){
					//JOptionPane.showMessageDialog(null, "The ID already exists");
					//error=1;
					//}
				}
				if(password_tf.getText().equals(passwordcheck_tf)) {
					JOptionPane.showMessageDialog(null, "Password not same");
					error=1;
				}
				
				//Query로 데이터 저장
				String user = user_tf.getText();
				String name = name_tf.getText();
				String password= password_tf.getText();
				String birth = birth_tf.getText();
				String phone = phone_number_tf.getText();
				String Address = address_tf.getText();
				String gender = null;
				if(male.isSelected()) {
					gender="male";
				}
				else if(female.isSelected()){
					gender="female";
				}
				else {
					JOptionPane.showMessageDialog(null, "Gender is not selected");
					error=1;
				}
				
				if(error==1) {
				}
				else if(user.equals("")&&name.equals("")&&password.equals("")&&birth.equals("")&&Address.equals("")&&phone.equals("")) {
					JOptionPane.showMessageDialog(null, "Fill the blank");
				}
				else {
					MainFrame login = new MainFrame();
					login.setVisible(true);
					frame.setVisible(false);
				}
			}
		});
	     
	     frame.setLocationRelativeTo(null);
	     frame.setVisible(true);
	 }
}