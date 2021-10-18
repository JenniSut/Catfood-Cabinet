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
import fi.harkka.catfood.domain.User;
import fi.harkka.catfood.domain.UserRepository;

@SpringBootApplication
public class CatfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatfoodApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo (FoodRepository frepository, CatRepository crepository, KindRepository krepository, UserRepository urepository) {
	return(args) -> {
		crepository.save(new Cat("Coco"));
		crepository.save(new Cat("Tootsie"));
		
		krepository.save(new Kind("Wet food"));
		krepository.save(new Kind("Dry food"));
		
		urepository.save(new User("user", "$2a$12$gijm3UphusWfVRBi//Tw6umZhFhHMo/7YmSzb9hbe1nux7H0cvnsa", "USER"));
		urepository.save(new User("admin", "$2a$12$IFILifeXBsyTIoo5n3HojeZVKljg83SeQueQKJxKDqMZa/JDwb.G6", "ADMIN"));
		
		//frepository.save(new Food("Wild Freedom Kitten, Golden Valley","https://www.zooplus.fi/shop/kissat/markaruoka/wild_freedom/wild_freedom_kitten/709035?origin=hopps&q=wild%20freedom&i=2&ro=1", 6, crepository.findByName("Coco").get(0), krepository.findByKindname("Wet food").get(0) ));
		//frepository.save(new Food("Kattovit Sensitive, Huhn","https://www.zooplus.fi/shop/kissat/markaruoka/kattovit/sensitive/481509?origin=hopps&q=kattovit%20sensitive%2C%20huhn&i=1&ro=2", 12, crepository.findByName("Tootsie").get(0), krepository.findByKindname("Wet food").get(0)));
		
		
	};};
};
