package fi.harkka.catfood;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.harkka.catfood.domain.Cat;
import fi.harkka.catfood.domain.CatRepository;
import fi.harkka.catfood.domain.Food;
import fi.harkka.catfood.domain.FoodRepository;
import fi.harkka.catfood.domain.Kind;
import fi.harkka.catfood.domain.KindRepository;

@SpringBootApplication
public class CatfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatfoodApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo (FoodRepository frepository, CatRepository crepository, KindRepository krepository) {
	return(args) -> {
		crepository.save(new Cat("Coco"));
		crepository.save(new Cat("Tootsie"));
		
		krepository.save(new Kind("Wet food"));
		krepository.save(new Kind("Dry food"));
		
		frepository.save(new Food("Wild Freedom Kitten, Golden Valley", 6, crepository.findByName("Coco").get(0), krepository.findByKindname("Wet food").get(0)));
		frepository.save(new Food("Kattovit Sensitive, Huhn", 12, crepository.findByName("Tootsie").get(0), krepository.findByKindname("Wet food").get(0)));
		
		
	};};
};
