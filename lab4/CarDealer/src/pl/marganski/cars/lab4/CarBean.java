package pl.marganski.cars.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@ViewScoped
public class CarBean {

	private String brand, model, price, engine, name, phone;

	private List<Car> cars;
	private List<String> models = new ArrayList<String>();
	private List<Car> availableCars = new ArrayList<Car>();
	private boolean disabled = true;

	public CarBean() {

		cars = new ArrayList<Car>();
		cars.add(new Car("Audi", "A4", "Diesel", 90000));
		cars.add(new Car("Audi", "Q7", "Petrol", 100000));
		cars.add(new Car("BMW", "X5", "Diesel", 110000));
		cars.add(new Car("BMW", "i8", "Petrol", 300000));
		cars.add(new Car("Mercedes", "CLS", "Petrol", 60000));
		cars.add(new Car("Mercedes", "AMG", "Diesel", 150000));
		cars.add(new Car("Opel", "Insignia", "Petrol", 120000));
		cars.add(new Car("Opel", "Mokka", "Diesel", 80000));

	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public List<String> getModels() {
		return models;
	}

	public void setModels(List<String> models) {
		this.models = models;
	}

	public List<Car> getAvailableCars() {
		return availableCars;
	}

	public void setAvailableCars(List<Car> availableCars) {
		this.availableCars = availableCars;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public void onBrandChange() {
		models.clear();
		models = cars
				.stream()
				.filter(object -> object.getBrand().equals(brand))
				.map(object -> object.getModel())
				.distinct()
				.collect(Collectors.toList());
	}

	public List<String> getBrands() {
		List<String> avalibleBrands = cars
				.stream()
				.map(object -> object.getBrand())
				.distinct()
				.collect(Collectors.toList());
		
		return avalibleBrands;
	}

	public void chosenCars(AjaxBehaviorEvent event) {
		String[] priceValues = price.split("-");
		int minVal = Integer.parseInt(priceValues[0]);
		int maxVal = Integer.parseInt(priceValues[1]);
		availableCars.clear();
		availableCars = cars.stream().filter(object -> object.getBrand().equals(brand))
				.filter(object -> object.getModel().equals(model))
				.filter(object -> Integer.valueOf(object.getPrice()) >= minVal)
				.filter(object -> Integer.valueOf(object.getPrice()) <= maxVal)
				.filter(object -> object.getEngine().equals(engine)).collect(Collectors.toList());

	}

	public void onButtonChange(AjaxBehaviorEvent event) {
		if (Stream.of(brand, engine, model, name, phone, price).allMatch(x -> x != null && !x.equals(""))) {
			this.disabled = false;
		} else {
			this.disabled = true;
		}
	}

	public void clearForm(AjaxBehaviorEvent event) {
		model = "";
		brand = "";
		price = "-";
		phone = "";
		name = "";
		availableCars.clear();
	}

}