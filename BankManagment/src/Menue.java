import java.awt.event.*; 

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class Menue extends JFrame implements ActionListener {
JFrame jf;
JButton jb1,jb2,jb3,jb4,jb5;
JLabel jl1;
Menue(){
	Connectivity con =new Connectivity();
	 JPanel jp= new JPanel(null);
	 jf=new JFrame("Banking System");
	 
	 jp.setBackground(Color.white);
	 
	 
	 jl1=new JLabel("MENU");
	 jl1.setBounds(140, 20, 200, 50);
	 jl1.setFont(new Font("Arial", Font.BOLD, 24));
	 
	 jb1=new JButton("Add Money");
	 jb1.setBounds(10,90,150,50);
	 jb1.setBackground(Color.pink);
	 
	 jb2=new JButton("Transfer Money");
	 jb2.setBounds(180,90,150,50);
	 jb2.setBackground(Color.pink);

	 jb5=new JButton("Check Balance");
	 jb5.setBounds(100,170,150,50);
	 jb5.setBackground(Color.pink);
	 
	 
	
	    jp.add(jl1);
	    jp.add(jb1);
	    jp.add(jb2);
	    jp.add(jb5);
	   
	    
	   
	    
	     setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
	     jf.setSize(400,300); 
	     jf.add(jp);       
	     jf.setVisible(true);
	     
	     jb1.addActionListener(this);
	     jb2.addActionListener(this);
	     jb5.addActionListener(this);
	    
		}

		@Override
		public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			if(e.getSource()==jb1)
			{
				jf.setVisible(false);
				new AddMoney().setVisible(true);
				jf.dispose();
			}
			if(e.getSource()==jb2)
			{
				jf.setVisible(false);
				new Transfer().setVisible(true);
				jf.dispose();
			}
			if(e.getSource()==jb5)
			{
				new CheckBalance().setVisible(true);
			}
			}


	public static void main(String[] args) {  
	    new Menue();  
	}


	
}
