package control;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import actores.Ball;
import actores.BumperA;
import actores.HUD;
import actores.MyActor;
import actores.RejillaAcceso;
import actores.Tablero;


public class GestorElementos {
		MyActor ball,tablero,hud,rejillaAcceso;
		ArrayList<MyActor> bumpers=new ArrayList<MyActor>();
		
		
	
	public GestorElementos(World world) {
		ball=new Ball(world,360,200);
		tablero=new Tablero(world, 0, 0);
		hud=new HUD(world, Gdx.graphics.getWidth()-200, Gdx.graphics.getHeight()-100);
		rejillaAcceso=new RejillaAcceso(world, 200, 200);
		bumpers.add(new BumperA(world, 200, 500));
		bumpers.add(new BumperA(world, 245, 425));
		bumpers.add(new BumperA(world, 150, 410));
		bumpers.add(new BumperA(world, 80,530));
	}
	
	
	public void anadirElementosStage(Stage stage){
		stage.addActor(tablero);
		for (MyActor myActor : bumpers) {
			stage.addActor(myActor);
		}
		stage.addActor(rejillaAcceso);
		stage.addActor(ball);
		stage.addActor(hud);
	}
	
	
	public MyActor getBall(){
		return ball;
	}
	
}
