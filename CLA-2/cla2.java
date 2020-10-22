import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

class WebBuy extends JFrame implements ActionListener {
  static JTextField t1;
  static JTextField t2;
  static JTextArea t3;
  static JScrollPane scroll;

  static JFrame f;

  static JButton b;

  static JLabel l1;
  static JLabel l2;
  static JLabel l3;
  static JLabel l;

  WebBuy() {}

  public static void main(String[] args) {
    f = new JFrame("Web Buy Application");
    l1 = new JLabel("TO");
    l2 = new JLabel("SUBJECT");
    l3 = new JLabel("MESSAGE");
    b = new JButton("SEND");

    l = new JLabel("");

    WebBuy te = new WebBuy();

    b.addActionListener(te);

    t1 = new JTextField(16);
    t2 = new JTextField(16);
    t3 = new JTextArea(5, 16);
    scroll =
      new JScrollPane(
        t3,
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
      );

    JPanel p = new JPanel();

    p.add(l1);
    p.add(t1);
    p.add(l2);
    p.add(t2);
    p.add(l3);
    p.add(scroll);
    p.add(b);
    p.add(l);
    f.add(p);
    f.setSize(220, 400);

    f.show();
  }

  public void actionPerformed(ActionEvent e) {
    if (t1.getText().isEmpty()) {
      l.setText("Please Enter A Valid To Address");
    } else if (t2.getText().isEmpty()) {
      l.setText("Please Enter A Valid Subject");
    } else if (t3.getText().isEmpty()) {
      l.setText("Please Enter A  Valid Message");
    } else {
      t1.setText(" ");
      t2.setText(" ");
      t3.setText(" ");
      l.setText("Message has been Sent");
    }
  }
}
