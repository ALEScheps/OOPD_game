package nl.han.ica.forestfight;

public class Skeleton extends Enemy{
	
	public static int range = 1;
	private static String fileName = "skeleton.png";
	
	public Skeleton(Forest forest, int hp, int att, int def) {
		super(forest, hp, att, def, fileName);
	}
	
}
