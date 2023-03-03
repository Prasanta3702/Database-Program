import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainActivity {
	
	JFrame frame = new JFrame();
	
	GridBagConstraints c = new GridBagConstraints();
	
	JPanel panel1 = new JPanel();
	
	JLabel imageLabel = new JLabel();
	
	JTextField userField = new JTextField(20);
	JPasswordField passField = new JPasswordField(20);
	
	MainActivity() {
	
		
		frame.setLayout(new GridBagLayout());
		frame.setSize(new Dimension(500, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(550, 100);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setVisible(true);
		
		
		c.weightx=1;
		c.weighty=1;
		c.fill = GridBagConstraints.BOTH;
		c.insets=new Insets(10, 10, 10, 10);
		
		panel1.setLayout(new GridBagLayout());
		panel1.setBackground(Color.DARK_GRAY);
		
			GridBagConstraints c2 = new GridBagConstraints();
			
			ImageIcon image1 = new ImageIcon("D:\\Texibition Project\\user2.png");
			imageLabel.setIcon(image1);
			
			c2.gridx=0;
			c2.gridy=0;
			panel1.add(imageLabel, c2);
			
			c2.insets = new Insets(40, 0, 10, 0);
			
			// username & password
			userField.setText("Username");
			userField.addFocusListener(new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					if(userField.getText().equals("Username")) {
						userField.setText("");
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					
					if(userField.getText().equals("")) {
						userField.setText("Username");
					}
				}
			});
			
			c2.gridx=0;
			c2.gridy=2;
			c2.ipady=6;
			panel1.add(userField, c2);
			
			
			passField.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(MainActivityConnector.check(userField.getText(), passField.getText())) {
						JOptionPane.showMessageDialog(passField, "Successfull");
						new Activity2();
						frame.setVisible(false);
					}
					else JOptionPane.showMessageDialog(passField, "UnSuccessfull");
				}
				
			});
			
			c2.insets = new Insets(0, 0, 0, 0);
			c2.gridx=0;
			c2.gridy=4;
			panel1.add(passField, c2);
			
		c.gridx=0;
		c.gridy=0;
		frame.add(panel1, c);

	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainActivity();
			}
		});
	}
}
