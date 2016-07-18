package Government;

public class Brain_GameStatus {

	public int Cash = 0;
	
	int GameTicks = 0;
	public int Year = 1;
	public int Month = 1;
	public int Day = 1;
	public int Hour = 1;
	
	public void GameTick() {
		GameTicks ++;
		
		Hour ++;
		if ( Hour > 24 ) {
			Hour = 1;
			
			Day ++;
			if ( Day > 30 ) {
				Day = 1;
				
				Month ++;
				if ( Month > 12 ) {
					Month = 1;
					
					Year ++;
				}
			}
		}
	}
}
