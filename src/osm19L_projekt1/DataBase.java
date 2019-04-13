package osm19L_projekt1;

/****************************************************************************************
 * Klasa DataBase odpowiada za tworzenie kontenerow. Stworzone sa dwa kontenery.		*
 * Jeden kontener "mapWithPatientsData" odpowida za przechowywanie danych personalnych	*
 * Drugi kontener "mapWithPatientsTestResults" przechowuje rezultaty badan 				*
 * 																						*
 * W kalsie zaimplementowana jest takze zmienna "patientUniqueNumber_", 				*
 * ktora nadaje unikalny numer kazdemu pacjentowi. 										*
 * 																						*
 * Klasa ta posiada takze funckje wykonujaca operacje:									*
 * #1 wprowadzania i dodawania pacjenta													*
 * #2 usuwania pacjenta																	*
 * #3 wsywietlania danych pacjenta o jego unikalnym numerze								*
 * #4 wyswietlania wszytskich pacjentow													*
 * #5 usuwanie pacjenta																	*
 * @author arciak																		*
 ****************************************************************************************/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class PatientID{
	public String name; 
    public String sureName;  
    public String idNumber;
    public String insuranceNumber;
 };


public class DataBase {
	
	PatientID patientId = new PatientID();
	private static Scanner inputID = new Scanner(System.in); //czyta standardowe wejscie
	
	private int patientUniqueNumber_ = 1;
	
	private Map< Integer ,Patient> mapWithPatientsData = new HashMap<>(); // dla dnych osobowych pacjenta
	private Map< Integer ,Patient> mapWithPatientsTestResults = new HashMap<>(); // dla badan pacjenta
	
/******************************** FUNKCJE *********************************************/
	//wprowadzanie danych pacjenta
	void enterPatientID(){
		System.out.print("Podaj imie: "); patientId.name = inputID.nextLine();
		System.out.print("Podaj nazwisko: "); patientId.sureName = inputID.nextLine();
		System.out.print("Podaj PESEL: "); patientId.idNumber = inputID.nextLine();
		System.out.print("Podaj numer ubezpieczania: "); patientId.insuranceNumber = inputID.nextLine();
	}
	//dodawnie pacjenta do listy
	void addPatient() throws IllegalAccessException{
		enterPatientID();
		PatientData patientData = new PatientData(patientUniqueNumber_, patientId.name , patientId.sureName , patientId.idNumber, patientId.insuranceNumber);
		//TestResults testResults = new TestResults(patientUniqueNumber_, 0, 0, 0, 0, 0, 0, 0);
		mapWithPatientsData.put(patientUniqueNumber_, patientData);
		//mapWithPatientsTestResults.put(patientUniqueNumber_, testResults);
		++patientUniqueNumber_;
	}
	//drukowanie na ekran danych konkretnego pacjenta
	void printPatient(int patientUniqueNumber) throws IllegalAccessException{
		PatientData patient = (PatientData) mapWithPatientsData.get(patientUniqueNumber);
		if(patient == null){
			throw new IllegalAccessException("Nie ma takiego pacjenta");
		}
		else {
			System.out.println("Nr Pacjenta: "+"Imie: "+ "Nazwisko: "+ "Numer PESEL: " + "Ubezpieczenie: ");
			patient.printPatientData();
		}
	}
	//pokazanie wsyztskich pacjentow
	void printAllPatients(){
		System.out.println("Nr Pacjenta: " + "Imie: "+ "Nazwisko: "+ "Numer PESEL: " + "Ubezpieczenie: ");
		for (Integer patientID: this.mapWithPatientsData.keySet()){
			PatientData patient = (PatientData) mapWithPatientsData.get(patientID);
			patient.printPatientData();
		} 
	}
	//usuwanie pacjenta
	void removePatient(int patientUniqueNumber){
		mapWithPatientsData.remove(patientUniqueNumber);
	}
}
