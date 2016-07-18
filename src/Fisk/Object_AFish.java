package Fisk;

public class Object_AFish extends Super_Species {
	
	int ID;
	int SpeciesID;
	int HealthPoints;
	double CMSize;
	double DaysAge;
	double StomachFill;
	
	//formering
	String Sex;
	boolean Pregnant;
	double PregnancyTime;
	
	//sykdom
	int SykdomsID = 0; //0=ikke syk
	
	//genetisk
	double MaxSize;
	double MaxAge;
	double StomachSize;

	public Object_AFish(String Species, int IDT, String SexT){
		
		super(Species);
		ID = IDT;
		Sex = SexT;
		if ( Sex.equals("Unknown") == false) { //ikke yngel, enten startfisk eller kjøpt
			DaysAge = 60;
		}
		
		StomachFill = StomachSize;
		HealthPoints = 100;
		DaysAge = 0;
		
		MaxSize = (Species_MaxSize * Math.random())+(Species_MaxSize/2.0); //(0-1)+0.5=0.5-1.5
		MaxAge = (Species_MaxAge * Math.random())+(Species_MaxAge/2.0); //(0-1)+0.5=0.5-1.5
		
	}
	
	public void AgeFish() { //per TIME
		
		DaysAge = DaysAge + (1/24.0);
		HealthPoints --;
		if ( DaysAge >= (MaxAge/6.0) ) {
			if ( Sex.equals("Unknown") == true ) {
				if ( (15.0 * Math.random()) > 7 ) {
					Sex = "Female";
				} else {
					Sex = "Male";
				}
			}
		}
		if ( DaysAge >= MaxAge ) {
			HealthPoints = 0;
		}
		if ( Pregnant == true ) {
			PregnancyTime = PregnancyTime + (1/24.0);
		}
		FishSize();
		
		if ((Diet.equals("Omnivorous")) || (Diet.equals("Herbivorous"))) {
			StomachFill = StomachFill + (StomachSize / 48.0); //alger og planter fra akvariet
		}
		if ( StomachFill > StomachSize ) {
			StomachFill = StomachSize;
		}
		
		StomachFill = StomachFill - (StomachSize / 24.0); //fordøyelse
		if ( StomachFill < 0 ) {
			StomachFill = 0;
		}
		
		Health();
		
	}
	
	private void Health() {
		
		if ( StomachFill == 0 ) {
			HealthPoints --;
		} else if ( StomachFill >= 50 ) {
			HealthPoints ++;
		} else if ( StomachFill == 100 ) {
			HealthPoints = HealthPoints + 2;
		}
		
	}
	
	private void FishSize() {
		
		if ( DaysAge < 50 ) {
			CMSize = (MaxSize/4.0);
		} else if ( DaysAge < 100 ) {
			CMSize = (MaxSize/2.0);
		} else if ( DaysAge < 150 ) {
			CMSize = (MaxSize/4.0*3);
		} else if ( DaysAge < 200 ) {
			CMSize = MaxSize;
		} else {
			CMSize = MaxSize;
		}
		
	}
	
}
