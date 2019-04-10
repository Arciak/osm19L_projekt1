package osm19L_projekt1;

/************************************************************************
 * Klasa tworzy obiekt odpowiedzialny za przechowywanie wynikow badan.	*
 * Przyjmuje argumenty:													*
 * #1 liczba leukocytow													*
 * #2 liczba neutrofili 												*
 * #3 liczba erytrocytow												*
 * Klasa dziedziczy po klasie Data, poniewaz w GUI ustawienie daty		*
 * i liczby krwinek bedzie w tym samym oknie							*
 * @author arciak														*
 ************************************************************************/


public class TestResults extends Date{
	private int leucocytesNumber_;
	private int neutrophilsNumber_;
	private int erythrocytes_;
	private int testState_;
	
	public TestResults(){
		super();
		this.setErythrocytes_(0);
		this.setLeucocytesNumber_(0);
		this.setNeutrophilsNumber_(0);
		this.setTestState_(0);
	}
	
	public TestResults(int patientNumber_, int day_, int month_, int year_, int leucocytesNumber_, int neutrophilsNumber_,
			int erythrocytes_, int testState_) {
		super(patientNumber_, day_, month_, year_);
		this.setLeucocytesNumber_(leucocytesNumber_);
		this.setNeutrophilsNumber_(neutrophilsNumber_);
		this.setErythrocytes_(erythrocytes_);
		this.setTestState_(testState_);
	}

	public int getLeucocytesNumber_() {
		return leucocytesNumber_;
	}

	public void setLeucocytesNumber_(int leucocytesNumber_) {
		this.leucocytesNumber_ = leucocytesNumber_;
	}

	public int getNeutrophilsNumber_() {
		return neutrophilsNumber_;
	}

	public void setNeutrophilsNumber_(int neutrophilsNumber_) {
		this.neutrophilsNumber_ = neutrophilsNumber_;
	}

	public int getErythrocytes_() {
		return erythrocytes_;
	}

	public void setErythrocytes_(int erythrocytes_) {
		this.erythrocytes_ = erythrocytes_;
	}

	public int getTestState_() {
		return testState_;
	}

	public void setTestState_(int testState_) {
		this.testState_ = testState_;
	}
	

}
