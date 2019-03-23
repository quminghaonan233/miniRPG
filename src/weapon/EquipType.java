package weapon;

public enum EquipType {
	Killer(Killer.class,0),
	Knife(Knife.class,1),
	DarkScarf(DarkScarf.class,2),
	FireHeart(FireHeart.class,3),
	FrostMourn(FrostMourn.class,4),
	InvicibleShiled(InvicibleShiled.class,5);
	
	private Class clazz;
	private int equipId;
	
	private EquipType(Class clazz,int id) {
		this.clazz= clazz;
		this.equipId = id;
	}
	
	public static equip getEquipById(int id) {
		for(EquipType et:EquipType.values()) {
			if(et.equipId == id) {
				try {
					return (equip) et.clazz.newInstance();
				} catch (Exception e) {

				}
			}
		}
		return null;
	}
	
	public static int getIdByEquip(Class clazz) {
		for(EquipType et:EquipType.values()) {
			if(et.clazz == clazz) {
				return et.equipId;
			}
		}
		return -1;
	}
}
