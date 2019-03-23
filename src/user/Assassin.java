package user;

import java.util.ArrayList;

import Medicine.HealMedicine;
import skill.assassinSkill1;
import skill.assassinSkill2;
import skill.assassinSkill3;
import skill.assassinSkill4;
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
		

		this.HP = 500;
		this.MP = 150;
		this.P_ATK = 65;
		this.P_DEF = 25;
		this.M_ATK = 50;
		this.M_DEF = 20;
		this.STR = 15;
		this.AGI = 40;
		this.INT = 10;
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
		
		this.skillList[0] = new assassinSkill1();
		this.skillList[1] = new assassinSkill2();
		this.skillList[2] = new assassinSkill3();
		this.skillList[3] = new assassinSkill4();

	}
	
	@Override
	public double getAVDDecroted() {
		double avd = super.getAVDDecroted()+20;
		return avd;
	}

	@Override
	public double getCRTDecroted() {
		double tempCRT = CRT;
		for(equip e :equipList){
			tempCRT += e.getCRT();
		}
		return tempCRT;
	}
}
