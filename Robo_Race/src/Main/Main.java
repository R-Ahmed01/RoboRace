package Main;
import java.io.File;
/**
 * The Main Class
 * 
 * @author Team 13: Daniel, Hayley, Rifath
 * 
 */
public class Main {

	/**
	 * The main method is the entry point of the application. 
	 * It's also where we set the board file.
	 * @param args
	 */
	public static void main(String[] args) {
		String relativePath = new File("").getAbsolutePath();
		File file = new File(relativePath + "/Tests/our-board/our-board.brd");
		
		Game game = new Game();
		game.startGame(file);
	}
}
