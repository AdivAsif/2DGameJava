package TileRPG;

//imports needed are typical slick methods, transitions for entering/exiting states. Vector for save/load
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

//newMenu as the old menu was very basic and was more of a test state, this will be the final iteration of the menu state
public class newMenu extends BasicGameState {
	/*
	 * make objects of background, title, switch and case block needed, so integers
	 * needed. Image array, for loop rendering the buttons, and /*colour for a
	 * "highlight" effect on the buttons. Object calling saveload to allow a saving
	 * and loading feature, so make an object of the vector - as the position of the
	 * characters should be saved in a text file
	 */
	private Image background, title;
	private static final int numberofchoices = 3; // maximum number of available choices
	private static final int start = 0;
	private static final int load = 1;
	private static final int quit = 2;
	private Image[] buttons = new Image[3];
	private int playersChoice; // switch(playersChoice)... case based on start, load, quit
	private int stateid;
	private Color chosen = new Color(255, 0, 255); // purple/magenta
	private saveload fileio = new saveload();
	private Vector2f heropos = new Vector2f(0, 0);
	private Music music; // not copystrike-free music, it is music from Fire Emblem: Fates

	public newMenu(int id) {
		stateid = id;
	}

	public int getID() {
		return stateid;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		playersChoice = 0;
		buttons[0] = new Image("res/newnewPlay.png");
		buttons[1] = new Image("res/newnewLoad.png");
		buttons[2] = new Image("res/newnewExit.png");
		background = new Image("res/start2.png");
		title = new Image("res/title.png");
		music = new Music("res/05FarDawnverAC.ogg");
		music.loop(1.0f, 0.5f);
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
			case start:
				sbg.enterState(Main.map, new FadeOutTransition(), new FadeInTransition());
				break;
			case load:
				heropos = fileio.loadSave();
				((Play) sbg.getState(Main.play)).setHeroPosition(heropos);
				sbg.enterState(Main.play, new FadeOutTransition(), new FadeInTransition());
				break;
			case quit:
				gc.exit();
				break;
			}
		}
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(0, 0);
		title.draw(400, 25);
		renderPlayersOptions();
	}

	private void renderPlayersOptions() {
		for (int i = 0; i < numberofchoices; i++) {
			if (playersChoice == i) {
				buttons[i].draw(700, i * 100 + 500, chosen);
			} else {
				buttons[i].draw(700, i * 100 + 500);
			}
		}
	}
}
