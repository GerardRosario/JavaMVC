package webtest.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CrT")
public class CrT extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int fId;
	String name2;
	int id = 20;
	int count1;
	int count2;
	int count3;
       
    public CrT() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fId = Integer.parseInt(request.getParameter("fId"));
		name2 = request.getParameter("name");
		request.getRequestDispatcher( "/CrT.jsp?fId="+fId).forward( request, response );	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateFormat df = new SimpleDateFormat("d/M/yyyy H:mm aa");
		Date dateobj = new Date();
		String dt = df.format(dateobj);
		
        String name = request.getParameter( "name" );
        String message = request.getParameter( "subject" );
        String content = request.getParameter( "content" );
        
        
        if(fId == 1) {
        	@SuppressWarnings("unchecked")
    		List<Integer> counter1 = (List<Integer>) getServletContext().getAttribute("counter1");
            counter1.add(count1);        
        } else if (fId == 2) {
        	@SuppressWarnings("unchecked")
    		List<Integer> counter2 = (List<Integer>) getServletContext().getAttribute("counter2");
            counter2.add(count2 );
        } else {
        	@SuppressWarnings("unchecked")
    		List<Integer> counter3 = (List<Integer>) getServletContext().getAttribute("counter1");
            counter3.add(count3 );
        }
        
        Connection c = null;
	    	try
	    	{
	    		String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu145?useSSL=false&allowPublicKeyRetrieval=true";
	    		String username = "cs3220stu145";
	    		String password = "CJhG#0vm";

	    		String sql = "insert into topic_sub (fId, id, name, subject, content, date) values (?, ?, ?, ?, ?, ?)";

	    		c = DriverManager.getConnection( url, username, password );
	    		PreparedStatement pstmt = c.prepareStatement( sql );
	    		pstmt.setInt( 1, fId );
	    		pstmt.setInt( 2, id );
	    		pstmt.setString( 3, name );
	    		pstmt.setString( 4, message );
	    		pstmt.setString( 5, content );
	    		pstmt.setString( 6, dt );
	    		pstmt.executeUpdate();
	    		c.close();
	    	}
	    	catch( SQLException e )
	    	{
	    		e.printStackTrace();
	    	}
	    	finally
	    	{
	    		try
	    		{
	    			if( c != null ) c.close();
	    		}
	    		catch( SQLException e )
	    		{
	    			e.printStackTrace();
	    		}
	    	}
	    	id++;
	    	// send the user back to the  display
	        response.sendRedirect( "DispT?fId="+fId+"&name="+name2);

	   }
}
