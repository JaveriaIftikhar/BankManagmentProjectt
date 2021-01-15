import java.awt.event.*; 
import java.sql.*;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
public class AddMoney extends JFrame  implements ActionListener {
	Connectivity con=new Connectivity();
	JLabel jl1,jl2,jl3;
	JFrame jf;
	JTextField tf1,tf2;
	JButton jb1,jb2;
	AddMoney()
	{
		 JPanel jp= new JPanel(null);
		 jp.setBackground(Color.white);
		 jf=new JFrame("Banking System");
		 jf.getContentPane().setBackground(Color.BLACK);
		 jl1=new JLabel("ADD MONEY");
		jl1.setBounds(100, 10, 250, 50);
		jl1.setFont(new Font("Arial", Font.BOLD, 24));
		
		 jl2=new JLabel("Account no");
		 jl2.setBounds(10, 50,170, 50);
		 jl2.setFont(new Font("Arial", Font.BOLD, 16));
		 tf1=new JTextField();
		 tf1.setBounds(10,90,270,30);
		 
		 jl3=new JLabel("Amount");
		 jl3.setBounds(10, 130, 170, 30);
		 jl3.setFont(new Font("Arial", Font.BOLD, 16));
		 tf2=new JTextField();
		 tf2.setBounds(10, 170, 270,30);
		 
		 jb1=new JButton("ADD");
		 jb1.setBounds(10,220,100,50);
		 jb1.setBackground(Color.pink);
		 
		 jb2=new JButton("BACK");
		 jb2.setBounds(150,220,100,50);
		 jb2.setBackground(Color.pink);
				 
			 
		  jp.add(jl1);
		  jp.add(jl2);
		  jp.add(tf1);
		  jp.add(jl3);
		  jp.add(tf2);
		  jp.add(jb1);
		  jp.add(jb2);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		  
		   setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		     jf.setSize(400,400); 
		     jf.add(jp);       
		     jf.setVisible(true);
			}
	public void actionPerformed(ActionEvent e)
	{
		String acc=tf1.getText();
		String Am=tf2.getText();
		int Amount=Integer.parseInt(Am);	
		int updatedBlnc=0;
		System.out.println("indide action listener");
		try {

			if(e.getSource()==jb1)
			{
				String blnc;
				
				String res=con.Compare(acc);
				
				if(res!=null)
				{
				System.out.println(res);
				String rs[]=res.split(" ");
					blnc=rs[1];
					System.out.println("Blnc is: "+blnc);
				
					int B1=Integer.parseInt(blnc);							//Table data;
											//Form data;
					
					
						updatedBlnc=B1+Amount;
						System.out.println("updated balance is:"+updatedBlnc);
						
						String result=con.update(updatedBlnc,acc);
						
						JOptionPane.showMessageDialog(null,"Amount Deposited successfully!!! " ,"Confirmation",JOptionPane.WARNING_MESSAGE);	
						JOptionPane.showMessageDialog(null,"New Amount: "+updatedBlnc+"" ,"Confirmation",JOptionPane.WARNING_MESSAGE);	
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Account not found!!!" ,"Warning",JOptionPane.WARNING_MESSAGE);	
					}
			}
			if(e.getSource()==jb2)
			{
				jf.dispose();
				new Menue();
			}
		}catch(Exception ex){
            ex.printStackTrace();
        }
	}


		public static void main(String[] args) {  
		    new AddMoney();  
		}
	}