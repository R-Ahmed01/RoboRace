package Main;

import java.io.File;
import java.io.IOException;

import GridLocations.Grid;

public class Game {
	
	private TUI Tui;
	private Grid grid;
	public void startGame(File file) {

		try {
			grid = new Grid(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    	/**
	    	 * A Loop that checks Player 1 enters 5 actions, then 2 and so on
	    	 * When last player has entered actions, Robot 1 does first action, then robot 2
	    	 * does first action until last robot has completed first action. When first round 
	    	 * of actions are done, board activates and then based on grid locations act().Then 
	    	 * robots do second action but starts with player 2.
	    	 * 
	    	 * ** This is Turn Based **
	    	 */
		
		 init(); //initialisation of images, sound..etc. will be executed once only

		    int fps = 10; //number of update per second.
		    double tickPerSecond = 10/fps;
		    double delta = 0;
		    long now;
		    long lastTime = System.nanoTime();
		    boolean running = true;

		    while(running){

		        now = System.nanoTime();
		        delta += (now - lastTime)/tickPerSecond;
		        lastTime = now;

		        if(delta >= 1){

		            tick();
		            render();
		            delta--;
		        }
		    }

	       
	}
	private void init() {
		
		Tui = new TUI();
		
	}
	private void render() {
		grid.render();
		Tui.Render();
		
	}
	private void tick() {
		// TODO Auto-generated method stub
		
	}	
}
