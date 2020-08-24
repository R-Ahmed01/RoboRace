package Main;

import java.io.File;
import java.io.IOException;
import java.util.*;

import GridLocations.EmptyTile;
import GridLocations.Grid;
import GridLocations.Robot;

public class Game {
	
	private TUI tui;
	private Grid grid;
	private LinkedList<Robot> robots;
	private boolean running;
	public void startGame(File file) {
		
		// Here is where we would read commands from file
		
		robots = new LinkedList<Robot>();
		try {
			grid = new Grid(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < grid.entities.length; i++) {
			for(int j = 0; j < grid.entities[i].length; j++) {
				var entity = grid.entities[i][j];
				if(entity instanceof Robot) {//found robots in list of entities
					Robot robot = (Robot)entity; //casting entity to a robot
					robots.add(robot);//add robots to list of robots
					robot.startingX = j;//set starting positions that remain
					robot.startingY = i;
					robot.x = j;//set starting positions that chnage
					robot.y = i;
					grid.entities[i][j] = new EmptyTile();//replace robots with empty tile in list of entities
					//robot is no longer in list of entities but is in list of robots seperate
					//robots are seperate and have coordinates
					
				}
			}
		}
		Collections.sort(robots, new RobotSorter());
		
		 init(); //initialisation of images, sound..etc. will be executed once only
		 render();
		    int fps = 1; //number of update per second.
		    double tickPerSecond = 60/fps;
		    double delta = 0;
		    long now;
		    long lastTime = System.nanoTime();
		    running = true;

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
		
		tui = new TUI();
		
	}
	
	private void render() {
		tui.showBoard(grid, robots);
	}
	
	private void promptForPlayerMoves() {
		for(int i = 0; i < robots.size(); i++) {
			System.out.println("Player " + robots.get(i));
			String moves = tui.promptMoves();
			while (!tui.areMovesValid(moves)) {
				moves = tui.promptMoves();
			}	
			LinkedList<Character> movesList = new LinkedList<Character>();
			for(char c:moves.toCharArray()) {
				movesList.add(c);
			}
			robots.get(i).storedActions(movesList);
		}
	}
	
	private void tick() {
		if(!robots.getFirst().hasActions()) {
			promptForPlayerMoves();
		}
		for(int i = 0; i < robots.size(); i++) {
			var robot = robots.remove();
			
			robot.turn();//take the list of robots and decide if bumping and push
			
			// Do the act method to see what the next move is
			
			robots.add(robot);			
		}
		render();
		robots.add(robots.remove());
		for(int i = 0; i < grid.entities.length; i++) {
			for(int j = 0; j < grid.entities[i].length; j++) {
				var entity = grid.entities[i][j];//entity at position
				var robot = grid.robotAtPosition(robots, j, i);//robot at position
				entity.act(robot);//If entity is a robot dont act
				if(robot != null && robot.flag == 4) {
					running = false;
					System.out.println("Player " + robot.robot + " has won!");
				}
			}
		}
		
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
