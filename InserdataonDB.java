import java.awt.HeadlessException;
	import java.sql.*;
	import javax.swing.*;
	
public class databaseInsert {
	 public static void main (String[] args) { 
	        try { 
	            String url = "jdbc:mysql://localhost:3306/(Database name)"; 
	            Connection conn = DriverManager.getConnection(url,"",""); 
	            Statement st = conn.createStatement(); 
	            st.executeUpdate("INSERT INTO (Table name)" + 
	                "VALUES (12, '', '', '', '', '', '')"); 
	            
	            conn.close(); 
	        } catch (Exception e) { 
	            System.err.println("Got an exception! "); 
	            System.err.println(e.getMessage()); 
	        } 
	  
	    }
	}
