package webtest.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/Reply")
public class Reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int id;
	int fId;
	String fname;
	String sub;
	
    public Reply() {
        super();
    }
    
    private TopicSub getEntry( Integer id )
    {
        @SuppressWarnings("unchecked")
		List<TopicSub> topics = (List<TopicSub>) getServletContext().getAttribute("topics" );

        for( TopicSub topic : topics )
            if( topic.getId().equals( id ) ) {
            	sub = topic.getSubject();
            	return topic;
            }
            
        return null;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html" );
		
		String a=request.getParameter("tId");
		String b=request.getParameter("fId");	
		String c=request.getParameter("fname");
		id = Integer.parseInt(a);
		fId = Integer.parseInt(b);
		fname = c;
		TopicSub top = getEntry(id);
		String Rname = top.getName();
		String Rcontent = top.getContent();
		String Rdate = top.getDate();
		String Rsubject = top.getSubject();
		int Rid = top.getId();
		
		request.setAttribute("stuff", top);
		RequestDispatcher rd=request.getRequestDispatcher("/Reply.jsp?name="+ Rname + "&content=" + Rcontent + "&date=" + Rdate + "&subject=" + Rsubject + "&id=" + Rid +"&fId=" + fId + "&fname=" + fname);
		rd.forward(request, response);

	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		@SuppressWarnings("unchecked")
		List<ReplySub> replies = (List<ReplySub>) getServletContext().getAttribute("replies" );
		
		DateFormat df = new SimpleDateFormat("d/M/yyyy H:mm aa");
		Date dateobj = new Date();
		String dt = df.format(dateobj);
		
        String name = request.getParameter( "name" );
        String content = request.getParameter( "content" );
        

        	Connection c = null;
  	        try
  	        {
  	            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu145?useSSL=false&allowPublicKeyRetrieval=true";
  	            String username = "cs3220stu145";
  	            String password = "CJhG#0vm";

  	            String sql = "insert into reply_sub (id, name, content, date) values (?, ?, ?, ?)";

                       c = DriverManager.getConnection( url, username, password );
                       PreparedStatement pstmt = c.prepareStatement( sql );
                       pstmt.setString( 1, request.getParameter( "id" ) );
                       pstmt.setString( 2, name );
                       pstmt.setString( 3, content );
                       pstmt.setString( 4, dt );
                       pstmt.executeUpdate();

  	            Statement stmt = c.createStatement();
  	            ResultSet rs = stmt.executeQuery( "select * from reply_sub" );

  	            while( rs.next() )
  	            {
  	                replies.add( new ReplySub( rs.getInt( "id" ), rs.getString( "name" ), rs.getString( "content" ), rs.getString( "date" ) ) );

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
    
        request.setAttribute("replies", replies);		
        // send the user back to topic replies
        response.sendRedirect( "Reply?id="+id+"&tId="+id+"&fId="+fId+"&fname="+fname);
	}

}
