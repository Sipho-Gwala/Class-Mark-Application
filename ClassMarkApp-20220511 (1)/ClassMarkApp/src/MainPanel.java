import java.io.IOException;

import javax.swing.JFrame;

public class MainPanel {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		JFrame myframe = new JFrame();
		 myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 myframe.add(new ClassMarks());
		 myframe.setSize(1024, 768);
		 myframe.setVisible(true);
	}

	}