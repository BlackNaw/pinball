package actores;

import com.badlogic.gdx.physics.box2d.World;

import behaviors.BallBehavior;
import behaviors.BehaivorHUD;
import bodies.BallBody;
import bodies.HUDBody;
import fixturas.BallFixture;

public class HUD extends MyActor {

	public HUD(World world, float posX, float posY) {
		super(world, posX, posY);
		myBody = new HUDBody(world, posX, posY);
		myBody.myBehavior = new BehaivorHUD(myBody);
//		myFixture = new BallFixture(myBody);
	}

}
