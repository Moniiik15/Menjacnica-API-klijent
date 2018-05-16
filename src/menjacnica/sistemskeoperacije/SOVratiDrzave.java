package menjacnica.sistemskeoperacije;

import java.util.ArrayList;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import menjacnica.domenskeklase.Drzava;

public class SOVratiDrzave {
	public static final String service = "/countries";
	public static final String CURRENCY_LAYER_API_URL = "http://free.currencyconverterapi.com/api/v3";

	public static ArrayList<Drzava> izvrsi() throws Exception {
		String url = CURRENCY_LAYER_API_URL + service;

		Gson gson = new GsonBuilder().serializeNulls().create();
		ArrayList<Drzava> drzave = new ArrayList<Drzava>();
		JsonObject objContent = gson.fromJson(SOUcitajSaURL.izvrsi(url), JsonObject.class);
		JsonObject countriesJson = objContent.get("results").getAsJsonObject();

		for (Entry<String, JsonElement> entry : countriesJson.entrySet()) {
			JsonObject obj = (JsonObject) entry.getValue();
			Drzava d = new Drzava();
			d = gson.fromJson(obj, Drzava.class);

			drzave.add(d);

		}

		return drzave;

	}
}
