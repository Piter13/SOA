package pl.marganski.cars.lab4;

public class Car {
	private String brand, model, engine;
	private int price;

	public Car(String brand, String model, String engine, int price) {
		this.brand = brand;
		this.model = model;
		this.engine = engine;
		this.price = price;
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

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
