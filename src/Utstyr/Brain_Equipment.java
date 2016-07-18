package Utstyr;

import Standalone.Object_Stats;
import Government.Communicator;

public class Brain_Equipment {
	
	Communicator Class_Communicator;

	Object_Akvarie[] AkvarieUtgaver = new Object_Akvarie[100];
	Object_Equipment[] PumpeUtgaver = new Object_Equipment[100];
	Object_Equipment[] LysroerUtgaver = new Object_Equipment[100];
	Object_Equipment[] VarmekolbeUtgaver = new Object_Equipment[100];
	
	public Object_Equipment InUse_Akvarie;
	
	public Brain_Equipment(Communicator Class_Communicator) {
		//System.out.println(this.getClass().toString()+" startet");
		this.Class_Communicator = Class_Communicator;
		Create_Akvarieutgaver();
		
	}
	
	private void Create_Akvarieutgaver() {
		
		for ( int X = 1 ; X < AkvarieUtgaver.length ; X ++ ) {
			Object_Stats AkvarieStats = new Object_Stats();
			AkvarieStats.WaterCapacity = X * 30;
			AkvarieUtgaver[X] = new Object_Akvarie("", AkvarieStats);
		}
		InUse_Akvarie = AkvarieUtgaver[1];
		
	}
	
}
