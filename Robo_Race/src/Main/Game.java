package Main;

public class Game {
	
	private TUI Tui;
	
	public void startGame() {


	    	/**
	    	 * A Loop that checks Player 1 enters 5 actions, then 2 and so on
	    	 * When last player has entered actions, Robot 1 does first action, then robot 2
	    	 * does first action until last robot has completed first action. When first round 
	    	 * of actions are done, board activates and then based on grid locations act().Then 
	    	 * robots do second action but starts with player 2.
	    	 * 
	    	 * ** This is Turn Based **
	    	 */

	       
	}
	private void init() {
		
		Tui = new TUI();
		
	}
	private void render() {
		
		Tui.Render();
		
	}
	private void tick() {
		// TODO Auto-generated method stub
		
	}	
}
