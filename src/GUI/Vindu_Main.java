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

public class Vindu_Main extends JPanel implements ActionListener {
	
	Communicator Class_Communicator;
	
	public JPanel TotalPanel;
		JPanel UpperHalf;
		JPanel BottomHalf;
			JPanel[] CollumnHolder = new JPanel[10];
			JLabel[][] Text = new JLabel[25][10];
				JButton Button_AquariumOverview;
				JButton Button_FishOverview;
				JButton Button_EconomicOverview;
			
	Border Separeringsbord, Grensebord;

	public Vindu_Main(Communicator Class_CommunicatorT){
		Class_Communicator = Class_CommunicatorT;
		//System.out.println("Vindu_Main created");
		
		setSize( 500, 400 );
		//Container pane = getContentPane();
		//pane.setLayout( new GridLayout(1, 3)); //y, x
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        GridBagConstraints c = new GridBagConstraints();
        
        Separeringsbord = BorderFactory.createEmptyBorder(0,0,0,10);
        Grensebord = BorderFactory.createEtchedBorder();
		
		TotalPanel = new JPanel();
		TotalPanel.setLayout(new BoxLayout(TotalPanel, BoxLayout.LINE_AXIS));
		//TotalPanel.setBorder(Separeringsbord);
        TotalPanel.setBackground(new Color((int)(210),(int)(225),(int)(240)));
        
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
        CollumnHolder[2].setBorder(Separeringsbord);
        CollumnHolder[4].setBorder(Separeringsbord);
        
        Text[1][1].setText("Date: ");
        Text[2][1].setText("Time: ");
        Text[3][1].setText("Cash: ");
        
        Text[5][1].setText("Water: ");
        Text[6][1].setText("Temperature: ");
        Text[7][1].setText("Light: ");
        Text[8][1].setText("Nitrite: ");
        Text[9][1].setText("Equipment state: ");
        
        Text[11][1].setText("Cm fish/liter: ");
        Text[12][1].setText("Sick fish: ");
        
        Text[14][1].setText("Warnings: ");
		
        this.add(TotalPanel, c);
        //pack();
		setVisible( true );
	}
	
	public void AddListeners() {
		//Button_AquariumOverview.addActionListener(this);
		//Button_FishOverview.addActionListener(this);
		//Button_EconomicOverview.addActionListener(this);
	}
	
	public void FillLabels() {
		//System.out.println("Vindu_Main FillLabels");
		
		Text[1][2].setText("Y"+Class_Communicator.Class_Brain_GameStatus.Year+" M"+Class_Communicator.Class_Brain_GameStatus.Month+" D"+Class_Communicator.Class_Brain_GameStatus.Day);
		Text[2][2].setText(Class_Communicator.Class_Brain_GameStatus.Hour+":00");
		Text[3][2].setText(Class_Communicator.Class_Brain_GameStatus.Cash+"");
		
		Text[5][2].setText(Class_Communicator.Class_Brain_Akvarie.VannIAkvarie+"l");
		Text[6][2].setText("?");
		Text[7][2].setText("?");
		Text[8][2].setText("?");
		Text[9][2].setText("?");
		
		Text[11][2].setText(Class_Communicator.Class_Brain_Fish.CMFishPerLiter+" cm/l");
		Text[12][2].setText(Class_Communicator.Class_Brain_Fish.SickFish+"");
		
		for ( int A = 1 ; A < Class_Communicator.Class_Brain_Warnings.Warnings.length ; A++ ) {
			Text[13+A][2].setText(" ");
		}
		
		for ( int A = 1 ; A < Class_Communicator.Class_Brain_Warnings.Warnings.length ; A++ ) {
			if ( Class_Communicator.Class_Brain_Warnings.Warnings[A].equals("") == false ) {
				Text[13+A][2].setText(Class_Communicator.Class_Brain_Warnings.Warnings[A]);
			}
		}
		        
	}
	
	public void actionPerformed(ActionEvent E) {
		if ( E.getSource() == Button_AquariumOverview ) {
	
		} else if ( E.getSource() == Button_FishOverview ) {
				
		} else if ( E.getSource() == Button_EconomicOverview ) {
				
		}
	}
	
}
