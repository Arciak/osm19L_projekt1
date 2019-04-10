package osm19L_projekt1;

/************************************************************
 * Klasa glowna pogramu.									*
 * @author arciak											*
 ***********************************************************/

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println( "Welcome Our OSM project!" );
		DataBase dataBase = new DataBase();
		dataBase.addPatient();
		dataBase.addPatient();
		dataBase.addPatient();
		dataBase.printPatient(1);
		dataBase.printPatient(2);
	}

}
