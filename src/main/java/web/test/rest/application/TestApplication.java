package web.test.rest.application;

import org.glassfish.jersey.server.ResourceConfig;
import web.test.rest.resource.TestResource;

/**
 * Created by PC on 05.09.14.
 */
public class TestApplication extends ResourceConfig {

    public TestApplication() {
        register(TestResource.class);
        register(ObjectMapperResolver.class);
    }
}
