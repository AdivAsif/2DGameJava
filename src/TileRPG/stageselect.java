package TileRPG;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class stageselect extends BasicGameState {
	private int stateid;
	private Color filter;
	private Image stages, one, two, three, icon1, icon2, icon3, icon4;
	private static final int numberofchoices1 = 4;
	private static final int numberofchoices2 = 8;
	private static final int numberofchoices3 = 12;
	public static int stageChoice;

	public stageselect(int id) {
		stateid = id;
	}

	public int getID() {
		return 2;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		filter = new Color(120, 0, 120);
		stages = new Image("res/stageselect.png");
		one = new Image("res/mission1.png");
		two = new Image("res/mission2.png");
		three = new Image("res/mission3.png");
		icon1 = new Image("res/fountainIcon.png");
		icon2 = new Image("res/corridorIcon.png");
		icon3 = new Image("res/doorIcon.png");
		icon4 = new Image("res/crownIcon.png");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		stages.draw(0, 0);
		if (newMap.playersChoice == 0) {
			one.draw(720, 100);
			if (stageChoice == 0) {
				icon1.draw(195, 382, filter);
			}
			if (stageChoice == 1) {
				icon2.draw(546, 380, filter);
			}
			if (stageChoice == 2) {
				icon3.draw(880, 376, filter);
			}
			if (stageChoice == 3) {
				icon4.draw(1245, 387, filter);
			}
		}
		if (newMap.playersChoice == 1) {
			two.draw(720, 100);
			if (stageChoice == 4) {
				icon1.draw(195, 382, filter);
			}
			if (stageChoice == 5) {
				icon2.draw(546, 380, filter);
			}
			if (stageChoice == 6) {
				icon3.draw(880, 376, filter);
			}
			if (stageChoice == 7) {
				icon4.draw(1245, 387, filter);
			}
		}
		if (newMap.playersChoice == 2) {
			three.draw(720, 100);
			if (stageChoice == 8) {
				icon1.draw(195, 382, filter);
			}
			if (stageChoice == 9) {
				icon2.draw(546, 380, filter);
			}
			if (stageChoice == 10) {
				icon3.draw(880, 376, filter);
			}
			if (stageChoice == 11) {
				icon4.draw(1245, 387, filter);
			}
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		if (newMap.playersChoice == 0) {
			stageChoice ^= 0;
			if (input.isKeyPressed(Input.KEY_D)) {
				if (stageChoice == (numberofchoices1 - 1)) {
					stageChoice = 0;
				} else {
					stageChoice++;
				}
			}
			if (input.isKeyPressed(Input.KEY_A) || input.isControlPressed(0, 3)) {
				if (stageChoice == 0) {
					stageChoice = numberofchoices1 - 1;
				} else {
					stageChoice--;
				}
			}
			if (stageChoice == 0 && (input.isKeyPressed(Input.KEY_ENTER) || input.isControlPressed(5, 3))) {
				System.out.println("Stage 1");
				sbg.enterState(Main.play, new FadeOutTransition(), new FadeInTransition());
			}
			if (stageChoice == 1 && (input.isKeyPressed(Input.KEY_ENTER) || input.isControlPressed(5, 3))) {
				System.out.println("Stage 2");
				sbg.enterState(Main.play, new FadeOutTransition(), new FadeInTransition());
			}
			if (stageChoice == 2 && (input.isKeyPressed(Input.KEY_ENTER) || input.isControlPressed(5, 3))) {
				System.out.println("Stage 3");
				sbg.enterState(Main.play, new FadeOutTransition(), new FadeInTransition());
			}
			if (stageChoice == 3 && (input.isKeyPressed(Input.KEY_ENTER) || input.isControlPressed(5, 3))) {
				System.out.println("Stage 4");
				sbg.enterState(Main.play, new FadeOutTransition(), new FadeInTransition());
			}
		}
		if (newMap.playersChoice == 1) {
			stageChoice ^= 4;
			if (input.isKeyPressed(Input.KEY_D)) {
				if (stageChoice == (numberofchoices2 - 1)) {
					stageChoice = 4;
				} else {
					stageChoice++;
				}
			}
			if (input.isKeyPressed(Input.KEY_A) || input.isControlPressed(0, 3)) {
				if (stageChoice == 4) {
					stageChoice = numberofchoices2 - 1;
				} else {
					stageChoice--;
				}
			}
			if (stageChoice == 4 && (input.isKeyPressed(Input.KEY_ENTER) || input.isControlPressed(5, 3))) {
				System.out.println("Stage 5");
				sbg.enterState(Main.play, new FadeOutTransition(), new FadeInTransition());
			}
			if (stageChoice == 5 && (input.isKeyPressed(Input.KEY_ENTER) || input.isControlPressed(5, 3))) {
				System.out.println("Stage 6");
				sbg.enterState(Main.play, new FadeOutTransition(), new FadeInTransition());
			}
			if (stageChoice == 6 && (input.isKeyPressed(Input.KEY_ENTER) || input.isControlPressed(5, 3))) {
				System.out.println("Stage 7");
				sbg.enterState(Main.play, new FadeOutTransition(), new FadeInTransition());
			}
			if (stageChoice == 7 && (input.isKeyPressed(Input.KEY_ENTER) || input.isControlPressed(5, 3))) {
				System.out.println("Stage 8");
				sbg.enterState(Main.play, new FadeOutTransition(), new FadeInTransition());
			}
		}
		if (newMap.playersChoice == 2) {
			stageChoice ^= 8;
			if (input.isKeyPressed(Input.KEY_D)) {
				if (stageChoice == (numberofchoices3 - 1)) {
					stageChoice = 8;
				} else {
					stageChoice++;
				}
			}
			if (input.isKeyPressed(Input.KEY_A) || input.isControlPressed(0, 3)) {
				if (stageChoice == 8) {
					stageChoice = numberofchoices3 - 1;
				} else {
					stageChoice--;
				}
			}
			if (stageChoice == 8 && (input.isKeyPressed(Input.KEY_ENTER) || input.isControlPressed(5, 3))) {
				System.out.println("Stage 9");
				sbg.enterState(Main.play, new FadeOutTransition(), new FadeInTransition());
			}
			if (stageChoice == 9 && (input.isKeyPressed(Input.KEY_ENTER) || input.isControlPressed(5, 3))) {
				System.out.println("Stage 10");
				sbg.enterState(Main.play, new FadeOutTransition(), new FadeInTransition());
			}
			if (stageChoice == 10 && (input.isKeyPressed(Input.KEY_ENTER) || input.isControlPressed(5, 3))) {
				System.out.println("Stage 11");
				sbg.enterState(Main.play, new FadeOutTransition(), new FadeInTransition());
			}
			if (stageChoice == 11 && (input.isKeyPressed(Input.KEY_ENTER) || input.isControlPressed(5, 3))) {
				System.out.println("Stage 12");
				sbg.enterState(Main.play, new FadeOutTransition(), new FadeInTransition());
			}
		}
		if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
		}
	}
}
//there was an issue here, if the player selected castle 3, the icons would not be highlighted unless the user presses D 8 times. This is fixed
//but now there is an odd flickering effect on the highlighted icons, from castle 2 onwards.
//another odd issue is that, at a specific frame, if A is pressed, or left on Icon1's position, then there is a glitch where no icons are highlighted
//this most likely will not affect players as they will not intentionally press left on the specific frame - as it is not known to them
//the reason for this may be because of the ^= operator, as the game updates every delta, or every ~17 milliseconds, there is a specific time window
//where the value for stageChoice cannot update in time. This may not affect players on controllers, as the precision in timing is lower than on
//keyboard, however it is possible for end users to experience this.