package osm19L_projekt1;
import helpers.GlobalVariables;

/***********************************************************************************************
 * Klasa zwiera dane osobowe pacjenta takie jak :											   *
 * #1 unikalny numer pacjenta po ktrym jest identyfikowany w systemie						   *
 * #2 imie																					   *
 * #3 nazwisko																				   *
 * #4 idNumber_ == numer PESEL																   *	
 * #5 numer ubezpieczenia																	   *	
 * 																							   *
 * klasa dziedziczy po klasie abstarkcyjnej, ktora odpowiada za jego unikalny numer. 		   *
 * Nadpisana zostala funkcja z klasy abstrakcyjnej--> patientNumber							   *	
 * @author arciak																			   *
 * *********************************************************************************************/


public class PatientData extends Patient{	
	private int patientNumber_;
	private String name_;
	private String surename_;
	String idNumber_;
	private int insurance_; 
	
	
	public PatientData(int patientNumber_,String name_, String surename_, String idNumber_, int insurance_) {
		this.setPatientNumber_(patientNumber_);
		this.setName_(name_);
		this.setSurename_(surename_);
		this.setIdNumber_(idNumber_);
		this.setInsurance_(insurance_);
	}

	boolean correctIdNumber(int[] idNumber) {
		
		return false;
	}
	
	
/**************************************************************
 * metoda ustawiajaca numer PESEL sprawdza jego dlugosc		  *
 * numery PESEL maja 11 znakow (liczb)						  *
 * w przypadku kiedy wprowadzony numer jest innej dlugosci 	  *
 * niz standarody numer PESEL zwracany jest wyjatek			  *
 * ************************************************************/
	public void setIdNumber_(String idNumber_) /*throws IllegalArgumentException */{	
		if(idNumber_.length()!=GlobalVariables.lengthOfIdNumber){
			throw new IllegalArgumentException("Zly PESEL");
		}
		else this.idNumber_ = idNumber_;
	}
	
	
	public int getInsurance_() {
		return insurance_;
	}

	public void setInsurance_(int insurance_) {
		this.insurance_ = insurance_;
	}

	public String getIdNumber_() {
		return idNumber_;
	}
	public String getSurename_() {
		return surename_;
	}

	public void setSurename_(String surename_) {
		this.surename_ = surename_;
	}

	public String getName_() {
		return name_;
	}

	public void setName_(String name_) {
		this.name_ = name_;
	}

	public int getPatientNumber_() {
		return patientNumber_;
	}

	public void setPatientNumber_(int patientNumber_) {
		this.patientNumber_ = patientNumber_;
	}

	@Override
	int patientNumber(int setNumber_) {
		// TODO Auto-generated method stub
		return setNumber_;
	}
	
}
