package menjacnica.sistemskeoperacije;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class SOVratiKurs {

	public static final String service2 = "/convert";
	public static final String CURRENCY_LAYER_API_URL2 = "http://free.currencyconverterapi.com/api/v3";

	public static double izvrsi(String iz, String u) {
		String url = CURRENCY_LAYER_API_URL2 + service2 + '?' + "q=" + iz + '_' + u;
		String sadrzaj;
		try {
			sadrzaj = SOUcitajSaURL.izvrsi(url);
			Gson gson = new GsonBuilder().create();
			JsonObject con = gson.fromJson(sadrzaj, JsonObject.class);
			JsonObject query = con.get("query").getAsJsonObject();

			if (query.get("count").getAsInt() != 0) {
				JsonObject result = con.get("results").getAsJsonObject();
				JsonObject kon = result.getAsJsonObject(iz + "_" + u).getAsJsonObject();
				double vrednost = kon.get("val").getAsDouble();

				return vrednost;
			} else {
				throw new RuntimeException("Ne postoje podaci o konverziji");

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return 0;

	}
}
