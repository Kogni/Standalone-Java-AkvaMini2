package GUI;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import Government.Communicator;

public class Vindu_Equipment extends JPanel implements ActionListener {
	
	Communicator Class_Communicator;
	
	public JPanel TotalPanel;
		JPanel UpperHalf;
		JPanel BottomHalf;
			JTabbedPane EquipmentTabs;
			
			Panel_Equipment_Akvarie Tab_Equipment_Akvarie;
			Panel_Equipment_Pumpe Tab_Panel_Equipment_Pumpe;
			Panel_Equipment_Varme Tab_Panel_Equipment_Varme;
			Panel_Equipment_Lys Tab_Panel_Equipment_Lys;
			Panel_Equipment_Water Tab_Panel_Equipment_Water;
			Panel_Equipment_Luft Tab_Panel_Equipment_Luft;
			
	Border Separeringsbord;

	public Vindu_Equipment(Communicator Class_CommunicatorT){
		Class_Communicator = Class_CommunicatorT;
		
		setSize( 500, 400 );
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        GridBagConstraints c = new GridBagConstraints();
        
        Separeringsbord = BorderFactory.createEmptyBorder(0, 0, 0, 10);
		
		TotalPanel = new JPanel();
		TotalPanel.setLayout(new BoxLayout(TotalPanel, BoxLayout.LINE_AXIS));
        TotalPanel.setBackground(new Color((int)(210),(int)(225),(int)(240)));
        
        UpperHalf = new JPanel();
        UpperHalf.setLayout(new BoxLayout(UpperHalf, BoxLayout.LINE_AXIS));
        TotalPanel.add(UpperHalf);
        
        BottomHalf = new JPanel();
        BottomHalf.setLayout(new BoxLayout(BottomHalf, BoxLayout.LINE_AXIS));
        TotalPanel.add(BottomHalf);
        
        Tab_Equipment_Akvarie = new Panel_Equipment_Akvarie(Class_Communicator); 
        Tab_Panel_Equipment_Pumpe = new Panel_Equipment_Pumpe(Class_Communicator);
        Tab_Panel_Equipment_Varme = new Panel_Equipment_Varme(Class_Communicator);
        Tab_Panel_Equipment_Lys = new Panel_Equipment_Lys(Class_Communicator);
        Tab_Panel_Equipment_Water = new Panel_Equipment_Water(Class_Communicator);
        Tab_Panel_Equipment_Luft = new Panel_Equipment_Luft(Class_Communicator);
        
        EquipmentTabs = new JTabbedPane();
        EquipmentTabs.addTab("Aquarium", Tab_Equipment_Akvarie);
        EquipmentTabs.addTab("Pump", Tab_Panel_Equipment_Pumpe);
        EquipmentTabs.addTab("Heater", Tab_Panel_Equipment_Varme);
        EquipmentTabs.addTab("Light", Tab_Panel_Equipment_Lys);
        EquipmentTabs.addTab("Air", Tab_Panel_Equipment_Luft);
        EquipmentTabs.addTab("Water quality", Tab_Panel_Equipment_Water);
        BottomHalf.add(EquipmentTabs);
		
        this.add(TotalPanel, c);
        //pack();
		setVisible( true );
	}
	
	public void AddListeners() {

	}
	
	public void FillLabels() {
		//System.out.println("Vindu_Main FillLabels");
		Tab_Equipment_Akvarie.FillLabels();
		Tab_Panel_Equipment_Pumpe.FillLabels();
		Tab_Panel_Equipment_Varme.FillLabels();
		Tab_Panel_Equipment_Lys.FillLabels();
		Tab_Panel_Equipment_Water.FillLabels();
		Tab_Panel_Equipment_Luft.FillLabels();
		
		repaint();
	}
	
	public void actionPerformed(ActionEvent E) {

	}
	
}
