package actores;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import behaviors.SuperBumperBehavior;
import bodies.SuperBumperBody;
import fixturas.BumperAFixture;
import interfaces.IObservador;

public class SuperBumper extends MyActor{
	public SuperBumper(World world, float posX, float posY) {
		super(world, posX, posY);
		myBody = new SuperBumperBody(world, posX, posY);
		myBody.myBehavior = new SuperBumperBehavior(myBody);
		myFixture = new BumperAFixture(myBody);
	}


}
