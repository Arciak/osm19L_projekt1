package osm19L_projekt1;

import java.awt.*;
import javax.swing.*;

public class Gui extends JFrame 
{
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
		lImie=new JLabel("Imiê");
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
		
		lPlec=new JLabel("P³eæ");
		//lPlec.setBounds(20,20,150,20);
		panelDane.add(lPlec);
		JRadioButton radioK=new JRadioButton("Kobieta");    
		JRadioButton radioM=new JRadioButton("Mê¿czyzna");    
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
		
		JButton bZapiszDane=new JButton("Zapisz");
		panelDane.add(bZapiszDane);
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
		panelLista.setBorder(BorderFactory.createTitledBorder("Lista pacjentów")) ;
		panelLista.setPreferredSize(new Dimension(200,300));
		
		
		String[] columnNames = { "Imie i nazwisko", "P³eæ", "Pesel", "Ubezpieczenie", "Badanie" };
		JTable tableLista= new JTable();
		//stworzyc obiekt dane
		tableLista.setBounds(30,40,200,300);
		panelLista.add(tableLista);
		
		JButton bDodaj=new JButton("Dodaj");
		panelLista.add(bDodaj);
		JButton bUsun=new JButton("Usuñ");
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
		Gui app=new Gui();
		app.setVisible(true);
	}
}
