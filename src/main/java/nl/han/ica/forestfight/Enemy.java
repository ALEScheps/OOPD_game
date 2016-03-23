package nl.han.ica.forestfight;

import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

public class Enemy extends SpriteObject {

	private Forest world;
	
	public Enemy(Forest forest) {
		this(new Sprite("src/main/java/nl/han/ica/forestfight/media/player.png"));
		this.world = forest;
	}
	
	private Enemy(Sprite sprite) {
        super(sprite);
        setxSpeed(-1);
    }
	
	public void update() {
//		if (getX()+getWidth()<=0) {
//            setX(world.getWidth());
//        }
		this.setDirectionSpeed(world.player.getCenterX(), 1);
	}

}
