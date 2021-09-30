package fi.harkka.catfood.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min=2, max=120)
	@NotNull
	private String name;
	int amount;
	
	@ManyToOne
	@JoinColumn(name="catid")
	private Cat cat;
	
	@ManyToOne
	@JoinColumn(name="kindid")
	private Kind kind;
	
	public Food() {}
	
	
	public Kind getKind() {
		return kind;
	}


	public void setKind(Kind kind) {
		this.kind = kind;
	}


	public Food(Long id, @Size(min = 2, max = 120) @NotNull String name, int amount, Cat cat, Kind kind) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.cat = cat;
		this.kind = kind;
	}


	public Food(@Size(min = 2, max = 120) @NotNull String name, int amount, Cat cat, Kind kind) {
		super();
		this.name = name;
		this.amount = amount;
		this.cat = cat;
		this.kind = kind;
	}


	public Food(Long id, String name, int amount, Cat cat) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.cat = cat;
	}


	public Food(String name, int amount, Cat cat) {
		super();
		this.name = name;
		this.amount = amount;
		this.cat = cat;
	}


	public Cat getCat() {
		return cat;
	}


	public void setCat(Cat cat) {
		this.cat = cat;
	}


	public Food(String name, int amount) {
		super();
		this.name = name;
		this.amount = amount;
	}
	public Food(Long id, String name, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", amount=" + amount + ", cat=" + cat + ", kind=" + kind + "]";
	}
	
	
}
