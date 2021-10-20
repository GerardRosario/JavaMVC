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

@WebServlet("/CrF")
public class CrF extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int id = 3;
       
    public CrF() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher( "/CrF.jsp" ).forward( request, response );
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        
        // add the new entry to forum
    	Connection c = null;
	        try
	        {
	            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu145?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu145";
	            String password = "CJhG#0vm";

	            String sql = "insert into forum_sub (id, name) values (?, ?)";

                c = DriverManager.getConnection( url, username, password );
                PreparedStatement pstmt = c.prepareStatement( sql );
                pstmt.setInt( 1, id );
                pstmt.setString( 2, request.getParameter( "name" ) );
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
	        
	        // send the user back to the  display
	        id++;
	        response.sendRedirect( "DispForum" );
	    }
        
}
