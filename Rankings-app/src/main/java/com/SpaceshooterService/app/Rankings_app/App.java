package com.SpaceshooterService.app.Rankings_app;

import Resources.RankingsResources;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Hello world!
 *
 */
public class App extends Application<SpaceshooterConfig>
{
	public AppMonitor testMonitor;
	
    public static void main(String[] args) throws Exception 
    {
    	String[] args2 = { "server", "conf/RankingsConf.yml" };
        new App().run(args2);
    }

    @Override
    public String getName() 
    {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<SpaceshooterConfig> bootstrap) 
    {
        // nothing to do yet
    }

    @Override
    public void run(SpaceshooterConfig configuration, Environment environment) 
    {
    	createMonitor();
    	final RankingsResources resource = new RankingsResources(
    	        configuration.getTemplate(),
    	        configuration.getDefaultName(),
    	        this.testMonitor
    	    );
    	    environment.jersey().register(resource);
    }
    
    private void createMonitor() {
    	this.testMonitor = new AppMonitor();    	
    }
}
