package Government;


public class Brain_Warnings {

	Communicator Class_Communicator;
	public String Warnings[] = new String[12];
	
	public Brain_Warnings(Communicator Class_CommunicatorT) {
		Class_Communicator = Class_CommunicatorT;
		
	}
	
	public void GenerateWarnings() {
		
		for ( int A = 1 ; A < Warnings.length ; A++ ) {
			Warnings[A] = "";
		}
		
		int X = 0;
		
		//vannkvalitet
		double A = Class_Communicator.Class_Brain_Akvarie.VannIAkvarie;
		double B = Class_Communicator.Class_Brain_Equipment.InUse_Akvarie.Bonuser.WaterCapacity * 0.1;
		if ( A < B ) {
			X ++;
			Warnings[X] = "There's very little water in the aquarium!";
		}
		
		A = 100;
		B = Class_Communicator.Class_Brain_Akvarie.Ammonium;
		if ( A < B ) {
			X ++;
			Warnings[X] = "There's lots of toxic ammonium in the aquarium!";
		}
		
		A = 100;
		B = Class_Communicator.Class_Brain_Akvarie.Nitrat;
		if ( A < B ) {
			X ++;
			Warnings[X] = "There's lots of toxic nitrate in the aquarium!";
		}
		
		A = 100;
		B = Class_Communicator.Class_Brain_Akvarie.Nitritt;
		if ( A < B ) {
			X ++;
			Warnings[X] = "There's lots of toxic nitrite in the aquarium!";
		}
		
		A = Class_Communicator.Class_Brain_Akvarie.Oksygen;
		B = 100;
		if ( A < B ) {
			X ++;
			Warnings[X] = "There's very little oxygen in the aquarium!";
		}
		
		A = 100;
		B = Class_Communicator.Class_Brain_Akvarie.Svovel;
		if ( A < B ) {
			X ++;
			Warnings[X] = "There's lots of sulphur in the aquarium!";
		}
		
		//Fisk
		
		A = 1;
		B = Class_Communicator.Class_Brain_Fish.CMFishPerLiter;
		if ( A < B ) {
			X ++;
			Warnings[X] = "The aquarium is crowded!";
		}
		
		A = 1;
		B = Class_Communicator.Class_Brain_Fish.MalesPerFemale;
		if ( A < B ) {
			X ++;
			Warnings[X] = "The male population is too large!";
		}
		
		A = Class_Communicator.Class_Brain_Fish.AvgAge;
		B = 60;
		if ( Class_Communicator.Class_Brain_Fish.FishInArray > 2 ) {
			if ( A < B ) {
				X ++;
				Warnings[X] = "The deathrate in your aquarium is very high!";
			}
		}
		
		A = Class_Communicator.Class_Brain_Fish.AvgHealthPoints;
		B = 40;
		if ( A < B ) {
			X ++;
			Warnings[X] = "Your fish are not of good health!";
		}
		
		A = 1;
		B = Class_Communicator.Class_Brain_Fish.SickFish;
		if ( A < B ) {
			X ++;
			Warnings[X] = "You haver sick fish!";
		}
		
		if ( Class_Communicator.Class_Brain_Fish.FishInArray == (Class_Communicator.Class_Brain_Fish.FishArray.length-1) ) {
			X ++;
			Warnings[X] = "There's no more room for fish!";
		}
		
	}
}
