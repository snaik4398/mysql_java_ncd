package mysqljava;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Result extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	// This method is called by the servlet container to process a 'post' request
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
		{
			
			handleRequest(request, response);
		}

		public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
		{

			  String result;
			  res.setContentType("text/html;charset=UTF-8");
			  PrintWriter out=res.getWriter();
			  out.println("<!DOCTYPE html>");
		      out.println("<html>");
		      out.println("<head>");
		      out.println("<title>NCD Risk Assessment Checklist</title> ");
		      out.println("</head>");
		      out.println("<body>");


			  int i=Integer.parseInt(req.getParameter("age"));
			  
			  int j1=Integer.parseInt(req.getParameter("2pp"));
			  int j2=Integer.parseInt(req.getParameter("3pp"));
			  int j3=Integer.parseInt(req.getParameter("4pp"));
			  int j4=Integer.parseInt(req.getParameter("5pp"));
			  int j5=Integer.parseInt(req.getParameter("6pp"));
			  
			  int k=i+j1+j2+j3+j4+j5;
			  out.println("result is :"+k);
			  if(k >= 4)
			  {
				  result="NEED TO SCRINNING";
				  out.println("NEED TO SCRINNING");
			  }
			  else{
				  
				  result=" NO NEED TO SCRINNING";
				  out.println(" NO NEED TO SCRINNING");
			  }
			  out.println("</h2><br><br><button onclick=\"location.href = 'signup.jsp';\" id=\"myButton\" class=\"float-left submit-button\" >Home</button>\r\n"
			  		+ "");
			  
			  out.println("</h2><br><br><button type=\"reset\"  onclick=history.back() align=center>Go Back</button>");
		
			  
		      out.println("</body>");
		      out.println("</html>");
		      Connection con=null;
		      try{
		    		Class.forName("com.mysql.jdbc.Driver");
//		    		
		    		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ncdjava?useSSL=false", "sqluser", "password");
		    		PreparedStatement ps=con.prepareStatement("UPDATE pat_info SET score = ? , result = ? WHERE adhar = ? ;") ;
		    		
		    		//		    		UPDATE pat_info
//		    		SET score=4 ,result="screening"
//		    				WHERE email="snaik4398@gmail.com"
		    		String s=String.valueOf(k);

		    		ps.setString(1,s);
		    		ps.setString(2,result);
		    		ps.setString(3,Registration.aadhaar);

		      
		      
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
		      }//finnaly block

		   
//end of handel function
		}
		   
//		end of http function   	    
	   }

