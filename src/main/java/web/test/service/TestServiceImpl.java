package web.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.test.domain.Test;
import web.test.repository.TestRepository;

import java.util.List;

/**
 * Created by PC on 07.09.14.
 */
@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository repository;

    public void setRepository(TestRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Test test) {
        repository.save(test);
    }

    @Override
    public Test get(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public List<Test> getAll() {
        return repository.findAll();
    }

}
