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
		  String emal=req.getParameter("email");
		  String gen=req.getParameter("gender");
		  String pin=req.getParameter("gender");
		  String dob=req.getParameter("birthday");
		  String ph=req.getParameter("phno");
		  aadhaar=req.getParameter("adhar");
		  String res1=" ";
		  String sc=" ";
				  
	
		  
		  
		  

//		  displaying the data in the data base
		  out.println("Name: "+fnm+" "+lnm);
		  fnm.concat(lnm); 

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
	    		PreparedStatement ps=con.prepareStatement("INSERT INTO pat_info" + "(patname,email,gender,dob,adhar,phno,postalcode,score,result) values(?,?,?,?,?,?,?,?,?)");
//	    		String INSERT_USERS_SQL = "INSERT INTO patientinfo" +
//	    	            "  (id, first_name, last_name, gender, aadhaar_uid, phone_no, dob, pincode) VALUES " +
//	    	            " (?, ?, ?, ?, ?,?,?,?);";
//	    		ps.setInt(1, 1);
	    		ps.setString(1,fnm);
	    		ps.setString(2,emal);
	    		ps.setString(3,gen);
	    		ps.setString(4,dob);
	    		ps.setString(5,aadhaar);
	    		ps.setString(6,ph);
	    		ps.setString(7,pin);
	    		ps.setString(8,sc);
	    		ps.setString(9,res1);
	      
	      
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
   