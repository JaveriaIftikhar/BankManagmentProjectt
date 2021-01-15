import java.awt.event.*; 
import java.sql.*;
import java.sql.Connection;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import javax.swing.*;

public class Accountinterface extends JFrame implements ActionListener {
	Connectivity C=new Connectivity();
	JFrame jf;
	JButton jb,jb2,jb3,jb4;
	JComboBox cb;
	JPasswordField jpf1;
	 JTextField tf,tf1,tf2,tf3;
	 JLabel jl,jl1,jl2,jl3,jl4,jl5,jl7;
	Accountinterface(){
		 JPanel jp= new JPanel(null);
	jf=new JFrame("Banking System")	;
	jp.setBackground(Color.WHITE);
	jl=new JLabel("Create New Account");
	jl.setFont(new Font("Arial", Font.BOLD, 24));
	
	jl.setBounds(100,1, 250,50);
	jl1=new JLabel("UserName");
	jl1.setBounds(10,20,170,50);
	tf= new JTextField();
    tf.setBounds(10,60,370,30);
    
    jl2=new JLabel("Address");
    jl2.setBounds(10, 80, 170, 50);
    tf1=new JTextField();
    tf1.setBounds(10, 120, 370,50);
    
    jl3=new JLabel("Branch Name");
    jl3.setBounds(10, 160, 170, 50);
    tf2=new JTextField();
    tf2.setBounds(10, 200, 370, 30);
    
    jl4=new JLabel("CNIC");
    jl4.setBounds(10,230,170,50);
    tf3=new JTextField();
    tf3.setBounds(10, 270, 370, 30);
    
    jl5=new JLabel("Password");
    jl5.setBounds(10,300,170,50);
    jpf1=new JPasswordField();
    jpf1.setBounds(10,340,370,30);
    

    jl7=new JLabel("Choose Account Type");
    jl7.setBounds(10,370,170,50);
    String Accounts[]={"Saving","Current"};        
    cb=new JComboBox(Accounts);    
   cb.setBounds(10,410,180,30); 

   jb=new JButton("Submit");
   jb.setBackground(Color.pink);
   jb.setBounds(10,470,100,50);
   jb.addActionListener(this);
   
   jb2=new JButton("Search by CNIC");
   jb2.setBackground(Color.pink);
   jb2.setBounds(200,470,200,50);
   jb2.addActionListener(this);
   
   jb3=new JButton("Show All Records");
   jb3.setBackground(Color.pink);
   jb3.setBounds(200,550,200,50);
   jb3.addActionListener(this);
   
   jb4=new JButton("Go to Menu");
   jb4.setBackground(Color.pink);
   jb4.setBounds(200,620,200,50);
   jb4.addActionListener(this);
   
   
    
    		
    jp.add(jl);
    jp.add(jl1);
    jp.add(tf);
    jp.add(jl2);
    jp.add(tf1);
    jp.add(jl3);
    jp.add(tf2);
    jp.add(jl4);
    jp.add(tf3);
    jp.add(jl5);
    jp.add(jpf1);
    jp.add(jl7);
    jp.add(cb);
    
    jp.add(jb);
    jp.add(jb2);
    jp.add(jb3);
    jp.add(jb4);
    
    
     setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
     jf.setSize(300,200); 
     jf.add(jp);       
     jf.setVisible(true);
    
     jf.setSize(500,900);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String Custname=tf.getText();
		String address=tf1.getText();
		String branchName=tf2.getText();
		String cnic=tf3.getText();
		String password=jpf1.getText();
		System.out.println("CNIC is:"+cnic);
		try
		{
			if(e.getSource()==jb)
			{
				if(Custname.isEmpty()&&address.isEmpty()&& branchName.isEmpty() && cnic.isEmpty()&&password.isEmpty())
				{
				JOptionPane.showMessageDialog(null,"Enter data first!!!! " ,"Warning",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					C.AddData(Custname, password, cnic, address);
				
					JOptionPane.showMessageDialog(null,"Data Enterd!!!!! " ,"Confirmation",JOptionPane.WARNING_MESSAGE);	
				}
			}
			
			if(e.getSource()==jb2)
			{
			String res=C.SearchData(cnic);
			if(res!=null)
			{
						System.out.println(res);
						String rs[]=res.split("-");
						tf.setText(rs[0]);
						tf1.setText(rs[3]);
						tf2.setText(" ");
						tf3.setText(rs[2]);
						System.out.println(rs[0]);
						System.out.println(rs[1]);
						System.out.println(rs[2]);
						System.out.println(rs[3]);
						
						JOptionPane.showMessageDialog(null, "This Account is registered by customer "+rs[0]);
			}
			else
					{
					JOptionPane.showMessageDialog(null, "No Record found ");
				}
			}
			if(e.getSource()==jb3)
			{
				String res=C.AllRecords();
				new ShowRecord(res);
				
			}
			if(e.getSource()==jb4)
			{
				jf.dispose();
				new Menue().setVisible(true);
			}
		}
		catch(Exception e1){
            e1.printStackTrace();
		}
		//jf.dispose();
		//new Menue().setVisible(true);
	}


public static void main(String[] args) {  
    new Accountinterface();  
}



}