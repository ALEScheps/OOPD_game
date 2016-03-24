package nl.han.ica.forestfight;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Exceptions.TileNotFoundException;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.forestfight.tiles.BoardsTile;
import processing.core.PVector;

public class Enemy extends SpriteObject implements ICollidableWithTiles {

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

		if(this.getDistanceFrom(world.player) > 1){
			this.setDirectionSpeed(this.getAngleFrom(world.player), 2);
		}
		else{
			this.setDirectionSpeed(this.getAngleFrom(world.player), 0);
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
                if (ct.collisionSide == ct.BOTTOM) {
                    try {
                        vector = world.getTileMap().getTilePixelLocation(ct.theTile);
                        setY(vector.y + getHeight());
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (ct.collisionSide == ct.RIGHT) {
                    try {
                        vector = world.getTileMap().getTilePixelLocation(ct.theTile);
                        setX(vector.x + getWidth());
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (ct.collisionSide == ct.LEFT) {
                    try {
                        vector = world.getTileMap().getTilePixelLocation(ct.theTile);
                        setX(vector.x - getWidth());
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
