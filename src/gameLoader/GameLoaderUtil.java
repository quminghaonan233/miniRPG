package gameLoader;

import java.io.File;
import java.util.ArrayList;

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
		
	}
}
