package fi.harkka.catfood;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.harkka.catfood.web.FoodController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CatfoodApplicationTests {

	
	
	@Autowired
	private FoodController controller;

	//Testing that context is creating this controller
	@Test
	void contextLoads() throws Exception{
		Assertions.assertThat(controller).isNotNull();
	}
}
