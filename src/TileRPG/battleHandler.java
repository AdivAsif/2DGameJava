package TileRPG;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class battleHandler {
	private Animation goblin1a, goblin2a, goblin3a, knighta, goblin1Hurt, goblin2Hurt, goblin3Hurt, knightHurt,
			cKnighta, bGoblina, backb, krossSlasha;
	private SpriteSheet bb, krossSlash;
	private SpriteSheet goblin1, goblin2, goblin3, knight, cKnight, bGoblin, goblin1h, goblin2h, goblin3h, knighth;
	private static final int animationSpeed = 100;
	private static final float speed = 0.1f;

	public battleHandler() throws SlickException {
		bb = new SpriteSheet("res/battlebackground.png", 1200, 800);
		backb = new Animation(bb, animationSpeed);
		backb.setPingPong(true);
		goblin1 = new SpriteSheet("res/goblinAttack.png", 400, 400);
		goblin2 = new SpriteSheet("res/goblin2Attack.png", 400, 400);
		goblin3 = new SpriteSheet("res/goblin3Attack.png", 400, 400);
		knight = new SpriteSheet("res/knightAttack.png", 400, 400);
		cKnight = new SpriteSheet("res/knightcorruptedAttack.png", 400, 400);
		bGoblin = new SpriteSheet("res/goblinBoss.png", 400, 400);
		goblin1h = new SpriteSheet("res/goblinHurt.png", 400, 400);
		goblin2h = new SpriteSheet("res/goblin2Hurt.png", 400, 400);
		goblin3h = new SpriteSheet("res/goblin3Hurt.png", 400, 400);
		knighth = new SpriteSheet("res/knightHurt.png", 400, 400);
		goblin1a = new Animation(goblin1, animationSpeed);
		goblin2a = new Animation(goblin2, animationSpeed);
		goblin3a = new Animation(goblin3, animationSpeed);
		knighta = new Animation(knight, animationSpeed);
		goblin1Hurt = new Animation(goblin1h, animationSpeed);
		goblin2Hurt = new Animation(goblin2h, animationSpeed);
		goblin3Hurt = new Animation(goblin3h, animationSpeed);
		knightHurt = new Animation(knighth, animationSpeed);
		cKnighta = new Animation(cKnight, animationSpeed);
		bGoblina = new Animation(bGoblin, animationSpeed);
		krossSlash = new SpriteSheet("res/krossslash.png", 400, 400);
		krossSlasha = new Animation(krossSlash, animationSpeed);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g, Play ps) throws SlickException {
		// battleids:
		/*
		 * 1 - goblin1 2 - goblin2 3 - goblin3 4 - knight 5 - boss Goblin 6 - boss
		 * Knight
		 */
		backb.draw(200, 80);
		krossSlasha.draw(400, 270);
		if (ps.battleid == 1) {
			goblin1a.draw(800, 300);
		}
		if (ps.battleid == 2) {
			goblin2a.draw(800, 300);
		}
		if (ps.battleid == 3) {
			goblin3a.draw(800, 300);
		}
		if (ps.battleid == 4) {
			knighta.draw(800, 300);
		}
		if (ps.battleid == 5) {
			bGoblina.draw(800, 300);
		}
		if (ps.battleid == 6) {
			cKnighta.draw(800, 300);
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta, Play ps) throws SlickException {
		Input input = gc.getInput();
		if (ps.battleid == 1) {
			if (input.isControlPressed(6, 3)) {
				System.out.println("Goblin battle!");
			}
		} else if (ps.battleid == 2) {
			if (input.isKeyPressed(Input.KEY_ENTER)) {
				System.out.println("Knight battle!");
			}
		} else if (ps.battleid == 0) {
			if (input.isKeyPressed(Input.KEY_BACK)) {
				System.out.println("Broken");
			}
		}
	}
}
