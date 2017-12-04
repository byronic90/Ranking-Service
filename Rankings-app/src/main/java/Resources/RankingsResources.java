package Resources;

import RepClass.Spaceshooter_DAO;

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Path("/Spaceshooter")
@Produces(MediaType.APPLICATION_JSON)
public class RankingsResources 
{
	private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public RankingsResources(String template, String defaultName) 
    {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }
    
    @Path("/GetTopTen")
    @GET
    @Timed
    public ArrayList<String> GetTopTen() 
    {
    	//TODO: trycatch first
        return new Spaceshooter_DAO().GetTopTen();
    }
    
    @Path("/SetNewPlayer")
    @GET
    @Timed
    public boolean SetNewPlayer(@NotNull@QueryParam("name") String name, @NotEmpty@QueryParam("score") int score) 
    {
    	try
    	{
    		return new Spaceshooter_DAO().SetNewPlayer(name, score);
    	}
    	catch (Exception ex)
    	{
    		return false;
    	}
    }
}
