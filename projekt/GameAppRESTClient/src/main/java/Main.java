import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import pl.marganski.soa.jpa.entities.Mag.Element;
import pl.marganski.soa.jpa.entities.Mag.Power;
import pl.marganski.soa.jpa.entities.dto.MagDTO;

public class Main {

	public static void main(String[] args) throws JSONException {
		MagDTO mag = new MagDTO();
			mag.setCastleId(1);
			mag.setElement(Element.Earth);
			mag.setMana(45);
			mag.setName("Bill");
			mag.setPower(Power.Crush);

		postMag(mag);
		getMags();
		getCastles();
	}

	private static void postMag(MagDTO mag) throws JSONException {
		try {
			URL url = new URL("http://localhost:8080/GameApp/rest/mags");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setRequestProperty("User-Agent", "Chrome");
				
			JSONObject jsonObject = new JSONObject();
				jsonObject.put("castleId", mag.getCastleId());
				jsonObject.put("element", mag.getElement());
				jsonObject.put("mana", mag.getMana());
				jsonObject.put("name", mag.getName());
				jsonObject.put("power", mag.getPower());
			
			System.out.println(jsonObject);
			String input = 
					"{\r\n" 
							+ "\"element\": \"1\",\r\n"
							+ "\"castleId\": \"1\",\r\n"
							+ "\"name\": \"Ricky\",\r\n" 
							+ "\"mana\": \"99\",\r\n"
							+ "\"power\": \"Crush\"\r\n" 
					+ "}";

			OutputStream outputStream = connection.getOutputStream();
				outputStream.write(input.getBytes());
				outputStream.flush();

			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
			}
			
			connection.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//catch (MalformedURLException e) {
			//e.printStackTrace();
		//} 
	}

	private static void getCastles() {
		try {

			URL url = new URL("http://localhost:8080/GameApp/rest/castles");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.setRequestProperty("Accept", "application/json");
				connection.setRequestProperty("User-Agent", "Chrome");

			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
			}

			connection.disconnect();
		}  catch (IOException e) {
			e.printStackTrace();
		}
		// catch (MalformedURLException e) {
		// e.printStackTrace();
		// }
	}

	private static void getMags() {
		try {
			URL url = new URL("http://localhost:8080/GameApp/rest/mags");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.setRequestProperty("Accept", "application/json");
				connection.setRequestProperty("User-Agent", "Chrome");

			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
			}
			
			connection.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// catch (MalformedURLException e) {
		// e.printStackTrace();
		// } 
	}

}