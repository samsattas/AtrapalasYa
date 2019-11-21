package model;

import java.io.Serializable;



public class Ball implements Serializable{
	public final static String DERECHA = "DERECHA";
	public final static String IZQUIERDA = "IZQUIERDA";
	public final static String ARRIBA = "ARRIBA";
	public final static String ABAJO = "ABAJO";
	
	private double radius;
	private double x;
	private double y;
	private double wait;
	private String direction;
	private int nbounce;
	private boolean stop = false;
	
	

	public Ball(double radius, double x, double y, double wait, String dir, int nbounce, boolean stop) {
		super();
		this.radius = radius;
		this.x = x;
		this.y = y; 
		this.wait = wait;
		if(dir.equals("DERECHA")) {
			this.direction = DERECHA;
		}else if(dir.equals("IZQUIERDA")) {
			this.direction = IZQUIERDA;
		}else if(dir.equals("ARRIBA")) {
			this.direction = ARRIBA;
		}else {
			this.direction = ABAJO;
		}
		this.nbounce = nbounce;
		this.stop = stop;
	}

	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWait() {
		return wait;
	}

	public void setWait(double wait) {
		this.wait = wait;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getNbounce() {
		return nbounce;
	}

	public void setNbounce(int nbounce) {
		this.nbounce = nbounce;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}




	public String Report() {
		String message =   radius + "\t"+ x + "\t" + y + "\t" + wait + "\t"  + direction + "\t" + nbounce ;
			return message;
	}
}
