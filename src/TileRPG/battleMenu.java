package TileRPG;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class battleMenu {
	private Image battlemenu, battle, end;
	private static final int numberofchoices = 2;
	public static int battleChoice;
	private Color filter;

	public battleMenu() throws SlickException {
		battlemenu = new Image("res/battleMenu.png");
		battle = new Image("res/battleMenuBattle.png");
		end = new Image("res/battleMenuEnd.png");
		filter = new Color(255, 0, 255);
		battleChoice = 0;
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta, Play ps) throws SlickException {
		Input input = gc.getInput();
		if (input.isKeyPressed(Input.KEY_S) || input.isControlPressed(1, 3)) {
			if (battleChoice == (numberofchoices - 1)) {
				battleChoice = 0;
			} else {
				battleChoice++;
			}
		}
		if (input.isKeyPressed(Input.KEY_W) || input.isControlPressed(0, 3)) {
			if (battleChoice == 0) {
				battleChoice = numberofchoices - 1;
			} else {
				battleChoice--;
			}
		}
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g, Play ps) throws SlickException {
		battlemenu.draw(ps.getHeroPosition().getX() + 100, ps.getHeroPosition().getY() - 100);
		battle.draw(ps.getHeroPosition().getX() + 100, ps.getHeroPosition().getY() - 40);
		end.draw(ps.getHeroPosition().getX() + 100, ps.getHeroPosition().getY() + 60);
		if (battleChoice == 0) {
			battle.draw(ps.getHeroPosition().getX() + 100, ps.getHeroPosition().getY() - 40, filter);
		}
		if (battleChoice == 1) {
			end.draw(ps.getHeroPosition().getX() + 100, ps.getHeroPosition().getY() + 60, filter);
		}
	}
}
