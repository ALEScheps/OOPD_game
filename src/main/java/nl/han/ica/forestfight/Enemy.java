package nl.han.ica.forestfight;

import java.util.List;

import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.ICollidableWithTiles;
import nl.han.ica.OOPDProcessingEngineHAN.Exceptions.TileNotFoundException;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.GameObject;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;
import nl.han.ica.forestfight.tiles.BoardsTile;
import processing.core.PVector;

public class Enemy extends SpriteObject implements ICollidableWithTiles, ICollidableWithGameObjects {

	protected Forest world;
	protected int enemyCount;
	protected int mhp;	//maximum hp
	protected int chp;	//hp the entity currently has
	protected int att;
	protected int def;
	protected int toAddExp;
	protected String fileName;

	public Enemy(Forest forest, int hp, int att, int def, String fileName) {
		this(new Sprite("src/main/java/nl/han/ica/forestfight/media/" + fileName));
		this.world = forest;
		this.mhp = hp;
		this.att = att;
		this.def = def;
	}

	private Enemy(Sprite sprite) {
		super(sprite);
		setxSpeed(0);
	}

	public void update() {
		if (this.getDistanceFrom(world.player) > 1) {
			this.setDirectionSpeed(this.getAngleFrom(world.player), 2);
		} else {
			this.setDirectionSpeed(this.getAngleFrom(world.player), 0);
		}
		if(this.chp < 1){
			this.die();
		}
	}

	@SuppressWarnings("static-access")
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
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

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		
		for (GameObject go : collidedGameObjects){
			
			for (GameObject cgo : collidedGameObjects) {
				if(go != cgo){
					if(go.getDistanceFrom(cgo) < go.getWidth()){
						cgo.setSpeed(0);
					}
				}
				
//				ik weet nog niet hoe ik de collision hiermee goed krijg, maar enemies gaan na een tijdje
//				rond te lopen onder elkaar lopen en player kan onder enemies door lopen
			}
		}
	}
	
	public void setMaxHp(int hp){
		this.mhp = hp;
	}
	
	public int getMaxHp(){
		return this.mhp;
	}
	
	public void setCurrentHp(int hp){
		this.chp = hp;
	}
	
	public int getCurrentHp(){
		return this.chp;
	}
	
	public void setAtt(int att){
		this.att = att;
	}
	
	public int getAtt(){
		return this.att;
	}
	
	public void setDef(int def){
		this.def = def;
	}
	
	public int getDef(){
		return this.def;
	}
	
	public void setExp(int exp){
		this.toAddExp = exp;
	}
	
	public int getExp(){
		return this.toAddExp;
	}
	
	public void die(){
		//remove the enemy from the game
	}
}
