package Resources;

import RepClass.Spaceshooter_DAO;

import com.SpaceshooterService.app.Rankings_app.AppMonitor;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Path("/Spaceshooter")
@Produces(MediaType.APPLICATION_JSON)
public class RankingsResources 
{
	private final String template;
    private final String defaultName;
    private final AtomicLong counter;
    private AppMonitor testMonitor;

    public RankingsResources(String template, String defaultName, AppMonitor testMonitor) 
    {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
        this.testMonitor = testMonitor;
    }
    
    @Path("/GetTopTen")
    @GET
    @Timed
    public ArrayList<String> GetTopTen() 
    {
    	//TODO: trycatch first
    	this.testMonitor.writeText("[" + new Timestamp(System.currentTimeMillis()) + "] - " + "GetTopTen");
        return new Spaceshooter_DAO().GetTopTen();
    }
    
    @Path("/SetNewPlayer")
    @POST
    @Timed
    public boolean SetNewPlayer(@QueryParam("name") String name, @QueryParam("score") int score) 
    {
    	try
    	{
    		this.testMonitor.writeText("[" + new Timestamp(System.currentTimeMillis()) + "] - " + "SetNewPlayer: {name:" + name + ",score:"+score);
    		return new Spaceshooter_DAO().SetNewPlayer(name, score);
    	}
    	catch (Exception ex)
    	{
    		return false;
    	}
    }
}
