package Resources;

import RepClass.Spaceshooter_DAO;

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
        return new Spaceshooter_DAO().GetTopTen();
    }
    
    @Path("/SetPlayerStats")
    @GET
    @Timed
    public Spaceshooter_DAO sayHello(@QueryParam("name") Optional<String> name) 
    {
        final String value = String.format(template, name.or(defaultName));
        return new Spaceshooter_DAO(counter.incrementAndGet(), value);
    }
}
