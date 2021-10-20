package webtest.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DispForum")
public class DispForum extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DispForum() {
    }
    
    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        List<ForumSub> forums = new ArrayList<ForumSub>();

        // store the data somewhere that can be accessed by this servlet
        // and other servlets.
        getServletContext().setAttribute( "forums", forums );
        
        List<TopicSub> topics = new ArrayList<TopicSub>();

        // store the data somewhere that can be accessed by this servlet
        // and other servlets.
        getServletContext().setAttribute( "topics", topics);
        
        List<ReplySub> replies = new ArrayList<ReplySub>();

        // store the data somewhere that can be accessed by this servlet
        // and other servlets.
        getServletContext().setAttribute( "replies", replies);
        
        List<Integer> counter1 = new ArrayList<Integer>();
        getServletContext().setAttribute( "counter1", counter1);
        
        List<Integer> counter2 = new ArrayList<Integer>();
        getServletContext().setAttribute( "counter2", counter2);
        
        List<Integer> counter3 = new ArrayList<Integer>();
        getServletContext().setAttribute( "counter3", counter3);
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 @SuppressWarnings("unchecked")
		 List<ForumSub> forums = (List<ForumSub>) getServletContext().getAttribute("forums" );
		 Connection c = null;
	        try
	        {
	            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu145?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu145";
	            String password = "CJhG#0vm";

	            c = DriverManager.getConnection( url, username, password );
	            Statement stmt = c.createStatement();
	            ResultSet rs = stmt.executeQuery( "select * from forum_sub" );

	            while( rs.next() )
	            {
	                forums.add( new ForumSub( rs.getInt( "id" ),rs.getString( "name" ) ) );

	            }

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
	        request.setAttribute( "forums", forums);
	        request.getRequestDispatcher( "/DispForum.jsp" ).forward( request, response );
	    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
