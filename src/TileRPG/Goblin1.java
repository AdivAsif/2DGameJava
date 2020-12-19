package TileRPG;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
import java.util.Timer;
import java.util.TimerTask;

public class Goblin1 {
	private Animation Gob1;
	private Vector2f pos;
	private static final int animationSpeed = 300;
	private static final float speed = 0.1f;
	private int w, h, onetile, mov;
	private boolean destroyed;
	public static int hp, atk, spd, lck, dfc;
	private Timer timer;
	information info;

	public Goblin1(float x, float y) throws SlickException {
		timer = new Timer();
		SpriteSheet goblinSheet = new SpriteSheet("res/goblin2.png", 80, 80);
		onetile = 80;
		w = goblinSheet.getSprite(0, 0).getWidth();
		h = goblinSheet.getSprite(0, 0).getHeight();
		pos = new Vector2f(x, y);
		Gob1 = new Animation(goblinSheet, animationSpeed);
		info = new information();
		info.goblin2Stats();
		destroyed = false;
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta, Play ps) {
		Gob1.update(delta);
		mov = info.goblin2Attribs[6];
		if (destroyed == false) {
			timer.schedule(new TimerTask() {
				public void run() {
					for (int i = 0; i < mov - 2; i++) {
						if (Play.newposx != getX()) {
							if (Play.newposx < getX()) {
								if (!ps.isBlocked(pos.x - delta * speed, pos.y + 4)
										&& !ps.isBlocked(pos.x - delta * speed, pos.y + h - 4)) {
									pos.x -= onetile;
								}
							}
							if (Play.newposx > getX()) {
								if (!ps.isBlocked(pos.x + w + delta * speed, pos.y + h - 4)
										&& !ps.isBlocked(pos.x + w + delta * speed, pos.y + 4)) {
									pos.x += onetile;
								}
							}
						}
						if (Play.newposy != getY()) {
							if (Play.newposy < getY()) {
								if (!ps.isBlocked(pos.x + w - 4, pos.y - delta * speed)
										&& !ps.isBlocked(pos.x + 4, pos.y - delta * speed)) {
									pos.y -= onetile;
								}
							}
							if (Play.newposy > getY()) {
								if (!ps.isBlocked(pos.x + w - 4, pos.y + h + delta * speed)
										&& !ps.isBlocked(pos.x + 4, pos.y + h + delta * speed)) {
									pos.y += onetile;
								}
							}
						}
					}
				}
			}, 1000);
		}
	}

	public void render() {
		Gob1.draw(pos.x, pos.y);
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

	public void silhouette() {
		Gob1.drawFlash(pos.x, pos.y, h, h);
	}

	public void destroyme() {
		pos.x = -600;
		pos.y = -600;
		destroyed = true;
	}

	public void getStats() {
		hp = info.goblin2Attribs[1];
		atk = info.goblin2Attribs[2];
		spd = info.goblin2Attribs[3];
		lck = info.goblin2Attribs[4];
		dfc = info.goblin2Attribs[5];
	}
}
