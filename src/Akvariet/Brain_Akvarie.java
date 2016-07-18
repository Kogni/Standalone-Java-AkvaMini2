package Akvariet;

import Government.Communicator;

public class Brain_Akvarie {

	Communicator Class_Communicator;
	
	//int Akvarie_Vann;
	//int Akvarie_Volum;
	
	public int VannIAkvarie;
	
	double CMRottingBioMaterial[] = new double[8];
	
	public double Ammonium = 0;
	public double AmmoniumConsentration = 0;
	public double Oksygen = 0;
	double OksygenConsentration = 0;
	public double Nitritt = 0;
	double NitrittConsentration = 0;
	public double Nitrat = 0;
	double NitratConsentration = 0;
	public double Svovel = 0;
	double SvovelConsentration = 0;
	public double Hydrogen = 0;
	double HydrogenConsentration = 0;
	public double Nitrogen = 0;
	double NitrogenConsentration = 0;
	
	int Befolkning_BaktA = 10;
	int Befolkning_BaktB = 10;
	int Befolkning_BaktC = 10;
	
	public Brain_Akvarie(Communicator Class_CommunicatorT) {
		//System.out.println(this.getClass().toString()+" startet");
		Class_Communicator = Class_CommunicatorT;
		
		VannIAkvarie = Class_Communicator.Class_Brain_Equipment.InUse_Akvarie.Bonuser.WaterCapacity;
	}
	
	public void VannFordamper() { //per TIME
		
		VannIAkvarie = VannIAkvarie - (int)(Class_Communicator.Class_Brain_Equipment.InUse_Akvarie.Bonuser.WaterCapacity*0.01);
		
	}
	
	public void Biomaterial_StartsRotting(double CM_Material) {
		CMRottingBioMaterial[7] = CMRottingBioMaterial[7] + CM_Material;
		//System.out.println("Bio materiale addet til råtnearray="+CMRottingBioMaterial[7]);
	}
	
	public void Biomaterial_IsRotting() { //per TIME
		Ammonium = Ammonium + CMRottingBioMaterial[0];
		
		CMRottingBioMaterial[0] = CMRottingBioMaterial[1];
		CMRottingBioMaterial[1] = CMRottingBioMaterial[2];
		CMRottingBioMaterial[2] = CMRottingBioMaterial[3];
		CMRottingBioMaterial[3] = CMRottingBioMaterial[4];
		CMRottingBioMaterial[4] = CMRottingBioMaterial[5];
		CMRottingBioMaterial[5] = CMRottingBioMaterial[6];
		CMRottingBioMaterial[6] = CMRottingBioMaterial[7];
		CMRottingBioMaterial[7] = 0;
		
		NitriteCyclus();
	}
	
	private void NitriteCyclus() {
		
		//2x ammonium + 3x oksygen = 2x nitrogen + 2x vann + 4x (?)
		for ( int A = 1 ; (A*10) <= Befolkning_BaktA ; A++ ) {
			//A=1 A<= 10/1000(1/100)
			//A=1 A<= 10*1000(10'000)
			//A=1 (A*10) <= 10
			if ( Ammonium >= 2 ) {
				if ( Oksygen >= 3 ) {
					Ammonium = Ammonium - 2;
					Oksygen = Oksygen - 3;
					Nitritt = Nitritt + 2; 
					Befolkning_BaktA = Befolkning_BaktA + 1; //per 10 bakterier som fôres, blir 1 ny bakterie født
				}
			}
		}
		
		//2x nitritt + 1x oksygen = 2x nitrat
		for ( int A = 1 ; (A*10) <= Befolkning_BaktB ; A++ ) {
			if ( Nitritt >= 2 ) {
				if ( Oksygen >= 1 ) {
					Nitrat = Nitrat + 2; 
					Befolkning_BaktB = Befolkning_BaktB + 1; //per 10 bakterier som fôres, blir 1 ny bakterie født
				}
			}
		}
		
		//2x nitrat + 1x svovel + 12x hydrogen = 1x nitrogen
		for ( int A = 1 ; (A*10) <= Befolkning_BaktC ; A++ ) {
			if ( Nitrat >= 2 ) {
				if ( Svovel >= 1 ) {
					if ( Hydrogen >= 12 ) {
						Nitrogen = Nitrogen + 1; 
						Befolkning_BaktC = Befolkning_BaktC + 1; //per 10 bakterier som fôres, blir 1 ny bakterie født
					}
				}
			}
		}
		
		AmmoniumConsentration = Ammonium / VannIAkvarie;
		OksygenConsentration = Oksygen / VannIAkvarie;
		NitrittConsentration = Nitritt / VannIAkvarie;
		NitratConsentration = Nitrat / VannIAkvarie;
		SvovelConsentration = Svovel / VannIAkvarie;
		HydrogenConsentration = Hydrogen / VannIAkvarie;
		NitrogenConsentration = Nitrogen / VannIAkvarie;
		
	}
	
}
