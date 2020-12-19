package TileRPG;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.newdawn.slick.geom.Vector2f;

public class saveload {
	private Vector2f coordinates = new Vector2f(80, 80);

	public saveload() {
	}

	public Vector2f loadSave() {
		try {
			Scanner scanner = new Scanner(new File("saves/kross.sav"));
			coordinates.x = Float.parseFloat(scanner.nextLine());
			coordinates.y = Float.parseFloat(scanner.nextLine());
		} catch (FileNotFoundException e) {
			System.out.println("Save file does not exist.");
		} catch (NumberFormatException e) {
			System.out.println("Could not read file");
		}
		return coordinates;
	}

	public void save(Vector2f vector) {
		try {
			PrintWriter writer = new PrintWriter(new File("saves/kross.sav"));
			writer.println(vector.x);
			writer.println(vector.y);
			writer.close();
		} catch (Exception e) {
			System.out.println("Could not save file");
		}
	}
}
