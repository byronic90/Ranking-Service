package Deserialization;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class JSON_PutClass 
{
	public String getName() 
	{
		return Name;
	}

	public void setName(String name) 
	{
		Name = name;
	}

	public int getScore() 
	{
		return Score;
	}

	public void setScore(int score) 
	{
		Score = score;
	}

	private String Name;
	private int Score;
	
	public JSON_PutClass(String Name, int Score)
	{
		this.Name = Name;
		this.Score = Score;
	}
}
