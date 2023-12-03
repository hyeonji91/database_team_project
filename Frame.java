package instagram;
//import java.awt.BorderLayout;
//import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
//import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame {
	/*public static void main(String[] args) {
		JFrame frame =new JFrame();
		JPanel panel=new JPanel();
		JLabel label=new JLabel("Some text");
		JButton btn1=new JButton("Click me!!");
		//JTextArea txtArea=new JTextArea(); //원하는 만큼 글씨 쓸 수 있음.
		//JTextField -> 한줄만 글씨 쓸 수 있음.
		JPanel btnPanel=new JPanel();
		JButton btn2=new JButton("Exit");
		
		panel.setLayout(new BorderLayout());//자기가 원하는 방식,위치에 두는 법
		
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		panel.add(label, BorderLayout.NORTH);//북쪽에 위치함.
		panel.add(btnPanel,BorderLayout.CENTER);
		//panel.add(txtArea,BorderLayout.CENTER);
		
		btn2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		frame.add(panel);//panel을 직접 넣어야 들어가게 됨.
		
		frame.setResizable(false);//program이 자동으로 움직일 수 있게 없게 하는거
		frame.setVisible(true);//보이게
		frame.setPreferredSize(new Dimension(1080,1080));
		frame.setSize(1080,1080);
		frame.setLocationRelativeTo(null);//어떤 위치에서 GUI를 실행할건가, null = 가운데
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//우리가 껐을 때 프로그램이 어떻게 행동해야 할지
		//EXIT_ON_CLOSE -> 프로그램 껐을 때 모든 것이 종료되는..
	}*/
	public static void main(String[] args) {
	    JFrame frame = new JFrame();
	    
	    Insets insets = new Insets(4, 4, 4, 4);
	    JPanel inputPanel = new JPanel(new GridBagLayout());
	    inputPanel.add(new JLabel("Username: "), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, insets, 0, 0));
	    inputPanel.add(new JTextField(), new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));
	    inputPanel.add(new JLabel("Password: "), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, insets, 0, 0));
	    inputPanel.add(new JPasswordField(), new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));
	    
	    JPanel buttonPanel = new JPanel(new GridBagLayout());
	    buttonPanel.add(new JButton("Register"), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, insets, 0, 0));
	    buttonPanel.add(new JButton("Log In"), new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, insets, 0, 0));
	    
	    frame.setLayout(new GridBagLayout());
	    frame.add(new JLabel("Welcome to List"), new GridBagConstraints(0, 0, 2, 1, 0, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));
	    frame.add(inputPanel, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));
	    frame.add(buttonPanel, new GridBagConstraints(0, 2, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0));
	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
}
}
