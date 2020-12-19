package TileRPG;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class pauseMenu extends BasicGameState {
	private Image background;
	private static final int numberofchoices = 4;
	private static final int Continue = 0;
	private static final int Save = 1;
	private static final int Load = 2;
	private static final int Quit = 3;
	private Image[] buttons = new Image[4];
	private String[] playersOptions = new String[numberofchoices];
	private int playersChoice, stateid;
	private Color chosen = new Color(255, 0, 255);
	private saveload fileio = new saveload();
	private Vector2f heropos = new Vector2f(0, 0);

	public pauseMenu(int id) {
		stateid = id;
	}

	public int getID() {
		return 4;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		buttons[0] = new Image("res/continue.png");
		buttons[1] = new Image("res/save.png");
		buttons[2] = new Image("res/pauseload.png");
		buttons[3] = new Image("res/quit.png");
		playersOptions[0] = "Continue";
		playersOptions[1] = "Save";
		playersOptions[2] = "Load";
		playersOptions[3] = "Quit";
		background = new Image("res/start2.png");
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyPressed(Input.KEY_S) || input.isControlPressed(3, 3)) {
			if (playersChoice == (numberofchoices - 1)) {
				playersChoice = 0;
			} else {
				playersChoice++;
			}
		}
		if (input.isKeyPressed(Input.KEY_W) || input.isControlPressed(2, 3)) {
			if (playersChoice == 0) {
				playersChoice = numberofchoices - 1;
			} else {
				playersChoice--;
			}
		}
		if (input.isKeyPressed(Input.KEY_ENTER) || input.isControlPressed(5, 3)) {
			switch (playersChoice) {
			case Continue:
				sbg.enterState(Main.play, new FadeOutTransition(), new FadeInTransition());
				break;
			case Save:
				heropos = ((Play) sbg.getState(Main.play)).getHeroPosition();
				fileio.save(heropos);
				sbg.enterState(Main.play, new FadeOutTransition(), new FadeInTransition());
				break;
			case Load:
				heropos = fileio.loadSave();
				((Play) sbg.getState(Main.play)).setHeroPosition(heropos);
				sbg.enterState(Main.play, new FadeOutTransition(), new FadeInTransition());
				break;
			case Quit:
				sbg.enterState(Main.menu, new FadeOutTransition(), new FadeInTransition());
				break;
			}
		}
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(0, 0);
		renderPlayersOptions();
	}

	private void renderPlayersOptions() {
		for (int i = 0; i < numberofchoices; i++) {
			if (playersChoice == i) {
				buttons[i].draw(700, i * 65 + 500, chosen);
			} else {
				buttons[i].draw(700, i * 65 + 500);
			}
		}
	}
}
