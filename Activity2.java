import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Activity2 {
	
	JFrame frame = new JFrame();
	GridBagConstraints c = new GridBagConstraints();
	
	JLabel imageLabel = new JLabel();
	ImageIcon image;
	
	Activity2() {
		frame.setLayout(new GridBagLayout());
		frame.setSize(new Dimension(500, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(300, 100);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setVisible(true);
		
		image = new ImageIcon("D:\\Texibition Project\\brainware_image.jpg");
		imageLabel.setIcon(image);
		
		c.gridx=0;
		c.gridy=0;
		frame.add(imageLabel, c);
		
		frame.pack();
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Activity2();
			}
		});
	}
}
