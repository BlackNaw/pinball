package control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.Contact;

import comunes.ContactAdapter;

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
		// TODO Auto-generated method stub
		super.beginContact(contact);
	}


}
