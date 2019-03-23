package weapon;

public enum EquipCompose {
	FrostMourn(4,0,1),
	InvicibleShiled(5,2,2);
	
	private int [] composeList;
	private int equipId;
	
	private EquipCompose(int id,Integer...a) {
		this.equipId = id;
		this.composeList = new int [a.length];
		int index = 0;
		for(Integer i:a) {
			composeList[index] = i;
			index ++;
		}
	}
	
	public static int[] getComposeById(int id) {
		for(EquipCompose e:EquipCompose.values()) {
			if(e.equipId == id) {
				return e.composeList;
			}
		}
		return null;
	}
}
