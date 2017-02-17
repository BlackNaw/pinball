package control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.Contact;

import actores.MyActor;
import behaviors.MyBehavior;
import bodies.MyBody;
import comunes.ContactAdapter;
import fixturas.MyFixture;

public class Logica extends ContactAdapter {
	MyBody bodyA, bodyB;

	public Logica() {

	}

	public void act() {

	}

	@Override
	public void beginContact(Contact contact) {
		super.beginContact(contact);
		bodyA = (MyBody) (contact.getFixtureA().getBody().getUserData());
		bodyB = (MyBody) (contact.getFixtureB().getBody().getUserData());

		if (bodyA.getClass().getSimpleName().contains("ball")) {
			bodyB.myBehavior.chocar(bodyA.body);
		} else {
			bodyA.myBehavior.chocar(bodyB.body);

		}

	}

}
