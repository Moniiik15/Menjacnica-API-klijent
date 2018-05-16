package menjacnica.sistemskeoperacije;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SOUcitajSaURL {
	public static String izvrsi(String url) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");

		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

		String content = "";
		boolean end = false;
		while (!end) {
			String line = reader.readLine();
			if (line == null)
				end = true;
			else {
				content += line;

			}

		}
		reader.close();
		return content;

	}
}
