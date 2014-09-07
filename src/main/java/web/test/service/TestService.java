package web.test.service;

import web.test.domain.Test;

import java.util.List;

/**
 * Created by PC on 07.09.14.
 */
public interface TestService {

    void save(Test test);

    Test get(Long id);

    void delete(Long id);

    List<Test> getAll();

}
