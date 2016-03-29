package nl.han.ica.forestfight;

public class Dragon extends Enemy{
	
	private static int range = 3;
	
	public Dragon(Forest forest, int hp, int att, int def, String fileName) {
		super(forest, hp, att, def, fileName);
	}
	
	@Override
	public void attack(){
	}
}
