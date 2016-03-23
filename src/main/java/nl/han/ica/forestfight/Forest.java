package nl.han.ica.forestfight;

import nl.han.ica.OOPDProcessingEngineHAN.Engine.GameEngine;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileMap;
import nl.han.ica.OOPDProcessingEngineHAN.Tile.TileType;
import nl.han.ica.OOPDProcessingEngineHAN.View.View;
import nl.han.ica.waterworld.tiles.BoardsTile;
import processing.core.PApplet;

public class Forest extends GameEngine {
	
	private static final long serialVersionUID = 302452811424115223L;
	public Player player;
	private Enemy enemy;
	
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
		enemy = new Enemy(this);
		addGameObject(enemy, 250, 250);
	}
	
	private void initializeTileMap() {
		Sprite boardsSprite = new Sprite("src/main/java/nl/han/ica/waterworld/media/boards.jpg");
		TileType<BoardsTile> boardTileType = new TileType<>(BoardsTile.class, boardsSprite);

        TileType[] tileTypes = { boardTileType };
        int tileSize=50;
        int tilesMap[][]={
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1, 0, 0, 0, 0,-1,0 , 0},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
        };
        tileMap = new TileMap(tileSize, tileTypes, tilesMap);
	}
	
	public void update() {
		
	}
}
