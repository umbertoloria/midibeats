package cose;

import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Play;
import jm.util.View;
import jm.util.Write;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Set;

public class Brano {

	private String titolo;
	private double tempo;
	private HashMap<String, Traccia> traccie = new HashMap<String, Traccia>();

	public Brano(String titolo, double tempo) {
		this.titolo = titolo;
		this.tempo = tempo;
	}

	public boolean esisteTraccia(String titolo_traccia) {
		return traccie.containsKey(titolo_traccia);
	}

	public void nuovaTraccia(String titolo_traccia) {
		if (esisteTraccia(titolo_traccia)) {
			throw new IllegalArgumentException("Traccia già presente.");
		}
		traccie.put(titolo_traccia, new Traccia(titolo_traccia));
	}

	public void setSimbolo(String traccia, char s, Simbolo simbolo) {
		if (!esisteTraccia(traccia)) {
			throw new NoSuchElementException("Traccia non presente.");
		}
		Traccia t = traccie.get(traccia);
		t.setSimbolo(s, simbolo);
	}

	public void riempiTraccia(String traccia, String pattern) {
		if (!esisteTraccia(traccia)) {
			throw new NoSuchElementException("Traccia non presente.");
		}
		Traccia t = traccie.get(traccia);
		t.riempi(pattern, 1);
	}

	public void riempiTraccia(String traccia, String pattern, int ripetizioni) {
		if (!esisteTraccia(traccia)) {
			throw new NoSuchElementException("Traccia non presente.");
		}
		Traccia t = traccie.get(traccia);
		t.riempi(pattern, ripetizioni);
	}

	public double getTempo() {
		return tempo;
	}

	public String getTitle() {
		return titolo;
	}

	public void play() {
		Play.midi(generateScore());
	}

	public void show() {
		View.show(generateScore());
	}

	public void save() {
		Write.midi(generateScore(), titolo + ".mid");
	}

	public void saveAs(String filename) {
		Write.midi(generateScore(), filename + ".mid");
	}

	public Score generateScore() {
		Score traccia = new Score(titolo, tempo);
		Set<String> keys_set = traccie.keySet();
		Object[] keys = keys_set.toArray();
		for (Object key : keys) {
			Traccia t = traccie.get(key);
			Phrase phrase = t.getPhrase();


			Part part = new Part(0, 9); // TODO: why 0 and 9? // t.getTitle()
			// p.setNumerator(UP);
			// p.setDenominator(DOWN);

			part.add(phrase);
			traccia.add(part);
		}
		return traccia;
	}
}
