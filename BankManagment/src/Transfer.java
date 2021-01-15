import java.awt.event.*; 
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;



public class Transfer  extends JFrame  implements ActionListener{

	Connectivity con1=new Connectivity();
	JFrame jf;
	JTextField tf1,tf2,tf3,tf4;
	JButton jb1,jb2,jb3;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	Transfer(){
		 JPanel jp= new JPanel(null);
		 jp.setBackground(Color.white);
		 jf=new JFrame("Banking System");
		 jl1=new JLabel("TRANSFER MONEY");
		jl1.setBounds(80, 10, 250, 50);
		jl1.setFont(new Font("Arial", Font.BOLD, 24));
		
		jl2=new JLabel("UserName");
		jl2.setBounds(10, 50,170, 50);
		 jl2.setFont(new Font("Arial", Font.BOLD, 16));
		 tf1=new JTextField();
		 tf1.setBounds(10,90,370,30);
		 
		jl3=new JLabel("Sender Account Number");
		jl3.setBounds(10, 130, 250, 30);
		 jl3.setFont(new Font("Arial", Font.BOLD, 16));
		 tf2=new JTextField();
		tf2.setBounds(10, 170, 370,50);
		
		jl4=new JLabel("Recipient Account no");
		jl4.setBounds(10, 210, 170, 50);
		 jl4.setFont(new Font("Arial", Font.BOLD, 16));
		 tf3=new JTextField();
		tf3.setBounds(10, 250, 370, 30);
		
		
		jl5=new JLabel("Amount");
		jl5.setBounds(10,280,170,50);
		 jl5.setFont(new Font("Arial", Font.BOLD, 16));
		 tf4=new JTextField();
		tf4.setBounds(10, 320, 370, 30);
		
		jb1=new JButton("Transfer");
		jb1.setBounds(10,380,150,50);
		
		jb1.setBackground(Color.pink);
		
		jb2=new JButton("Exit");
		jb2.setBounds(210,380,150,50);
		jb2.setBackground(Color.pink);
		
		 
		  jp.add(jl1);
		  jp.add(jl2);
		  jp.add(tf1);
		  jp.add(jl3);
		  jp.add(tf2);
		  jp.add(jl4);
		  jp.add(tf3);
		  jp.add(jl5);
		  jp.add(tf4);
		   jp.add(jb1);
		   jp.add(jb2);
		   
		   jb1.addActionListener(this);
		   jb2.addActionListener(this);
		  
		   
		     setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		     jf.add(jp);       
		     jf.setVisible(true);
		    
		     jf.setSize(420,570);
			}
	public void actionPerformed(ActionEvent e)
	{
		String userName=tf1.getText();
		String SenderAcc=tf2.getText();
		String RaccNo=tf3.getText();
		String Am=tf4.getText();
		int updatedBlnc = 0;
	//try {
		
		if(e.getSource()==jb1)
		{
			if(userName.isEmpty()&&SenderAcc.isEmpty()&& RaccNo.isEmpty() &&Am.isEmpty())
			{
			JOptionPane.showMessageDialog(null,"Enter data first!!!! " ,"Warning",JOptionPane.WARNING_MESSAGE);
			}
		
			else
			{
				String blnc;
				
				String res=con1.Compare(SenderAcc);
				
				if(res!=null)
				{
				System.out.println(res);
				String rs[]=res.split(" ");
					blnc=rs[1];
					System.out.println("Blnc is: "+blnc);
				
					int B1=Integer.parseInt(blnc);							//Table data;
					int Amount=Integer.parseInt(Am);						//Form data;
					
					if(Amount<=B1)
					{
						updatedBlnc=B1-Amount;
						System.out.println("updated balance is:"+updatedBlnc);
						
						String result=con1.update(updatedBlnc,SenderAcc);
						
						JOptionPane.showMessageDialog(null,"Transfered successfully!!! " ,"Confirmation",JOptionPane.WARNING_MESSAGE);	
						JOptionPane.showMessageDialog(null,"Remaining Amount: "+updatedBlnc+"" ,"Confirmation",JOptionPane.WARNING_MESSAGE);	
					}
					else
					{
						JOptionPane.showMessageDialog(null,"You have insufficient Balance!!!" ,"Warning",JOptionPane.WARNING_MESSAGE);	
					}
				}
			}
		}
		if(e.getSource()==jb2)
		{
			jf.dispose();
		}
	//}
	/*catch (SQLException e1)
			{				
				e1.printStackTrace();
				System.out.print("Inside catch");
			}*/
}


	
		public static void main(String[] args) {  
		    new Transfer();  
		}

}