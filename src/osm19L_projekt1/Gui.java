package osm19L_projekt1;

import java.awt.*;
import javax.swing.*;

public class Gui extends JFrame 
{
	public Gui()
	{

		this.setTitle("Rejestracja wynikow bada");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		
		
		JPanel panelDane=new JPanel();
		panelDane.setBorder(BorderFactory.createTitledBorder("Dane pacjenta")) ;
		panelDane.setPreferredSize(new Dimension(200,150));
		
		GridLayout layoutDane= new GridLayout(6,2);
		panelDane.setLayout(layoutDane);
		
		JLabel lImie, lNazwisko, lPesel, lPlec, lUbezpieczenie;
		lImie=new JLabel("Imiê");
		//lImie.setBounds(20,20,150,20);
		panelDane.add(lImie);
		JTextField tfImie=new JTextField(30);
		panelDane.add(tfImie);
		
		lNazwisko=new JLabel("Nazwisko");
		//lNazwisko.setBounds(20,20,150,20);
		panelDane.add(lNazwisko);
		JTextField tfNazwisko=new JTextField(30);
		panelDane.add(tfNazwisko);
		
		lPesel=new JLabel("Pesel");
		//lPesel.setBounds(20,20,150,20);
		panelDane.add(lPesel);
		JTextField tfPesel=new JTextField(30); 
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
		
		JButton bZapiszDane=new JButton("Zapisz");
		panelDane.add(bZapiszDane);
		JButton bAnulujDane=new JButton("Anuluj");
		panelDane.add(bAnulujDane);
		
		
		
		JPanel panelBadanie=new JPanel();
		panelBadanie.setBorder(BorderFactory.createTitledBorder("Badanie")) ;
		panelBadanie.setPreferredSize(new Dimension(200,150));
		
		JLabel lData, lLeukocyty, lNeutrofile, lErytrocyty;
		lData=new JLabel("Data");
		lData.setBounds(20,20,150,20);
		panelBadanie.add(lData);
		
		lLeukocyty=new JLabel("Leukocyty");
		lLeukocyty.setBounds(20,20,150,20);
		panelBadanie.add(lLeukocyty);
		
		lNeutrofile=new JLabel("Neutrofile");
		lNeutrofile.setBounds(20,20,150,20);
		panelBadanie.add(lNeutrofile);
		
		lErytrocyty=new JLabel("Erytrocyty");
		lErytrocyty.setBounds(20,20,150,20);
		panelBadanie.add(lErytrocyty);
		
		JTextField tfLeukocyty=new JTextField(30);
		panelBadanie.add(tfLeukocyty);
		JTextField tfNeutrofile=new JTextField(30);
		panelBadanie.add(tfNeutrofile);
		JTextField tfErytrocyty=new JTextField(30); 
		panelBadanie.add(tfErytrocyty);
		
		JButton bZapiszBadanie=new JButton("Zapisz");
		panelBadanie.add(bZapiszBadanie);
		JButton bAnulujBadanie=new JButton("Anuluj");
		panelBadanie.add(bAnulujBadanie);
		
		
		JPanel panelLista=new JPanel();
		panelLista.setBorder(BorderFactory.createTitledBorder("Lista pacjentów")) ;
		panelLista.setPreferredSize(new Dimension(200,300));
		
		
		String[] columnNames = { "Imie i nazwisko", "P³eæ", "Pesel", "Ubezpieczenie", "Badanie" };
		JTable tableLista= new JTable(columnNames);
		tableLista.setBounds(30,40,200,300);
		panelLista.add(tableLista);
		
		JButton bDodaj=new JButton("Dodaj");
		panelLista.add(bDodaj);
		JButton bUsun=new JButton("Usuñ");
		panelLista.add(bUsuñ);
		
	}
	public static void main(String[] args)
	{
		Gui app=new Gui();
		app.setVisible(true);
	}
}
