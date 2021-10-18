
package fi.harkka.catfood.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.harkka.catfood.domain.CatRepository;
import fi.harkka.catfood.domain.Food;
import fi.harkka.catfood.domain.Cat;
import fi.harkka.catfood.domain.FoodRepository;
import fi.harkka.catfood.domain.Kind;
import fi.harkka.catfood.domain.KindRepository;

@RestController
public class RESTContoroller {
	
	@Autowired
	private FoodRepository frepository;
	@Autowired
	private CatRepository crepository;
	@Autowired
	private KindRepository krepository;
	
	
	@GetMapping("/cats")
	public @ResponseBody List<Cat> catListRest(){
		return (List<Cat>) crepository.findAll();
	};
	
	@GetMapping("/kinds")
	public @ResponseBody List<Kind> kindListRest(){
		return (List<Kind>) krepository.findAll();
	};
	
	@GetMapping("/foods")
	public @ResponseBody List<Food> foodListRest(){
		return (List<Food>) frepository.findAll();
	};
	
	@GetMapping("/cat/{catid}")
	public @ResponseBody Optional<Cat> findCat(@PathVariable("catid") Long catid) {
		return crepository.findById(catid);
	}
	
}