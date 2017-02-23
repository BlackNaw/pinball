package actores;

import java.util.ArrayList;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import behaviors.AgujeroNegroBehaviors;
import behaviors.MuroBehaviors;
import bodies.AgujeroNegroBody;
import bodies.MuroBody;
import fixturas.AgujeroNegroFixture;
import fixturas.MuroFixture;

public class AgujeroNegro extends MyActor{

	public AgujeroNegro(World world, float posX, float posY, ArrayList<Body> actores) {
		super(world, posX, posY);
		myBody = new AgujeroNegroBody(world, posX, posY);
		myBody.myBehavior = new AgujeroNegroBehaviors(myBody, actores);
		myFixture = new AgujeroNegroFixture(myBody);
	}

}
