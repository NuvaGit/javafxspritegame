package application;
	
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			Canvas canvas = new Canvas(600,600);
			GraphicsContext context = canvas.getGraphicsContext2D();
			root.setCenter(canvas);
			context.setFill(Color.BLUE);
			context.fillRect(0, 0, 600, 600);
			// monitor keyboard input
			ArrayList<String> inputList = new ArrayList<String>();
			scene.setOnKeyPressed(
					(KeyEvent event) -> {
						String keyName = event.getCode().toString();
							if(!inputList.contains(keyName))
								inputList.add(keyName);
					}
					
					);
			scene.setOnKeyReleased(
					(KeyEvent event) -> {
						String keyName = event.getCode().toString();
								inputList.remove(keyName);
					}
					
					);
			//sprite creation
			Sprite horshe = new Sprite();
			horshe.position.set(100, 100);
			horshe.setImage("horshe.jpg");
			
			
			AnimationTimer gameloop = new AnimationTimer() {
				public void handle(long nanotime) {
					horshe.velocity.set(0, 0);
					if(inputList.contains("LEFT"))horshe.velocity.add(-50,0);
					if(inputList.contains("RIGHT"))horshe.velocity.add(50,0);
					if(inputList.contains("UP"))horshe.velocity.add(0,-50);
					if(inputList.contains("DOWN"))horshe.velocity.add(0,50);

horshe.position.add(horshe.velocity.multiply(1/60));
					horshe.render(context);
					
				}
			};
			gameloop.start();
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
