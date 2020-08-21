package Main;

import java.io.File;
import java.io.IOException;
import java.util.*;

import GridLocations.Grid;
import GridLocations.Robot;

public class Game {
	
	private TUI Tui;
	private Grid grid;
	private LinkedList<Robot> robots;
	public void startGame(File file) {
		
		// Here is where we would read commands from file
		
		robots = new LinkedList<Robot>();
		var moves = new LinkedList<Character>(); 
		
		moves.add('F');
		moves.add('U');
		moves.add('F');
		moves.add('L');
		moves.add('R');
		
		robots.add(new Robot(moves));

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

		    int fps = 1; //number of update per second.
		    double tickPerSecond = 60/fps;
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
		
		
		for(int i = 0; i < robots.size(); i++) {
			var robot = robots.remove();
			
			robot.act();
			
			// Do the act method to see what the next move is
			
			robots.add(robot);
			
		}
		
		robots.add(robots.remove());
		// loop through row then column
		
		//for(int i = 0; i < grid.entities.size(); i++) {
			//var entity = grid.entities[i];
			
			//entity.act();
		//}
		
		/**
		 * Whose turn is it
		 * List of players do their turn
		 * Have ordered List of players and after the player is done goes to the back
		 * 
		 *  Make gridEntity public and call it in here
		 *  Loop through board
		 *  
		 *  robot separate from board or give everything co-ords giving positions
		 *  loop thru all entities 
		 *  
		 *  have 2 lists one for robots and one for everything else
		 *  2d array of all the extras 
		 *  another 2d array of robots
		 *  
		 *  Send outcome to consle that robot has flag
		 *  
		 *  ---------------------------------------------------------------------------------------------
		 *  
		 *  create 2d array of entity and then have all the extras on the board - The Board (Grid)
		 *  in here have list of robots (list of players) - set of co-oridnates x and y
		 *  print method (grid class) - loop thru 2d array before printing each entity check if it has robot 
		 *  if it does then print robot
		 *  
		 *  tic()
		 *  whose turn it is
		 *  update co-ords depending on whose turn it is 
		 *  if co-ords same the push the other robot away
		 *  then loop through the 2d array of entities
		 *  tell them to act - activation stuff
		 * 
		 */
	}	
}
