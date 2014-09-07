package web.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import web.test.domain.Test;

/**
 * Created by PC on 07.09.14.
 */
@Repository
public interface TestRepository extends MongoRepository<Test, Long> {
}
