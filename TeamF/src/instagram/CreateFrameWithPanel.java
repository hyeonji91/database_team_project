package instagram;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CreateFrameWithPanel extends JFrame{

	//panel을 포함한 new frame제작
	CreateFrameWithPanel(JPanel p) { 
			 
	    	//JFrame frame = new JFrame();
	    	this.setTitle("instagram");//프레임 제목 설정
			ImageIcon icon = new ImageIcon("./bin/image/logo.png");	    
			this.setIconImage(icon.getImage());
			this.setSize(450, 700);
			this.setLocationRelativeTo(null);//화면 중앙에 배치
			this.setResizable(false);
	    	
			this.add(p);
			this.setVisible(true);

	}
}
