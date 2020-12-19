package TileRPG;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class information {
	public information() {
	}

	public int[] krossAttribs = new int[9];
	public int[] goblin1Attribs = new int[7];
	public int[] goblin2Attribs = new int[7];
	public int[] goblin3Attribs = new int[7];
	public int[] knightAttribs = new int[7];
	public int[] goblinKingAttribs = new int[7];

	public void krossStats() {
		File file = new File("information/krossStat.txt");
		Scanner sc;
		try {
			sc = new Scanner(file);
			int count = 0;
			while (sc.hasNextLine()) {
				count++;
				krossAttribs[count] = sc.nextInt();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void goblin1Stats() {
		File file = new File("information/goblin1Stat.txt");
		Scanner sc;
		try {
			sc = new Scanner(file);
			int count = 0;
			while (sc.hasNextLine()) {
				count++;
				goblin1Attribs[count] = sc.nextInt();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void goblin2Stats() {
		File file = new File("information/goblin2Stat.txt");
		Scanner sc;
		try {
			sc = new Scanner(file);
			int count = 0;
			while (sc.hasNextLine()) {
				count++;
				goblin2Attribs[count] = sc.nextInt();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void goblin3Stats() {
		File file = new File("information/goblin3Stat.txt");
		Scanner sc;
		try {
			sc = new Scanner(file);
			int count = 0;
			while (sc.hasNextLine()) {
				count++;
				goblin3Attribs[count] = sc.nextInt();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void knightStats() {
		File file = new File("information/knightStat.txt");
		Scanner sc;
		try {
			sc = new Scanner(file);
			int count = 0;
			while (sc.hasNextLine()) {
				count++;
				knightAttribs[count] = sc.nextInt();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void goblinKingStats() {
		File file = new File("information/goblinKingStat.txt");
		Scanner sc;
		try {
			sc = new Scanner(file);
			int count = 0;
			while (sc.hasNextLine()) {
				count++;
				goblinKingAttribs[count] = sc.nextInt();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
