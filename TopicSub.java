package webtest.servlet;

import java.util.ArrayList;
import java.util.List;

public class TopicSub {
	
	Integer fId;
	Integer id;
	String name;
	String subject;
	String content;
	String date;	
	
	public TopicSub(Integer fId, Integer id, String name, String subject, String content, String date)
	{
		this.fId = fId;
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.content = content;
		this.date = date;
		
	}
	
	public Integer getfId()
	{
		return fId;
	}
	
	public void setfId(Integer fId)
	{
		this.fId = fId;
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
	
	public String getSubject()
	{
		return subject;
	}
	
	public void setSubject(String subject)
	{
		this.subject = subject;
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
