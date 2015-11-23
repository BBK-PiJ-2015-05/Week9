/**
* Week 9, day 17
* Game of Life
* Sarah Connor
*/

public class GameOfLife{


	public static State getNextState(State current, int neighbourCount){
		if(neighbourCount == 3 || (neighbourCount == 2 && current == State.LIVE)){
			return State.LIVE;
		}else{
			return State.DEAD;
		}
	}
}