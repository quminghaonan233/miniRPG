package gameLoader;

import java.util.ArrayList;

import slime.Slime;

public class Area {
	private ArrayList<Slime> slimeList;

	public ArrayList<Slime> getSlimeList() {
		return slimeList;
	}

	public void setSlimeList(ArrayList<Slime> slimeList) {
		this.slimeList = slimeList;
	}

	public Area() {
		this.slimeList = new ArrayList<Slime>();
	}

	public Area(ArrayList<Slime> slimeList) {
		this.slimeList = slimeList;
	}
	
}
