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


	public Logica() {
		
	}

	public void act() {
		if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT))
			System.out.println("izquierda");
		if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT))
			System.out.println("derecha");

	}
	@Override
	public void beginContact(Contact contact) {
		super.beginContact(contact);
		((MyBody)(contact.getFixtureA().getBody().getUserData())).myBehavior.chocar(null);
		
	}
}
