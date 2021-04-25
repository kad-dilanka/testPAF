package rest;

import java.sql.*;

import connection.OrderConnection;

public class Order {

	OrderConnection productConnection = new OrderConnection();
    
	public String insertOrder(String name, String quantity, String date, String status) 
	{ 
		String output = ""; 
		try
		{ 
			Connection connect = productConnection.getConnection(); 
			if (connect == null) 
			{
				return "Error while connecting to the database for inserting."; 
			} 
			// create a prepared statement
			String query = " insert into `order`(`orderID`,`name`,`quantity`,`date`,`status`)"
					+ " values (?, ?, ?, ?, ?)"; 
			PreparedStatement preparedStmt = connect.prepareStatement(query); 
			// binding values
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(2, name); 
			preparedStmt.setString(3, quantity); 
			preparedStmt.setString(4, date); 
			preparedStmt.setString(5, status); 
			// execute the statement3
			preparedStmt.execute(); 
			connect.close(); 
			output = "Inserted successfully"; 
		} 
		catch (Exception e) 
		{ 
			output = "Error while inserting the item."; 
			System.err.println(e.getMessage()); 
		} 
		return output; 
	 } 
	
    public String readOrders(){
    	
		String output = "";
		
		try{
			Connection connect = productConnection.getConnection();
			if (connect == null){
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output =  "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl' crossorigin='anonymous'>"
					+ "<link rel='stylesheet' href='../css/product-list.css'>"
					+ "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js' integrity='sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0' crossorigin='anonymous'></script>"
					+ "<script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js' integrity='sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi' crossorigin='anonymous'></script>"
					+ "<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js' integrity='sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG' crossorigin='anonymous'></script>" 
					+"<table class='table table-bordered' style='border-color:#1A237E; overflow-x:auto;'>"
					+ "	   <thead>"
					+ "    		<tr>"
					+ "      		<th scope='col'>#</th>"
					+ "      		<th scope='col'>ID</th>"
					+ "				<th scope='col'>Name</th>"
					+ "				<th scope='col'>Quantity</th>"
					+ "				<th scope='col'>Date</th>"
					+ "				<th scope='col'>Status</th>"
					+ "				<th scope='col'>Update</th>"
					+ "				<th scope='col'>Delete</th>"
					+ "			</tr>"
					+ "		</thead>";
			String query = "select * from `order`";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			int i=0;
			
			// iterate through the rows in the result set
			while (rs.next()){
				i++;
				String hash = Integer.toString(i);
				String orderID = Integer.toString(rs.getInt("orderID"));
				String name = rs.getString("name");
				String quantity = rs.getString("quantity");
				String date = rs.getString("date");
				String status = rs.getString("status");
				
				// Add into the html table
				output += "<tr>";
				output += "<td scope='row'>" + hash + "</td>";
				output += "<td>" + orderID + "</td>";
				output += "<td>" + name + "</td>"; 
				output += "<td>" + quantity + "</td>";
				output += "<td>" + date + "</td>";
				output += "<td>" + status + "</td>";
				// buttons
				output +="<form method='post' action='product-update.jsp'>"
						+ "<td>"
						+ "<input name='orderID' type='hidden' value='"+ orderID + "'>"
						+ "	  <button type='submit' class='btn operation-update' style='text-decoration: none;'>"
						+ "     <svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-arrow-clockwise operation-update' viewBox='0 0 16 16'>"
						+ "  		<path fill-rule='evenodd' d='M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z'/>"
						+ "  		<path d='M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z'/>"
						+ "		</svg>Update"
						+ "   </button>"
						+ "</td>"
						+ "</form>"
						+ "<form method='post' action='product-list.jsp'>"
						+ "<td>"
						+ "   <button type='submit' class='btn operation-delete' style='text-decoration: none;'>"
						+ "     <svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' fill='currentColor' class='bi bi-x operation-delete' viewBox='0 0 16 16'>"
						+ "  		<path d='M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z'/>"
						+ "		</svg>Delete"
						+ "	  </button>"
						+ "</td>"
						+ " <input name='orderID' type='hidden' value='"+ orderID + "'>"
						+ "</form>"
						+ "</tr>"
						+ "</tbody>";
				}
				connect.close();
				// Complete the html table
				output += "</table>";
			}
			catch (Exception e){
				output = "Error while reading the items.";
				System.err.println(e.getMessage());
			}
		return output;
	}
    
    public String updateOrder(String ID, String name, String quantity, String date, String status)
    { 
    	String output = ""; 
    try
    { 
    	Connection connect = productConnection.getConnection(); 
    	if (connect == null) 
    	{
    		return "Error while connecting to the database for updating."; 
    	} 
    	// create a prepared statement
    	String query = "UPDATE `order` SET name=?,quantity=?,date=?,status=? WHERE orderID=?"; 
    	
    	PreparedStatement preparedStmt = connect.prepareStatement(query); 
    	// binding values
    	preparedStmt.setString(1, name); 
    	preparedStmt.setString(2, quantity); 
    	preparedStmt.setString(3, date); 
    	preparedStmt.setString(4, status); 
    	preparedStmt.setInt(5, Integer.parseInt(ID)); 
    	// execute the statement
    	preparedStmt.execute(); 
    	connect.close(); 
    	output = "Updated successfully"; 
    	} 
    	catch (Exception e) 
    	{ 
    		output = "Error while updating the item."; 
    		System.err.println(e.getMessage()); 
    	} 
    	return output; 
    	} 
    
    public String deleteOrder(String orderID){
    	
		String output = "";
		
		try{
			Connection connect = productConnection.getConnection();
			if (connect == null){
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from order where orderID=?";
			PreparedStatement preparedStmt = connect.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(orderID));

			// execute the statement
			preparedStmt.execute();
			connect.close();
			output = "Deleted successfully";
		}
		catch (Exception e){
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
