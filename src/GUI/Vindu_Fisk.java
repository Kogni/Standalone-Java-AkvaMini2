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

public class Vindu_Fisk extends JPanel implements ActionListener {
	
	Communicator Class_Communicator;
	
	public JPanel TotalPanel;
		JPanel UpperHalf;
		JPanel BottomHalf;
			JPanel[] CollumnHolder = new JPanel[10];
			JLabel[][] Text = new JLabel[10][10];
			
	Border Separeringsbord;

	public Vindu_Fisk(Communicator Class_CommunicatorT){
		Class_Communicator = Class_CommunicatorT;
		//System.out.println("Vindu_Main created");
		
		setSize( 500, 400 );
		//Container pane = getContentPane();
		//pane.setLayout( new GridLayout(1, 3)); //y, x
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        //GridBagConstraints c = new GridBagConstraints();
        
        Separeringsbord = BorderFactory.createEtchedBorder();
		
		TotalPanel = new JPanel();
		TotalPanel.setLayout(new BoxLayout(TotalPanel, BoxLayout.LINE_AXIS));
		//TotalPanel.setBorder(Separeringsbord);
        TotalPanel.setBackground(new Color((int)(210),(int)(225),(int)(240)));
        TotalPanel.setSize( 500, 400 );
        
        UpperHalf = new JPanel();
        UpperHalf.setLayout(new BoxLayout(UpperHalf, BoxLayout.LINE_AXIS));
        TotalPanel.add(UpperHalf);
        //UpperHalf.add(Class_Communicator.Link_Panel_Akvariebilde.TotalPanel);
        //UpperHalf.setSize(Class_Communicator.Link_Panel_Akvariebilde.TotalPanel.getSize());
        
        BottomHalf = new JPanel();
        BottomHalf.setLayout(new BoxLayout(BottomHalf, BoxLayout.LINE_AXIS));
        TotalPanel.add(BottomHalf);
        
        for ( int x = 1 ; x < CollumnHolder.length ; x++ ) {
        	CollumnHolder[x] = new JPanel();
        	//CollumnHolder[x].setLayout( new GridLayout(0, 1));
        	//CollumnHolder[x].setBorder(Separeringsbord);
        	CollumnHolder[x].setLayout(new BoxLayout(CollumnHolder[x], BoxLayout.PAGE_AXIS));
        	BottomHalf.add(CollumnHolder[x]);
        	for ( int y = 1 ; y < Text.length ; y++ ) {
        		Text[y][x] = new JLabel(" ");
        		CollumnHolder[x].add(Text[y][x]);
        	}
        }
        Text[1][1].setText("Live fish: ");
        Text[2][1].setText(" Females: ");
        Text[3][1].setText(" Males: ");
        Text[4][1].setText(" Fry: ");
        
        Text[6][1].setText("Avg health: ");
        Text[7][1].setText("Cm fish/liter: ");
        Text[8][1].setText("Sick fish: ");
        Text[9][1].setText("Avg age: ");
		
        //this.add(TotalPanel, c);
        this.add(TotalPanel);
        //pack();
		setVisible( true );
	}
	
	public void AddListeners() {

	}
	
	public void FillLabels() {
		//System.out.println("Vindu_Main FillLabels");
		
		String Fish = Class_Communicator.Class_Brain_Fish.FishInArray+" ";
		/*
		if ( Class_Communicator.Class_Brain_Fish.FishInArray == (Class_Communicator.Class_Brain_Fish.FishArray.length-1) ) {
			Fish = Fish + " MAX reached!";
		}
		*/
		Text[1][2].setText(Fish);
		Text[2][2].setText(Class_Communicator.Class_Brain_Fish.Females+"");
		Text[3][2].setText(Class_Communicator.Class_Brain_Fish.Males+"");
		Text[4][2].setText(Class_Communicator.Class_Brain_Fish.Fry+"");
		
		if ( Class_Communicator.Class_Brain_Fish.FishInArray > 0 ) {
			Text[2][3].setText((Class_Communicator.Class_Brain_Fish.Females*100/Class_Communicator.Class_Brain_Fish.FishInArray)+"%");
			Text[3][3].setText((Class_Communicator.Class_Brain_Fish.Males*100/Class_Communicator.Class_Brain_Fish.FishInArray)+"%");
			Text[4][3].setText((Class_Communicator.Class_Brain_Fish.Fry*100/Class_Communicator.Class_Brain_Fish.FishInArray)+"%");
		} else {
			Text[2][3].setText("");
			Text[3][3].setText("");
			Text[4][3].setText("");
		}
		
		Text[6][2].setText(Class_Communicator.Class_Brain_Fish.AvgHealthPoints+"%");
		Text[7][2].setText(Class_Communicator.Class_Brain_Fish.CMFishPerLiter+" cm/l");
		Text[8][2].setText(Class_Communicator.Class_Brain_Fish.SickFish+"");
		Text[9][2].setText(Class_Communicator.Class_Brain_Fish.AvgAge+" days");
		        
		repaint();
	}
	
	public void actionPerformed(ActionEvent E) {

	}
	
}
