package Government;
import javax.swing.JFrame;

import Utstyr.Brain_Equipment;

import Akvariet.Brain_Akvarie;
import Fisk.Brain_Fish;
import GUI.Panel_Akvariebilde;
import GUI.Panel_Menu;
import GUI.Vindu_ContentFrame;
import GUI.Vindu_Equipment;
import GUI.Vindu_Fisk;
import GUI.Vindu_Main;
import GUI.Vindu_Shopping;

public class Communicator {

	Vindu_ContentFrame	Class_Vindu_ContentFrame;
	public Panel_Menu			Class_Panel_Menu;
	
	public Vindu_Main 			Class_Vindu_Main;
	public Vindu_Fisk 			Class_Vindu_Fisk;
	public Vindu_Equipment		Class_Vindu_Equipment;
	public Vindu_Shopping		Class_Vindu_Shopping;
	
	public Brain_Equipment		Class_Brain_Equipment;
	public Brain_Akvarie		Class_Brain_Akvarie;
	public Brain_Fish 			Class_Brain_Fish;
	public Brain_GameStatus	Class_Brain_GameStatus;
	public Brain_Warnings		Class_Brain_Warnings;
	TimeKeeper 			Class_TimeKeeper;
	
	//Object_BruksAkvarie	AkvarieIBruk;
	
	Panel_Akvariebilde	Link_Panel_Akvariebilde;
	
	public void SetupProgram(){
		
		//AkvarieIBruk = new Object_BruksAkvarie(this, 60);
		Link_Panel_Akvariebilde = new Panel_Akvariebilde(this);
		
		Class_Brain_Equipment = new Brain_Equipment(this);
		Class_Brain_Akvarie = new Brain_Akvarie(this);
		Class_Brain_Fish = new Brain_Fish(this);
		
		Class_Panel_Menu = new Panel_Menu(this);
		
		Class_Vindu_Main = new Vindu_Main(this);
		Class_Vindu_Fisk = new Vindu_Fisk(this);
		Class_Vindu_Equipment = new Vindu_Equipment(this);
		Class_Vindu_Shopping = new Vindu_Shopping(this);
		
		Class_Vindu_ContentFrame = new Vindu_ContentFrame(this);
		Class_Vindu_ContentFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		Class_Brain_GameStatus = new Brain_GameStatus();
		Class_TimeKeeper = new TimeKeeper(this);
		Class_Brain_Warnings = new Brain_Warnings(this);
	}
	
	public void Startup(){
		
		Class_Brain_Fish.Startup();
		Class_TimeKeeper.Startup();
		
		Class_Vindu_Main.AddListeners();
	}
	
	public void Open_Overview() {
		System.out.println("Vil bytte ut høyre vindu i contentframe med vindu_main");
		Class_Vindu_ContentFrame.RightHalf.removeAll();
		Class_Vindu_ContentFrame.RightHalf.add(Class_Vindu_Main.TotalPanel);
	}
	
	public void Open_Equipment() {
		System.out.println("Vil bytte ut høyre vindu i contentframe med Vindu_Equipment");
		Class_Vindu_ContentFrame.RightHalf.removeAll();
		Class_Vindu_ContentFrame.RightHalf.add(Class_Vindu_Equipment.TotalPanel);
	}
	
	public void Open_FishOverview() {
		System.out.println("Vil bytte ut høyre vindu i contentframe med vindu_fisk");
		Class_Vindu_ContentFrame.RightHalf.removeAll();
		Class_Vindu_ContentFrame.RightHalf.add(Class_Vindu_Fisk.TotalPanel);
	}
	
	public void Open_Shopping() {
		System.out.println("Vil bytte ut høyre vindu i contentframe med vindu_shopping");
		Class_Vindu_ContentFrame.RightHalf.removeAll();
		Class_Vindu_ContentFrame.RightHalf.add(Class_Vindu_Shopping.TotalPanel);
	}
	
	public void TimeTick() {
		//System.out.println("Communicator TimeTick");
		//Class_Brain_GameStatus.GameTick();
		
		Class_Brain_Fish.TimeProcessFish();
		Class_Brain_Akvarie.VannFordamper();
		Class_Brain_Akvarie.Biomaterial_IsRotting();
		Class_Brain_Warnings.GenerateWarnings();
		UpdateGUI();
	}
	
	public void FeedFish() {
		Class_Brain_Fish.FeedFish();
		UpdateGUI();
	}
	
	public void UpdateGUI() {
		Class_Vindu_Main.FillLabels();
		Class_Vindu_Fisk.FillLabels();
		Class_Vindu_Equipment.FillLabels();
		Class_Vindu_Shopping.FillLabels();
		
		Link_Panel_Akvariebilde.Update();
		Class_Vindu_ContentFrame.repaint();
	}

	public void HourTick() {
		
		Class_Brain_GameStatus.GameTick();
		Class_Brain_Fish.TimeProcessFish();
		Class_Brain_Akvarie.VannFordamper();
		Class_Brain_Akvarie.Biomaterial_IsRotting();
		Class_Brain_Warnings.GenerateWarnings();
		UpdateGUI();
		
	}
}
