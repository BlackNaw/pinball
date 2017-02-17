package control;

import com.badlogic.gdx.physics.box2d.Contact;

import bodies.MyBody;
import comunes.ContactAdapter;

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
