package osm19L_projekt1;

/****************************************************************************
 * Patient jest to klasa abstrakcyjna przyjmujaca uniklany numer pacjenta	*
 * Na jej podstawie tworzone są kontenery Map oraz przechowywane info		
 * indetyfikacja po numerze PESEL*
 * @author arciak
 ****************************************************************************/

public abstract class Patient {
	abstract String patientID(String setNumber_);
}
