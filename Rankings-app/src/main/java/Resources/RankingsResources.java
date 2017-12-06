package Resources;

import Deserialization.JSON_PutClass;
import RepClass.Spaceshooter_DAO;

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    @POST
    @Timed
    public boolean SetNewPlayer(@QueryParam("name") String name, @QueryParam("score") int score) 
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
