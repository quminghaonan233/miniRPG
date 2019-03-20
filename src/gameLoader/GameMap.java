package gameLoader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import slime.Slime;

public class GameMap implements Serializable{
	private static final int xSize = 20;
	private static final int ySize = 16;
	
	private int level;
	
	private int startX;
	
	private int startY;
	
	private int endX;
	
	private int endY;
	
	private int [][] mapArr;
	
	private ArrayList<Slime> slimeList;
	
	
	//用于初始化开始地图
	public GameMap() {
		this(0);
	}
	
	public GameMap(int level) {
		this.level = level;
		this.mapArr = new int[xSize][ySize];
		initialStartEnd();		
		initialSlime();
	}
	
	private void initialStartEnd() {
		this.startX = 0;
		this.startY = 0;
		this.endX = xSize - 1;
		this.endY = ySize - 1;
	}
	
	private void initialSlime() {
		
		
	}
}
