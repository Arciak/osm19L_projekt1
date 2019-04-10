package osm19L_projekt1;

/****************************************************************************
 * Klasa przechowuje date. Data moze xostac ustawiona przez uzytkownika		*
 * jezeli uzytkjownik nie ustwwi daty wywolany zostanie kontruktor domyslny *
 * Klasa przyjmuje argumenty:												*
 * #1 unikalny numer pacjenta po ktrym jest identyfikowany w systemie		*
 * #2 dzien																	*
 * #3 miesiac																*
 * #4 rok																	*
 * klasa dziedziczy po klasie abstarkcyjnej, ktora odpowiada za jego 		*
 * unikalny numer.															*
 * Nadpisana zostala funkcja z klasy abstrakcyjnej--> patientNumber			*
 * @author arciak															*
 ****************************************************************************/

public class Date extends Patient{
	private int patientNumber_;
	private int day_;
	private int month_;
	private int year_;
	
/************************************************************************************
 * konstruktor domyslny ma byc tak napsany aby ustawial aktulana date z komputera	*
 * @author arciak																	*
 ************************************************************************************/
	public Date(){
		this.setPatientNumber_(0);
		this.setDay_(0);
		this.setMonth_(0);
		this.setYear_(0);
	}
	
	public Date(int patientNumber_, int day_, int month_, int year_) {
		super();
		this.setPatientNumber_(patientNumber_);
		this.setDay_(day_);
		this.setMonth_(month_);
		this.setYear_(year_);
	}

	public int getDay_() {
		return day_;
	}

	public void setDay_(int day_) {
		this.day_ = day_;
	}

	public int getMonth_() {
		return month_;
	}

	public void setMonth_(int month_) {
		this.month_ = month_;
	}

	public int getYear_() {
		return year_;
	}

	public void setYear_(int year_) {
		this.year_ = year_;
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
