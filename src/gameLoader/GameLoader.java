package gameLoader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameLoader {
	private static GameLoader gameLoader;
	private static String userDir = System.getProperty("user.dir") + "/resource/gamedata/";
	
	private GameLoader() {
		
	}
	
	public static GameLoader getInstance() {
		if (gameLoader == null) {
			gameLoader = new GameLoader();
		}
		return gameLoader;		
	}
	
	public <T> T load(Class<T> clazz) {
		T obj = null;
		try {
			
	        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
	        		userDir + clazz.getName()));
	        obj = (T) ois.readObject();
	        ois.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public <T> void save(T obj) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(
			        userDir+obj.getClass().getName()));
	        oos.writeObject(obj);
	        oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
