package pl.marganski.soa;

import java.util.ArrayList;
import java.util.List;

public class CatShelter {
	
	List<Cat> cats = new ArrayList<>();
	
	public CatShelter() {
		cats.add(new Cat(1,"Puszek","toyger"));
		cats.add(new Cat(2,"Rumcajs","persian"));
		cats.add(new Cat(3,"Polly","russian"));
	}
	
	public List<Cat> getCats(){
		return cats;
	}
	
	public void setCats(List<Cat> cats) {
		this.cats = cats;
	}
	
	public void save(List<Cat> newCats) {
		cats.addAll(newCats);
	}
	
	public void update(int id, Cat cat) {
        remove(id);
        cats.add(cat);
    }
	
	public void remove(int id) {
		Cat cat = cats.stream().filter(lambCat -> lambCat.getId() == id).findAny().get();
		cats.remove(cat);
	}

	
}
