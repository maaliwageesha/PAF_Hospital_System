package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; 

import model.PatientRepository;

/**
 * Servlet implementation class patientAPI
 */
@WebServlet("/patientAPI")
public class patientAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	PatientRepository patient=new PatientRepository();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
public patientAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String output = patient.createPatientAsForm(request.getParameter("Nic"),
				             request.getParameter("firstName"),
				             request.getParameter("lastName"),
				             request.getParameter("email"),
				             request.getParameter("Gender"),
				             request.getParameter("Address"), 
				             request.getParameter("password"),
				             request.getParameter("City"),
				             request.getParameter("phone-number"));
				
		response.getWriter().write(output); 
	}
// Convert request parameters to a Map
private static Map getParasMap(HttpServletRequest request)
	{  
		Map<String, String> map = new HashMap<String, String>(); 
		try  
		   {   Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
		       String queryString = scanner.hasNext() ?          
		    		                scanner.useDelimiter("\\A").next() : "";   
		       scanner.close(); 
	
	 
	          String[] params = queryString.split("&");
	          for (String param : params)   
	          { 
	  
	            String[] p = param.split("=");
	            map.put(p[0], p[1]);   
	         }  
        } 
      catch (Exception e)
		{  }  
		return map; 
  }

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Map paras = getParasMap(request); 
		
		System.out.println("this is nic"+paras.get("Nic").toString());
		System.out.println( paras.get("firstName").toString());
		System.out.println(  paras.get("lastName").toString());
		System.out.println( paras.get("gridRadios").toString());
		System.out.println( paras.get("password").toString());
		System.out.println( paras.get("contact").toString());
		 
		String output = patient.UpdatePatient(paras.get("hidpatientIDSave").toString(),
				           paras.get("Nic").toString(),
				           paras.get("firstName").toString(),  
				           paras.get("lastName").toString(),  
				           paras.get("email").toString().replace("%40", "@"),
				           paras.get("gridRadios").toString(),
				           paras.get("address").toString().replace("+", " "),
				           paras.get("password").toString(),
				           paras.get("city").toString(),
				           paras.get("contact").toString()
				 ); 
		
		 response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 Map paras = getParasMap(request);
		 System.out.println("del value"+paras.get("patientID").toString());
		 String output = patient.DeletePatient(paras.get("patientID").toString());
		 response.getWriter().write(output); 
	}

}
