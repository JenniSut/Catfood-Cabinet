package fi.harkka.catfood;


import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fi.harkka.catfood.domain.Cat;
import fi.harkka.catfood.domain.Kind;
import fi.harkka.catfood.domain.Food;
import fi.harkka.catfood.domain.CatRepository;
import fi.harkka.catfood.domain.FoodRepository;
import fi.harkka.catfood.domain.KindRepository;

@SpringBootTest
public class RepositoryTest {

	@Autowired
	public FoodRepository frepository;
	@Autowired
	public CatRepository crepository;
	@Autowired
	public KindRepository krepository;
	
	@Test
	public void findCatByName() {
		List<Cat> cats = crepository.findByName("Tootsie");
		Assertions.assertThat(cats.get(0).getName()).isEqualTo("Tootsie");
	}
	
	@Test
	public void addCat() {
		Cat cat = new Cat("Lumi");
		crepository.save(cat);
		List<Cat> cats = crepository.findByName("Lumi");
		Assertions.assertThat(cats.get(0).getName()).isEqualTo("Lumi");
	}
	
	@Test
	public void findKindByName() {
		List<Kind> kinds = krepository.findByKindname("Wet food");
		Assertions.assertThat(kinds.get(0).getKindname()).isEqualTo("Wet food");
	}
	
	@Test
	public void insertNewFood() {
		Food food = new Food("Kattovit Sensitive, Pollo", 12, crepository.findByName("Tootsie").get(0), krepository.findByKindname("Wet food").get(0));
		frepository.save(food);
		List<Food> foods = frepository.findByName("Kattovit Sensitive, Pollo");
		Assertions.assertThat(foods.get(0).getName()).isEqualTo("Kattovit Sensitive, Pollo");
	}
	
	
	
}
