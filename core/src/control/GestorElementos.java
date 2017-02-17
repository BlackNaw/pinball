package control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import actores.Ball;
import actores.HUD;
import actores.MyActor;
import actores.Tablero;


public class GestorElementos {
		MyActor ball,tablero,hud;
		
		
	
	public GestorElementos(World world) {
		ball=new Ball(world,360,200);
		tablero=new Tablero(world, 0, 0);
		hud=new HUD(world, Gdx.graphics.getWidth()-200, Gdx.graphics.getHeight()-100);
	}
	
	
	public void anadirElementosStage(Stage stage){
		stage.addActor(tablero);
		stage.addActor(ball);
		stage.addActor(hud);
	}
	
	
	public MyActor getBall(){
		return ball;
	}
	
}
