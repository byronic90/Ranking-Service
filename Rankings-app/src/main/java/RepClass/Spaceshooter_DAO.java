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
        // Parameterless Constructor
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
    		Database_DAO db_DAO = new Database_DAO();
    		retList = db_DAO.GetTopTenFromDB();
    		
    		db_DAO.CloseConnection();
    		return retList;
    	}
    	catch (Exception ex)
    	{
    		return retList;
    	}
    }
    
    public boolean SetNewPlayer(String Name, int Punktzahl)
    {
    	boolean retBool = false;
    	try
    	{
    		// Save new player to database
    		Database_DAO db_DAO = new Database_DAO();
    		retBool = db_DAO.SetNewPlayerToDB(Name, Punktzahl);
    		
    		db_DAO.CloseConnection();
    		return retBool;
    	}
    	catch (Exception ex)
    	{
    		return retBool;
    	}
    }
}
