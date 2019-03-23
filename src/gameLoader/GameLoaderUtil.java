package gameLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import weapon.DarkScarf;
import weapon.EquipCompose;
import weapon.EquipType;
import weapon.Killer;
import weapon.Knife;
import weapon.equip;

public class GameLoaderUtil {
	private static GameLoaderUtil glu;
	private static String userDir = System.getProperty("user.dir") + "/resource/gamedata/";

	
	private GameLoaderUtil() {
		
	}
	
	public static GameLoaderUtil getInstance() {
		if(glu == null) {
			glu = new GameLoaderUtil();
		}
		return glu;
	}
	
	public boolean judgeFirstGame() {
		File file = new File(userDir);  
		File[] listFiles = file.listFiles();  
		if(listFiles.length > 0) {
			return false;
		}
		return true;
	}
	
	public void PackageCombine(ArrayList<equip> equipList) {
		//判断是否可合成
		EquipCompose [] ecList =  EquipCompose.values();
		for(int i=0;i < ecList.length;i++) {
			judgeAndCombine(equipList, ecList[i]);
		}
		
		
	}
	
	public void judgeAndCombine(ArrayList<equip> equipList,EquipCompose equipcompose) {
		int [] compose = equipcompose.composeList;
		int combineId = equipcompose.equipId;
		boolean [] contain = new boolean[compose.length];
		for(int i = 0;i < contain.length;i++) {
			contain[i] = false;
		}
		for(equip e:equipList) {
			for(int i = 0;i<compose.length;i++) {
				if(EquipType.getIdByEquip(e.getClass()) == compose[i] && !contain[i]) {
					contain[i] = true;
					break;
				}
			}
		}
		for(int i = 0;i<contain.length;i++) {
			if(contain[i] == false) {
				return;
			}
		}
		for(int i=0;i<compose.length;i++) {
			for(equip e:equipList) {
				if(EquipType.getIdByEquip(e.getClass()) == compose[i]) {
					equipList.remove(e);
					break;
				}
			}
		}
		equipList.add(EquipType.getEquipById(combineId));
	}
//	
//	public static void main(String [] args) {
//		ArrayList<equip> equipList = new ArrayList<equip>();
//		equipList.add(new Killer());
//		equipList.add(new Knife());
//		equipList.add(new DarkScarf());
//		equipList.add(new DarkScarf());
//		GameLoaderUtil.getInstance().PackageCombine(equipList);
//		for(equip e:equipList) {
//			System.out.println(e.getImagePath());
//		}
//	}
}
