package nl.han.ica.forestfight;

import java.util.ArrayList;
import nl.han.ica.OOPDProcessingEngineHAN.Alarm.IAlarmListener;

public class EnemySpawner implements IAlarmListener{
	private int instanceLevel = 0;
	private ArrayList<Enemy> Enemies = new ArrayList();
	
	public EnemySpawner(int iLevel){
		this.instanceLevel = iLevel;
	}
	
//	Laat dit de enemies 1 voor 1 spawnen, hier moeten we er nog voor zorgen dat er niet te veel enemies
//	tegelijk op de map komen. Dit is momenteel gedaan door het iLevel op 10 vast te zetten.
//	public void spawnEnemies(ArrayList enemies){
//		for(enemies : enemy){
//			enemy.spawn();
//		}
//	}
	
	public void fillList(int iLevel){
//		private int iLevel;
		for(int i = 0; i < 10; i++){ // Maximum instanceLevel is op het moment 10
			if(iLevel < 4){
				iLevel -= 4;
//				Enemies.add(new Dragon dragon()); //hier moeten nog sprites ingezet worden
			}else if(iLevel < 1){
				iLevel -= 1;
//				Enemies.add(new Skeleton skeleton()); //hier moeten nog sprites ingezet worden
			}
		}
		
	}

	@Override
	public void triggerAlarm(String alarmName) {
		// TODO Auto-generated method stub
		
	}

}
