package osm19L_projekt1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import helpers.Exceptions;

public class Gui extends JFrame 
{
	DataBase dataBase = new DataBase();
	public Gui()
	{
		GridBagLayout layoutGui= new GridBagLayout();
		setLayout(layoutGui);
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.fill=GridBagConstraints.HORIZONTAL;
		
		this.setTitle("Rejestracja wynikow bada");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 500);
		
		//PANEL DANYCH PACJENTA
		JPanel panelDane=new JPanel();
		panelDane.setBorder(BorderFactory.createTitledBorder("Dane pacjenta")) ;
		//panelDane.setPreferredSize(new Dimension(200,500));
		
		
		
		JLabel lImie, lNazwisko, lPesel, lPlec, lUbezpieczenie;
		lImie=new JLabel("Imie");
		//lImie.setBounds(20,20,150,20);
		panelDane.add(lImie);
		JTextField tfImie=new JTextField(15);
		panelDane.add(tfImie);
		
		lNazwisko=new JLabel("Nazwisko");
		//lNazwisko.setBounds(20,20,150,20);
		panelDane.add(lNazwisko);
		JTextField tfNazwisko=new JTextField(15);
		panelDane.add(tfNazwisko);
		
		lPesel=new JLabel("Pesel");
		//lPesel.setBounds(20,20,150,20);
		panelDane.add(lPesel);
		JTextField tfPesel=new JTextField(15); 
		panelDane.add(tfPesel);
		
		lPlec=new JLabel("Plec");
		//lPlec.setBounds(20,20,150,20);
		panelDane.add(lPlec);
		JRadioButton radioK=new JRadioButton("Kobieta");    
		JRadioButton radioM=new JRadioButton("Meczyzna");    
		radioK.setBounds(75,50,100,30);    
		radioM.setBounds(100,50,100,30);    
		ButtonGroup bg=new ButtonGroup();    
		bg.add(radioK);bg.add(radioM);    
		panelDane.add(radioK);panelDane.add(radioM);  
		
		lUbezpieczenie=new JLabel("Ubezpieczenie");
		//lUbezpieczenie.setBounds(20,20,150,20);
		panelDane.add(lUbezpieczenie);		
		JComboBox<String> comboUbezpieczenie = new JComboBox<String>();
		comboUbezpieczenie.addItem("NFZ");
		comboUbezpieczenie.addItem("Prywatnie");
		comboUbezpieczenie.addItem("Brak");
		panelDane.add(comboUbezpieczenie);
		
/*********************** dodawanie danych pacjenta	*************************************/	
		JButton bZapiszDane=new JButton("Zapisz");
		panelDane.add(bZapiszDane);
		bZapiszDane.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					PatientData newPatientData = new PatientData(tfImie.getText(), tfNazwisko.getText(),tfPesel.getText(), comboUbezpieczenie.getSelectedItem().toString());
					dataBase.addPatient(newPatientData);
					dataBase.printAllPatients();
					} catch (Exceptions zleNazwisko) {
					}
			}
	    } );
		
		JButton bAnulujDane=new JButton("Anuluj");
		panelDane.add(bAnulujDane);
		
		GridBagLayout layoutDane= new GridBagLayout();
		panelDane.setLayout(layoutDane);
		GridBagConstraints gbcDane=new GridBagConstraints();
		gbcDane.fill=GridBagConstraints.HORIZONTAL;
		
		//PANEL BADANIA
		JPanel panelBadanie=new JPanel();
		panelBadanie.setBorder(BorderFactory.createTitledBorder("Badanie")) ;
		//panelBadanie.setPreferredSize(new Dimension(200,500));
		
		GridLayout layoutBadanie= new GridLayout(4,2);
		panelDane.setLayout(layoutBadanie);
		
		JLabel lData, lLeukocyty, lNeutrofile, lErytrocyty;
		lData=new JLabel("Data");
		//lData.setBounds(20,20,150,20);
		panelBadanie.add(lData);
		
		JTextField tfLeukocyty=new JTextField(30);
		panelBadanie.add(tfLeukocyty);
		lLeukocyty=new JLabel("Leukocyty");
		//lLeukocyty.setBounds(20,20,150,20);
		panelBadanie.add(lLeukocyty);
		
		
		JTextField tfNeutrofile=new JTextField(30);
		panelBadanie.add(tfNeutrofile);
		lNeutrofile=new JLabel("Neutrofile");
		//lNeutrofile.setBounds(20,20,150,20);
		panelBadanie.add(lNeutrofile);
		
		JTextField tfErytrocyty=new JTextField(30); 
		panelBadanie.add(tfErytrocyty);
		lErytrocyty=new JLabel("Erytrocyty");
		//lErytrocyty.setBounds(20,20,150,20);
		panelBadanie.add(lErytrocyty);
		
		
		JButton bZapiszBadanie=new JButton("Zapisz");
		panelBadanie.add(bZapiszBadanie);
		JButton bAnulujBadanie=new JButton("Anuluj");
		panelBadanie.add(bAnulujBadanie);
		
		
		//PANEL LISTY PACJENTOW
		JPanel panelLista=new JPanel();
		panelLista.setBorder(BorderFactory.createTitledBorder("Lista pacjent�w")) ;
		panelLista.setPreferredSize(new Dimension(200,300));
		
		
		String[] columnNames = { "Imie i nazwisko", "Plec", "Pesel", "Ubezpieczenie", "Badanie" };
		JTable tableLista= new JTable();
		//stworzyc obiekt dane
		tableLista.setBounds(30,40,200,300);
		panelLista.add(tableLista);
		
		JButton bDodaj=new JButton("Dodaj");
		panelLista.add(bDodaj);
		JButton bUsun=new JButton("Usun");
		panelLista.add(bUsun);
		
		//DODANIE PANELI
		gbc.gridx=0;
		gbc.gridy=0;		
		add(panelDane,gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		add(panelBadanie,gbc);
		gbc.gridx=1;
		gbc.gridy=0;
		add(panelLista,gbc);
		
	}
	public static void main(String[] args)
	{	
		System.out.print( "Welcome Our OSM project! \n " );
		Gui app=new Gui();
		app.setVisible(true);
	}
}
