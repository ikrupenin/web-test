package web.test.rest.application;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by PC on 07.09.14.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public interface TestMixIn {
    @JsonProperty("uId")
    Long getId();

    String getName();

    Date getDate();

}
