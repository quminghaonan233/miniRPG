package slime;

public class GreenSlimeFactory implements SlimeFactory {

	private static GreenSlimeFactory g;
	
	private GreenSlimeFactory() {
		
	}
	
	public static GreenSlimeFactory getInstance() {
		if(g == null) {
			g = new GreenSlimeFactory();
		}
		return g;
	}
	
	@Override
	public Slime createSlime(int x,int y) {
		return new GreenSlime(x,y);
	}

}
