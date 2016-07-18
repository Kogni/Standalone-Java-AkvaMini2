package GUI;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Government.Communicator;

public class Panel_Equipment_Pumpe extends JPanel implements ActionListener {
	
	Communicator Class_Communicator;
	
	JPanel TotalPanel;
		JPanel UpperHalf;
		JPanel BottomHalf;
			JPanel[] CollumnHolder = new JPanel[10];
			JLabel[][] Text = new JLabel[25][10];
			
			Border Separeringsbord;

	public Panel_Equipment_Pumpe(Communicator Class_CommunicatorT) {
		Class_Communicator = Class_CommunicatorT;
		
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
        
        for ( int x = 1 ; x < CollumnHolder.length ; x++ ) {
        	CollumnHolder[x] = new JPanel();
        	CollumnHolder[x].setLayout(new BoxLayout(CollumnHolder[x], BoxLayout.PAGE_AXIS));
        	BottomHalf.add(CollumnHolder[x]);
        	for ( int y = 1 ; y < Text.length ; y++ ) {
        		Text[y][x] = new JLabel(" ");
        		CollumnHolder[x].add(Text[y][x]);
        	}
        }
        CollumnHolder[2].setBorder(Separeringsbord);
        CollumnHolder[4].setBorder(Separeringsbord);
        
        Text[1][1].setText("Pump: ");
        Text[2][1].setText(" Age(months): ");
        Text[3][1].setText(" Max effect: ");
        Text[4][1].setText(" Effect now: ");
        
        this.add(TotalPanel, c);
		setVisible( true );
	}
	
	public void FillLabels() {
		//System.out.println("Vindu_Main FillLabels");
		
		Text[2][2].setText(" ");
		Text[3][2].setText(" ");
		Text[4][2].setText(" ");
		
		repaint();
	}
	
	public void actionPerformed(ActionEvent E) {

	}
}
