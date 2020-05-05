package model;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;



/**
 * @author Malidi
 *
 */
public class PatientRepository{
	Connection con=null;
	public PatientRepository()
	{
		String url="jdbc:mysql://localhost:3306/pafdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String username="root";
		String password="";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			System.out.println("successfully connected to DB");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Unanel to make connection");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to make connection");
			e.printStackTrace();
		}
		
	}
	
	public String getAllPatients()
	{ String output="";
	output = "<table border=\"1\"><tr><th>Patient ID</th><th>NIC</th><th>First Name</th><th>Last Name</th>"
			+ "<th>Email</th><th>Gender</th><th>Address</th><th>Password</th><th>City</th><th>Contact</th><th>update</th><th>remove></th></tr>";
		
		String sql="select * from patient";
		
		try {
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
				
				output += "<tr><td><input id='hidItemIDUpdate'name='hidItemIDUpdate' type='hidden'value='" + patientID + "'>" + patientID + "</td>"; 
				//output += "<tr><td>" + patientID + "</td>";
				output += "<td>" + NIC + "</td>";
				output += "<td>" + firstName + "</td>";
				output += "<td>" + lastName + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + gender + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + password + "</td>";
				output += "<td>" + city + "</td>";
				output += "<td>" + contact + "</td>";
				
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td><td><input name='btnRemove' type='button' value='Remove'class='btnRemove btn btn-danger' data-itemid='"+ patientID + "'>" + "</td></tr>"; 

			}
			con.close();
			output += "</table>";
			return output;
			
		} catch (SQLException e) {
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
		} catch (SQLException e) {
			output = "Error while Get patient data.";
			e.printStackTrace();
		}
		return output;
	}
	
	

	
	
	public String createPatientAsForm(String NIC, 
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
			PreparedStatement stm = con.prepareStatement(sql2);
			stm.setString(1,email);
			
			ResultSet rs=stm.executeQuery();
			if(rs.next())
			{
				return "Sorry there is already a registered user with this email!!";
			}else {

			
			
			
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
		} catch (SQLException e) {
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
		}else {
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the item.\"}"; 
			return output;
		}
		
	}


	/**
	 * @param p1
	 * @return
	 */
    //Update patients
	public String UpdatePatient(int patientID,
			                    String NIC,
			                    String firstName,
			                    String lastName,
			                    String email , 
			                    String gender , 
			                    String address,
			                    String password,
			                    String city,
			                    String contact)
	{
		String output = "";
		int count=0;
	  try {
		    if (con == null)  
			 {   
			   return "Error while connecting to the database for updating.";  
			 }
	     //Create a Prepared statement
		 String sql = "update patient set NIC = ? , firstName = ? , lastName = ?,email = ? ,"
		      		  + " gender = ? , address = ?,password = ? , city = ? , contact = ?  where patientID = ?";
			   
		 PreparedStatement st = con.prepareStatement(sql);

	    //binding values
		st.setString(1,NIC);
    	st.setString(2,firstName);
	    st.setString(3,lastName);
	    st.setString(4,email);
	    st.setString(5,gender);
		st.setString(6,address);
		st.setString(7,password);
		st.setString(8,city);
		st.setString(9,contact);
		st.setInt(10,patientID);
			
		count=st.executeUpdate();
	} 
    catch (SQLException e)
	{ 
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
 		 output = "{\"status\":\"error\", \"data\": \"Error while updating the item.\"}"; 
 		 return output;
 	   }
	}    	 
      	 
//Delete patients
//public String DeletePatient(String patientID)
 //{
		//String output = "";
	//	try {
			
		
			//String query = "delete from patient where patientID=?";
			//PreparedStatement preparedStmt = con.prepareStatement(query);
			//preparedStmt.setInt(1, Integer.parseInt(patientID)); 
			//preparedStmt.execute();
			//con.close();
			//output = "Deleted successfully";
		//} catch (Exception e) {
			//output = "Error while deleting the patient.";
		//	System.err.println(e.getMessage());
		//}
		//return output;
	 //}
 //}
public String DeletePatient(String patientID)
 {  
	String output = ""; 
	 
	  try 
	  {   
		  Connection con = null; 
	 
	      if (con == null) 
	      {  
	    	 return "Error while connecting to the database for deleting.";
	      } 
	  
	      //create a prepared statement   
	      String sql = "delete from items where patientID=?"; 
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
	


