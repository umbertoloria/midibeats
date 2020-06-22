package cose;

import java.util.HashMap;
import java.util.LinkedList;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Phrase;

public class Traccia implements JMC {

	private String titolo;
	private HashMap<Character, Simbolo> simboli = new HashMap<>();
	private LinkedList<Note> notes = new LinkedList<>();

	public Traccia(String titolo) {
		this.titolo = titolo;
	}

	public void setSimbolo(char s, Simbolo simbolo) {
		if (esisteSimbolo(s)) {
			throw new IllegalArgumentException("Simbolo già presente.");
		}
		simboli.put(s, simbolo);
	}

	public boolean esisteSimbolo(char s) {
		return simboli.containsKey(s);
	}

	public String getTitle() {
		return titolo;
	}

	public void riempi(String pattern, int ripetizioni) {
//		String app = "";
//		while (ripetizioni > 0) {
//			app += pattern;
//			ripetizioni--;
//		}
		char[] ls = pattern.repeat(ripetizioni).toCharArray();
		for (char l : ls) {
			if (l != '|' && esisteSimbolo(l)) {
				Simbolo s = simboli.get(l);
				notes.addAll(s.getNotes());
			}
		}
		// TODO: studiare -> Mod.repeat(frase, 2);
	}

	public Phrase getPhrase() {
		Phrase frase = new Phrase();
		// frase.setNumerator(UP);
		// frase.setDenominator(DOWN);
		frase.add(new Note(REST, 1));
		for (Note note : notes) {
			frase.add(note);
		}
		return frase;
	}

}
