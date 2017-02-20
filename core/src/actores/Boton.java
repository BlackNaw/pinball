package actores;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import behaviors.BallBehavior;
import behaviors.BotonBehaivor;
import bodies.BallBody;
import bodies.BotonBody;
import fixturas.BallFixture;
import fixturas.BotonFixture;

public class Boton extends MyActor {
	public Boton(World world,float posX, float posY, float giro) {
		super(world, posX, posY);
		myBody = new BotonBody(world, posX, posY,giro);
		myBody.myBehavior = new BotonBehaivor(myBody);
		myFixture = new BotonFixture(myBody,giro);
		
	}
	

}
