
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class InventoryManagement {
	
	public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(".//Data/inventory.json");

		JSONObject inventoryobj = (JSONObject) jsonparser.parse(reader); 
		JSONArray array = (JSONArray) inventoryobj.get("inventory"); 
		Map<String,Double> map = new HashMap<>();
		
		for (int i = 0; i < array.size(); i++) {
			
			JSONObject inventoryDetails = (JSONObject) array.get(i);
			String name = (String) inventoryDetails.get("name");
			double weight = (double) inventoryDetails.get("weight");
			double pricePerKg = (double) inventoryDetails.get("pricePerWeight");
			String type = (String) inventoryDetails.get("type");
			System.out.println("Item " + i + " details are:");
			System.out.println("name: " + name);
			System.out.println("weight: " + weight);
			System.out.println("pricePerKg: " + pricePerKg);
			System.out.println("type: " + type);
			double value = weight * pricePerKg;
			System.out.println("value for Inventory is:" + value);
			map.put(name, value);
		}
		JSONArray values =  new JSONArray();
		for (String s: map.keySet()) {
			JSONObject object1=new JSONObject();
			object1.put("name", s);
			object1.put("Totalprice",map.get(s));
			values.add(object1);
		}
		JSONObject resultsobj =  new JSONObject();
		resultsobj.put("Result", values);
		System.out.println(resultsobj);
		try {
				FileWriter writer = new FileWriter("/Users/farazshabbir/eclipse-workspace/JSON/Data/results.json");
				writer.write(resultsobj.toJSONString());
				writer.flush();
		} 
		catch (IOException e) {
		
				e.printStackTrace();
		}
	}
		
	
}