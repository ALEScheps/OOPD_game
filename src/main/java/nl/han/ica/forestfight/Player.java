package nl.han.ica.forestfight;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Exceptions.TileNotFoundException;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.forestfight.tiles.BoardsTile;
import processing.core.PVector;

public class Player extends AnimatedSpriteObject implements ICollidableWithTiles {

	private final int size = 50;
	private Forest world;
	
	private int level = 1;
	private int exp = 0;
	private int hp = 200;
	private int att = 50;
	private int def = 0;
	private int cash = 0;
	private int instanceLevel = 1;
	
	Sprite playerSprite = new Sprite("src/main/java/nl/han/ica/forestfight/media/player.png");
	
	protected static Backpack playerBackpack;

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
	
	/**
	 * @return the level
	 */
	public int getLevel(){
		return level;
	}

	/**
	 * @return the hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * @param hp the hp to set
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * @return the att
	 */
	public int getAtt() {
		return att;
	}

	/**
	 * @param att the att to set
	 */
	public void setAtt(int att) {
		this.att = att;
	}

	/**
	 * @return the def
	 */
	public int getDef() {
		return def;
	}

	/**
	 * @param def the def to set
	 */
	public void setDef(int def) {
		this.def = def;
	}
	
	/**
	 * @param toAddExp the exp to set
	 */
	public void addExp(int toAddExp){
		exp = exp + toAddExp;
	}
}
