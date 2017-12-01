package RepClass;

import java.util.ArrayList;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Spaceshooter_DAO 
{
	private long id;

    @Length(max = 3)
    private String content;

    public Spaceshooter_DAO() 
    {
        // Jackson deserialization
    }

    public Spaceshooter_DAO(long id, String content) 
    {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() 
    {
        return id;
    }

    @JsonProperty
    public String getContent() 
    {
        return content;
    }

    public ArrayList<String> GetTopTen()
    {
    	ArrayList<String> retList = new ArrayList<String>();
    	try
    	{
    		// Get top ten players from database 
    		String obj1 = "name:turag,score:5000";
    		retList.add(obj1);
    		String obj2 = "name:malte,score:15000";
    		retList.add(obj2);
    		String obj3 = "name:yannik,score:500";
    		retList.add(obj3);
    		return retList;
    	}
    	catch (Exception ex)
    	{
    		return retList;
    	}
    }
}
