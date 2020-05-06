package model;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;



/**
 * @author Malidi
 *
 */
public class PatientRepository{
	
private static Connection connect() {
		Connection con = null;
		try {
			  Class.forName("com.mysql.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pafdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
public String getAllPatients()
	{ String output="";
	  output = "<table border='1'><tr><th>Patient ID</th><th>NIC</th><th>First Name</th><th>Last Name</th>"
			   + "<th>Email</th><th>Gender</th><th>Address</th><th>Password</th><th>City</th><th>Contact</th><th>update</th><th>remove></th></tr>";
		
	  String sql="select * from patient";
		
	  try {
		  Connection con = connect();
			java.sql.Statement st =con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				String patientID=Integer.toString(rs.getInt("patientID"));
				String NIC=rs.getString("NIC");
				String firstName=rs.getString("firstName");
				String lastName=rs.getString("lastName");
				String email=rs.getString("email");
				String gender=rs.getString("gender");
				String address=rs.getString("address");
				String password=rs.getString("password");
				String city=rs.getString("city");
				String contact=rs.getString("contact");
				
				//Add into the HTML table
				output += "<tr><td><input id='hidItemIDUpdate'name='hidItemIDUpdate' type='hidden'value='" + patientID + "'>" + patientID + "</td>"; 
				output += "<td>" + NIC + "</td>";
				output += "<td>" + firstName + "</td>";
				output += "<td>" + lastName + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + gender + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + password + "</td>";
				output += "<td>" + city + "</td>";
				output += "<td>" + contact + "</td>";
				
				//Buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-patientid='" + patientID + "'>"
						+ "</td></tr>";   

			}
			con.close();
			//Complete the patient HTML table
			output += "</table>";
			return output;
			
		} catch (SQLException e)
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
			output="invalid";
		}
		
		return output;
	}
	
public String getPatient(String patID) {
		String output="";
		output = "<table border=\"1\"><tr><th>Patient ID</th><th>NIC</th><th>First Name</th><th>Last Name</th>"
				+ "<th>Email</th><th>Gender</th><th>Address</th><th>Password</th><th>City</th><th>Contact</th></tr>";
		
		int val=Integer.parseInt(patID);
		String sql = "Select * from patient where `patientID`="+val;
		
		try {
			 Connection con = connect();
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			System.out.println(preparedStmt);

			System.out.println(val);
			ResultSet rs = preparedStmt.executeQuery(sql);
			if(rs.next())
			{
				
				String patientID=Integer.toString(rs.getInt("patientID"));
				String NIC=rs.getString("NIC");
				String firstName=rs.getString("firstName");
				String lastName=rs.getString("lastName");
				String email=rs.getString("email");
				String gender=rs.getString("gender");
				String address=rs.getString("address");
				String password=rs.getString("password");
				String city=rs.getString("city");
				String contact=rs.getString("contact");
				
				output += "<tr><td>" + patientID + "</td>";
				output += "<td>" + NIC + "</td>";
				output += "<td>" + firstName + "</td>";
				output += "<td>" + lastName + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + gender + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + password + "</td>";
				output += "<td>" + city + "</td>";
				output += "<td>" + contact + "</td>";
				
			}
			con.close();
			output += "</table>";
			
			return output;
		}catch (SQLException e)
		{
			output = "Error while Get patient data.";
			e.printStackTrace();
		}
		return output;
	}
	
public String createPatientAsForm( String NIC, 
			                       String firstName,
			                       String lastName,
			                       String email ,
			                       String gender ,
			                       String address,
			                       String password,
			                       String city,
			                       String contact)
	{
		String output;
		int count=0;
		String sql="insert into patient (NIC, firstName, lastName, email , gender , address, password, city, contact) values (?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		String sql2=new String("select * from patient where email=?");
		
		try {
			Connection con = connect();
			PreparedStatement stm = con.prepareStatement(sql2);
			stm.setString(1,email);
			
			ResultSet rs=stm.executeQuery();
			if(rs.next())
			{
				return "Sorry there is already a registered user with this email!!";
			}
			else {

			PreparedStatement st =con.prepareStatement(sql);
			System.out.println(st);
		
			st.setString(1,NIC);
			st.setString(2,firstName);
			st.setString(3,lastName);
			st.setString(4,email);
			st.setString(5,gender);
			st.setString(6,address);
			st.setString(7,password);
			st.setString(8,city);
			st.setString(9,contact);
			
			count=st.executeUpdate();
			
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("connection value"+e);
		}
		String getPatients = getAllPatients();
		 output = "{\"status\":\"success\", \"data\": \"" +
				 getPatients + "\"}"; 
		
		if(count>0)
		{
			return output;
		}else
		{
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the item.\"}"; 
			return output;
		}
		
	}


	/**
	 * @param p1
	 * @return
	 */
//Update patients...
public String UpdatePatient(String patientID,
		                    String NIC,
		                    String firstName,
			                String lastName,
			                String email ,
			                String gender ,
			                String address,
			                String password,
			                String city,
			                String contact) {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "update patient set NIC = ? , firstName = ? , lastName = ?,email = ?, gender = ? , address = ?,password = ? , city = ? , contact = ?  where patientID = ?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values

			preparedStmt.setString(1, NIC);
			preparedStmt.setString(2, firstName);
			preparedStmt.setString(3, lastName);
			preparedStmt.setString(4, email);
			preparedStmt.setString(5, gender);
			preparedStmt.setString(6, address);
			preparedStmt.setString(7, password);
			preparedStmt.setString(8, city);
			preparedStmt.setString(9, contact);
			preparedStmt.setInt(10, Integer.parseInt(patientID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			String getPatients = getAllPatients();
			output = "{\"status\":\"success\", \"data\": \"" +getPatients + "\"}";
			 
		}
		catch (Exception e)
		{
			output = "{\"status\":\"error\", \"data\": \"Error while updating the Schedule.\"}";
			 
			System.err.println(e.getMessage());
		}
			
		return output;
			 
	} 

//Delete patients...
public String DeletePatient(String patientID)
 {  
	System.out.println("visited delete");
	String output = ""; 
	 
	  try 
	  {   
		  Connection con = connect();
	 
	      if (con == null) 
	      {  
	    	 return "Error while connecting to the database for deleting.";
	      } 
	  
	      //create a prepared statement   
	      String sql = "delete from patient where patientID=?"; 
	      PreparedStatement st =con.prepareStatement(sql); 
	      
	      //binding values    
	      st.setInt(1, Integer.parseInt(patientID)); 
	 
	      // execute the statement
	      st.execute(); 
	      con.close(); 
	 
	      String getPatients = getAllPatients(); 
	      output = "{\"status\":\"success\", \"data\": \""
	                 +getPatients + "\"}";
	   } 
	   catch (Exception e)
	    {   
		  output = "{\"status\":\"error\", \"data\":"
		  		    + "\"Error while deleting the patients.\"}";
		  System.err.println(e.getMessage());
		} 
	 
	  return output;
	}
}
	


