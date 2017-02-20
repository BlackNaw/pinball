package actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import behaviors.BallBehavior;
import behaviors.MyBehavior;
import behaviors.BotonesSuperBumperBehavior;
import bodies.BallBody;
import control.Logica;
import fixturas.BallFixture;
import fixturas.MyFixture;
import interfaces.IObservable;
import interfaces.IObservador;

public class Ball extends MyActor implements IObservador{
	Stage stage;
	World world;
	public Ball(World world, float posX, float posY) {
		super(world, posX, posY);
		this.world=world;
		myBody = new BallBody(world, posX, posY);
		myBody.myBehavior = new BallBehavior(myBody);
		myFixture = new BallFixture(myBody);
	}

	@Override
	public void update() {
		System.out.println("nueva bola");
		MyActor bola= new Ball(world, 200, 400);
		stage.addActor(bola);
	}
	
	
	public void setStage(Stage stage){
		this.stage=stage;
	}

}
