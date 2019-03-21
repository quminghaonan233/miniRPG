package slime;

public enum SlimeType {
	Green(GreenSlimeFactory.getInstance(),0),
	Red(RedSlimeFactory.getInstance(),1);
	
	private SlimeFactory factory;
	private int simpleType;
		
	private SlimeType(SlimeFactory factory,int slimeType) {
		this.factory = factory;
		this.simpleType = slimeType;
	}
	
	public static SlimeFactory getFactory(int slimeType) {
		for (SlimeType s:SlimeType.values()) {
			if(s.simpleType == slimeType) {
				return s.factory;
			}
		}
		return null;
	}
	
}
