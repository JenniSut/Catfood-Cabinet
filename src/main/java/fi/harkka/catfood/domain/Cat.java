package fi.harkka.catfood.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long catid;
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cat")
	private List<Food> foods;
	
	public Cat () {}
	
	

	@Override
	public String toString() {
		return "Cat [catid=" + catid + ", name=" + name + ", foods=" + foods + "]";
	}



	public Cat(String name) {
		super();
		this.name = name;
	}



	public Cat(String name, List<Food> foods) {
		super();
		this.name = name;
		this.foods = foods;
	}



	public Cat(Long catid, String name, List<Food> foods) {
		super();
		this.catid = catid;
		this.name = name;
		this.foods = foods;
	}



	public Long getCatid() {
		return catid;
	}

	public void setCatid(Long catid) {
		this.catid = catid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
	
	
}
