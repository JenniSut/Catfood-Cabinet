package fi.harkka.catfood.domain;

import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Long>
{
 }
