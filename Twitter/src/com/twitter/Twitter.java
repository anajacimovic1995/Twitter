package com.twitter;

import java.util.LinkedList; 
import com.twitter.poruke.TwitterPoruka;
	/**
	 * Class that represent Twitter message which has linked lists of messages and returned messages.
	 * 
	 * @author Ana Jacimovic
	 *
	 */
public class Twitter { 
	
	/**
	 *  Linked liste of messages.
	 */
 
	private LinkedList<TwitterPoruka> poruke = 
			new LinkedList<TwitterPoruka>(); 
	/**
	 * Linked list of returned messages.
	 * @return message
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	/**
	 * Methode for creating new message.
	 * @param korisnik
	 * @param poruka
	 */
	public void unesi(String korisnik, String poruka) { 
		//Pravi se nova poruka i puni podacima.
		//Greska: Provera da li je unet null ili prazan string za korisnika i poruku.
		if (korisnik == null || poruka == null || korisnik.isEmpty() || poruka.length() > 140) {
			throw new RuntimeException("Customer and message has to exist.");
		}
		TwitterPoruka tp = new TwitterPoruka();
		// Greska: Potrebno je ukloniti navodnike iz razloga sto se unese podaci o korisniku.
		tp.setKorisnik(korisnik); 
		tp.setPoruka(poruka); 
 
		//Poruka se unosi u listu na kraj 
		poruke.addLast(tp); 
} 
/**
 * Methode which return list of messages.
 * 
 * @param maxBroj
 * @param tag
 * @return TwitterPoruka[]
 */
 
public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) { 
	if (tag==null || tag == "")
		throw new RuntimeException("Morate uneti tag");
	//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka 
	if (maxBroj<=0)
		maxBroj = 100;
	//Pomocna promenljiva koja predstavlja brojac upisanih poruka 
	int brojac = 0; //Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
	//sve poruke koje u sebi imaju zadati tag
	TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj]; 
 
	//Pretrazuju se poruke i traze se one koje sadrze tag. 
	//Ako se nadje neka takva, i ako nije prekoracen maxBroj 
	//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga 
	//se prekida. 
	for (int i = 0; i < poruke.size(); i++) 
		if (poruke.get(i).getPoruka().indexOf(tag)!=-1) 
			if (brojac < maxBroj){ 
				// Greska: Niz nije popunjavan na svako drugo mesto.
				rezultat[brojac]=poruke.get(i);
				brojac++; 
			} 
			else break; 
 
	return rezultat;
	} 
 
}