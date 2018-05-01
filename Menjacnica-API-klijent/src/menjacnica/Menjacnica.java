package menjacnica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
import com.google.gson.JsonParser;




public class Menjacnica {
	public static final String service = "/countries";
	public static final String CURRENCY_LAYER_API_URL = "http://free.currencyconverterapi.com/api/v3";
	public static final String service2 = "/convert";
	public static final String CURRENCY_LAYER_API_URL2 = "http://free.currencyconverterapi.com/api/v3";
	
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
	
	public static double vratiKurs(String iz, String u)  {
		String url = CURRENCY_LAYER_API_URL2 + service2 + '?' + "q=" + iz + '_' + u;
		String sadrzaj;
		try {
			sadrzaj = ucitajSaURL(url);
			Gson gson=new GsonBuilder().create();
			JsonObject con=gson.fromJson(sadrzaj, JsonObject.class);
			JsonObject query = con.get("query").getAsJsonObject();
			
			if(query.get("count").getAsInt()!=0) {
				JsonObject result = con.get("results").getAsJsonObject();
				JsonObject kon=result.getAsJsonObject(iz+"_"+u).getAsJsonObject();
				double vrednost=kon.get("val").getAsDouble();
				
				return vrednost;
			} 
			else {
				throw new RuntimeException("Ne postoje podaci o konverziji");
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;	
		
	}
	public static void main(String[] args) {
		try {
			vratiKurs("USD", "EUR");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
