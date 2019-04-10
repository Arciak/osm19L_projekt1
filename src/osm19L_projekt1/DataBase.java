package osm19L_projekt1;

/****************************************************************************************
 * Klasa DataBase odpowiada za tworzenie kontenerow. Stworzone sa dwa kontenery.		*
 * Jeden kontener "mapWithPatientsData" odpowida za przechowywanie danych personalnych	*
 * Drugi kontener "mapWithPatientsTestResults" przechowuje rezultaty badan 				*
 * 																						*
 * W kalsie zaimplementowana jest takze zmienna "patientUniqueNumber_", 				*
 * ktora nadaje unikalny numer kazdemu pacjentowi. 										*
 * 																						*
 * Klasa ta posiada takze funckje wykonujaca operacje dodawania, usuwania oraz 			*
 * modyfikacji danych pacjenta															*
 * @author arciak																		*
 ****************************************************************************************/

import java.util.HashMap;
import java.util.Map;

public class DataBase {
	private int patientUniqueNumber_ = 1;
	private Map< Integer ,Patient> mapWithPatientsData = new HashMap<>();
	private Map< Integer ,Patient> mapWithPatientsTestResults = new HashMap<>();
	String id = "12345678910";
	
	// funcje dodawac do listy i funkcje usuwanie z listy
	void addPatient(){
		PatientData patientData = new PatientData(patientUniqueNumber_, "Stefan", null, id, patientUniqueNumber_-1);
		TestResults testResults = new TestResults(patientUniqueNumber_, 0, 0, 0, 0, 0, 0, 0);
		mapWithPatientsData.put(patientUniqueNumber_, patientData);
		mapWithPatientsTestResults.put(patientUniqueNumber_, testResults);
		patientUniqueNumber_ = patientUniqueNumber_ + 1;
	}
	
	void printPatient(int patientUniqueNumber){
		PatientData patient22 = (PatientData) mapWithPatientsData.get(patientUniqueNumber);
		TestResults test22 = (TestResults) mapWithPatientsTestResults.get(patientUniqueNumber);
		System.out.println(Integer.toString(patient22.getInsurance_()));
		System.out.println(Integer.toString(test22.getDay_()));
	}
	
}
