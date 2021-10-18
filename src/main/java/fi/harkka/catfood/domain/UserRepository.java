package fi.harkka.catfood.domain;

import org.springframework.data.repository.CrudRepository;
import fi.harkka.catfood.domain.User;


public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}