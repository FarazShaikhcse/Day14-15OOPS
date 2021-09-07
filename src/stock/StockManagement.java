package stock;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class StockManagement {
	public static Scanner sc = new Scanner(System.in);
	public static JSONArray stockList = new JSONArray();

	public static void main(String[] args) {
		
		System.out.println("Stock Management:");
		int choice = 0;
		
		while(choice != 3) {
			
		System.out.println("Enter your choice:\n1.Add Stock \n2.Print stock report \n3.Exit");
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			addStock();
			break;
		case 2:
			printStock();
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
	}
	}

	public static void printStock() {
		System.out.println("The stock details are:");
		JSONParser jsonParser = new JSONParser();
		try {
			JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(".//Data/stock.json"));
			for (int i = 0; i < jsonArray.size(); i++) {
				System.out.printf("\nStock %s:\n", i + 1);
				JSONObject obj = (JSONObject) jsonArray.get(i);
				String name = (String) obj.get("name");
				long shares = (long) obj.get("no_of_shares");
				Double price = (Double) obj.get("price");
				System.out.println("Stock Name : " + name);
				System.out.println("Number of Shares : " + shares);
				System.out.println("Stock price : " + price);
		    }
		} 
		catch (FileNotFoundException e) {

			System.out.println("File Not Found");
		} 
		catch (IOException e) {
			System.out.println("File IO Exception");
		} 
		catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		
	}

	public static void addStock() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Stock Name:");
		String stockName = sc.nextLine();
		System.out.println("Enter number of shares:");
		int noOfShares = sc.nextInt();
		System.out.println("Enter share price:");
		double sharePrice = sc.nextDouble();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", stockName); 
		jsonObject.put("no_of_shares", noOfShares);
		jsonObject.put("price", sharePrice);
		stockList.add(jsonObject); 
		try {
		FileWriter file = new FileWriter("/Users/farazshabbir/eclipse-workspace/JSON/Data/stock.json");
		file.write(stockList.toJSONString());
		file.close();
		} catch (IOException e) {
	
		e.printStackTrace();
		}
		System.out.println("Added the stock: "+jsonObject);
	
	}
}