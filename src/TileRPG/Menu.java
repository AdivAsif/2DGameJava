package TileRPG;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
	private Image background;
	private Image title;
	private Image playNow;
	private SpriteSheet playSheet;
	private Animation playAnimation;;
	private Image exitGame;
	private SpriteSheet exitSheet;
	private Animation exitAnimation;

	public Menu(int state) {
	}

	// initialise
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("res/start2.png");
		title = new Image("res/title.png");
		playNow = new Image("res/play.png");
		playSheet = new SpriteSheet("res/playAni.png", 400, 200);
		playAnimation = new Animation(playSheet, 100);
		exitGame = new Image("res/exit.png");
		exitSheet = new SpriteSheet("res/exitAni.png", 400, 200);
		exitAnimation = new Animation(exitSheet, 100);
	}

	// render
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		background.draw(0, 0);
		title.draw(400, 25);
		playNow.draw(600, 475);
		exitGame.draw(600, 700);
		if ((posX > 605 && posX < 995) && (posY > 290 && posY < 475)) {
			playAnimation.draw(600, 475);
		}
		if ((posX > 605 && posX < 995) && (posY > 65 && posY < 250)) {
			exitAnimation.draw(600, 700);
		}
	}

	// update
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		// playNow button
		if ((posX > 605 && posX < 995) && (posY > 290 && posY < 475)) {
			if (Mouse.isButtonDown(0)) {
				sbg.enterState(1);
			}
		}
		// exitGame button
		if ((posX > 605 && posX < 995) && (posY > 65 && posY < 250)) {
			if (Mouse.isButtonDown(0)) {
				System.exit(0);
			}
		}
	}

	// returns ID
	public int getID() {
		return 0;
	}
}