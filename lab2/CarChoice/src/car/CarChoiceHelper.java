package car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

enum CarType {sportowy, miejski, luksusowy }

class CarData {
	public int value;
	public CarType type;
	
	public CarData(int value, CarType type) {
		this.value = value;
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public CarType getType() {
		return type;
	}

	public void setType(CarType type) {
		this.type = type;
	}
	
}

public class CarChoiceHelper {
	static Map<String, CarData> cars = new HashMap<String, CarData>();
	{
		cars.put("Passat B5 1.9TDI Kombii", new CarData(20000, CarType.miejski));
		cars.put("Audi A3", new CarData(8000, CarType.miejski));
		cars.put("BMW X5", new CarData(50000, CarType.miejski));
		cars.put("Bentley Continental", new CarData(500000, CarType.luksusowy));
		cars.put("Porsche Carrera", new CarData(150000, CarType.sportowy));
		cars.put("Ferrari F50", new CarData(180000, CarType.sportowy));
		cars.put("Rolls Royce", new CarData(200000, CarType.luksusowy));
		cars.put("Bugatti Veyron", new CarData(1000000, CarType.luksusowy));
		cars.put("Mitsubishi Evo", new CarData(60000, CarType.sportowy));
	}
	
	public ArrayList<String> selectCars(String range, String type){
		String[] values = range.split("-");
		int minVal = Integer.parseInt(values[0]);
		int maxVal = Integer.parseInt(values[1]);
		
		switch(type){
			case "sportowy": {
				return getCarByRange(minVal, maxVal, CarType.sportowy); 
			}
			case "miejski":{
				return getCarByRange(minVal, maxVal, CarType.miejski);
			}
			case "luksusowy":{
				return getCarByRange(minVal, maxVal, CarType.luksusowy);
			}
		}
		return null;
	}
	
	ArrayList<String> getCarByRange(int minVal, int maxVal, CarType type){
		return (ArrayList<String>) cars.entrySet().stream()
                .filter(map -> map.getValue().getValue() >= minVal && map.getValue().getValue() <= maxVal && map.getValue().getType() == type) 
                .map(map -> map.getKey())
                .collect(Collectors.toList());
	}
}
