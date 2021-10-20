package webtest.servlet;

public class ReplySub {

	Integer id;
	String name;
	String content;
	String date;
	
	public ReplySub( Integer id, String name, String content, String date)
	{
		this.id = id;
		this.name = name;
		this.content = content;
		this.date = date;
		
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getContent()
	{
		return content;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}

}
