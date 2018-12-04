
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DisplayAll {
	public static void main(String[] args) {
			Connection dbConnection = null;
		    try {
		      String url = "jdbc:mysql://localhost:3306/sql1";
		      Properties info = new Properties();
		      info.put("user", "root");
		      info.put("password", "ouma");

		      dbConnection = DriverManager.getConnection(url, info);
		      
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			//query to display all records from table employee
			String q="Select * from sq";
			Statement smt=dbConnection.createStatement();
			//to execute query
			ResultSet rs=smt.executeQuery(q);
			
			//to print the resultset on console
			if(rs.next()){ 
				do{
				System.out.println(rs.getString(1)+","+rs.getString(2));
				}while(rs.next());
			}
			else{
				System.out.println("Record Not Found...");
			}
			dbConnection.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
