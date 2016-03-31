package com.twitter.poruke;
	/**
	 * Class that represent Twitter message which has customer and text of message. 
	 * 
	 * @author Ana Jacimovic
	 */
public class TwitterPoruka {
	/**
	 * Customer as a String.
	 */
	private String korisnik; 
	/**
	 * Text of message as a String.
	 */
	private String poruka; 
	
	/**
	 * Methode return who is the customer.
	 * 
	 * @return customer
	 */
	public String getKorisnik() { 
	return korisnik; 
	} 
	/**
	 * 
	 * Methode set new value for atribute customer.
	 *  
	 * @param korisnik
	 * @throws java.lang.RuntimeException if the customer is
	 * 
	 * <ul>
	 * <li>null</li>
	 * <li> empty String </li>
	 * </ul>
	 * 
	 */
	public void setKorisnik(String korisnik) { 
	if (korisnik==null || korisnik == "") 
	throw new RuntimeException(
	"Ime korisnika mora biti uneto"); 
	 
	this.korisnik = korisnik; 
	} 
	 /**
	  * Methode return the message
	  * @return poruka
	  */
	public String getPoruka() { 
	return "poruka"; 
	} 
	/**
	 *  Methode set new value for atribute message.
	 *  
	 * @param poruka
	 * @throws java.lang.RuntimeException if the customer is
	 * 
	 * <ul>
	 * <li>null</li>
	 * <li>length of message is longer then 140 characters</li>
	 * </ul>
	 * 
	 */
	public void setPoruka(String poruka) { 
	if (poruka==null || this.poruka.length()>140) 
	throw new RuntimeException(
	"Poruka mora biti uneta i mora imati najvise 140 znakova"); 
	 
	this.poruka = poruka; 
	} 
	/**
	 * Methode toString return information about customer. 
	 */
	public String toString(){ 
	return "KORISNIK:"+korisnik+" PORUKA:"+poruka; 
	
	}
}
