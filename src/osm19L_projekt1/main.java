package osm19L_projekt1;

import java.util.Scanner;

/************************************************************
 * Klasa glowna pogramu.									*
 * @author arciak											*
 ***********************************************************/

public class main {
	

	private static Scanner input;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean endLoop = false; // aby zakonczyc petle
		input = new Scanner(System.in);// czytanie wejscia
		int chooseMenu = 0; // zmienna dla menu
		int patientNumber = 0; // numer pacjenta
		
		DataBase dataBase = new DataBase();
		
		System.out.print( "Welcome Our OSM project!" );
////////////zapletamy menu :) 
		while(!endLoop){
			System.out.println("\n 1--> dodaj pacjenta \n 2--> wyswietl \n 3--> wyswietl wszytskich pacjentow \n 4--> usun pacjenta \n 9--> zakoncz");
			chooseMenu = input.nextInt();
			
			switch(chooseMenu){
				case 1:
					try{
					dataBase.addPatient();
					} catch (IllegalAccessException e) {
						System.out.println(e);
					}
					break;
				case 2:
					System.out.println("Podaj numer pacjenta: "); 
					patientNumber = input.nextInt();
					try{
						dataBase.printPatient(patientNumber);
					} catch(IllegalAccessException e){
						System.out.println(e);
					}
					break;
				case 3:
					dataBase.printAllPatients();
					break;
				case 4:
					System.out.println("Podaj numer pacjenta: "); 
					patientNumber = input.nextInt();
					dataBase.removePatient(patientNumber);
					break;
				case 9:
					endLoop = true;
					break;
				default: 
					System.out.println("default");		
			}
			chooseMenu = 0;
			patientNumber = 0;
		}
		
		System.out.println("Koniec programu :)"); 
	}

}
