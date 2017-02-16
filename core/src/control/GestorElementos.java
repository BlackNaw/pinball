package control;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import actores.Ball;
import actores.MyActor;
import actores.Tablero;
import behaviors.BallBehavior;
import bodies.BallBody;
import fixturas.BallFixture;
import fixturas.MyFixture;
import interfaces.IObservable;
import interfaces.IObservador;


public class GestorElementos {
		MyActor ball,tablero;
		
		
	
	public GestorElementos(World world) {
		ball=new Ball(world,360,200);
		tablero=new Tablero(world, 0, 0);
	}
	
	
	public void anadirElementosStage(Stage stage){
		stage.addActor(tablero);
		stage.addActor(ball);
	}
	
	
	public MyActor getBall(){
		return ball;
	}
	
}
