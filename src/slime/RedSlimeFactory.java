package slime;

public class RedSlimeFactory implements SlimeFactory{
	private static RedSlimeFactory f;
	
	private RedSlimeFactory() {
		
	}
	
	public static RedSlimeFactory getInstance() {
		if(f == null) {
			f = new RedSlimeFactory();
		}
		return f;
	}
	
	@Override
	public Slime createSlime(int x,int y) {
		return new RedSlime(x,y);
	}

}
