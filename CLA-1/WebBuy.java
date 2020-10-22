// Java program to create a blank text 
// field of definite number of columns. 
import java.awt.event.*; 
import javax.swing.*; 
class WebBuy extends JFrame implements ActionListener { 
	// JTextField 
	static JTextField t1; 
	static JTextField t2; 
	static JTextField t3; 

	// JFrame 
	static JFrame f; 

	// JButton 
	static JButton b; 

	// label to display text 
	static JLabel l; 

	// default constructor 
	WebBuy() 
	{ 
	} 

	// main class 
	public static void main(String[] args) 
	{ 

		f = new JFrame("Web Buy Application"); 
		l = new JLabel("nothing entered"); 
		b = new JButton("submit"); 


		WebBuy te = new WebBuy(); 


		b.addActionListener(te); 


        t1 = new JTextField(16); 
        t2 = new JTextField(16); 
        t3 = new JTextField(100000); 

		// create a panel to add buttons and textfield 
		JPanel p = new JPanel(); 

		// add buttons and textfield to panel 
        p.add(t1); 
        p.add(t2); 
        p.add(t3); 
		p.add(b); 
		p.add(l); 

		// add panel to frame 
		f.add(p); 

		// set the size of frame 
		f.setSize(300, 300); 

		f.show(); 
	} 

	// if the vutton is pressed 
	public void actionPerformed(ActionEvent e) 
	{ 
		String s = e.getActionCommand(); 
		if (s.equals("submit")) { 
			// set the text of the label to the text of the field 
			l.setText(t1.getText()); 

			// set the text of field to blank 
			t1.setText(" "); 
		} 
	} 
} 
