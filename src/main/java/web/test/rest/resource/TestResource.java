package web.test.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by PC on 05.09.14.
 */
@Path("rest")
public class TestResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String count() {
        return "This is REST";
    }

}
