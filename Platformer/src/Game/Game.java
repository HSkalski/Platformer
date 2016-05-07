package Game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{

	public static final String TITLE = "Chicken Logic (Beta Build 0.0.1)";
	public static final int menu = 0; 
	public static final int play = 1;
	public static final int intro = 2;
	
	public static final int WIDTH = 640;
	public static final int HEIGHT = 360;
	
	public static final int TARGET_FPS = 144;
	
	public Game(String gameName) {
		super(gameName);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new Intro(intro));
		
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(intro).init(gc, this);
		this.enterState(menu);
		
	}
	
	public static void main(String[] args) {
		AppGameContainer mainWindow;
		
		try{
			
			mainWindow = new AppGameContainer(new Game(TITLE));
			mainWindow.setDisplayMode(WIDTH, HEIGHT, false);
			mainWindow.setTargetFrameRate(TARGET_FPS);
			mainWindow.start();
			
		}catch(SlickException e){
			e.printStackTrace();
		}	
	}
}
