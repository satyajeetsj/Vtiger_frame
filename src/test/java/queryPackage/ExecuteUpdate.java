package queryPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try
		{
		//step 1: Register the database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//step 2: establish connection with database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
		//step 3: Issue create statement
		Statement stat = con.createStatement();
		//step 4: Execute any query
		 int result = stat.executeUpdate("insert into customer values('15','yash','SJ','Germany')");
		
		if(result==1)
		{
			System.out.println("Customer created successfully");
		}
		else
		{
			System.out.println("Query failed");
		}
		}
		catch(Exception e){
		}
		finally
		{
		//step 5: Close database connection
		con.close();
		System.out.println("connection closed");
		}

	}

}
