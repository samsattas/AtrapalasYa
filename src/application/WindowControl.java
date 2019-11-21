package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.*;
import threads.*;

public class WindowControl implements Initializable {
	private ArrayList<Ball> balls;
	private Game game;
	
	@FXML
	private Pane pane;
	
	@FXML
	private MenuBar menuBar;
	
	@FXML
	private MenuItem salir;
	
	@FXML
	private MenuItem info;
	
	@FXML
	private MenuItem save;
	
	@FXML
	private MenuItem load;
	
	private GraphicsContext gc;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	} 
	
	public void showInfo() {
		Label secondLabel = new Label("El juego consiste en atrapar todas las pelotas, para ello debera \n"
									+ "dar click sobre ellas mientras se encuentran en movimiento. Entre \n"
									+ "menos rebotes tenga, mejor. Si logra superar a alguno de los primeros \n"
									+ "10 mejores puntajes, podra colocar su nombre en el hall de la fama y \n"
									+ "demostrar tus habilidades como jugador. \n"
									+ "Buena suerte jugador :D");
		Font font = new Font("Impact", 20);
		secondLabel.setFont(font);
		 
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(secondLabel);

        Scene secondScene = new Scene(secondaryLayout, 600, 300);

        Stage newWindow = new Stage();
        newWindow.setTitle("Acerca del Juego");
        newWindow.setScene(secondScene);

        newWindow.setX(500);
        newWindow.setY(500);

        newWindow.show();
	}
	
	
	
	public void exit() {
		System.exit(0);
	}
	
	
	public void save() {
		game = new Game();
		try {
			game.save();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void start(){
		Canvas canvas = new Canvas(pane.getWidth(), pane.getHeight()-menuBar.getHeight());
		pane.getChildren().add(canvas);
		gc = canvas.getGraphicsContext2D();
		AnimationThread at = new AnimationThread(pane.getWidth(), pane.getHeight()-menuBar.getHeight());
		at.start();
	}
	
	
	public void draw( double x, double y, double radius, double i, double j) {
		gc.setFill(Color.DARKGREEN);
		gc.clearRect(0,0,i, j);
		gc.fillOval(x, y, radius, radius);
	}
	
	
	public void load() {
		try {
			game = new Game();
			game.load();
			balls = game.getBList();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void animate2(double x, double y) {
		load();
		boolean dir = true;
		while(true) {
			for(int i=0; i<balls.size();i++) {				
				if(balls.get(i).getDirection().equals("DERECHA")) {
					if(dir) {
						if(balls.get(i).getX()<=x-30) {
							draw( balls.get(i).getX(), balls.get(i).getY(), balls.get(i).getRadius(), x, y);
							balls.get(i).setX(balls.get(i).getX()+1);;
						}else {
							dir = false;
						}
					}else {
						if(balls.get(i).getX()>=0) {
							draw( balls.get(i).getX(), balls.get(i).getY(), balls.get(i).getRadius(), x, y);
							balls.get(i).setX(balls.get(i).getX()-1);;
						}else {
							dir = true;
						}
					}
				} else if(balls.get(i).getDirection().equals("IZQUIERDA")) {
					if(dir) {
						if(balls.get(i).getX()<=x-30) {
							draw( balls.get(i).getX(), balls.get(i).getY(), balls.get(i).getRadius(), x, y);
							balls.get(i).setX(balls.get(i).getX()-1);;
						}else {
							dir = false;
						}
					}else {
						if(balls.get(i).getX()>=0) {
							draw( balls.get(i).getX(), balls.get(i).getY(), balls.get(i).getRadius(), x, y);
							balls.get(i).setX(balls.get(i).getX()+1);;
						}else {
							dir = true;
						}
					}
				} else if(balls.get(i).getDirection().equals("ABAJO")) {
					if(dir) {
						if(balls.get(i).getY()<=y-30) {
							draw( balls.get(i).getX(), balls.get(i).getY(), balls.get(i).getRadius(), x, y);
							balls.get(i).setY(balls.get(i).getY()+1);;
						}else {
							dir = false;
						}
					}else {
						if(balls.get(i).getY()>=0) {
							draw( balls.get(i).getX(), balls.get(i).getY(), balls.get(i).getRadius(), x, y);
							balls.get(i).setY(balls.get(i).getY()-1);;
						}else {
							dir = true;
						}
					}
				} else {
					if(dir) {
						if(balls.get(i).getY()<=y-30) {
							draw( balls.get(i).getX(), balls.get(i).getY(), balls.get(i).getRadius(), x, y);
							balls.get(i).setY(balls.get(i).getY()-1);;
						}else {
							dir = false;
						}
					}else {
						if(balls.get(i).getY()>=0) {
							draw( balls.get(i).getX(), balls.get(i).getY(), balls.get(i).getRadius(), x, y);
							balls.get(i).setY(balls.get(i).getY()+1);;
						}else {
							dir = true;
						}
					}
				}
			}
			
		}
		
	}
	
	
}
