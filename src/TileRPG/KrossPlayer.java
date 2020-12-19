package TileRPG;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class KrossPlayer {
	private SpriteSheet krossSheet;
	private Animation Kross;
	private Vector2f pos;
	public static int count;
	public static boolean playersTurn;
	private static final int animationSpeed = 140;
	private static final float speed = 0.1f;
	private int w, h, onetile, mov;
	public static int hp, atk, spd, lck, dfc, lv, exp;
	information info;

	public KrossPlayer(float x, float y) throws SlickException {
		SpriteSheet krossSheet = new SpriteSheet("res/Kross2.png", 80, 80);
		onetile = 80;
		w = krossSheet.getSprite(0, 0).getWidth();
		h = krossSheet.getSprite(0, 0).getHeight();
		pos = new Vector2f(x, y);
		Kross = new Animation(krossSheet, animationSpeed);
		info = new information();
		info.krossStats();
		count = 0;
		playersTurn = true;
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta, Play ps) {
		Kross.update(delta);
		Input input = gc.getInput();
		mov = info.krossAttribs[6];
		if (playersTurn == true) {
			if (input.isKeyPressed(Input.KEY_W) || input.isControlPressed(2, 3)) {
				if (!ps.isBlocked(pos.x + w - 4, pos.y - delta * speed)
						&& !ps.isBlocked(pos.x + 4, pos.y - delta * speed)) {
					pos.y -= onetile;
				}
				count += 1;
			}
			if (input.isKeyPressed(Input.KEY_S) || input.isControlPressed(3, 3)) {
				if (!ps.isBlocked(pos.x + w - 4, pos.y + h + delta * speed)
						&& !ps.isBlocked(pos.x + 4, pos.y + h + delta * speed)) {
					pos.y += onetile;
				}
				count += 1;
			}
			if (input.isKeyPressed(Input.KEY_A) || input.isControlPressed(0, 3)) {
				if (!ps.isBlocked(pos.x - delta * speed, pos.y + 4)
						&& !ps.isBlocked(pos.x - delta * speed, pos.y + h - 4)) {
					pos.x -= onetile;
				}
				count += 1;
			}
			if (input.isKeyPressed(Input.KEY_D) || input.isControlPressed(1, 3)) {
				if (!ps.isBlocked(pos.x + w + delta * speed, pos.y + h - 4)
						&& !ps.isBlocked(pos.x + w + delta * speed, pos.y + 4)) {
					pos.x += onetile;
				}
				count += 1;
			}
		}
		if (count == mov) {
			playersTurn = false;
		}
	}

	public void render() {
		Kross.draw(pos.x, pos.y);
	}

	public float getX() {
		return pos.x;
	}

	public float getY() {
		return pos.y;
	}

	public Vector2f getpos() {
		return pos;
	}

	public void setpos(Vector2f pos) {
		this.pos = pos;
	}

	public void getStats() {
		hp = info.krossAttribs[1];
		atk = info.krossAttribs[2];
		spd = info.krossAttribs[3];
		lck = info.krossAttribs[4];
		dfc = info.krossAttribs[5];
		lv = info.krossAttribs[7];
		exp = info.krossAttribs[8];
	}
}
