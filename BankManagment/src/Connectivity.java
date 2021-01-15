import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
public class Connectivity {
	Connection cont;

	Connectivity()
	{
        String url = "jdbc:mysql://localhost:3306/myProject?allowPublicKeyRetrieval=true&useSSL=false";
        String user = "jiyaa";
        String password = "MySql@123";
        String query="DROP TABLE IF EXISTS Bank, Branch, Customer, Account,AccountInfo, BankBranchDetails, BranchAccountDetails" ;
        String q1="CREATE TABLE Bank (BName VARCHAR(100), BCode VARCHAR(100) PRIMARY KEY)";
        String q2="CREATE TABLE Customer (CustName VARCHAR(100), Password VARCHAR(100), CNIC VARCHAR(20) PRIMARY KEY, CustAddress VARCHAR(100)); ";
        String q4="CREATE TABLE Account (AccNo VARCHAR(40) PRIMARY KEY , Balance BIGINT)";
       
 try  { cont = DriverManager.getConnection(url, user, password);
        		
        			System.out.println("Connection successfull");
        			
        			/*PreparedStatement pst = cont.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();*/
        		} 
        catch (SQLException ex) {
            
            Logger lgr = Logger.getLogger(Connectivity.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
	}
	
	public String AddData (String Custname,String password,String cnic, String address)          ///User login;
	{
		String sql = "INSERT INTO Customer(CustName,Password,CNIC,CustAddress) VALUES(?,?,?,?)";
		try
		{
			PreparedStatement pst=cont.prepareStatement(sql);
			pst.setString(1, Custname);
			pst.setString(2, password);
			pst.setString(3, cnic);
			pst.setString(4,address);
            pst.executeUpdate();
            return "A new record add in the data";
            
        } catch (SQLException ex) {
            
        	return ex.getMessage();
           }
		}
	public String AddAcc (String AccNum,int Blnc)                                               // to Add Money;
	{
		String sql = "INSERT INTO Account(AccNo,Balance) VALUES(?,?)";
		try
		{
			PreparedStatement pst=cont.prepareStatement(sql);
			pst.setString(1, AccNum);
			pst.setInt(2, Blnc);
            pst.executeUpdate();
            return "Record inserted in Account";

        } catch (SQLException ex) {
            
        	return ex.getMessage();
           }
		}
	public String Compare(String AccNo)								//To search account and deposit;
	{
		
		String sql = "Select * from Account where AccNo like '"+ AccNo+ "'";
		System.out.println(sql);
		String ans=null;
		try
		{
			PreparedStatement pst=cont.prepareStatement(sql);
		    
			ResultSet rs= pst.executeQuery();
		    
         while(rs.next())
         {  
        	 	ans=rs.getString(1);
         		ans=rs.getString(1)+" "+rs.getInt(2);
         		System.out.println("Answer is:"+ans);
         		return ans;

         }
		}catch (SQLException ex) {

        	 Logger lgr = Logger.getLogger(Connectivity.class.getName());
             lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
		return null;
		}
	public String SearchData(String cnic)
	{	
		String sql = "Select * from Customer where CNIC like '"+ cnic+ "'";
		System.out.println(sql);
		String ans=null;
		
		try
		{
			PreparedStatement pst=cont.prepareStatement(sql);
			ResultSet rs= pst.executeQuery();
			
			
			while(rs.next())
			{
				ans=rs.getString(1)+"-"+rs.getString(2)+"-"+rs.getString(3)+"-"+rs.getString(4);
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
            }
           
			//System.out.println(rs.getString(4));
           return ans;

        } catch (SQLException ex) {

        	 Logger lgr = Logger.getLogger(Connectivity.class.getName());
             lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
		return null;
		}
	String update(int blnc,String SenderAcc)
	{
		String sql = "UPDATE Account SET Balance=blnc WHERE AccNo=SenderAcc";
		
		System.out.println(sql);
		
		//String ans=null;
		try
		{
			
			PreparedStatement pst=cont.prepareStatement(sql);
			
			//ResultSet rs= pst.executeQuery();
			System.out.println("Inside try");
			//while(rs.next())
     		pst.setInt(2, blnc);
     		//System.out.println("under pst");
     		pst.executeUpdate();
     		//System.out.println("Answer is:"+ans);
     		// pst.executeUpdate();
     		String ans=" blnc";
     		return ans ;
     	
		
		}catch (SQLException ex) {

    	 Logger lgr = Logger.getLogger(Connectivity.class.getName());
         lgr.log(Level.SEVERE, ex.getMessage(), ex);

		}
		return " ";
	}	
	String deposit(int blnc,String SenderAcc)
	{
		String sql = "UPDATE Account SET Balance=blnc WHERE AccNo=SenderAcc";
		
		System.out.println(sql);
		try
		{
			
			PreparedStatement pst=cont.prepareStatement(sql);
			
			System.out.println("Inside try");
     		pst.setInt(2,blnc);
     		pst.executeUpdate();
     		String ans=" blnc";
     		return ans ;
     	
		
		}catch (SQLException ex) {

    	 Logger lgr = Logger.getLogger(Connectivity.class.getName());
         lgr.log(Level.SEVERE, ex.getMessage(), ex);

		}
		return " ";
	}	
	public String AllRecords()
	{
		
		
		String sql = "Select * from Customer";
		String ans=null;
		try
		{
			PreparedStatement pst=cont.prepareStatement(sql);
			
           ResultSet rs= pst.executeQuery();
           ans="";
         while(rs.next())
         {  ans+=rs.getString(1)+"  " + rs.getString(2)+"  "+rs.getString(3)+ "  "+rs.getString(4)+"\n";
                
         }
        
           return ans;

        } catch (SQLException ex) {

        	 Logger lgr = Logger.getLogger(Connectivity.class.getName());
             lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }
		return null;
		}
}