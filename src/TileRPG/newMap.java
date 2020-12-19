package TileRPG;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class newMap extends BasicGameState {
	private int stateid;
	private static final int numberofchoices = 3;
	public static int playersChoice;
	private Image overworld, castle1, castle2, castle3;
	private Color filter;

	public newMap(int id) {
		stateid = id;
	}

	public int getID() {
		return 1;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		playersChoice = 0;
		overworld = new Image("res/finalmap.png");
		castle1 = new Image("res/castleIcon.png");
		castle2 = new Image("res/castle1Icon.png");
		castle3 = new Image("res/castle2Icon.png");
		filter = new Color(255, 0, 255);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// quality of life changes such as adding colour filters implemented
		overworld.draw(0, 0);
		if (playersChoice == 0) {
			castle1.draw(32, 20, filter);
		}
		if (playersChoice == 1) {
			castle2.draw(600, 480, filter);
		}
		if (playersChoice == 2) {
			castle3.draw(1144, 99, filter);
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyPressed(Input.KEY_D) || input.isControlPressed(1, 3)) {
			if (playersChoice == (numberofchoices - 1)) {
				playersChoice = 0;
			} else {
				playersChoice++;
			}
		}
		if (input.isKeyPressed(Input.KEY_A) || input.isControlPressed(0, 3)) {
			if (playersChoice == 0) {
				playersChoice = numberofchoices - 1;
			} else {
				playersChoice--;
			}
		}
		if (playersChoice == 0 && (input.isKeyPressed(Input.KEY_ENTER) || input.isControlPressed(5, 3))) {
			System.out.println("Castle 1");
			sbg.enterState(Main.stage, new FadeOutTransition(), new FadeInTransition());
		}
		if (playersChoice == 1 && (input.isKeyPressed(Input.KEY_ENTER) || input.isControlPressed(5, 3))) {
			System.out.println("Castle 2");
			sbg.enterState(Main.stage, new FadeOutTransition(), new FadeInTransition());
		}
		if (playersChoice == 2 && (input.isKeyPressed(Input.KEY_ENTER) || input.isControlPressed(5, 3))) {
			System.out.println("Castle 3");
			sbg.enterState(Main.stage, new FadeOutTransition(), new FadeInTransition());
		}
	}
}
