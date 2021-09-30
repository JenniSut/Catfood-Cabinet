package fi.harkka.catfood.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kind {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long kindid;
	String kindname;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kind")
	private List<Food> foods;
	
	public Kind() {}

	public Kind(String kindname) {
		super();
		this.kindname = kindname;
	}

	public Kind(Long kindid, String kindname, List<Food> foods) {
		super();
		this.kindid = kindid;
		this.kindname = kindname;
		this.foods = foods;
	}

	public Long getKindid() {
		return kindid;
	}

	public void setKindid(Long kindid) {
		this.kindid = kindid;
	}

	public String getKindname() {
		return kindname;
	}

	public void setKindname(String kindname) {
		this.kindname = kindname;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	@Override
	public String toString() {
		return "Kind [kindid=" + kindid + ", kindname=" + kindname + ", foods=" + foods + "]";
	}
	
	
}
