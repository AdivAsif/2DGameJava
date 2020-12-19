package TileRPG;

import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;

public class Map extends BasicGameState {
	public int maps;
	TiledMap map, map2, map3, map4;

	public Map(int state) {
	}

	// initialise
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		maps = 0;
		map = new TiledMap("res/map.tmx");
		map2 = new TiledMap("res/map2.tmx");
		map3 = new TiledMap("res/map3.tmx");
		map4 = new TiledMap("res/map4.tmx");
	}

	// render
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setColor(Color.black);
		if (maps == 0) {
			map.render(0, 0);
			g.drawString("MAP 1", 790, 450);
		}
		if (maps == 1) {
			map2.render(0, 0);
			g.drawString("MAP 2", 790, 450);
		}
		if (maps == 2) {
			map3.render(0, 0);
			g.drawString("MAP 3", 790, 450);
		}
		if (maps == 3) {
			map4.render(0, 0);
			g.drawString("MAP 4", 790, 450);
		}
	}

	// update
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		if (maps < 0) {
			maps++;
		}
		if (maps > 6) {
			maps--;
		}
		if (input.isKeyPressed(Input.KEY_D) || input.isControlPressed(1, 3)) {
			maps++;
		}
		if (input.isKeyPressed(Input.KEY_A) || input.isControlPressed(0, 3)) {
			maps--;
		}
		if (input.isKeyPressed(Input.KEY_ENTER) || input.isControlPressed(5, 3)) {
			sbg.enterState(2);
		}
		if (input.isKeyPressed(Input.KEY_ESCAPE) || input.isControlPressed(13, 3)) {
			sbg.enterState(0);
		}
	}

	// returns ID
	public int getID() {
		return 1;
	}
}
