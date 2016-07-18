package Utstyr;

import Standalone.Object_Stats;

public class Object_Equipment {

	String Name;
	String Slot;
	Boolean InUse;
	Boolean Owned;
	
	int Age_Hours = 0;
	int QualityLevel; //bestemmer hvor fort itemet får redusert virkning
	
	public Object_Stats Bonuser;
	
	public Object_Equipment(String Name, Object_Stats Stats) {
		this.Name = Name;
		//this.Slot = Slot;
		this.InUse = false;
		this.Owned = false;
		
		this.Bonuser = Stats;
	}
	
}
