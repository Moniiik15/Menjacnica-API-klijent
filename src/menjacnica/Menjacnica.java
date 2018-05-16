package menjacnica;

import java.util.ArrayList;
import menjacnica.domenskeklase.Drzava;

import menjacnica.sistemskeoperacije.SOSerijalizacija;
import menjacnica.sistemskeoperacije.SOUcitajSaURL;
import menjacnica.sistemskeoperacije.SOVratiDrzave;
import menjacnica.sistemskeoperacije.SOVratiKurs;

public class Menjacnica {

	public String ucitajSaURL(String url) throws Exception {
		return SOUcitajSaURL.izvrsi(url);
	}

	public ArrayList<Drzava> vratiDrzave() throws Exception {
		return SOVratiDrzave.izvrsi();
	}

	public double vratiKurs(String iz, String u) {
		return SOVratiKurs.izvrsi(iz, u);

	}

	public void serijalizacija(String iz, String u, double kurs) {
		SOSerijalizacija.izvrsi(iz, u, kurs);

	}
}
