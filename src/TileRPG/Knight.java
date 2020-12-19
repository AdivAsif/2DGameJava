package TileRPG;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
import java.util.Timer;
import java.util.TimerTask;

public class Knight {
	private Animation Knight;
	private Vector2f pos;
	private static final int animationSpeed = 300;
	private static final float speed = 0.1f;
	private int w, h, onetile, mov;
	private boolean destroyed;
	public static int hp, atk, spd, lck, dfc;
	private Timer timer;
	information info;

	public Knight(float x, float y) throws SlickException {
		timer = new Timer();
		SpriteSheet knightSheet = new SpriteSheet("res/knight.png", 80, 80);
		onetile = 80;
		w = knightSheet.getSprite(0, 0).getWidth();
		h = knightSheet.getSprite(0, 0).getHeight();
		pos = new Vector2f(x, y);
		Knight = new Animation(knightSheet, animationSpeed);
		info = new information();
		info.knightStats();
		destroyed = false;
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta, Play ps) {
		Knight.update(delta);
		mov = info.knightAttribs[6];
		if (destroyed == false) {
			timer.schedule(new TimerTask() {
				public void run() {
					for (int i = 0; i < mov - 1; i++) {
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
		Knight.draw(pos.x, pos.y);
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
		Knight.drawFlash(pos.x, pos.y, h, h);
	}

	public void destroyme() {
		pos.x = -600;
		pos.y = -600;
		destroyed = true;
	}

	public void getStats() {
		hp = info.knightAttribs[1];
		atk = info.knightAttribs[2];
		spd = info.knightAttribs[3];
		lck = info.knightAttribs[4];
		dfc = info.knightAttribs[5];
	}
}
