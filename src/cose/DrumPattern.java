package cose;

import jm.JMC;

class DrumPattern implements JMC {

	public static void main(String[] args) {

		Brano b = new Brano("Canzone bella", 105);

		b.nuovaTraccia("Hit Hat");
		b.setSimbolo("Hit Hat", 'x', new Simbolo(CLOSED_HI_HAT, .25));
		b.setSimbolo("Hit Hat", 'X', new Simbolo(OPEN_HI_HAT, .25));
		b.setSimbolo("Hit Hat", ' ', new Simbolo(REST, .25));

		b.nuovaTraccia("Snare");
		b.setSimbolo("Snare", 'a', new Simbolo(ACOUSTIC_SNARE, .25));
		b.setSimbolo("Snare", 'A', new Simbolo(ACOUSTIC_SNARE, .125, 2));
		b.setSimbolo("Snare", ' ', new Simbolo(REST, .25));

		b.nuovaTraccia("Bass");
		b.setSimbolo("Bass", 'b', new Simbolo(BASS_DRUM_1, .25));
		b.setSimbolo("Bass", ' ', new Simbolo(REST, .25));

		String hhPattern123 = "x x x x X X X X ";
		String snPattern123 = "    a  a    AA a";
		String bsPattern123 = "b b     b bb  b ";
		b.riempiTraccia("Hit Hat", hhPattern123, 3);
		b.riempiTraccia("Snare", snPattern123, 3);
		b.riempiTraccia("Bass", bsPattern123, 3);


		String hhPattern4 = "X X X X X X X X ";
		String snPattern4 = "        aaaaAAAA";
		String bsPattern4 = "b b b b         ";
		b.riempiTraccia("Hit Hat", hhPattern4);
		b.riempiTraccia("Snare", snPattern4);
		b.riempiTraccia("Bass", bsPattern4);

		b.play();
//		b.save();
//		b.show();
	}

	/*
	 * public static void putPart(Score traccia, String title, int note_type, String
	 * pattern) { Part p = new Part(title, 0, 9); p.setNumerator(UP);
	 * p.setDenominator(DOWN);
	 *
	 * Phrase frase = new Phrase(); frase.setNumerator(UP);
	 * frase.setDenominator(DOWN);
	 *
	 * //frase.add(new Note(REST, dur));
	 *
	 * for (char l : pattern.toCharArray()) { if (l == 'x') { frase.add(new
	 * Note(note_type, dur)); } else if (l == '|') {
	 *
	 * } else if (l == 'y') { frase.add(new Note(note_type, dur / 2)); frase.add(new
	 * Note(note_type, dur / 2)); } else { frase.add(new Note(REST, dur)); } }
	 * Mod.repeat(frase, 2);
	 *
	 * p.add(frase);
	 *
	 * traccia.addPart(p); }
	 *
	 * /* public static void snarePart(Score traccia, String pattern) { Part p = new
	 * Part("Snare", 0, 9);
	 *
	 * Phrase frase = new Phrase();
	 *
	 * for (char l : pattern.toCharArray()) { if (l == 'x') { frase.add(new
	 * Note(ACOUSTIC_SNARE, dur)); } else if (l == '|') {
	 *
	 * } else { frase.add(new Note(REST, dur)); } }
	 *
	 * p.add(frase);
	 *
	 * traccia.addPart(p); }
	 */

	/*
	 * public static void riempiTraccia(Phrase frase, int strumento, final Score
	 * traccia) { Part part = new Part(frase.getTitle(), strumento, 0);
	 * part.addPhrase(frase); traccia.addPart(part); }
	 */
}