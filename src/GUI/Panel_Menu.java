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

public class Panel_Menu extends JPanel implements ActionListener {
	
	Communicator Class_Communicator;
	
	JPanel TotalPanel;
		JPanel UpperHalf;
		JPanel BottomHalf;
			JPanel[] CollumnHolder = new JPanel[10];
				JButton Button_Overview;
				JButton Button_AquariumOverview;
				JButton Button_FishOverview;
				JButton Button_PlantOverview;
				JButton Button_EconomicOverview;
				JButton Button_Shops;
				JButton Button_Market;
				JButton Button_Logg;
				JButton Button_Settings;
			
	Border Separeringsbord;

	public Panel_Menu(Communicator Class_CommunicatorT){
		Class_Communicator = Class_CommunicatorT;
		//System.out.println("Vindu_Main created");
		
		TotalPanel = new JPanel();
		
		TotalPanel.setMinimumSize(new Dimension(50, 400));
		TotalPanel.setSize( 75, 400 ); //w,h
		TotalPanel.setMaximumSize(new Dimension(100, 400));
		TotalPanel.setLayout( new GridLayout(0, 1)); //y, x
		//this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		TotalPanel.setBackground(new Color((int)(0),(int)(100),(int)(255)));
		
		Separeringsbord = BorderFactory.createEtchedBorder();
        
        for ( int x = 1 ; x < CollumnHolder.length ; x++ ) {
        	CollumnHolder[x] = new JPanel();
        	//CollumnHolder[x].setBorder(Separeringsbord);
        	TotalPanel.add(CollumnHolder[x]);
        }
        
        int X = 0;
        
        X ++;
        Button_Overview = new JButton("Overview");
        Button_Overview.setSize( 100, 400 ); //w,h
        CollumnHolder[X].add(Button_Overview);
        X ++;
        Button_AquariumOverview = new JButton("Equipment");
        Button_AquariumOverview.setSize( 100, 400 ); //w,h
        CollumnHolder[X].add(Button_AquariumOverview);
        X ++;
        Button_FishOverview = new JButton("Fish");
        Button_FishOverview.setSize( 100, 400 ); //w,h
        CollumnHolder[X].add(Button_FishOverview);
        X ++;
        Button_PlantOverview = new JButton("Plants");
        Button_PlantOverview.setSize( 100, 400 ); //w,h
        CollumnHolder[X].add(Button_PlantOverview);
        X ++;
        Button_EconomicOverview = new JButton("Economy");
        Button_EconomicOverview.setSize( 100, 400 ); //w,h
        CollumnHolder[X].add(Button_EconomicOverview);
        X ++;
        Button_Shops = new JButton("Shopping");
        Button_Shops.setSize( 100, 400 ); //w,h
        CollumnHolder[X].add(Button_Shops);
        X ++;
        Button_Market = new JButton("Market");
        Button_Market.setSize( 100, 400 ); //w,h
        CollumnHolder[X].add(Button_Market);
        X ++;
        Button_Logg = new JButton("Logg");
        Button_Logg.setSize( 100, 400 ); //w,h
        CollumnHolder[X].add(Button_Logg);
        X ++;
        Button_Settings = new JButton("Settings");
        Button_Settings.setSize( 100, 400 ); //w,h
        CollumnHolder[X].add(Button_Settings);
        
		
        setVisible( true );
        TotalPanel.setBorder(Separeringsbord);
        AddListeners();
	}
	
	public void AddListeners() {
		Button_Overview.addActionListener(this);
		Button_AquariumOverview.addActionListener(this);
		Button_FishOverview.addActionListener(this);
		Button_PlantOverview.addActionListener(this);
		Button_EconomicOverview.addActionListener(this);
		Button_Shops.addActionListener(this);
		Button_Market.addActionListener(this);
		Button_Logg.addActionListener(this);
		Button_Settings.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent E) {
		if ( E.getSource() == Button_Overview ) {
			this.Class_Communicator.Open_Overview();
		} else if ( E.getSource() == Button_AquariumOverview ) {
			this.Class_Communicator.Open_Equipment();
		} else if ( E.getSource() == Button_FishOverview ) {
			this.Class_Communicator.Open_FishOverview();
		} else if ( E.getSource() == Button_Shops ) {
			this.Class_Communicator.Open_Shopping();
		}
	}
	
}
