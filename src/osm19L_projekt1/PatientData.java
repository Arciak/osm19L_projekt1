package osm19L_projekt1;
import helpers.GlobalVariables;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import helpers.Exceptions;

/***********************************************************************************************
 * Klasa zwiera dane osobowe pacjenta takie jak :											   *
 * #1 unikalny numer pacjenta po ktrym jest identyfikowany w systemie						   *
 * #2 imie																					   *
 * #3 nazwisko																				   *
 * #4															   *	
 * #5 numer ubezpieczenia																	   *
 * 																							   *
 * Klasa posiada funckjce:																	   *
 * 1. Wypisywanie na ekran danych															   *
 * 														   									   *	
 * 																							   *
 * klasa dziedziczy po klasie abstarkcyjnej, ktora odpowiada za jego unikalny numer. 		   *
 * Nadpisana zostala funkcja z klasy abstrakcyjnej--> patientNumber							   *	
 * @author arciak																			   *
 * *********************************************************************************************/


public class PatientData{	
	private String name_;
	private String surename_;
	private String sex_;
	private String insurance_; 
	
	
	public PatientData(String name_, String surename_, String sex_, String insurance_) throws Exceptions {
		this.setName_(name_);
		this.setSurename_(surename_);
		this.setSex_(sex_);
		this.setInsurance_(insurance_);
	}
	
	
/**************************************************************
 * metoda ustawiajaca numer PESEL sprawdza jego dlugosc		  *
 * numery PESEL maja 11 znakow (liczb)						  *
 * w przypadku kiedy wprowadzony numer jest innej dlugosci 	  *
 * niz standarody numer PESEL zwracany jest wyjatek			  *
 * ************************************************************/
	public String getInsurance_() {
		return insurance_;
	}

	public void setInsurance_(String insurance_) {
		this.insurance_ = insurance_;
	}

	
	
	public String getSurename_() {
		return surename_;
	}

	public void setSurename_(String surename_) throws Exceptions {
		if(surename_ == null || surename_.length() == 0){
			throw new Exceptions("Wprowadz nazwisko");
		}
		else this.surename_ = surename_;
	}

	public String getName_() {
		return name_;
	}

	public void setName_(String name_) throws Exceptions{
		if(name_ == null || name_.length() == 0){
			throw new Exceptions("Wprowadz imie");
		}
		else this.name_ = name_;
	}
	
	
	public String getSex_() {
		return sex_;
	}


	public void setSex_(String sex_) throws Exceptions{
		if(sex_ == null || sex_.length() == 0){
			throw new Exceptions("Wybierz plec");
		}
		else this.sex_ = sex_;
	}
	
	public void printPatientData(){
		System.out.println( name_+" "+surename_+ " " + sex_ + " "+ insurance_);
	}
	
}
