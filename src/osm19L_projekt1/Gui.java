package osm19L_projekt1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import java.util.*;

import com.toedter.calendar.JCalendar;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdesktop.swingx.JXDatePicker;
import org.jdatepicker.*;


import helpers.Exceptions;
import helpers.GlobalVariables;
import helpers.Window;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Gui extends JFrame 
{
	private JDatePickerImpl datePicker;
	
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


	DataBase dataBase = new DataBase();
	int SelectedRawIndex = 0;
	int EditData = 0;
	
	public Gui()
	{	
		JFrame gbc = new JFrame("Rejestracja wynikow badan");
	    gbc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    gbc.setLayout(new BorderLayout());
		
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
		tfImie.setEditable(false);
		//panelDane.add(tfImie);
		imeP.add(lImie, BorderLayout.WEST);
		imeP.add(tfImie, BorderLayout.EAST);
		
		JPanel nazP = new JPanel();
		lNazwisko=new JLabel("Nazwisko");
		//lNazwisko.setBounds(20,20,150,20);
		//panelDane.add(lNazwisko);
		JTextField tfNazwisko=new JTextField(15);
		tfNazwisko.setEditable(false);
		//panelDane.add(tfNazwisko);
		nazP.add(lNazwisko, BorderLayout.WEST);
		nazP.add(tfNazwisko, BorderLayout.EAST);
		
		JPanel peselP = new JPanel();
		lPesel=new JLabel("Pesel");
		//lPesel.setBounds(20,20,150,20);
		//panelDane.add(lPesel);
		JTextField tfPesel=new JTextField(15); 
		tfPesel.setEditable(false);
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
		
		panelDane.add(imieNazPesel,BorderLayout.CENTER);
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
		panelBadanie.setLayout(new BorderLayout());
		//panelBadanie.setPreferredSize(new Dimension(200,500));
		JPanel leukNeutEryt= new JPanel();
		JLabel lData, lLeukocyty, lNeutrofile, lErytrocyty;
		
		
		
/********************************* KALENDARZ ********************************************/
		lData=new JLabel("Data");
		
		JXDatePicker picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        
		
		
		
		
		JPanel dataP = new JPanel();
		dataP.setLayout(new BorderLayout());
		dataP.add(lData, BorderLayout.WEST);
		dataP.add(picker, BorderLayout.CENTER);
		//dataP.add(calendar, BorderLayout.EAST);
		//dataP.add(datePicker,BorderLayout.WEST);
		
		JTextField tfLeukocyty=new JTextField(15);
		tfLeukocyty.setEditable(false);
		lLeukocyty=new JLabel("Leukocyty");
		JPanel leukP = new JPanel();
		leukP.setLayout(new BorderLayout());
		
		leukP.add(lLeukocyty, BorderLayout.WEST);
		leukP.add(tfLeukocyty, BorderLayout.EAST);
		
		
		JTextField tfNeutrofile=new JTextField(15);
		lNeutrofile=new JLabel("Neutrofile");
		tfNeutrofile.setEditable(false);
		JPanel neutP = new JPanel();
		neutP.setLayout(new BorderLayout());
		neutP.add(lNeutrofile, BorderLayout.WEST);
		neutP.add(tfNeutrofile, BorderLayout.EAST);

		
		JTextField tfErytrocyty=new JTextField(15); 
		lErytrocyty=new JLabel("Erytrocyty");
		tfErytrocyty.setEditable(false);
		
		JPanel erytP = new JPanel();
		erytP.setLayout(new BorderLayout());
		erytP.add(lErytrocyty, BorderLayout.WEST);
		erytP.add(tfErytrocyty, BorderLayout.EAST);
		
		leukNeutEryt.add(leukP, BorderLayout.NORTH);
		leukNeutEryt.add(neutP, BorderLayout.CENTER);
		leukNeutEryt.add(erytP, BorderLayout.SOUTH);
		
		JButton bZapiszBadanie=new JButton("Zapisz");
		JButton bAnulujBadanie=new JButton("Anuluj");
		
		JPanel zapAnulBadP = new JPanel();
		zapAnulBadP.setLayout(new BorderLayout());
		zapAnulBadP.add(bZapiszBadanie, BorderLayout.EAST);
		zapAnulBadP.add(bAnulujBadanie, BorderLayout.WEST);
		
		panelBadanie.add(dataP,BorderLayout.NORTH);
		panelBadanie.add(leukNeutEryt,BorderLayout.CENTER);
		panelBadanie.add(zapAnulBadP,BorderLayout.SOUTH);
		
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
		bAnulujBadanie.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				tfLeukocyty.setText("");
				tfNeutrofile.setText("");
				tfErytrocyty.setText("");	
				tfImie.setEditable(false);
				tfNazwisko.setEditable(false);
				tfPesel.setEditable(false);
			}
			
		});
		
		
		//PANEL LISTY PACJENTOW
				JPanel panelLista=new JPanel();
				panelLista.setLayout(new BorderLayout());
				panelLista.setBorder(BorderFactory.createTitledBorder("Lista pacjentow")) ;
				//panelLista.setBounds(300, 0, 450, 500);
				
				Object[] columnNames = { "Imie i nazwisko", "Plec", "Pesel", "Ubezpieczenie", "Badanie" };
				JTable tableLista= new JTable(){
					private static final long serialVersionUID = 1L;
					public boolean isCellEditable(int row, int column){
						return false;
					};
				};
					
				
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
		            	tfLeukocyty.setText("");
						tfNeutrofile.setText("");
						tfErytrocyty.setText("");	
		            	if(sex == "M")
		            		radioM.setSelected(true);
		            	else 
		            		radioK.setSelected(true);
		            	try{
		            	Integer[] testData = dataBase.bloodCellsAnddataValue(model.getValueAt(SelectedRawIndex, 2).toString());
		            	tfLeukocyty.setText(testData[3].toString());
		            	tfNeutrofile.setText(testData[4].toString());
		            	tfErytrocyty.setText(testData[5].toString());
		            	}  catch (Exception e) {
		            		System.out.println(e);
						}
		            	
		            	EditData = 1;
		            }
		        });
		        
/**************************** zapis danych pacjenta ******************************************/		        
		        bZapiszDane.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try{
							Object[] row = new Object[5];
							PatientData newPatientData = new PatientData(tfImie.getText(), tfNazwisko.getText(),bg.getSelection().getActionCommand().toString(), comboUbezpieczenie.getSelectedItem().toString());
							dataBase.addPatient(setIdNumber_(tfPesel.getText()), newPatientData,EditData);
							row = dataBase.returnDataTable(tfPesel.getText()); 
							JCheckBox check= new JCheckBox();
							check.isVisible();
					        row[4] = check;
					        if(EditData == 0)
					        	model.addRow(row);
					        else{
					        	model.setValueAt(row[0], SelectedRawIndex, 0);
					        	model.setValueAt(row[1], SelectedRawIndex, 1);
					        	model.setValueAt(row[2], SelectedRawIndex, 2);
					        	model.setValueAt(row[3], SelectedRawIndex, 3);
					        	model.setValueAt(row[4], SelectedRawIndex, 4);
					        }
							} catch (Exceptions zleNazwisko) {
							} catch (Exception e1){
								new Window("Wybierz plec");
							}
						EditData = 0;
					}
			    } );
		        
		        bZapiszBadanie.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						check.isSelected();
						try{
							java.util.Date oDate = picker.getDate();        
							DateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
							String[] szDate = oDateFormat.format(oDate).split("-");
							
							
							TestResults newTest = new TestResults(Integer.parseInt(szDate[2]),Integer.parseInt(szDate[1]),Integer.parseInt(szDate[0]), Integer.parseInt(tfLeukocyty.getText()), Integer.parseInt(tfNeutrofile.getText()),Integer.parseInt(tfErytrocyty.getText()), 1);
							dataBase.addTestResults(setIdNumber_(tfPesel.getText()), newTest);
							//row = dataBase.returnDataTable(tfPesel.getText()); 
							JCheckBox check= new JCheckBox();
							check.setSelected(true);
							model.setValueAt(check, SelectedRawIndex, 4);							
							} catch (Exceptions zleNazwisko) {
							} catch (Exception e1){
								new Window("Zle dane wejsciowe badania. Trzeba liczby calkowite");
							}
					}
			    } );
		        
		        JScrollPane tableLista2 = new JScrollPane(jpTemp2);
		        panelLista.add(tableLista2);
		        
		        JPanel bDaU = new JPanel();
		        bDaU.setLayout(new BorderLayout());
		        JButton bDodaj=new JButton("Dodaj");
		        bDaU.add(bDodaj, BorderLayout.WEST);
				JButton bUsun=new JButton("Usun");
				bDaU.add(bUsun,BorderLayout.EAST);
		        panelLista.add(bDaU, BorderLayout.SOUTH);
		        
		        bDodaj.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						tfImie.setText("");
						tfNazwisko.setText("");
						tfPesel.setText("");
						radioK.setSelected(false);
						radioM.setSelected(false);	
						tfLeukocyty.setText("");
						tfErytrocyty.setText("");
						tfNeutrofile.setText("");;
						tfImie.setEditable(true);
						tfNazwisko.setEditable(true);
						tfPesel.setEditable(true);
						tfLeukocyty.setEditable(true);
						tfNeutrofile.setEditable(true);
						tfErytrocyty.setEditable(true);
					}
					
				});
		        
		        bUsun.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							dataBase.removePatient(tfPesel.getText());
							((DefaultTableModel)tableLista.getModel()).removeRow(SelectedRawIndex);
							tfImie.setText("");
							tfNazwisko.setText("");
							tfPesel.setText("");
							radioK.setSelected(false);
							radioM.setSelected(false);	
							tfLeukocyty.setText("");
							tfErytrocyty.setText("");
							tfNeutrofile.setText("");;
							tfImie.setEditable(false);
							tfNazwisko.setEditable(false);
							tfPesel.setEditable(false);
							tfLeukocyty.setEditable(false);
							tfNeutrofile.setEditable(false);
							tfErytrocyty.setEditable(false);
						} catch (Exceptions e1) {
						}
						
					}
		        	
		        });
		        
		
		//DODANIE PANELI
		JPanel wynikiBadanP = new JPanel();
		wynikiBadanP.setLayout(new BorderLayout());
		wynikiBadanP.add(panelDane, BorderLayout.NORTH);
		wynikiBadanP.add(panelBadanie, BorderLayout.SOUTH);
		gbc.add(wynikiBadanP,BorderLayout.WEST);
		gbc.add(panelLista, BorderLayout.CENTER);
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
