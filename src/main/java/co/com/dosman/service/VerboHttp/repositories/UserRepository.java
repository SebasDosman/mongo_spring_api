package co.com.dosman.service.VerboHttp.repositories;

import co.com.dosman.service.VerboHttp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
