package user;

import java.util.ArrayList;

import Medicine.HealMedicine;
import weapon.DarkScarf;
import weapon.FireHeart;
import weapon.Killer;
import weapon.Knife;
import weapon.equip;

public class Assassin extends User{
	private static final String path = System.getProperty("user.dir") + "/resource/img/paidaxing.jpg";
	private static final int type = 0;
	
	public Assassin(String userName) {
		super(userName, type);
		this.imagePath = path;
		this.growHP = 15;
		this.growMP = 10;
		this.growP_ATK = 5;
		this.growP_DEF = 2;
		this.growM_ATK = 2;
		this.growM_DEF = 3;
		this.LV = 1;
		

		this.HP = 100;
		this.MP = 50;
		ArrayList<equip> eq = new ArrayList<equip>();
		this.equipList = eq;
		
		ArrayList<equip> pack = new ArrayList<equip>();
		pack.add(new HealMedicine());
		pack.add(new Knife());
		pack.add(new Killer());
		pack.add(new DarkScarf());
		pack.add(new FireHeart());
		this.packageList = pack;
		this.current_HP = this.getHPDecroted();
		this.current_MP = this.getMPDecroted();

	}
}
