package Fisk;

public class Super_Species {
	
	String Species;
	
	double Species_MaxSize; //voksen normalstørrelse
	double Species_MaxAge; //days, alderdomsdød
	
	String Diet; //Carnivorous\Omnivorous\Herbivorous
	
	public Super_Species(String Species) {
		
		this.Species = Species;
		Species_Settings();
		
	}
	
	private void Species_Settings() {
		
		if ( Species.equals("Guppy")) {
			Species_MaxSize = 4;
			Species_MaxAge = 360;
			Diet = "Omnivorous";
		}
		
	}

}
