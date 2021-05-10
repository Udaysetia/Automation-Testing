package project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Account {
boolean authentiation(String username,String password)
{
		Connection con;
		try {
			con = DBConnection.getConnection();
			String get_query="Select username,password from bankdata";
			Statement stmt=con.createStatement();
			ResultSet rSet=stmt.executeQuery(get_query);
			while(rSet.next())
			{
				if(rSet.getString(1).equals(username)&&rSet.getString(2).equals(password))
				{
					return true;
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
}
boolean addAccount(String name,int age,long contactNo,String address,String aadharCardNumber,String accountType,String username,String password)
{
	Connection con;
	try {
		con = DBConnection.getConnection();
		String get_query="insert into bankdata values('"+ name +"',"+ age +","+ contactNo +",'"+ address +"','"+aadharCardNumber +"','"+ accountType+"','"+username+"','"+password +"')";
		Statement stmt=con.createStatement();
		int check=stmt.executeUpdate(get_query);
		if(check!=0)
			return true;
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}
void allAccountDetails()
{
	Connection con;
	try {
		con = DBConnection.getConnection();
		String get_query="select count(*) as rowcount from bankdata";
		Statement stmt=con.createStatement();
		ResultSet rSet=stmt.executeQuery(get_query);
		rSet.next();
		System.out.println("Total Records: "+rSet.getInt("rowcount"));
		get_query="select * from bankdata";
		rSet=stmt.executeQuery(get_query);
		System.out.format("%-25s %-25s %-25s %-25s %-25s %-25s %-25s %-25s %s\n","Name","Age","Contact Number","Address","Aadhar Number","Username","Password","Type of Account","Balance");
		while(rSet.next())
		{
			System.out.format("%-25s %-25s %-25s %-25s %-25s %-25s %-25s %-25s %s\n",rSet.getString(1),rSet.getLong(2),rSet.getLong(3),rSet.getString(4),rSet.getString(5),rSet.getString(6),rSet.getString(7),rSet.getString(8),rSet.getInt(9)); 
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

void searchAccount(String username)
{
	Connection con;
	try {
		con = DBConnection.getConnection();
		Statement stmt=con.createStatement();
		String get_query="select * from bankdata";
		ResultSet rSet=stmt.executeQuery(get_query);
		System.out.format("%-25s %-25s %-25s %-25s %-25s %-25s %-25s %-25s %s\n","Name","Age","Contact Number","Address","Aadhar Number","Username","Password","Type of Account","Balance");
		while(rSet.next())
		{
			if(username.equals(rSet.getString(1)))
			System.out.format("%-25s %-25s %-25s %-25s %-25s %-25s %-25s %-25s %s\n",rSet.getString(1),rSet.getLong(2),rSet.getLong(3),rSet.getString(4),rSet.getString(5),rSet.getString(6),rSet.getString(7),rSet.getString(8),rSet.getInt(9)); 
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
void deleteAccount(String accountName)
{
	Connection con;
	try {
		con = DBConnection.getConnection();
		Statement stmt=con.createStatement();
		String get_query="delete from bankdata where username='"+accountName+"'";
		int check=stmt.executeUpdate(get_query);
		if(check==0)
			System.out.println("Deleted Successfully");
		else
			System.out.println("Unsuccessfull");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
boolean withdrawAmount(String username,int amount)
{
	Connection con;
	try {
		con = DBConnection.getConnection();
		Statement stmt=con.createStatement();
		String get_query="select  account_type,balance from bankdata where username='"+username+"'";
		ResultSet rSet=stmt.executeQuery(get_query);
		rSet.next();
		if(rSet.getString(1).equals("saving")&&rSet.getLong(2)>amount||rSet.getString(1).equals("current")&&rSet.getLong(2)>-3000)
		{
			get_query="update bankdata set balance="+(rSet.getLong(2)-amount)+"where username='"+username+"'";
			stmt.executeUpdate(get_query);
			return true;
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return false;
}
boolean depositAmount(String username,int amount)
{
	Connection con;
	try {
		con = DBConnection.getConnection();
		Statement stmt=con.createStatement();
		String get_query="select balance from bankdata where username='"+username+"'";
		ResultSet rSet=stmt.executeQuery(get_query);
		rSet.next();
		get_query="update bankdata set balance="+(rSet.getLong(1)+amount)+"where username='"+username+"'";
		stmt.executeUpdate(get_query);
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return true;
}
}
