package GUI;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Government.Communicator;

import java.awt.*;
import java.awt.event.*;

public class Panel_Akvariebilde extends JFrame  {

	Communicator Class_Communicator;
	
	JPanel TotalPanel;
		JPanel AquariumPanel;
		JPanel AirPanel;
		JPanel WaterPanel;
		
	//int Hoeyde = 10;
	//int Bredde = 10;
	
	public Panel_Akvariebilde(Communicator Class_CommunicatorT) {
		Class_Communicator = Class_CommunicatorT;
		setSize( 200, 200 );
		Container pane = getContentPane();
		pane.setLayout( new GridLayout(1, 3)); //y, x
        GridBagConstraints c = new GridBagConstraints();
        
        TotalPanel = new JPanel();
        TotalPanel.setLayout(new BoxLayout(TotalPanel, BoxLayout.PAGE_AXIS));
        TotalPanel.setBackground(new Color((int)(255),(int)(255),(int)(255)));
        
        AquariumPanel = new JPanel();
        AquariumPanel.setLayout(new BoxLayout(AquariumPanel, BoxLayout.PAGE_AXIS));
        AquariumPanel.setBackground(new Color((int)(255),(int)(255),(int)(255)));
        TotalPanel.add(AquariumPanel);
        
        AirPanel = new JPanel();
        AirPanel.setBackground(new Color((int)(210),(int)(240),(int)(240)));
        AquariumPanel.add(AirPanel);
        
        WaterPanel = new JPanel();
        WaterPanel.setBackground(new Color((int)(210),(int)(225),(int)(240)));
        AquariumPanel.add(WaterPanel);
        
        pane.add(TotalPanel);
        pack();
        Update();
	}
	
	public void Update(){
	
	}
	
}
