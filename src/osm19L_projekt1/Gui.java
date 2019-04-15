package osm19L_projekt1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import helpers.Exceptions;
import helpers.GlobalVariables;
import helpers.Window;

public class Gui extends JFrame 
{
	private String setIdNumber_(String idNumber_) throws Exceptions {	
		if (idNumber_.matches("[0-9]+") == true) {
			return idNumber_;
		}
		else if(idNumber_.length()!=GlobalVariables.lengthOfIdNumber){
			throw new Exceptions("Zla dlugosc PESEL");
		}
		else 
			throw new Exceptions("Pesel zawiera litery");	
	}
	private static final Insets insets = new Insets(0, 0, 0, 0);
	private static void addComponentFrame(Container container, Component component, int gridx, int gridy,
		      int gridwidth, int gridheight, int anchor, int fill) {
		    GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
		        anchor, fill, insets, 0, 0);
		    container.add(component, gbc);
		  }

	DataBase dataBase = new DataBase();
	int SelectedRawIndex = 0;
	
	public Gui()
	{	
		JFrame gbc = new JFrame("Rejestracja wynikow bada");
	    gbc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    gbc.setLayout(new GridBagLayout());
		
		//PANEL DANYCH PACJENTA
		JPanel panelDane=new JPanel();
		panelDane.setLayout(new BorderLayout());
		panelDane.setBorder(BorderFactory.createTitledBorder("Dane pacjenta")) ;
		
		JPanel imieNazPesel = new JPanel();
		imieNazPesel.setLayout(new BorderLayout());
//		panelDane.setPreferredSize(new Dimension(200,500));
		
		
		
		JLabel lImie, lNazwisko, lPesel, lPlec, lUbezpieczenie;
		JPanel imeP = new JPanel();
		lImie=new JLabel("Imie");
		//lImie.setBounds(20,20,150,20);
		//panelDane.add(lImie);
		JTextField tfImie=new JTextField(15);
		//panelDane.add(tfImie);
		imeP.add(lImie, BorderLayout.WEST);
		imeP.add(tfImie, BorderLayout.EAST);
		
		JPanel nazP = new JPanel();
		lNazwisko=new JLabel("Nazwisko");
		//lNazwisko.setBounds(20,20,150,20);
		//panelDane.add(lNazwisko);
		JTextField tfNazwisko=new JTextField(15);
		//panelDane.add(tfNazwisko);
		nazP.add(lNazwisko, BorderLayout.WEST);
		nazP.add(tfNazwisko, BorderLayout.EAST);
		
		JPanel peselP = new JPanel();
		lPesel=new JLabel("Pesel");
		//lPesel.setBounds(20,20,150,20);
		//panelDane.add(lPesel);
		JTextField tfPesel=new JTextField(15); 
		//panelDane.add(tfPesel);
		peselP.add(lPesel,BorderLayout.WEST);
		peselP.add(tfPesel,BorderLayout.EAST);
		
		imieNazPesel .add(imeP, BorderLayout.NORTH);	
		imieNazPesel .add(nazP, BorderLayout.CENTER);
		imieNazPesel .add(peselP, BorderLayout.SOUTH);
		panelDane.add(imieNazPesel,BorderLayout.NORTH);
		
		JPanel plecUbezBut = new JPanel();
		plecUbezBut.setLayout(new BorderLayout());
		JPanel plecP= new JPanel();
		lPlec=new JLabel("Plec");
		//lPlec.setBounds(20,20,150,20);
		//panelDane.add(lPlec);
		JRadioButton radioK=new JRadioButton("Kobieta");    
		radioK.setActionCommand("K");
		JRadioButton radioM=new JRadioButton("Meczyzna");  
		radioM.setActionCommand("M");
		radioK.setBounds(75,50,100,30);    
		radioM.setBounds(100,50,100,30);    
		ButtonGroup bg=new ButtonGroup();    
		bg.add(radioK);bg.add(radioM);    
		//panelDane.add(radioK);panelDane.add(radioM); 
		plecP.add(lPlec,BorderLayout.WEST);
		plecP.add(radioK, BorderLayout.CENTER);
		plecP.add(radioM, BorderLayout.EAST);
		
		JPanel ubezP = new JPanel();
		lUbezpieczenie=new JLabel("Ubezpieczenie");
		//lUbezpieczenie.setBounds(20,20,150,20);
		//panelDane.add(lUbezpieczenie);		
		JComboBox<String> comboUbezpieczenie = new JComboBox<String>();
		comboUbezpieczenie.addItem("NFZ");
		comboUbezpieczenie.addItem("Prywatnie");
		comboUbezpieczenie.addItem("Brak");
		//panelDane.add(comboUbezpieczenie);
		ubezP.add(lUbezpieczenie, BorderLayout.WEST);
		ubezP.add(comboUbezpieczenie, BorderLayout.EAST);
		
		JPanel zapAnulP = new JPanel();
		JButton bZapiszDane=new JButton("Zapisz");
		//panelDane.add(bZapiszDane);
		
		JButton bAnulujDane=new JButton("Anuluj");
		//panelDane.add(bAnulujDane);
		zapAnulP.add(bZapiszDane, BorderLayout.EAST);
		zapAnulP.add(bAnulujDane, BorderLayout.WEST);
		
		plecUbezBut.add(plecP,BorderLayout.NORTH);
		plecUbezBut.add(ubezP, BorderLayout.CENTER);
		plecUbezBut.add(zapAnulP, BorderLayout.SOUTH);
		
		panelDane.add(imieNazPesel,BorderLayout.NORTH);
		panelDane.add(plecUbezBut,BorderLayout.SOUTH);
		
//		GridBagLayout layoutDane= new GridBagLayout();
//		panelDane.setLayout(layoutDane);
//		GridBagConstraints gbcDane=new GridBagConstraints();
//		gbcDane.fill=GridBagConstraints.HORIZONTAL;
//		GridLayout layoutBadanie= new GridLayout(4,2);
//		panelDane.setPreferredSize(new Dimension(200,500));
//		panelDane.setLayout(layoutBadanie);
//		
		//PANEL BADANIA
		JPanel panelBadanie=new JPanel();
		panelBadanie.setBorder(BorderFactory.createTitledBorder("Badanie")) ;
		//panelBadanie.setPreferredSize(new Dimension(200,500));
		
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
		
		bAnulujDane.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				tfImie.setText("");
				tfNazwisko.setText("");
				tfPesel.setText("");
				radioK.setSelected(false);
				radioM.setSelected(false);			
			}
			
		});
		
		
		//PANEL LISTY PACJENTOW
				JPanel panelLista=new JPanel();
				panelLista.setLayout(new BorderLayout());
				panelLista.setBorder(BorderFactory.createTitledBorder("Lista pacjentow")) ;
				//panelLista.setBounds(300, 0, 450, 500);
				
				Object[] columnNames = { "Imie i nazwisko", "Plec", "Pesel", "Ubezpieczenie", "Badanie" };
				JTable tableLista= new JTable();
					
				
//				if(TestResults.getTestState_()==0 ){
//		        	   check.setSelected(false);
//		        	} else {
//		        	   check.setSelected(true);
//		        	}
//		        tableLista.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(check)); 
				
				DefaultTableModel model = new DefaultTableModel();
		        model.setColumnIdentifiers(columnNames);
		        tableLista.setModel(model);
		        JPanel jpTemp2 = new JPanel(); 
		        jpTemp2.setLayout(new BorderLayout());
		        jpTemp2.add(tableLista, BorderLayout.CENTER); 
		        jpTemp2.add(tableLista.getTableHeader(), BorderLayout.NORTH); 
		        JCheckBox check= new JCheckBox();
		        tableLista.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(check)); 
		        
		        ListSelectionModel selectionModel = tableLista.getSelectionModel();
		        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

/**************************** tutaj mysz wybiera wiersz ************************************/      
		        tableLista.addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseClicked(java.awt.event.MouseEvent evt) {
		            	DefaultTableModel model = (DefaultTableModel)tableLista.getModel();
		            	SelectedRawIndex = tableLista.getSelectedRow();
		            	String[] imieNaz = model.getValueAt(SelectedRawIndex,0).toString().split(" ");
		            	tfImie.setText(imieNaz[0]);
		            	tfNazwisko.setText(imieNaz[1]);
		            	tfPesel.setText(model.getValueAt(SelectedRawIndex, 2).toString());
		            	String sex = model.getValueAt(SelectedRawIndex, 1).toString();
		            	if(sex == "M")
		            		radioM.setSelected(true);
		            	else 
		            		radioK.setSelected(true);
		            	
		            }
		        });
		        
/**************************** zapis danych pacjenta ******************************************/		        
		        bZapiszDane.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try{
							Object[] row = new Object[5];
							PatientData newPatientData = new PatientData(tfImie.getText(), tfNazwisko.getText(),bg.getSelection().getActionCommand().toString(), comboUbezpieczenie.getSelectedItem().toString());
							dataBase.addPatient(setIdNumber_(tfPesel.getText()), newPatientData);
							row = dataBase.returnDataTable(tfPesel.getText()); 
							JCheckBox check= new JCheckBox();
					        row[4] = check;
							model.addRow(row);
							//dataBase.printAllPatients();
							} catch (Exceptions zleNazwisko) {
							} catch (Exception e1){
								new Window("Wybierz plec");
							}
					}
			    } );
		        
		        JScrollPane tableLista2 = new JScrollPane(jpTemp2);
		        panelLista.add(tableLista2);
		        
		        JPanel bDaU = new JPanel();
		        JButton bDodaj=new JButton("Dodaj");
		        bDaU.add(bDodaj, BorderLayout.WEST);
				JButton bUsun=new JButton("Usuń");
				bDaU.add(bUsun,BorderLayout.EAST);
		        panelLista.add(bDaU, BorderLayout.SOUTH);
		        
		        bUsun.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							dataBase.removePatient(tfPesel.getText());
							((DefaultTableModel)tableLista.getModel()).removeRow(SelectedRawIndex);
						} catch (Exceptions e1) {
						}
						
					}
		        	
		        });
		        
		
		//DODANIE PANELI
		addComponentFrame(gbc, panelDane,  0, 0, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH);
		addComponentFrame(gbc, panelBadanie, 0, 1, 1, 1, GridBagConstraints.SOUTH, GridBagConstraints.BOTH);
		addComponentFrame(gbc, panelLista, 2,0, 2, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		gbc.setSize(700, 500);
		gbc.setVisible(true);
		
	}
	public static void main(String[] args)
	{	
		System.out.print( "Welcome Our OSM project! \n " );
		new Gui();
		//app.setVisible(true);
	}
}
