package queryPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteQuery {

	public static void main(String[] args) throws SQLException {
		//step 1: Register the database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		//step 2: establish connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
		//step 3: Issue create statement
		Statement stat = con.createStatement();
		//step 4: Execute any query
		ResultSet result = stat.executeQuery("select * from customer;");
		
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		//step 5: Close database connection
		con.close();

	}

}
