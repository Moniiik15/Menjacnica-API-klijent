package menjacnica;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;




public class Menjacnica {
	public static final String service = "/countries";
	public static final String CURRENCY_LAYER_API_URL = "http://free.currencyconverterapi.com/api/v3";
	
	
	public static String ucitajSaURL(String url) throws Exception {
		URL obj=new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		String content="";
		boolean end=false;
		while(!end) {
			String line=reader.readLine();
			if(line==null) end=true;
			else {
				content+=line;
				
			}
			
		}
		reader.close();
		return content;
		
	}
	public static ArrayList<Drzava> vratiDrzave() throws Exception{
		String url = CURRENCY_LAYER_API_URL + service;
		
		Gson gson=new GsonBuilder().create();
		ArrayList<Drzava> drzave=new ArrayList<Drzava>();
		JsonObject objContent=gson.fromJson(ucitajSaURL(url), JsonObject.class);
		JsonObject countriesJson = objContent.get("results").getAsJsonObject();
		
		
		
		for (Entry<String, JsonElement> entry : countriesJson.entrySet()) {
			JsonObject obj=(JsonObject) entry.getValue();
			Drzava d=new Drzava();
			d.setAlpha3(obj.get("alpha3").getAsString());
			d.setCurrencyId(obj.get("currencyId").getAsString());
			d.setCurrencyName(obj.get("currencyName").getAsString());
			if(obj.get("currencySymbol")!=null)
			d.setCurrencySymbol(obj.get("currencySymbol").getAsString());
			d.setId(obj.get("id").getAsString());
			d.setName(obj.get("name").getAsString());
			drzave.add(d);
			//System.out.println(d.toString());
			
		}
		
		
		return drzave;
	}
	public static void main(String[] args) {
		Menjacnica m=new Menjacnica();
		try {
			m.vratiDrzave();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
