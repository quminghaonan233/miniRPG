package gameLoader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import slime.Slime;
import slime.SlimeFactory;
import slime.SlimeType;
import weapon.EquipType;
import weapon.equip;

public class GameMap implements Serializable{
	public static final int xSize = 16;
	public static final int ySize = 16;
	private static final int slimeNumMin = 10;
	
	private int level;
	
	private int startX;
	
	private int startY;
	
	private int endX;

	private int endY;
	
	private ArrayList<Slime> slimeList;
	
	
	//用于初始化开始地图
	public GameMap() {
		this(1);
	}
	
	public GameMap(int level) {
		this.level = level;
		this.slimeList = new ArrayList<Slime>();
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
		Random r = new Random();
		int slimeNum = slimeNumMin + r.nextInt(slimeNumMin);
		for (int i = 0; i < slimeNum; i++) {
			int slimeType = r.nextInt(SlimeType.values().length);
			
			SlimeFactory s = SlimeType.getFactory(slimeType);

			int x = r.nextInt(xSize);
			int y = r.nextInt(ySize);
			Slime slime = s.createSlime(x,y,level);
			Random random = new Random();
			equip eq = EquipType.getEquipById(random.nextInt(EquipType.values().length));
			if(eq != null && random.nextInt(100) < eq.getProbability()) {
				slime.setEquip(eq);
			}
			this.slimeList.add(slime);			
		}
		
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public int getEndX() {
		return endX;
	}

	public void setEndX(int endX) {
		this.endX = endX;
	}

	public int getEndY() {
		return endY;
	}

	public void setEndY(int endY) {
		this.endY = endY;
	}
	
	public ArrayList<Slime> getSlimeList() {
		return slimeList;
	}

	public void setSlimeList(ArrayList<Slime> slimeList) {
		this.slimeList = slimeList;
	}
	

}
