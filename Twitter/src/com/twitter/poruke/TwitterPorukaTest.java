/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Ana Jacimovic
 *
 */
public class TwitterPorukaTest {
	private TwitterPoruka tp;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnikNull() {
		String korisnik = null;
		
		tp.setKorisnik(korisnik);
		
		assertEquals(korisnik, tp.getKorisnik());
		
	}
	public void testSetKorisnikEmptyString() {
		String korisnik = "";
		
		tp.setKorisnik(korisnik);
		
		assertEquals(korisnik, tp.getKorisnik());
		
	}
	public void testSetKorisnikRightMessage() {
		String korisnik = "Petar Petrovic";
		
		tp.setKorisnik(korisnik);
		
		assertEquals(korisnik, tp.getKorisnik());
		
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPorukaRightMessage() {
		String poruka = "Good morning!";
		
		tp.setPoruka(poruka);
		
		assertEquals(poruka, tp.getPoruka());
	}
	@Test
	public void testSetPorukaNull() {
		String poruka = null;
		
		tp.setPoruka(poruka);
		
		assertEquals(poruka, tp.getPoruka());
	}
	@Test
	public void testSetPorukaEmptyString() {
		String poruka = "";
		
		tp.setPoruka(poruka);
		
		
		assertEquals(poruka, tp.getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaBrojKarakteraVeciOd140() {
		String string = "";
		for (int i = 0; i < 150; i++) {
			string += "a";
		}
		tp.setPoruka(string);
	}


	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		String korisnik = tp.getKorisnik();
		String poruka = tp.getPoruka();
		
		assertEquals("KORISNIK:"+korisnik+" PORUKA:"+poruka,tp.toString());
		
	}

}
