package web.test.rest.resource;

import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.CollectionUtils;
import web.test.domain.Test;
import web.test.service.TestService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by PC on 05.09.14.
 */
@Path("rest")
public class TestResource {

    public static final FastDateFormat FORMATTER = FastDateFormat.getInstance("MM/dd/yyyy");

    @Autowired
    @Qualifier("testService")
    private TestService service;

    public void setService(TestService service) {
        this.service = service;
    }

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Test> tests = service.getAll();
        if (CollectionUtils.isEmpty(tests)) {
            throw new NotFoundException("Entities not found");
        }
        return Response.ok().entity(tests).build();
    }

    @GET
    @Path("test/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Long id) {
        Test test = service.get(id);
        if (test == null) {
            throw new NotFoundException("Entity not found: id=" + id);
        }
        return Response.ok().entity(test).build();
    }

    @POST
    @Path("test/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("id") Long id,
                           @FormParam("name") String name, @FormParam("date") String dateParam) {
        Date date;
        try {
            date = FORMATTER.parse(dateParam);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Illegal 'date' parameter. Should have format 'MM/dd/yyyy'");
        }
        if (service.get(id) != null) {
            throw new IllegalArgumentException("Entity already exists: id=" + id);
        }
        Test test = new Test(id, name, date);
        service.save(test);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("test/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id,
                           @FormParam("name") String name, @FormParam("date") String dateParam) {
        Date date;
        try {
            date = FORMATTER.parse(dateParam);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Illegal 'date' parameter. Should have format 'MM/dd/yyyy'");
        }
        Test test = service.get(id);
        if (test == null) {
            throw new IllegalArgumentException("Entity doesn't exist: id=" + id);
        }
        test.setName(name);
        test.setDate(date);
        service.save(test);
        return Response.ok().build();
    }

    @DELETE
    @Path("test/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.ok().build();
    }

}
