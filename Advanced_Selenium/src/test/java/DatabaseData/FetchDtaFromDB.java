package DatabaseData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchDtaFromDB {
	public static void main(String[] args) throws Throwable {
		// step 1: Register/load mySql database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		// Step2: get connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainerdetails", "root", "Root");
		// step3: create sql statement
		Statement state = conn.createStatement();
		String query = "select * from trainers";
		ResultSet result = state.executeQuery(query); 
		
		
		while(result.next()) {
			System.out.println(result.getInt(1)+ " "+ result.getString(2)+ " "+result.getString(3)+" "+result.getString(4));
		}
		conn.close();

	}
}
