package nl.han.ica.forestfight;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Exceptions.TileNotFoundException;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PVector;

public class Player extends AnimatedSpriteObject implements ICollidableWithTiles {

	final int size = 50;
	private final Forest world;
	Sprite playerSprite = new Sprite("src/main/java/nl/han/ica/forestfight/media/player.png");

	public Player(Forest world) {
        super(new Sprite("src/main/java/nl/han/ica/forestfight/media/player.png"), 1);
        this.world = world;
        setCurrentFrameIndex(0);
        setFriction(0.05f);
    }
	
	public void update() {
		if (getX()<=0) {
            setxSpeed(0);
            setX(0);
        }
        if (getY()<=0) {
            setySpeed(0);
            setY(0);
        }
        if (getX()>=world.getWidth()-size) {
            setxSpeed(0);
            setX(world.getWidth() - size);
        }
        if (getY()>=world.getHeight()-size) {
            setySpeed(0);
            setY(world.getHeight() - size);
        }
	}
	
	/* (non-Javadoc)
	 * @see nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject#keyPressed(int, char)
	 */
	@SuppressWarnings("static-access")
	public void keyPressed(int keyCode, char key) {
        final int speed = 5;
        
        if (keyCode == 'A') {
            setDirectionSpeed(270, speed);
        }
        if (keyCode == 'W') {
            setDirectionSpeed(0, speed);
        }
        if (keyCode == 'D') {
            setDirectionSpeed(90, speed);
        }
        if (keyCode == 'S') {
            setDirectionSpeed(180, speed);
        }
        if (key == ' ') {
            System.out.println("Spatie!");
        }
    }
	
	@SuppressWarnings("static-access")
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles)  {
        PVector vector;

        for (CollidedTile ct : collidedTiles) {
            if (ct.theTile instanceof BoardsTile) {
                if (ct.collisionSide == ct.TOP) {
                    try {
                        vector = world.getTileMap().getTilePixelLocation(ct.theTile);
                        setY(vector.y - getHeight());
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (ct.collisionSide == ct.RIGHT) {
                    try {
                        vector = world.getTileMap().getTilePixelLocation(ct.theTile);
//                        world.getTileMap().setTile((int) vector.x / 50, (int) vector.y / 50, -1);
                        setX(vector.x + getWidth());
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
