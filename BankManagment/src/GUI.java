import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class GUI extends JFrame implements ActionListener {
     JFrame frame;
     JLabel label,label1, label2 ;
     JButton jb1,jb2,jb3;
    
    
    GUI()
    {
    
    	frame=new JFrame(" Banking System ");
    	setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    	frame.getContentPane().setBackground(Color.WHITE);
    	
    	label= new JLabel("  Welcome to Banking System");
    	label.setBounds(20, 30,700, 60);
    	
    	label.setFont(new Font("AGENCY FB", Font.BOLD, 50));
    	
    	label1= new JLabel( " Do not have account? Sign Up " );
    	label1.setFont(new Font("Calbri",Font.BOLD,18));
    	label1.setBounds(120,120, 300, 50);
    	
    	
    	label2=new JLabel("Already have account? Sign In");
    	label2.setFont(new Font("Calibri",Font.BOLD,18));
    	label2.setBounds(120, 250, 300, 50);
    	
    	
   
    	jb1=new JButton(" Sign Up ");
    	jb1.setBorderPainted(true);
    	jb1.setBounds(130, 180, 200, 50);
    	jb1.setBackground(Color.pink);
    	
    	
    	
    	jb2=new JButton(" Sign In ");
    	jb2.setBorderPainted(true);
    	jb2.setBounds(130, 310, 200, 50);
    	jb2.setBackground(Color.pink);
    	
    	
    	
    	
    	frame.add(label);
    	frame.add(label1);
    	frame.add(label2);
    	frame.add(jb1);
    	frame.add(jb2);
    	
    	frame.setLayout(null);
    	frame.setSize(600,450);
    	frame.setVisible(true);
    	
    	
    	
    	jb1.addActionListener(this);
    	jb2.addActionListener(this);
    	
    }
    public void actionPerformed(ActionEvent e) 
    {
		if(e.getSource()==jb1)
		{
			frame.setVisible(false);
			new Accountinterface().setVisible(true);
		}
		if(e.getSource()==jb2)
		{
			frame.setVisible(false);
			new LoginGUI().setVisible(true);
		}
		
	}
    public static void main (String args[])
    {
    	new GUI();
    }
	
	

}