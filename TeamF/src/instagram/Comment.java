package instagram;

import utile.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import utile.CommentStruct;

class comment_struct {
	private int group_num;
	private int hierarchy;
	private String user_id;
	private String text;

	public int getGroup_num() {
		return group_num;
	}

	public int getHierarchy() {
		return hierarchy;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getText() {
		return text;
	}

	public void set(int group, int hie, String user, String content) {
		group_num = group;
		hierarchy = hie;
		user_id = user;
		text = content;
	}
}

class Comment {
	Comment(String user_id, int article_id) {
		SQL sql = new SQL();

		JFrame frame = new JFrame("Instagram");
		frame.setSize(450, 700);
		frame.setLayout(new BorderLayout());

		// 인스타그램 로고
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.WHITE);
		topPanel.setLayout(new BorderLayout());
		topPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

		ImageIcon Instagramicon = new ImageIcon("./bin/image/Instagram-Logo.png"); // Replace with your own logo file
		Image InstagramImg = Instagramicon.getImage();
		Image InstagramChangeImg = InstagramImg.getScaledInstance(120, 60, Image.SCALE_SMOOTH);
		ImageIcon InstagramChageIcon = new ImageIcon(InstagramChangeImg);
		JButton logoLabel = new JButton(InstagramChageIcon);
		logoLabel.setBorderPainted(false);
		logoLabel.setBackground(Color.WHITE);
		logoLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Post(user_id);
				frame.setVisible(false);
			}
		});

		topPanel.add(logoLabel, BorderLayout.WEST);

		// 페널에 추가할 UI 를 미리 만든다.
		JLabel label = new JLabel("Main" + " : ");
		label.setBorder(new EmptyBorder(0, 20, 0, 0));
		JTextField inputName = new JTextField(15);
		JButton addBtn = new JButton("댓글삽입");
		
		// 삭제 버튼
		JButton deleteBtn = new JButton("댓글 삭제");

		// 페널에 UI 를 추가
		JPanel tPanel = new JPanel();
		tPanel.setLayout(new BorderLayout());
		tPanel.add(label, BorderLayout.NORTH);
		JPanel tempPanel = new JPanel();
		tempPanel.add(inputName);
		tempPanel.add(addBtn);
		tempPanel.add(deleteBtn);
		tempPanel.setBackground(Color.WHITE);
		tPanel.add(tempPanel, BorderLayout.CENTER);
		tPanel.setBackground(Color.WHITE);
		tPanel.setPreferredSize(new Dimension(450, 60));

		// 스크롤 창 부분
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.WHITE);
		// centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.setLayout(new FlowLayout());
		centerPanel.setPreferredSize(new Dimension(450, 600));
		centerPanel.setBorder(BorderFactory.createEmptyBorder(-6, 0, 0, 0));

		// Create a JScrollPane and add the center panel to it
		JScrollPane scrollPane = new JScrollPane(centerPanel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(30);
		scrollPane.setBackground(Color.white);
		scrollPane.setForeground(Color.white);

		// Query
		CommentStruct[] temp = sql.getComment(article_id); 
		comment_struct[] list = new comment_struct[temp.length];
		for (int i = 0; i < temp.length; i++) {
			list[i] = new comment_struct();
			list[i].set(temp[i].getGroup_num(), temp[i].getHierarchy(), temp[i].getUser_id(), temp[i].getContext());
		}	

		for (int i = 0; i < list.length; i++) {
			JLabel name = new JLabel();
			name.setFont(new Font("Arial", Font.BOLD, 14));
			JLabel comment = new JLabel();
			comment.setText(list[i].getText());
			comment.setFont(new Font("Arial", Font.BOLD, 14));

			if (list[i].getHierarchy() == 1) {
				JButton block = new JButton();
				block.setBackground(Color.WHITE);
				block.setLayout(new FlowLayout());
				block.setPreferredSize(new Dimension(450, 20));
				name.setText(list[i].getUser_id() + " : ");

				block.setLayout(new BorderLayout());
				block.add(name, BorderLayout.WEST);
				block.add(comment, BorderLayout.CENTER);
				centerPanel.add(block);
				
				block.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String temp = label.getText();
						if (temp == "Main" + " : ") {
							label.setText(name.getText() + comment.getText());
						} else {
							label.setText("Main" + " : ");
						}
					}
				});
			} else {
				JLabel sub = new JLabel();
				sub.setBackground(Color.WHITE);
				sub.setLayout(new FlowLayout());
				sub.setPreferredSize(new Dimension(450, 10));
				name.setText("           ->  " + list[i].getUser_id() + " : ");

				sub.setLayout(new BorderLayout());
				sub.add(name, BorderLayout.WEST);
				sub.add(comment, BorderLayout.CENTER);
				centerPanel.add(sub);
			}
		}

		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = label.getText();
				if (temp != "Main" + " : ") {
					String find = label.getText();
					int group_num =sql.find_group(article_id, user_id, find.substring(find.indexOf(":")+2));
					sql.delete_comment(article_id, group_num);
					
					new Comment(user_id, article_id);
					frame.setVisible(false);
				}
			}
		});
		
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String context = inputName.getText();
				inputName.setText("");			
				String temp = label.getText();
				String find=label.getText();
				if (temp == "Main" + " : ") {
					int group_num =sql.find__next_group(article_id);
					CommentStruct newone = new CommentStruct(-1,article_id,group_num,1,null,context,user_id);
					sql.addComment(newone);
				} else {
					int group_num =sql.find_group(article_id, user_id, find.substring(find.indexOf(":")+2));
					CommentStruct newone = new CommentStruct(-1,article_id, group_num, 2,null,context,user_id);
					sql.addComment(newone);
				}
				
				
				new Comment(user_id, article_id);
				frame.setVisible(false);
			}
		});

		
		JPanel main = new JPanel();
		main.add(tPanel);
		main.add(scrollPane);
		main.setBackground(Color.WHITE);

		// Add the top panel and scroll pane to the frame
		frame.add(topPanel, BorderLayout.NORTH);
		// 페널째로 프레임의 상단에 추가하기
		frame.add(main, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);// 화면 중앙에 배치
	}

}