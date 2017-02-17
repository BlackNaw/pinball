package actores;

import com.badlogic.gdx.physics.box2d.World;

import behaviors.BallBehavior;
import behaviors.RejillaAccesoBehaviors;
import bodies.BallBody;
import bodies.RejillaAccesoBody;
import fixturas.BallFixture;
import fixturas.RejillaAccesoFixture;

public class RejillaAcceso extends MyActor{

	public RejillaAcceso(World world, float posX, float posY) {
		super(world, posX, posY);
		myBody = new RejillaAccesoBody(world, posX, posY);
		myBody.myBehavior = new RejillaAccesoBehaviors(myBody);
		myFixture = new RejillaAccesoFixture(myBody);
	}

}
