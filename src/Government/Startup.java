package Government;


public class Startup {
	public static void main(String[] args) throws Exception {
		System.out.println("Starting AkvaMini");

		Communicator Class_Communicator = new Communicator();
		Class_Communicator.SetupProgram();
		Class_Communicator.Startup();
		
	}
}
