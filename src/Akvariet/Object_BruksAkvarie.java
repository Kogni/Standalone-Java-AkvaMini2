package Akvariet;

import Government.Communicator;

public class Object_BruksAkvarie {

	Communicator Class_Communicator;
	
	double Liter_Volum;
	double Liter_Vann;
	
	public Object_BruksAkvarie(Communicator Class_CommunicatorT, double Liter_VolumT) {
		Class_Communicator = Class_CommunicatorT;
		Liter_Volum = Liter_VolumT;
		Liter_Vann = Liter_Volum;
	}
	
	public void VannFordamper() {
		Liter_Vann = Liter_Vann - (Liter_Volum*0.01);
		//System.out.println("Vann i akvariet="+Liter_Vann);
	}
	
}
