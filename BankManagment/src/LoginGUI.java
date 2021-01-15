import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginGUI extends JFrame  implements ActionListener
{
JFrame frame;
JPanel panel;
JButton button;
JLabel label, password;
JTextField text;
JPasswordField pText;
          LoginGUI ()
           {
        	  frame= new JFrame("User Login");
        	  frame.setSize(300,200);
        	 
        	  panel= new JPanel();
        	  panel.setLayout(null);
        	  panel.setBackground(Color.white);
        	  
        	  label=new JLabel("User Name");
        	  label.setBounds(10, 20, 80, 25);
        	  panel.add(label);
        	  
        	  text = new JTextField(100);
        	  text.setBounds(100, 20, 165, 25);
        	  panel.add(text);
        	   password = new JLabel ("Password");
        	  password.setBounds(10, 50, 80, 25);
        	  panel.add(password);
        	  pText= new JPasswordField();
        	  pText.setBounds(100, 50, 165, 25);
        	  panel.add(pText);
        	  //panel.add(frame);
        	  frame.add(panel);
        	  frame.setVisible(true);
        	  button = new JButton("Login");
        	  button.setBounds(100, 90, 70, 25);
        	  button.setBackground(Color.pink);
        	  panel.add(button);
        	  button.addActionListener(this);
        	  
	       }
          @Override
          public void actionPerformed(ActionEvent e)
  		{
        	String userEmail=text.getText();
        	String Password=pText.getText();
        	 
  			if(e.getSource()==button)
  			{
  				frame.setVisible(false);
  				new Menue().setVisible(true);
  			}
  			
  			
  		}
          
          public static void main(String args[])
          {
        	  new LoginGUI().setVisible(true);
          }
		
		
}
