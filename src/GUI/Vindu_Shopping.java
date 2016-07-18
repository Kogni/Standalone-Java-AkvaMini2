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
import javax.swing.JTabbedPane;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import Government.Communicator;

public class Vindu_Shopping extends JPanel implements ActionListener {
	
	Communicator Class_Communicator;
	
	public JPanel TotalPanel;
		JPanel UpperHalf;
		JPanel BottomHalf;
			JPanel[] CollumnHolder = new JPanel[10];
			JLabel[][] Text = new JLabel[10][10];
			
			JTabbedPane TabbedPanel_EquipmentType;
			
			Panel_Equipment_Akvarie Tab_Equipment_Akvarie;
			Panel_Equipment_Pumpe Tab_Panel_Equipment_Pumpe;
			Panel_Equipment_Varme Tab_Panel_Equipment_Varme;
			Panel_Equipment_Lys Tab_Panel_Equipment_Lys;
			Panel_Equipment_Water Tab_Panel_Equipment_Water;
			Panel_Equipment_Luft Tab_Panel_Equipment_Luft;
			
	Border Separeringsbord;

	public Vindu_Shopping(Communicator Class_Communicator){
		this.Class_Communicator = Class_Communicator;
		
		setSize( 500, 400 );
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        GridBagConstraints c = new GridBagConstraints();
        
        Separeringsbord = BorderFactory.createEtchedBorder();
		
		TotalPanel = new JPanel();
		TotalPanel.setLayout(new BoxLayout(TotalPanel, BoxLayout.LINE_AXIS));
        TotalPanel.setBackground(new Color((int)(210),(int)(225),(int)(240)));
        
        UpperHalf = new JPanel();
        UpperHalf.setLayout(new BoxLayout(UpperHalf, BoxLayout.LINE_AXIS));
        TotalPanel.add(UpperHalf);
        
        BottomHalf = new JPanel();
        BottomHalf.setLayout(new BoxLayout(BottomHalf, BoxLayout.LINE_AXIS));
        TotalPanel.add(BottomHalf);
        
        for ( int x = 1 ; x < CollumnHolder.length ; x++ ) {
        	CollumnHolder[x] = new JPanel();
        	CollumnHolder[x].setLayout(new BoxLayout(CollumnHolder[x], BoxLayout.PAGE_AXIS));
        	BottomHalf.add(CollumnHolder[x]);
        	for ( int y = 1 ; y < Text.length ; y++ ) {
        		Text[y][x] = new JLabel(" ");
        		CollumnHolder[x].add(Text[y][x]);
        	}
        }
        
        Tab_Equipment_Akvarie = new Panel_Equipment_Akvarie(Class_Communicator); 
        Tab_Panel_Equipment_Pumpe = new Panel_Equipment_Pumpe(Class_Communicator);
        Tab_Panel_Equipment_Varme = new Panel_Equipment_Varme(Class_Communicator);
        Tab_Panel_Equipment_Lys = new Panel_Equipment_Lys(Class_Communicator);
        Tab_Panel_Equipment_Water = new Panel_Equipment_Water(Class_Communicator);
        Tab_Panel_Equipment_Luft = new Panel_Equipment_Luft(Class_Communicator);
        
        TabbedPanel_EquipmentType = new JTabbedPane();
        TabbedPanel_EquipmentType.addTab("Aquarium", Tab_Equipment_Akvarie);
        TabbedPanel_EquipmentType.addTab("Pump", Tab_Panel_Equipment_Pumpe);
        TabbedPanel_EquipmentType.addTab("Heater", Tab_Panel_Equipment_Varme);
        TabbedPanel_EquipmentType.addTab("Light", Tab_Panel_Equipment_Lys);
        TabbedPanel_EquipmentType.addTab("Air", Tab_Panel_Equipment_Luft);
        TabbedPanel_EquipmentType.addTab("Water quality", Tab_Panel_Equipment_Water);
        BottomHalf.add(TabbedPanel_EquipmentType);
		
        this.add(TotalPanel, c);
		setVisible( true );
	}
	
	public void AddListeners() {

	}
	
	public void FillLabels() {

		        
		repaint();
	}
	
	public void actionPerformed(ActionEvent E) {

	}
	
}
