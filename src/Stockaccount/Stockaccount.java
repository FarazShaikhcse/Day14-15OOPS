package Stockaccount;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import stock.Stock;

public class Stockaccount {

	static Reader reader ;
	static JSONParser jsonParser;
	static JSONObject jsonObject;
	static JSONArray jsonArray;
	String filename;
	public Stockaccount(String filename) {
		this.filename = "/Users/farazshabbir/eclipse-workspace/JSON/Data/"+filename;
	}
	double valueof() {
		double value = 0.0;
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject obj = (JSONObject) jsonArray.get(i);
			long noOfShares = (long) obj.get("no_of_shares");
			double price = (double) obj.get("price");
			value += noOfShares*price;
			
	    }
		return value;
	}
	void buy(int amount, String symbol) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of shares:");
		int noOfShares = sc.nextInt();
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("no_of_shares", noOfShares);
		jsonObject.put("price", amount);
		jsonObject.put("symbol", symbol);
		jsonObject.put("date-time", java.time.LocalDateTime.now().toString()); 
		jsonArray.add(jsonObject); 
		try {
			FileWriter file = new FileWriter(filename);
			file.write(jsonArray.toJSONString());
			file.close();
		} catch (IOException e) {
	
		e.printStackTrace();
		}
		System.out.println("Added the stock: "+jsonObject);
	}
	void save(String filename) {
		
	}
	void printReport() {
		for (int i = 0; i < jsonArray.size(); i++) {
			System.out.printf("\nStock %s:\n", i + 1);
			JSONObject obj = (JSONObject) jsonArray.get(i);
			String name = (String) obj.get("symbol");
			long shares = (long) obj.get("no_of_shares");
			Double price = (Double) obj.get("price");
			String time = (String) obj.get("date-time");
			System.out.println("Stock symbol : " + name);
			System.out.println("Number of Shares : " + shares);
			System.out.println("Stock price : " + price);
			System.out.println("Purchase date : " + time);
			
			
	    }
	}
	public static void main(String[] args) {
		Stockaccount stockaccount = new Stockaccount("stock2.json");
		try {
			reader = new FileReader(stockaccount.filename);
			jsonParser = new JSONParser();
			jsonObject = (JSONObject) jsonParser.parse(reader);
			jsonArray = (JSONArray) jsonObject.get("stock");
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		stockaccount.buy(500,"Wipro");
		stockaccount.printReport();
		System.out.println("Value of all the shares: "+stockaccount.valueof());
		
		
	}
}
