package menjacnica.sistemskeoperacije;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import menjacnica.domenskeklase.Konverzija;

public class SOSerijalizacija {
	public static void izvrsi(String iz, String u, double kurs) {
		Konverzija k = new Konverzija();
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss.SSSSSS");
		String date = format.format(now);
		k.setDatumVreme(date);
		k.setIzValuta(iz);
		k.setuValuta(u);
		k.setKurs(kurs);
		JsonArray proslo = null;
		try (FileReader reader = new FileReader("data/log.json")) {
			proslo = gson.fromJson(reader, JsonArray.class);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (FileWriter writer = new FileWriter("data/log.json")) {
			if (proslo == null) {
				writer.write(gson.toJson(k));
			} else {
				String string = gson.toJson(k);
				// iz stringa u json objekat
				JsonObject obj = gson.fromJson(string, JsonObject.class);
				proslo.add(obj);
				writer.write(gson.toJson(proslo));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
