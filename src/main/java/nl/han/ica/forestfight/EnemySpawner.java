package nl.han.ica.forestfight;

import java.util.ArrayList;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;

public class EnemySpawner implements IAlarmListener {
	private int instanceLevel = 0;
	private ArrayList<Enemy> Enemies = new ArrayList();

	public EnemySpawner(int iLevel) {
		this.instanceLevel = iLevel;
	}

	public void fillList(int iLevel, Forest forest) {
		// private int iLevel;
		for (int i = 0; i < 10; i++) { // Maximum instanceLevel is op het moment
										// 10
			if (iLevel < 4) {
				iLevel -= 4;
				Dragon dragon;
				dragon = new Dragon(forest, 20, 50, 10);
				 Enemies.add(dragon);
			} else if (iLevel < 1) {
				iLevel -= 1;
				Skeleton skeleton;
				skeleton = new Skeleton(forest, 20, 50, 10);
				 Enemies.add(skeleton);
			}
		}

	}
	
	public void spawnEnemies(Forest forest){
		for(Enemy enemy: Enemies){
			forest.addGameObject(enemy, 400, 200);
		}
	}

	@Override
	public void triggerAlarm(String alarmName) {
		// TODO Auto-generated method stub

	}

}
