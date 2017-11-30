package com.SpaceshooterService.app.Rankings_app;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Hello world!
 *
 */
public class App extends Application<SpaceshooterConfig>
{
    public static void main(String[] args) throws Exception 
    {
        new App().run(args);
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
        // nothing to do yet
    }
}
