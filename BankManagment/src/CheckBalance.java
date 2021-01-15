import java.awt.event.*; 

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class CheckBalance extends JFrame implements ActionListener {
	Connectivity con =new Connectivity();
	JFrame jf;
JButton jb1;
JLabel jl1;
JTextField tf;
CheckBalance(){
	
	 JPanel jp= new JPanel(null);
	 jf=new JFrame("Banking System");
	 
	 jp.setBackground(Color.white);
	 
	 
	 jl1=new JLabel("Enter Account Number");
	 jl1.setBounds(60, 20, 300, 50);
	 jl1.setFont(new Font("Arial", Font.BOLD, 20));
	 
	 tf=new JTextField();
	 tf.setBounds(50,100,250,50);
	 
	 jb1=new JButton("OK");
	 jb1.setBounds(100,190,150,50);
	 jb1.setBackground(Color.pink);
	 
	    jp.add(jl1);
	    jp.add(tf);
	    jp.add(jb1);

	    	    
	     setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
	     jf.setSize(400,400); 
	     jf.add(jp);       
	     jf.setVisible(true);
	     
	     jb1.addActionListener(this);
	     
	    
		}

public void actionPerformed(ActionEvent e) 
{
	if(e.getSource()==jb1)
	{
		String acc=tf.getText();
		String blnc;
		
		String res=con.Compare(acc);
		
		if(res!=null)
		{
			System.out.println(res);
			String rs[]=res.split(" ");
			blnc=rs[1];
			JOptionPane.showMessageDialog(null,"Your Current account is:"+blnc ,"Confirmation",JOptionPane.WARNING_MESSAGE);	
			
		
		}	
			else
			{
				JOptionPane.showMessageDialog(null,"Re-enter Account!!!" ,"Warning",JOptionPane.WARNING_MESSAGE);	
			}
	}
	jf.dispose();
	new Menue().setVisible(true);
	
}
public static void main(String args[])
{
	new CheckBalance(); 
}
}