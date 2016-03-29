package nl.han.ica.forestfight;

public class Dragon extends Enemy{
	
	public static int range = 3;
	private static String fileName = "dragon.png";
	
	public Dragon(Forest forest, int hp, int att, int def) {
		super(forest, hp, att, def, fileName);
	}
	
}
