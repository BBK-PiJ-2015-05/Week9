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
	public void testsGetNextStateZeroNeighbours(){
		assertEquals(State.DEAD, testGame.getNextState(State.LIVE, 0));
		assertEquals(State.DEAD, testGame.getNextState(State.DEAD, 0));
	}
	
	@Test
	public void testsGetNextStateOneNeighbours(){
		assertEquals(State.DEAD, testGame.getNextState(State.LIVE, 1));
		assertEquals(State.DEAD, testGame.getNextState(State.DEAD, 1));
	}
	
	@Test
	public void testsGetNextStateBetweenFourAndEightNeighbours(){
		for(int i = 4; i < 9; i++){
			assertEquals(State.DEAD, testGame.getNextState(State.LIVE, i));
		}
	}

	@Test
	public void testsGetNextStateIfDeadAndTwoNeighbours(){
		assertEquals(State.DEAD, testGame.getNextState(State.DEAD, 2));
	}
	
	@Test
	public void testsGetNextStateThreeNeighboursAlive(){
		assertEquals(State.LIVE, testGame.getNextState(State.LIVE, 3));
		assertEquals(State.LIVE, testGame.getNextState(State.DEAD, 3));
	}
}