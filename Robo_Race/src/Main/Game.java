package Main;

public class Game {
	
	private TUI Tui;
	
	public void startGame() {
		init(); //initialisation of images, sound..etc. will be executed once only

	    int fps = 60 //number of update per second.
	    double tickPerSecond = 1000000000/fps;
	    double delta = 0;
	    long now;
	    long lastTime = System.nanoTime();

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
		
		Tui.Render();
		
	}
	private void tick() {
		// TODO Auto-generated method stub
		
	}	
}
