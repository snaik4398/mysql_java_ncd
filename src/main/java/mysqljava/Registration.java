package mysqljava;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/signup")
public class Registration extends HttpServlet {
	public static String pnm;
	public static String pid;
	public static String emal;
	public static String gen;
	public static String pin;
	public static String dob;
	public static String ph;
	public static String aadhaar;


	private static final long serialVersionUID = 1L;

	// This method is called by the servlet container to process a 'post' request
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			handleRequest(request, response);
		} catch (IOException | ServletException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, SQLException {

		  PrintWriter out=res.getWriter();
		  out.println("<!DOCTYPE html>");
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<title>NCD Risk Assessment Checklist</title> ");
	      out.println("</head>");
	      out.println("<body>");
		  String fnm=req.getParameter("fname");
		  String lnm=req.getParameter("lname");
		   emal=req.getParameter("email");
		  gen=req.getParameter("gender");
		   pin=req.getParameter("gender");
		   dob=req.getParameter("birthday");
		   ph=req.getParameter("phno");
		  aadhaar=req.getParameter("adhar");
		  String res1=" ";
		  String sc=" ";
				  
	
		  
			    
		    long  min = 99999999999999L;
		    long  max = 10000000000000L;
//	the value of (max-min+1)+min is 10^^14+1
		    long random_int = (long)(Math.random() * (max - min + 1) + min);
		     pid = Long.toString(random_int);
		
		    out.println("partient: "+pid);
			  
		    out.println("<br><br>");

//		  displaying the data in the data base
		  out.println("Name: "+fnm+" "+lnm);
		  pnm=fnm.concat(lnm); 

		  out.println("<br><br>");
		  out.println("Gender: " +gen);

		  out.println("<br><br>");
		  out.println("Email:"+emal);

		  out.println("<br><br>");
		  out.println("DOB:"+dob);

		  out.println("<br><br>");
		  out.println("PINCODE:"+pin);
		  
		  out.println("<br><br>");
//		  birthday
		  out.println("<a href=\"index.html\" class=\"sign\">calculate data </a>");
		  
		  out.println("</h2><br><br><button onclick=\"location.href = 'index.jsp';\" id=\"myButton\" class=\"float-left submit-button\" >CALCULATE</button>\r\n"
			  		+ "");
		  out.println("</h2><br><br><button onclick=\"location.href = 'signup.jsp';\" id=\"myButton\" class=\"float-left submit-button\" >Home</button>\r\n"
			  		+ "");
			  
			/* int j1=Integer.parseInt(req.getParameter("2pp")); */
	      out.println("</h2><br><br><button type=\"reset\"  onclick=history.back() align=center>Go Back</button>");
	      out.println("</body>");
	      out.println("</html>");
	      Connection con=null;
	      try{
	    		Class.forName("com.mysql.jdbc.Driver");
//	    		con =DriverManager.getConnection("jdbc:mqsql://localhost:3306/pat_info","sqluser","password");
	    		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ncdjava?useSSL=false", "sqluser", "password");
	    		PreparedStatement ps=con.prepareStatement("INSERT INTO pat_info" + "(id,patname,email,gender,dob,adhar,phno,postalcode,score,result) values(?,?,?,?,?,?,?,?,?,?)");
//	    		String INSERT_USERS_SQL = "INSERT INTO patientinfo" +
//	    	            "  (id, first_name, last_name, gender, aadhaar_uid, phone_no, dob, pincode) VALUES " +
//	    	            " (?, ?, ?, ?, ?,?,?,?);";
	    		
	    		ps.setString(1,pid);
	    		ps.setString(2,pnm);
	    		ps.setString(3,emal);
	    		ps.setString(4,gen);
	    		ps.setString(5,dob);
	    		ps.setString(6,aadhaar);
	    		ps.setString(7,ph);
	    		ps.setString(8,pin);
	    		ps.setString(9,sc);
	    		ps.setString(10,res1);
	      
//	    		mysql> desc pat_info;
//	    		+------------+--------------+------+-----+---------+-------+
//	    		| Field      | Type         | Null | Key | Default | Extra |
//	    		+------------+--------------+------+-----+---------+-------+
//	    		| id         | varchar(14)  | NO   | PRI | NULL    |       |
//	    		| patname    | varchar(50)  | NO   |     | NULL    |       |
//	    		| email      | varchar(100) | NO   |     | NULL    |       |
//	    		| gender     | varchar(100) | NO   |     | NULL    |       |
//	    		| dob        | varchar(100) | NO   |     | NULL    |       |
//	    		| adhar      | varchar(100) | NO   |     | NULL    |       |
//	    		| phno       | varchar(100) | NO   |     | NULL    |       |
//	    		| postalcode | varchar(100) | NO   |     | NULL    |       |
//	    		| score      | varchar(100) | NO   |     | NULL    |       |
//	    		| result     | varchar(100) | NO   |     | NULL    |       |
//	    		+------------+--------------+------+-----+---------+-------+
//	    		10 rows in set (0.00 sec)
//
  		
	    		int rowCount=ps.executeUpdate();
    		if (rowCount>0)
    		{
    			out.print(rowCount+" created indb");
    		}
    		else {
    			out.print(rowCount+" zero afftected indb");
    			
    		}
	      }
	      catch(Exception e)
	      {
	    	  
	    	  out.print(" exception occurren :::::"+e);
	    	  
	      }
	      finally {
	    	  try {
	    		  
	    		  con.close();
	    	  }
	    	  catch(Exception e)
		      {
		    	  
		    	  out.print(e);
		    	  
		      }  
	      }
	      
	    		
	    		
	    		

	
			    
		    
//	 ending of handel request function     
	}
	
//	final block ending bracket
}
   