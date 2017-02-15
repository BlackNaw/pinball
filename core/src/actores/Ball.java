package actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;

import behaviors.BallBehavior;
import behaviors.MyBehavior;
import bodies.BallBody;
import control.Logica;
import fixturas.BallFixture;
import fixturas.MyFixture;
import interfaces.IObservable;
import interfaces.IObservador;

public class Ball extends MyActor {

	public Ball(World world, IObservable observable, float posX, float posY) {
		super(world, posX, posY);
		BallBody bodyBall = new BallBody(world, posX, posY);
		myBehavior = new BallBehavior(bodyBall,observable);
		myFixture = new BallFixture(bodyBall);
	}

}
