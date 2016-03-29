package nl.han.ica.forestfight;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileMap;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileType;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.forestfight.tiles.BoardsTile;
import processing.core.PApplet;

public class Forest extends GameEngine {
	
	private static final long serialVersionUID = 302452811424115223L;
	public Player player;
	private Dragon dragon;
	private Skeleton skeleton;
	
    public static void main(String[] args) {
        PApplet.main(new String[]{"nl.han.ica.forestfight.Forest"});
    }

    @Override
	public void setupGame() {
		int worldWidth = 800;
		int worldHeight = 600;
				
		createViewWithoutViewport(worldWidth, worldHeight);
		
		initializeTileMap();
		createObjects();
	}
	
	private void createViewWithoutViewport(int screenWidth, int screenHeight) {
        View view = new View(screenWidth,screenHeight);
        view.setBackground(loadImage("src/main/java/nl/han/ica/forestfight/media/background.jpg"));

        setView(view);
        size(screenWidth, screenHeight);
    }
	
	public void createObjects() {
		player = new Player(this);
		addGameObject(player, 100, 100);
		dragon = new Dragon(this, 20, 50, 10);
		addGameObject(dragon, 250, 400);
		skeleton = new Skeleton(this, 20, 50, 10);
		addGameObject(skeleton, 400, 250);
//		EnemySpawner spawner = new EnemySpawner(player.getLevel()); //wil nu nog niet werken
//		spawner.fillList(player.getLevel(), this);
//		spawner.spawnEnemies(this);
	}
	
	private void initializeTileMap() {
		Sprite houseSprite = new Sprite("src/main/java/nl/han/ica/forestfight/media/house.png");
		TileType<BoardsTile> houseTileType = new TileType<>(BoardsTile.class, houseSprite);
		
		Sprite foliage = new Sprite("src/main/java/nl/han/ica/forestfight/media/foliage.png");
		TileType<BoardsTile> foliageTileType = new TileType<>(BoardsTile.class, foliage);
		
		Sprite gate = new Sprite("src/main/java/nl/han/ica/forestfight/media/gate.png");
		TileType<BoardsTile> gateTileType = new TileType<>(BoardsTile.class, gate);

        TileType[] tileTypes = { houseTileType, gateTileType, foliageTileType };
        int tileSize=50;
        int tilesMap[][]={
		            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1,-1},
		            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
        };
//        {2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2},//2 is de barriere om het level heen, 1 zijn de doorgang naar volgende
//        {2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2},// instance of naar de volgende safe-zone, moet hiervoor
//        {2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2},// de sprites er nog in zetten en uitvogelen hoe je kan aangeven
//        {2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2},// dat wanneer de player alles verslagen heeft en op 3 staat
//        {2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2},// hij naar het volgende stuk door mag.
//        {2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2},
//        {2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2},
//        {2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2},
//        {2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2},
//        {2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2},
//        {2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2},
//        {2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2}
        tileMap = new TileMap(tileSize, tileTypes, tilesMap);
	}
	
	public void update() {
	}
}
