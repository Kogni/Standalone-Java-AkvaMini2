package Fisk;
import java.util.Random;


import Government.Communicator;

public class Brain_Fish {
	
	Communicator Class_Communicator;
	
	public Object_AFish[] FishArray = new Object_AFish[1000];
	
	public int FishInArray = 0;
	public int Females = 0;
	public int Males = 0;
	public int Fry = 0;
	
	public double MalesPerFemale = 0;
	public double AvgHealthPoints;
	public double CMFishPerLiter = 0;
	public int SickFish = 0;
	public double AvgAge = 0;

	public Brain_Fish(Communicator Class_CommunicatorT){
		Class_Communicator = Class_CommunicatorT;
	}
	
	public void Startup(){
		
		CreateFish();
		CreateFish();
		
		UpdateFishInfo();
	}
	
	private void CreateFish() {
		
		Object_AFish NewFish = null;
		if( FishInArray == 0 ) {
			NewFish = new Object_AFish("Guppy", FishInArray, "Female");
		} else if( FishInArray == 1 ) {
			NewFish = new Object_AFish("Guppy", FishInArray, "Male");
		} else {
			NewFish = new Object_AFish("Guppy", FishInArray, "Unknown");
		}
		
		boolean Inserted = false;
		for ( int y = 1 ; y < FishArray.length ; y++ ) {
			if ( Inserted == false ) {
				if ( FishArray[y] == null ) {
					FishArray[y] = NewFish;
					Inserted = true;
					FishInArray ++;
				}
			}
		}
		
	}
	
	public void TimeProcessFish() {

		for ( int y = 1 ; y < FishArray.length ; y++ ) {
			if ( FishArray[y] != null ) {
				FishArray[y].AgeFish();
			}
		}
		
		Death_ByHealth();
		Death_ByAge();
		Pregnancy();
		AmmoniumConsequences();

		UpdateFishInfo();
		
	}
	
	private void Death_ByAge() {
		
		for ( int y = 1 ; y < FishArray.length ; y++ ) {
			if ( FishArray[y] != null ) {
				if ( FishArray[y].DaysAge > FishArray[y].MaxAge ) {
					this.Class_Communicator.Class_Brain_Akvarie.Biomaterial_StartsRotting(FishArray[y].CMSize);
					FishArray[y] = null;
					FishInArray --;
					System.out.println("fish died from age");
				}
			}
		}
		
	}
	
	private void Death_ByHealth() {
		
		for ( int y = 1 ; y < FishArray.length ; y++ ) {
			if ( FishArray[y] != null ) {
				if ( FishArray[y].HealthPoints <= 0 ) {
					this.Class_Communicator.Class_Brain_Akvarie.Biomaterial_StartsRotting(FishArray[y].CMSize);
					FishArray[y] = null;
					FishInArray --;
					System.out.println("fish died from health");
				}
			}
		}
		
	}
	
	private void AmmoniumConsequences() {
		
		for ( int y = 1 ; y < FishArray.length ; y++ ) {
			if ( FishArray[y] != null ) {
				
				if ( Class_Communicator.Class_Brain_Akvarie.AmmoniumConsentration > 25 ) {
					
				}
			}
		}
		
	}
	
	private void Pregnancy() {
		
		for ( int y = 1 ; y < FishArray.length ; y++ ) {
			if ( FishArray[y] != null ) {
				if ( FishArray[y].Sex.equals("Female")) {
					if ( FishArray[y].Pregnant == true ) {
						if ( FishArray[y].PregnancyTime >= 14.0 ) {
							FishArray[y].PregnancyTime = 0;
							FishArray[y].Pregnant = false;
							int AntallUnger = (int)(15.0 * Math.random()) + 5;
							for ( int x = 1 ; x < AntallUnger ; x++ ) {
								CreateFish();
							}
						}
					} else {
						if ( Males > 0 ) {
							if ( (100.0 * Math.random()) >= MalesPerFemale ) {
								FishArray[y].Pregnant = true;
							}
						}
					}
				}
			}
		}
		
	}
	
	public void FeedFish() {

		for ( int y = 1 ; y < FishArray.length ; y++ ) {
			if ( FishArray[y] != null ) {
				FishArray[y].HealthPoints = 100;
			}
		}
		UpdateFishInfo();
		
	}
	
	public void UpdateFishInfo() {
		
		AvgHealthPoints = 0;
		Females = 0;
		Males = 0;
		Fry = 0;
		CMFishPerLiter = 0;
		SickFish = 0;
		AvgAge = 0;
		for ( int y = 1 ; y < FishArray.length ; y++ ) {
			if ( FishArray[y] != null ) {
				AvgHealthPoints = AvgHealthPoints + FishArray[y].HealthPoints;
				//System.out.println("FishArray[y].HealthPoints="+FishArray[y].HealthPoints);
				if ( FishArray[y].Sex.equals("Female") ) {
					Females ++;
				} else if ( FishArray[y].Sex.equals("Male") ) {
					Males ++;
				} else {
					Fry ++;
				}
				CMFishPerLiter = CMFishPerLiter + FishArray[y].CMSize;
				if ( FishArray[y].SykdomsID > 0 ) {
					SickFish ++;
				}
				AvgAge = AvgAge + FishArray[y].DaysAge;
			}
		}
		MalesPerFemale = Males / (Females*1.0);
		AvgHealthPoints = (int)Math.floor(AvgHealthPoints / (FishInArray*1.0));
		CMFishPerLiter = (int)Math.floor((CMFishPerLiter / Class_Communicator.Class_Brain_Akvarie.VannIAkvarie)*100);
		CMFishPerLiter = CMFishPerLiter / 100;
		AvgAge = (int)Math.floor(AvgAge / (FishInArray*1.0));

	}
	
}
