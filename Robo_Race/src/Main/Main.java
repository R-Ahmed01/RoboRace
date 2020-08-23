package Main;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		String relativePath = new File("").getAbsolutePath();
		File file = new File(relativePath + "/Tests/boards/only-pits.brd");
		
		Game game = new Game();
		game.startGame(file);
	}
}
