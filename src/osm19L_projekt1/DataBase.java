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

import helpers.Exceptions;

public class DataBase {
	
	//PatientID patientId = new PatientID();
	private static Scanner inputID = new Scanner(System.in); //czyta standardowe wejscie
	
	private Map< String ,PatientData> mapWithPatientsData = new HashMap<>(); // dla dnych osobowych pacjenta
	private Map< String ,TestResults> mapWithPatientsTestResults = new HashMap<>(); // dla badan pacjenta
	
/******************************** FUNKCJE *********************************************/
	//dodawnie pacjenta do listy
	void addPatient(String numberId, PatientData patientData, int EditData) throws Exceptions{
		if(numberId == null || numberId.length() == 0){
			throw new Exceptions("Wprowadz PESEL");
		}
		if(EditData == 0){
		for (String patientID: mapWithPatientsData.keySet()){
			if(numberId.equals(patientID))
				throw new Exceptions("Pacjent o podanym numerze PESEL juz jest w bazie");
			else 
				System.out.println("Jest ok");
		} 
		}
		mapWithPatientsData.put(numberId, patientData);
	}
	//drukowanie na ekran danych konkretnego pacjenta
	void printPatient(int patientUniqueNumber) throws IllegalAccessException{
		PatientData patient = (PatientData) mapWithPatientsData.get(patientUniqueNumber);
		if(patient == null){
			throw new IllegalAccessException("Nie ma takiego pacjenta");
		}
		else {
			System.out.println("Nr Pacjenta: "+"Imie: "+ "Nazwisko: "+ "Ubezpieczenie: ");
			patient.printPatientData();
		}
	}
	
	//pokazanie wszytskich pacjentow
	void printAllPatients(){
		System.out.println("Imie: "+ "Nazwisko: "+"Plec: "+ "Numer PESEL: " + "Ubezpieczenie: ");
		for (String patientID: this.mapWithPatientsData.keySet()){
			PatientData patient = (PatientData) mapWithPatientsData.get(patientID);
			patient.printPatientData();
		} 
	}
	
	Object[] returnDataTable(String numberId){
		Object[] wartosci = new Object[5];
		wartosci[0] =  mapWithPatientsData.get(numberId).getName_() + " " + mapWithPatientsData.get(numberId).getSurename_();
		wartosci[1] =  mapWithPatientsData.get(numberId).getSex_();
		wartosci[2] =  numberId;
		wartosci[3] = mapWithPatientsData.get(numberId).getInsurance_();
		return wartosci;
		
	}
	
	//usuwanie pacjenta
	void removePatient(String patientUniqueNumber) throws Exceptions{
		if(patientUniqueNumber== null || patientUniqueNumber.length() == 0){
			throw new Exceptions("Wybierz pacjenta");
		}
		mapWithPatientsData.remove(patientUniqueNumber);
	}
	
	void addTestResults(String uniqNumber, TestResults patientTestResults){
		mapWithPatientsTestResults.put(uniqNumber, patientTestResults);
	}
	
	Integer[] bloodCellsAnddataValue(String patientId) throws Exception{
		Integer[] data = new Integer[6];
		
		if(mapWithPatientsTestResults.get(patientId)==null){
			throw new IllegalArgumentException("Nie ma jeszcze danych");
		}
		
		TestResults downData = (TestResults) mapWithPatientsTestResults.get(patientId);
		data[0] = downData.getDay_();
		data[1] = downData.getMonth_();
		data[2] = downData.getYear_();
		data[3] = downData.getLeucocytesNumber_();
		data[4] = downData.getNeutrophilsNumber_();
		data[5] = downData.getErythrocytes_();	
		return data;
	}
	
}
