package Main;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import GridLocations.EmptyTile;
import GridLocations.Grid;
import GridLocations.Robot;
/**
 * The Game Class
 * 
 * @author Team 13: Daniel, Hayley, Rifath
 * 
 * Handles the start and running of the game
 */
public class Game {
	
	private TUI tui;
	private Grid grid;
	private LinkedList<Robot> robots;
	private boolean running;
	
	/**
	 * Start game is responsible for what we see and know at the start of the game,
	 * from displaying board entities read from a board file, to knowing entity and 
	 * robot positions.
	 * @param file
	 */
	public void startGame(File file) {
		robots = new LinkedList<Robot>();
		try {
			grid = new Grid(file);
		} catch (IOException e) {
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
					robot.x = j;//set starting positions that change
					robot.y = i;
					grid.entities[i][j] = new EmptyTile();//replace robots with empty tile in list of entities
					//robot is no longer in list of entities but is in list of robots separate
					//robots are separate and have coordinates	
				}
			}
		}
		Collections.sort(robots, new RobotSorter());
		
		/**
		 * Responsible for speed that board graphics update in console during robot moves
		 */
		init();//initialise once
		render();
	    int fps = 1;//updates per second
	    double delta = 0;
	    long now;
	    long lastTime = System.nanoTime();
	    running = true;
	    while(running){
	        now = System.nanoTime();
	        delta += (now - lastTime)*fps;
	        lastTime = now;
	        if(delta >= 1e9){
	            tick();
	            delta=0;
	        }
	    }    
	}
	
	/**
	 * Initialises TUI
	 */
	private void init() {
		tui = new TUI();
	}
	
	/**
	 * Renders the grid and robots
	 */
	private void render() {
		tui.showBoard(grid, robots);
	}
	
	/**
	 * Prompt for player moves with Player who's turn it is
	 */
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
	
	/**
	 * One tick is one move for one player.
	 * Tick determines who's move it is, 
	 * updates coordinates, loops through entities
	 * and tells them to act based on location. 
	 */
	private void tick() {
		if(!robots.getFirst().hasActions()) {
			promptForPlayerMoves();
		}
		for(int i = 0; i < robots.size(); i++) {
			var robot = robots.remove();
			robot.turn(robots);
			robots.add(robot);	
			render();
			try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		robots.add(robots.remove());
		for(int i = 0; i < grid.entities.length; i++) {
			for(int j = 0; j < grid.entities[i].length; j++) {
				var entity = grid.entities[i][j];//entity at position
				var robot = grid.robotAtPosition(robots, j, i);//robot at position
				entity.act(robot);//If entity is a robot don't act
				if(robot != null && robot.flag == 4) {//determines winner
					running = false;
					System.out.println("Player " + robot.robot + " has won!");
				}
			}
		}
	}	
}
