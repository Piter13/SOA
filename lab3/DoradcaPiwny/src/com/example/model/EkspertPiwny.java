package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class EkspertPiwny {

	public List<String> getMarki(String kolor){
		
        List<String> marki = new ArrayList<String>();

		if (kolor.equals("jasne")) {
			marki.add("Kasztelan");
			marki.add("Perla");
		}

		if (kolor.equals("bursztynowe")) {
			marki.add("Komes");
			marki.add("Zawiercie");
		}

		if (kolor.equals("brazowe")) {
			marki.add("Fortuna");
			marki.add("Zywiec");
		}

		if (kolor.equals("ciemne")) {
			marki.add("Piwo na miodzie gryczanym");
			marki.add("Warka");
		}

		return marki;
	}
}
