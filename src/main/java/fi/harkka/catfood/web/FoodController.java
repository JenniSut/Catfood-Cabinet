package fi.harkka.catfood.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import javax.validation.Valid;

import fi.harkka.catfood.domain.FileUploadUtil;
import fi.harkka.catfood.domain.CatRepository;
import fi.harkka.catfood.domain.Food;
import fi.harkka.catfood.domain.FoodRepository;
import fi.harkka.catfood.domain.KindRepository;


@Controller
public class FoodController {
	//Injecting the repositories
	@Autowired
	private FoodRepository frepository;
	@Autowired
	private CatRepository crepository;
	@Autowired
	private KindRepository krepository;
	
	//index-page
	@RequestMapping(value="/index")
	public String foodlist(Model model) {
		model.addAttribute("foods", frepository.findAll());
		return("foodlist");
	}
	
	//add-page, which takes the food + cat to the addfood-page
	@RequestMapping(value="/add")
	public String addFood(Model model) {
		model.addAttribute("food", new Food());
		model.addAttribute("cats", crepository.findAll());
		model.addAttribute("kinds", krepository.findAll());
		return("addfood");
	}
	
	//save-page, which validates the information given on the addfood and editpages
	@PostMapping("/save")
	public String save(@Valid Food food, BindingResult bindingResult, Model model, @RequestParam("image") MultipartFile multipartFile) throws IOException {
		
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("cats", crepository.findAll());
			model.addAttribute("kinds", krepository.findAll());
			return "addfood";
		}
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		food.setPhotos(fileName);
		frepository.save(food);
		
		String uploadDir = "food-photos/" + food.getId();
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		
		return("redirect:index");
		
	}
	
	@PostMapping("/saveedit")
	public String saveEdit(@Valid Food food, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("cats", crepository.findAll());
			model.addAttribute("kinds", krepository.findAll());
			return "addfood";
		}
		frepository.save(food);
		return("redirect:index");
	}
	
	@GetMapping ("/delete/{id}")
	//Method-level authorization
	@PreAuthorize ("hasAuthority('ADMIN')")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		frepository.deleteById(id);
		return "redirect:../index";
		}
	
	@RequestMapping(value = "/edit/{id}")
	@PreAuthorize ("hasAuthority('ADMIN')")
	public String addBook(@PathVariable("id") long id, Model model) {
		model.addAttribute("food", frepository.findById(id));
		model.addAttribute("cats", crepository.findAll());
		model.addAttribute("kinds", krepository.findAll());
		return "editfood";
	}
	
}
