package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	
	private Twitter twitter;

	@Before
	public void setUp() throws Exception {
		twitter = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		twitter = null;
	}
	@Test
	public void testVratiSvePoruke() {
		twitter.vratiSvePoruke();
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiNull() {
		String korisnik = null;
		String poruka = null;
		twitter.unesi(korisnik, poruka);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiKorisnikEmptyString() {
		String korisnik = "";
		String poruka = "";
		for (int i = 0; i < 150; i++) {
			poruka += "a";
		}
		twitter.unesi(korisnik, poruka);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiMoreThan140() {
		String korisnik = "Petar Petrovic";
		String poruka = "";
		for (int i = 0; i < 150; i++) {
			poruka += "a";
		}
		twitter.unesi(korisnik, poruka);
	}

	@Test
	public void testUnesiRightMessage() {
		String korisnik = "Petar Petrovic";
		String poruka = "Good morning!";
		twitter.unesi(korisnik, poruka);
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		assertEquals(tp.toString(), twitter.vratiSvePoruke().getLast().toString());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNullTag() {
		String tag = null;
		twitter.vratiPoruke(5, tag);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeEmptyStringTag() {
		String tag = "";
		twitter.vratiPoruke(5, tag);
	}

	@Test
	public void testVratiPorukeLessOrEqualsZero() {
		String korisnik = "Petar Petrovic";
		String poruka = "Morning!";
		for (int i = 0; i < 150; i++) {
			twitter.unesi(korisnik, poruka);
		}
		twitter.vratiPoruke(0, poruka);
	}

	@Test
	public void testVratiPorukeRightMessage() {
		String tag = "Morning!";
		twitter.vratiPoruke(15, tag);
	}

}
