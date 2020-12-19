package TileRPG;

import java.util.Timer;
import java.util.TimerTask;
import org.newdawn.slick.Image;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

public class Play extends BasicGameState {
	static boolean fullscreen = false;
	static boolean showFPS = true;
	static int fpslimit = 60;
	private boolean enemyAI;
	private boolean playerTurn;
	private boolean[][] blocked;
	private Timer timer, timer1;
	private Image playerPhase, enemyPhase;
	TiledMap[] maps = new TiledMap[12];
	KrossPlayer player;
	Goblin gobEnemy;
	Goblin1 gob2Enemy;
	Goblin2 gob3Enemy;
	Knight knightEnemy;
	battleHandler bh;
	information info;
	battleMenu bu;
	public static float newposx, newposy;
	int mapHeight, mapWidth;
	int tileHeight, tileWidth;
	int gobStartX, gobStartY;
	int knightStartX, knightStartY;
	int stateid;
	int battleid;
	int x, y;

	public Play(int id) {
		stateid = id;
	}

	public int getID() {
		return 3;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		enemyAI = false;
		playerTurn = true;
		battleid = 0;
		timer = new Timer();
		timer1 = new Timer();
		playerPhase = new Image("res/playerPhase.png");
		enemyPhase = new Image("res/enemyPhase.png");
		maps[0] = new TiledMap("res/map.tmx");
		maps[1] = new TiledMap("res/map2.tmx");
		maps[2] = new TiledMap("res/map3.tmx");
		maps[3] = new TiledMap("res/map4.tmx");
		maps[4] = new TiledMap("res/map5.tmx");
		maps[5] = new TiledMap("res/map6.tmx");
		maps[6] = new TiledMap("res/map7.tmx");
		maps[7] = new TiledMap("res/map8.tmx");
		maps[8] = new TiledMap("res/map9.tmx");
		maps[9] = new TiledMap("res/map10.tmx");
		maps[10] = new TiledMap("res/map11.tmx");
		maps[11] = new TiledMap("res/map12.tmx");
		mapWidth = 1600;
		mapHeight = 960;
		tileHeight = 80;
		tileWidth = 80;
		gobStartX = 1360;
		gobStartY = 720;
		knightStartX = 160;
		knightStartY = 720;
		player = new KrossPlayer(tileWidth, tileHeight);
		gobEnemy = new Goblin(gobStartX, gobStartY);
		knightEnemy = new Knight(knightStartX, knightStartY);
		bh = new battleHandler();
		info = new information();
		bu = new battleMenu();
		// there was an issue where if blocked, and initialiseBlocked() were placed
		// here, the map's appearance would change, but the obstacles would not.
		// to fix this, I placed blocked and initialiseBlocked() in the update method.
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		blocked = new boolean[maps[stageselect.stageChoice].getWidth()][maps[stageselect.stageChoice].getHeight()];
		initialiseBlocked();
		Input input = gc.getInput();
		newposx = getHeroPosition().x;
		newposy = getHeroPosition().y;
		if (gc.hasFocus() == true) {
			if (enemyAI == true) {
				input.pause();
				gobEnemy.update(gc, sbg, delta, this);
				knightEnemy.update(gc, sbg, delta, this);
				KrossPlayer.playersTurn = true;
				KrossPlayer.count = 0;
				enemyAI = false;
				timer1.schedule(new TimerTask() {
					public void run() {
						playerTurn = true;
					}
				}, 1000);
			}
			if (playerTurn == true) {
				input.resume();
				player.update(gc, sbg, delta, this);
				if (input.isKeyPressed(Input.KEY_ENTER) || input.isControlPressed(5, 3)) {
					KrossPlayer.playersTurn = false;
					playerTurn = false;
					timer.schedule(new TimerTask() {
						public void run() {
							enemyAI = true;
						}
					}, 1000);
				}
			}
		}
		if (input.isKeyPressed(Input.KEY_ESCAPE) || input.isControlPressed(13, 3)) {
			sbg.enterState(Main.pause, new FadeOutTransition(), new FadeInTransition());
		}
		if (input.isControlPressed(7, 3)) {
			info.krossStats();
			System.out.println(info.krossAttribs[2]);
		}
		if (gc.getInput().isKeyPressed(Input.KEY_1)) {
			System.out.println(getHeroPosition());
		}
		if (getHeroPosition().equals(getGobPosition())) {
			battleid = 1;
			bh.update(gc, sbg, delta, this);
		}
		if (getHeroPosition().equals(getKnightPosition())) {
			battleid = 4;
			bh.update(gc, sbg, delta, this);
		}
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		maps[stageselect.stageChoice].render(0, 0);
		player.render();
		gobEnemy.render();
		knightEnemy.render();
		if (getHeroPosition().equals(getGobPosition())) {
			gobEnemy.silhouette();
			bh.render(gc, sbg, g, this);
			gobEnemy.destroyme();
		}
		if (getHeroPosition().equals(getKnightPosition())) {
			knightEnemy.silhouette();
			bh.render(gc, sbg, g, this);
		}
		if (playerTurn == true) {
			playerPhase.draw(0, 0);
		} else {
			enemyPhase.draw(0, 0);
		}
	}

	public boolean isBlocked(float x, float y) {
		int xBlock = (int) x / maps[stageselect.stageChoice].getTileWidth();
		int yBlock = (int) y / maps[stageselect.stageChoice].getTileHeight();
		return blocked[xBlock][yBlock];
	}

	public Vector2f getHeroPosition() {
		return player.getpos();
	}

	public Vector2f getGobPosition() {
		return gobEnemy.getpos();
	}

	public Vector2f getKnightPosition() {
		return knightEnemy.getpos();
	}

	public void setHeroPosition(Vector2f pos) {
		player.setpos(pos);
	}

	public void setGobPosition(Vector2f pos) {
		gobEnemy.setpos(pos);
	}

	public void setKnightPosition(Vector2f pos) {
		knightEnemy.setpos(pos);
	}

	private void initialiseBlocked() {
		for (int l = 0; l < maps[stageselect.stageChoice].getLayerCount(); l++) {
			String layerValue = maps[stageselect.stageChoice].getLayerProperty(l, "blocked", "false");
			if (layerValue.equals("true")) {
				for (int c = 0; c < maps[stageselect.stageChoice].getWidth(); c++) {
					for (int r = 0; r < maps[stageselect.stageChoice].getHeight(); r++) {
						if (maps[stageselect.stageChoice].getTileId(c, r, l) != 0) {
							blocked[c][r] = true;
						}
					}
				}
			}
		}
	}

	public int batid() {
		return battleid;
	}
}
