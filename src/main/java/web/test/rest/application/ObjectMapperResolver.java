package web.test.rest.application;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;

/**
 * Created by PC on 07.09.14.
 */
@Produces(MediaType.APPLICATION_JSON)
public class ObjectMapperResolver implements ContextResolver<ObjectMapper> {

    private final ObjectMapper mapper;

    public ObjectMapperResolver() {
        System.out.println("new ObjectMapperResolver()");
        mapper = new ObjectMapper();
        mapper.registerModule(new TestModule());
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        System.out.println("ObjectMapperResolver.getContext(...)");
        return mapper;
    }

}
