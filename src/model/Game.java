package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Game extends Thread{
	
	private ArrayList<Ball> BList = new ArrayList<Ball>() ;
	private int number;
	private int level;
	private HallOfFame hof;
	
	public Game( ) {
	
	}
	
	public ArrayList<Ball> getBList() {
		return BList;
	}



	public void setBList(ArrayList<Ball> bList) {
		BList = bList;
	}



	public int getNumber() {
		return number;
	}



	public void setNumber(int number) {
		this.number = number;
	}



	public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
	public HallOfFame getHof() {
		return hof;
	}
	
	

	public void setHof(HallOfFame hof) {
		this.hof = hof;
	}

	public void save() throws FileNotFoundException {
		String message = "";
		File f = new File("./data/Game0.txt");
		PrintWriter pw = new PrintWriter(f);
		for(int c = 0; c < BList.size(); c++) {
			message += BList.get(c).Report() + "\n";
		}
		pw.write(level + "\n");
		pw.write(message);
		pw.close();

	}
	
	public int load() throws IOException {
		File file = new File("./data/Game0.txt");
		FileReader fr = new FileReader(file);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		int level = 0;
		String line = br.readLine();
	
		while(line != null) {
			if(line.charAt(0) != '#') {
				
				String[] array = line.split("\t");
				
				if(array.length == 1) {
					level = Integer.parseInt(array[0]);
				}else {
					double radius = Double.parseDouble(array[0]);
					double x = Double.parseDouble(array[1]);
					double y = Double.parseDouble(array[2]);
					double wait = Double.parseDouble(array[3]);
					String direction = array[4];
				    int  nbounce = Integer.parseInt(array[5]);
					boolean stop = Boolean.parseBoolean(array[6]);
					Ball b = new Ball(radius, x, y, wait, direction, nbounce, stop);
					
					BList.add(b);
				}
			
			}
			line = br.readLine();
			
			
		}
	
		return level;
	}
}
