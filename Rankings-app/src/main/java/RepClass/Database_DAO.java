package RepClass;
import java.sql.*;
import java.util.ArrayList;

public class Database_DAO 
{
	private Connection conn;
	
	public Database_DAO() throws Exception
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spaceshooter?user=root");
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	
	public boolean SetNewPlayerToDB(String Name, int Punktzahl)
	{
		boolean retBool = false;
		try 
	    {
		    Statement stmt = conn.createStatement();
	        String strSelect = "INSERT INTO rankings (Name, Punktzahl) VALUES ('"+Name+"',"+Punktzahl+")";
	        int retInt = stmt.executeUpdate(strSelect);
	        
	        if (retInt>0)
	        {
	        	retBool = true;
	        }

	        return retBool;
        } 
		catch(Exception ex) 
		{
			return retBool;
		}
	}
	
	public ArrayList<String> GetTopTenFromDB()
	{
		ArrayList<String> retList = new ArrayList<String>();
		try 
	    {
		    Statement stmt = conn.createStatement();
	        String strSelect = "SELECT Name, Punktzahl FROM rankings GROUP BY Punktzahl DESC LIMIT 10 ";
	 
	        ResultSet rset = stmt.executeQuery(strSelect);
	 
	        int rowCount = 0;
	        while(rset.next()) 
	        {
	           String Name = rset.getString("Name");
	           int Punktzahl = rset.getInt("Punktzahl");
	            
	           retList.add("name:"+Name+",score:"+Punktzahl);
	            
	           ++rowCount;
	        }
	         
	        return retList;
        } 
		catch(Exception ex) 
		{
			retList = new ArrayList<String>();
			retList.add("Error:"+ex.getMessage());
			return retList;
		}
	}
	
	public boolean CloseConnection()
	{
		try
		{
			if(!conn.isClosed())
			{
				conn.close();
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			return false;
		}
	}

}
