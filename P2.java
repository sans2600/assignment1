package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class P2 {
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		

		String query = "";
		int roll = 0;
		int exists = 0;
		String name = "", std = "";
		
		//Connection
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/globallogic", "root", "root");
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		//Checking if input is valid
		int rollno=0;
		
		do
		{
			System.out.println("Enter Student Roll No to delete the details:");
			String rollstr = sc.nextLine();
			
			try 
			{	
				rollno = Integer.parseInt(rollstr);
				if(String.valueOf(rollno).length()!=4)
				{
					rollno = 0;
				}
				
			}
			catch(Exception e)
			{
				System.out.println("Invalid Input");
			}
			
		}while(rollno==0);
		
		//Checking table if the given input exists or not.
		try
		{
			query = "select * from student";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery(query);
			
			while(rs.next())
			{
				roll = rs.getInt("RollNo");
				name = rs.getString("StudentName");
				std = rs.getString("Standard");
				if(rollno == roll)
				{
					//System.out.println("fOUND");
					exists = 1;
					//query = "delete from student where r"
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//If the given input exists moving forward with the code.
		try
		{
			if(exists == 1)
			{
				System.out.println("Enter leaving date (YYYY/MM/DD):");
				String leavingdate = sc.nextLine();
				
				//Deleting data from table student
				query = "delete from student where RollNo = ?";
				ps = con.prepareStatement(query);
				
				ps.setInt(1, rollno);
				ps.executeUpdate();
				System.out.println("Record deleted sucessfully");
			
				//Inserting data in table studentlog.
				query = "insert into studentlog values(?,?,?,?)";
			
				try
				{
					ps = con.prepareStatement(query);
					
					System.out.println(rollno);
					ps.setInt(1, rollno);
					ps.setString(2, name);
					ps.setString(3, std);
					ps.setString(4, leavingdate);
					ps.executeUpdate();
					
					System.out.println("Studentlog Updated sucessfully");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}	
			}
			else
			{
				throw new Exception();
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Invalid Data/Data does not exists");
		}
	}


}
