package nl.han.ica.forestfight;

public class Skeleton extends Enemy{
	
	public static int range = 1;
	
	public Skeleton(Forest forest, int hp, int att, int def, String fileName) {
		super(forest, hp, att, def, fileName);
	}
}
