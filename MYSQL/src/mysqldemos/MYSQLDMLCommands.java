package mysqldemos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;

public class MYSQLDMLCommands {
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			
		  String MySQLURL = "jdbc:mysql://localhost:3306/test";		
	      String databseUserName = "root";
	      String databasePassword = "";
	      
	      
	      
	      
	      try {
	    	  
	    	  Connection conn1 = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);	    	  
			  java.sql.Statement stmt = conn1.createStatement();
			  
			  if (conn1 != null) {
		            System.out.println("Database connection is successful !!!");
		      }
			  
			  
			  String query;
			  //= "CREATE TABLE products (ProductID int,Description varchar(255),Status varchar(255),Quantity varchar(255),Price varchar(255),date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP)";
			  //stmt.executeUpdate(query);
			  
			  Scanner scan = new Scanner(System.in);
			  
			  
			  System.out.println("1. Add new exercise: ");
			  System.out.println("2. Update new exercise plan quantity and price: ");			  
			  System.out.println("3. Update new exercise fakt quantity: ");
			  
			  System.out.println("4. Select not finished exercise: ");
			  System.out.println("5. Select finished exercise for period: ");	
			  System.out.println("6. Select finished exercise common price for period: ");	
			  
			  System.out.println("7. Delete exercise: ");
			  
			  
			  System.out.print("Enter choice: ");
			  String choise = scan.nextLine();
			  
			  
			  
				
			switch(choise) {			  
			  case "1":
				  // Add exercise 
				  System.out.print("Enter description: ");
				  String description = scan.nextLine();
				  
				  
				  //System.out.print("Enter status: ");
				  //String status = scan.nextLine();
				  
				  
				  System.out.print("Enter quantity: ");
				  int quantity = scan.nextInt();
				  
				  
				  //System.out.print("Enter user price: ");
				  //String price = scan.nextLine();
				  
				  
				  query = "INSERT INTO products (Description, Status, Quantity, Price) VALUES ('"+description+"','Project','"+quantity+"','0.00')";
				  int result = stmt.executeUpdate(query);
				  
				  if(result > 0) 
				  {
					  System.out.println("User updated succesefuly !");
					  
					  System.out.println("1. Add new exercise: ");
				  }
				  else
				  {
					  System.out.println("Exercise not found !");
				  }
				  
				  
				  break;
			  case "2":
				  // Update exercise quantity price
				
				  System.out.print("Enter user PersonID: ");
				  int id = scan.nextInt();
				  
				  scan.nextLine(); //Skip a line
				  
				  //query = "SELECT * from products where Status='not finished'";
				  ResultSet rs; 
				  
				  System.out.print("Enter new description: ");
				  description = scan.nextLine();
				  
				  //System.out.print("Enter new user status: ");
				  //status = scan.nextLine();
				  
				  System.out.print("Enter new quantity: ");
				  quantity = scan.nextInt();
				  
				  
				  System.out.print("Enter new price: ");
				  float price = scan.nextFloat();
				  
				  
				  
			  
				  query = "UPDATE products SET Description='"+description+"',Status='Project',Quantity='"+quantity+"',Price='"+price+"' WHERE ProductID =" + id;				  
				  result = stmt.executeUpdate(query);
				  
				  if(result > 0) 
				  {
					  System.out.println("User updated succesefuly !");				  
				  }
				  else
				  {
					  System.out.println("Exercise not found !");
				  }
				  
				  
				  break;
			  case "3":
				  // Update exercise
				  System.out.print("Enter user PersonID: ");
				  id = scan.nextInt();
				  
				  scan.nextLine(); //Skip a line
				  
				  
				  System.out.print("Enter new description: ");
				  description = scan.nextLine();
				  
				  //System.out.print("Enter new user status: ");
				  //status = scan.nextLine();
				  
				  System.out.print("Enter new quantity: ");
				  int quantity2 = scan.nextInt();
				  
				  
				  System.out.print("Enter new price: ");
				  float  price2 = scan.nextFloat();
				  
				 float a =price2;
				 float b =quantity2;
				 float g=0;
				 g=a*b;
			  
				  query = "UPDATE products SET Description='"+description+"',Status='Finished',Quantity='"+quantity2+"',Price='"+g+"' WHERE ProductID =" + id;				  
				  result = stmt.executeUpdate(query);
				  
				  if(result > 0) 
				  {
					  System.out.println("User updated succesefuly !");	
					  
					  System.out.println("2. Update new exercise plan quantity and price: ");
				  }
				  else
				  {
					  System.out.println("Exercise not found !");
				  }
				  
			      break;			  
			  case "4":
				  // Read not finished exercise
				  
				  //System.out.print("Enter exercise id: ");
				  //id = scan.nextInt();
				  
				  System.out.print("Enter date from: ");
				  String from = scan.nextLine();
				  
				  System.out.print("Enter date to: ");
				  String to = scan.nextLine();
				  
				  query ="SELECT * FROM products WHERE Status='Project' AND `date` BETWEEN '"+from+"' AND '"+to+"'";
				  //query = "SELECT * from products where Status='Project'  BETWEEN CAST('"+from+"' AS DATE) AND CAST('"+to+"' AS DATE)";
				  rs = stmt.executeQuery(query);
				  
				  if(rs.next()) {
					  
					  //query = "SELECT * from products where Status='Project'";
					  query ="SELECT * FROM products WHERE Status='Project' AND `date` BETWEEN '"+from+"' AND '"+to+"'";
					  //query = "SELECT * from products where Status='Project'  BETWEEN CAST('"+from+"' AS DATE) AND CAST('"+to+"' AS DATE)";
					  //query = "SELECT * from products where Status='Project' BETWEEN CAST('2024-02-05' AS DATE) AND CAST('2024-02-05' AS DATE)";
					  rs = stmt.executeQuery(query);
					  while(rs.next()) { 
						
					  System.out.println("Description: "+rs.getString("Description"));
					  System.out.println("Status: "+rs.getString("Status"));
					  System.out.println("Quantity: "+rs.getString("Quantity"));
					  System.out.println("Price: "+rs.getString("Price"));
					  System.out.println("Exercise number: "+rs.getInt("ProductID"));
					  System.out.println("Date: "+rs.getString("date"));
					  
					}
					  
				  }
				  else 
				  {
					  
					  System.out.println("Exercise not found !");
					  
				  }
				  
				  break;
			  case "5":
				  // Read finished exercise
				  
				  //System.out.print("Enter exercise id: ");
				  //id = scan.nextInt();
				  
				  System.out.print("Enter date from: ");
				  from = scan.nextLine();
				  
				  System.out.print("Enter date to: ");
				  to = scan.nextLine();
				  
				  query ="SELECT * FROM products WHERE Status='Finished' AND `date` BETWEEN '"+from+"' AND '"+to+"'";
				  rs = stmt.executeQuery(query);
				  
				  
				  if(rs.next()) {
					  
					  //query = "SELECT * from products where Status='Finished'";					  
					  query ="SELECT * FROM products WHERE Status='Finished' AND `date` BETWEEN '"+from+"' AND '"+to+"'";
					  //query = "SELECT * from products where Status='Finished' BETWEEN CAST('2024-02-05' AS DATE) AND CAST('2024-02-05' AS DATE)";
					  rs = stmt.executeQuery(query);
					  while(rs.next()) {  
						  
					  System.out.println("Description: "+rs.getString("Description"));
					  System.out.println("Status: "+rs.getString("Status"));
					  System.out.println("Quantity: "+rs.getString("Quantity"));
					  System.out.println("Price: "+rs.getString("Price"));
					  System.out.println("Exercise number: "+rs.getInt("ProductID"));
					  System.out.println("Date: "+rs.getString("date"));
					  
					  }
					  
				  }
				  else 
				  {
					  
					  System.out.println("Exercise not found !");
					  
				  }
				  
				  break;
			  case "6":
				  // Read finished exercise
				  // System.out.print("Enter exercise id: ");
				  // id = scan.nextInt();
				  
				  query = "select sum(price) from products where status='Finished'";
				  rs = stmt.executeQuery(query);
				  
				  if(rs.next()) {
					  
					  
					  //System.out.println("Description: "+rs.getString("Description"));
					  //System.out.println("Status: "+rs.getString("Status"));
					  //System.out.println("Quantity: "+rs.getString("Quantity"));
					  System.out.println("Common price of exercises: "+rs.getString("sum(price)"));
					  //System.out.println("Exercise number: "+rs.getInt("ProductID"));
					  //System.out.println("Date: "+rs.getString("date"));
					  
				  }
				  else 
				  {
					  
					  System.out.println("Exercise not found !");
					  
				  }
				  
				  break;
			  case "7":
				  // Delete exercise
				  System.out.print("Enter user ProductID: ");
				  id = scan.nextInt();
				  
				  query = "DELETE FROM products WHERE ProductID =" + id;				  
				  result = stmt.executeUpdate(query);
				  
				  if(result > 0) 
				  {
					  System.out.println("User deleted succesefuly !");				  
				  }
				  else
				  {
					  System.out.println("User not found !");
				  }
				  
				  break;
			  }
			  
			 
			  
			  stmt.close();
			  conn1.close();
	    	 
			
	         
	         
	         
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	}

}
