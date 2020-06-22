package cose;

import jm.music.data.Note;

import java.util.ArrayList;
import java.util.LinkedList;

public class Simbolo {

	private int suono;
	private double figura;
	private int ripetizioni = 1;
	private ArrayList<Note> notes = new ArrayList<>();

	public Simbolo(int suono, double figura) {
		this.suono = suono;
		this.figura = figura;
		generateNotes();
	}

	public Simbolo(int suono, double figura, int ripetizioni) {
		this.suono = suono;
		this.figura = figura;
		this.ripetizioni = ripetizioni;
		generateNotes();
	}

	private void generateNotes() {
		while (ripetizioni > 0) {
			notes.add(new Note(suono, figura));
			ripetizioni--;
		}
	}

	public ArrayList<Note> getNotes() {
		return notes;
	}

}
