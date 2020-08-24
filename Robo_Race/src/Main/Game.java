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
					robot.x = j;//set starting positions that chnage
					robot.y = i;
					grid.entities[i][j] = new EmptyTile();//replace robots with empty tile in list of entities
					//robot is no longer in list of entities but is in list of robots seperate
					//robots are seperate and have coordinates	
				}
			}
		}
		Collections.sort(robots, new RobotSorter());
		
		 init();
		 render();
		    int fps = 1;
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
			robot.turn(robots);
			robots.add(robot);			
		}
		render();
		robots.add(robots.remove());
		for(int i = 0; i < grid.entities.length; i++) {
			for(int j = 0; j < grid.entities[i].length; j++) {
				var entity = grid.entities[i][j];
				var robot = grid.robotAtPosition(robots, j, i);
				entity.act(robot);
				if(robot != null && robot.flag == 4) {
					running = false;
					System.out.println("Player " + robot.robot + " has won!");
				}
			}
		}
	}	
}
