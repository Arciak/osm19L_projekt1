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

public class DataBase {
	
	//PatientID patientId = new PatientID();
	private static Scanner inputID = new Scanner(System.in); //czyta standardowe wejscie
	
	private int patientUniqueNumber_ = 1;
	
	private Map< Integer ,PatientData> mapWithPatientsData = new HashMap<>(); // dla dnych osobowych pacjenta
	private Map< Integer ,Patient> mapWithPatientsTestResults = new HashMap<>(); // dla badan pacjenta
	
/******************************** FUNKCJE *********************************************/
	//dodawnie pacjenta do listy
	void addPatient(PatientData patientData){
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
	//pokazanie wszytskich pacjentow
	void printAllPatients(){
		System.out.println("Imie: "+ "Nazwisko: "+"Plec: "+ "Numer PESEL: " + "Ubezpieczenie: ");
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
