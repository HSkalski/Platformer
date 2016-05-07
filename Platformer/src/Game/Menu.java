package Game;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState{

	Image background;
	boolean playHover=false;
	boolean exitHover=false;
	public int xpos;
	public int ypos;

	public Menu(int state){
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("res/menu.png");
	}

	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		//Background Draw
		g.drawImage(background,0,0);
		
		//Play Button Draw
		if(playHover==false){
			g.drawRect(75,100,100,100);
			g.drawString("Play", 100, 150);
		}else{
			g.fillRect(75,100,100,100);
			g.drawString("Play", 100, 150);
		}
		
		//Exit Button Draw
		if(exitHover==false){
			g.drawRect(275,100,100,100);
			g.drawString("Exit", 300, 150);
		}else{
			g.fillRect(275,100,100,100);
			g.drawString("Exit", 300, 150);
		}
		
		//Mouse Draw
		g.drawString("X:"+xpos+" Y: "+ypos, 50, 50);
	}

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		xpos = Mouse.getX();
		ypos = Mouse.getY();
		
		
		//Play Button
		if((xpos>75 && xpos<175) && (ypos>160 && ypos<260)){
			playHover = true;
			if(input.isMouseButtonDown(0)){
				sbg.enterState(1);
			}
		}else{playHover = false;}
		
		//Exit Button
		if((xpos>275 && xpos<375) && (ypos>160 && ypos<260)){
			exitHover = true;
			if(input.isMouseButtonDown(0)){
				System.exit(0);
			}
		}else{exitHover = false;}
		
		
	}

	
	public int getID() {
		return 0;
	}
	
	

}
