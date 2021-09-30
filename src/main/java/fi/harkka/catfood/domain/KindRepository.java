package fi.harkka.catfood.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KindRepository extends CrudRepository<Kind, Long>
{
	List<Kind> findByKindname(String kindname);
 }
