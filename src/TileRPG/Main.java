package TileRPG;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

//StateBasedGame, as there will be different states the game is in, such as splash, menu, etc.
public class Main extends StateBasedGame {
	// store the name of the game into a variable, less repetition of the name,
	// saving time
	public static final String gamename = "Kross's Conquest";
	public static final int menu = 0;
	public static final int map = 1;
	public static final int stage = 2;
	public static final int play = 3;
	public static final int pause = 4;

	// constructor
	public Main(String gamename) {
		// title of game is on window title
		super(gamename);
		this.addState(new newMenu(menu));
		this.addState(new newMap(map));
		this.addState(new stageselect(stage));
		this.addState(new Play(play));
		this.addState(new pauseMenu(pause));
	}

	// initialise states
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(map).init(gc, this);
		this.getState(stage).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(pause).init(gc, this);
		this.enterState(menu);
	}

	/*
	 * different aspects of the game can be set here, such as max fps, window size,
	 * etc. slick2d makes it very simple to create a window, so long as the logic of
	 * the states is correct.
	 */
	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			int width = 1600;
			int height = 960;
			int maxFPS = 60;
			appgc = new AppGameContainer(new Main(gamename));
			appgc.setDisplayMode(width, height, false);
			appgc.setTargetFrameRate(maxFPS);
			appgc.setIcon("res/Icon.png");
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
