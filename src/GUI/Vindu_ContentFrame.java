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

public class Vindu_ContentFrame extends JFrame {
	
	Communicator Class_Communicator;
	
	JPanel TotalPanel;
		JPanel LeftHalf;
		public JPanel RightHalf;
			
	Border Separeringsbord;

	public Vindu_ContentFrame(Communicator Class_CommunicatorT){
		super( "AkvaMini" );
		Class_Communicator = Class_CommunicatorT;
		//System.out.println("Vindu_ContentFrame created");
		
		setSize( 600, 400 );
		Container pane = getContentPane();
		//pane.setLayout( new GridLayout(1, 3)); //y, x
		pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));
        GridBagConstraints c = new GridBagConstraints();
        
        Separeringsbord = BorderFactory.createEtchedBorder();
		
		TotalPanel = new JPanel();
		TotalPanel.setLayout(new BoxLayout(TotalPanel, BoxLayout.LINE_AXIS));
		TotalPanel.setBorder(Separeringsbord);
        TotalPanel.setBackground(new Color((int)(210),(int)(225),(int)(240)));
		
		LeftHalf = new JPanel();
		//LeftHalf.setBorder(Separeringsbord);
		LeftHalf.setBackground(new Color((int)(0),(int)(255),(int)(255)));
		LeftHalf.setLayout(new BoxLayout(LeftHalf, BoxLayout.PAGE_AXIS));
		LeftHalf.add(Class_Communicator.Class_Panel_Menu.TotalPanel);
		LeftHalf.setSize(100, 400);
		LeftHalf.setMinimumSize(new Dimension(50, 400));
		LeftHalf.setMaximumSize(new Dimension(100, 400));
		TotalPanel.add(LeftHalf);
		
		RightHalf = new JPanel();
		//RightHalf.setBorder(Separeringsbord);
		RightHalf.setBackground(new Color((int)(210),(int)(240),(int)(255)));
		RightHalf.setLayout(new BoxLayout(RightHalf, BoxLayout.PAGE_AXIS));
		RightHalf.add(Class_Communicator.Class_Vindu_Equipment.TotalPanel);
		RightHalf.removeAll();
		RightHalf.add(Class_Communicator.Class_Vindu_Fisk.TotalPanel);
		RightHalf.removeAll();
		RightHalf.add(Class_Communicator.Class_Vindu_Shopping.TotalPanel);
		RightHalf.removeAll();
		RightHalf.add(Class_Communicator.Class_Vindu_Main.TotalPanel);
		RightHalf.setSize(500, 400);
		RightHalf.setMinimumSize(new Dimension(500, 400));
		RightHalf.setMaximumSize(new Dimension(500, 400));
		TotalPanel.add(RightHalf);

        pane.add(TotalPanel, c);
		setVisible( true );
	}
	
	public void Startup(){
		//System.out.println("Vindu_Main started");
		
	}
	
	public void AddListeners() {
		//Button_AquariumOverview.addActionListener(this);
		//Button_FishOverview.addActionListener(this);
		//Button_EconomicOverview.addActionListener(this);
	}
	
}
