package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import GridLocations.Grid;
import GridLocations.Robot;
import Main.Game;

public class PitTest {

	@Test
	public void pitTest() throws FileNotFoundException, IOException {
		
		//Arrange
		String relativePath = new File("").getAbsolutePath();
		File file = new File(relativePath + "/Tests/our-board/pit.brd");
		Grid game = new Grid(file);
		Robot r = new Robot('A');
		var startingX = r .startingX;
		
	
		//Act
		r.moveBackwards();
		r.rotateLeft();
		r.rotateRight();
		r.moveForward();
		r.moveBackwards();
		
		var endingX = r.x;
		
		assertEquals(startingX, endingX);
	}

}
