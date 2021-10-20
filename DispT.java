package webtest.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DispT")
public class DispT extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int fId;
       
    public DispT() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		List<TopicSub> topics = (List<TopicSub>) getServletContext().getAttribute("topics" );
		fId = Integer.parseInt(request.getParameter("fId"));
		String name = request.getParameter("name");
		
		
		Connection c = null;
	    	try
	    	{
	    		String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu145?useSSL=false&allowPublicKeyRetrieval=true";
	    		String username = "cs3220stu145";
	    		String password = "CJhG#0vm";

	    		c = DriverManager.getConnection( url, username, password );
	    		Statement stmt = c.createStatement();
	    		ResultSet rs = stmt.executeQuery( "select * from topic_sub" );

	    		while( rs.next() )
	    		{
	    			topics.add( new TopicSub( rs.getInt( "fId" ), rs.getInt("id"), rs.getString( "name" ), rs.getString( "subject" ), rs.getString( "content" ), rs.getString( "date" ) ) );

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
	    request.setAttribute("topics", topics);
		request.getRequestDispatcher( "/DispT.jsp?fId="+fId+"&name="+name).forward( request, response );
	   }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		List<ForumSub> forums = (List<ForumSub>) getServletContext().getAttribute("forums");
		ForumSub forum = forums.get(0);
		fId = Integer.parseInt(request.getParameter("fId"));
		if(fId != 0) {
			for(ForumSub f: forums) {
				if(f.getId().equals(fId)) {
					forum = f;
					break;
				}
				
			}
		}
		
		request.setAttribute("forum", forum);
		request.getRequestDispatcher("/DispT.jsp?fId="+fId).forward(request, response);
		
	}

}
