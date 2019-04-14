package osm19L_projekt1;

import java.awt.*;
import javax.swing.*;

public class Gui extends JFrame 
{
	public Gui()
	{
		JPanel panelDane=new JPanel();
		panelDane.setBorder(BorderFactory.createTitledBorder("Dane pacjenta")) ;
		panelDane.setPreferredSize(new Dimension(200,150));
		this.setTitle("Rejestracja wynikow bada");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		JButton bDodaj=new JButton("Dodaj");
		bDodaj.setBounds(100, 50, 100, 20);
		add(bDodaj);
		
		
		JLabel lImie, lNazwisko, lPesel, lPlec, lUbezpieczenie;
		lImie=new JLabel("Imiê");
		lImie.setBounds(20,20,150,20);
		add(lImie);
		
		lNazwisko=new JLabel("Nazwisko");
		lNazwisko.setBounds(20,20,150,20);
		add(lNazwisko);
		
		lPesel=new JLabel("Pesel");
		lPesel.setBounds(20,20,150,20);
		add(lPesel);
		
		lPlec=new JLabel("P³eæ");
		lPlec.setBounds(20,20,150,20);
		add(lPlec);
		
		lUbezpieczenie=new JLabel("Ubezpieczenie");
		lUbezpieczenie.setBounds(20,20,150,20);
		add(lUbezpieczenie);
		
		
		
		JTextField imie=new JTextField(30);
		JTextField nazwisko=new JTextField(30);
		JTextField pesel=new JTextField(30); 
		JRadioButton radioK=new JRadioButton("Kobieta");    
		JRadioButton radioM=new JRadioButton("Mê¿czyzna");    
		radioK.setBounds(75,50,100,30);    
		radioM.setBounds(75,100,100,30);    
		ButtonGroup bg=new ButtonGroup();    
		bg.add(radioK);bg.add(radioM);    
		f.add(radioK);f.add(radioM);  
		
		JComboBox<String> comboUbezpieczenie = new JComboBox<String>();
		comboUbezpieczenie.addItem("NFZ");
		comboUbezpieczenie.addItem("Prywatnie");
		comboUbezpieczenie.addItem("Brak");
		
		
		JLabel lData, lLeukocyty, lNeutrofile, lErytrocyty;
		lData=new JLabel("Data");
		lData.setBounds(20,20,150,20);
		add(lData);
		
		lLeukocyty=new JLabel("Leukocyty");
		lLeukocyty.setBounds(20,20,150,20);
		add(lLeukocyty);
		
		lNeutrofile=new JLabel("Neutrofile");
		lNeutrofile.setBounds(20,20,150,20);
		add(lNeutrofile);
		
		lErytrocyty=new JLabel("Erytrocyty");
		lErytrocyty.setBounds(20,20,150,20);
		add(lErytrocyty);
		
		JTextField leukocyty=new JTextField(30);
		JTextField neutrofile=new JTextField(30);
		JTextField erytrocyty=new JTextField(30); 
	}
	public static void main(String[] args)
	{
		Gui app=new Gui();
		app.setVisible(true);
	}
}
