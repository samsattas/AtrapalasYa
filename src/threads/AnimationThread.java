package threads;

import application.WindowControl;
import model.Ball;


public class AnimationThread extends Thread{
	private WindowControl wc;
	private double x;
	private double y;
	
	
	
	public AnimationThread(double x, double y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		setDaemon(true);
	}

	public void run() {
		try {
			wc = new WindowControl();
			wc.animate2(this.x, this.y);
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
