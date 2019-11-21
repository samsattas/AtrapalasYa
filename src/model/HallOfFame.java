package model;

import java.io.Serializable;
import java.util.ArrayList;

public class HallOfFame implements Serializable{
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public HallOfFame() {
		
	}
	
	public String showHOF() {
		String msg = "";
		arrangeByScore();
		for(int i = 0; i < 10; i++) {
			msg+=players.get(i).getName() + "\t" + players.get(i).getScore() + "\n";
		}
		
		return msg;
	}
	
	public void arrangeByScore() {
		Player aux;
		for(int i = 0;i<players.size();i++) {			
			for(int j = i+1; j<players.size();j++) {				
				if(players.get(j).getScore() - players.get(i).getScore()<0) {
					aux = players.get(i);
					players.set(i, players.get(j));
					players.set(j, aux);
				}
			}
		}
	}
}
