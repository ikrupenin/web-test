package web.test.rest.application;

import com.fasterxml.jackson.databind.module.SimpleModule;
import web.test.domain.Test;

/**
 * Created by PC on 07.09.14.
 */
public class TestModule extends SimpleModule {

    public TestModule() {
        setMixInAnnotation(Test.class, TestMixIn.class);
    }
}
