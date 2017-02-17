package actores;

import com.badlogic.gdx.physics.box2d.World;

import behaviors.BallBehavior;
import behaviors.BumperABehavior;
import bodies.BallBody;
import bodies.BumperABody;
import fixturas.BallFixture;
import fixturas.BumperAFixture;

public class BumperA extends MyActor {

	public BumperA(World world, float posX, float posY) {
		super(world, posX, posY);
		myBody = new BumperABody(world, posX, posY);
		myBody.myBehavior = new BumperABehavior(myBody);
		myFixture = new BumperAFixture(myBody);
	}

}
