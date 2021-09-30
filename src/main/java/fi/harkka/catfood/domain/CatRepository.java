package fi.harkka.catfood.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import fi.harkka.catfood.domain.Cat;


public interface CatRepository extends CrudRepository<Cat, Long> {
	List<Cat> findByName(String name);
}
