import org.junit.*;
import static org.junit.Assert.*;

/**
* Week 9, day 17
* Game of Life
* Sarah Connor
*/

public class TestGame{

	private GameOfLife testGame;
	
	@Before
	public void initialise(){
		testGame = new GameOfLife();
	}
	
	@Test
	public void testsGetNextStateLIVE(){
		assertEquals(State.LIVE, testGame.getNextState(State.LIVE, 2));
		assertEquals(State.LIVE, testGame.getNextState(State.DEAD, 3));
		
	}
	
	@Test
	public void testsGetNextStateDEAD(){
		assertEquals(State.DEAD, testGame.getNextState(State.LIVE, 0));
		assertEquals(State.DEAD, testGame.getNextState(State.LIVE, 4));
		assertEquals(State.DEAD, testGame.getNextState(State.DEAD, 2));
		assertEquals(State.DEAD, testGame.getNextState(State.DEAD, 8));
	}

}