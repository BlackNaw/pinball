package control;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.Contact;

import comunes.ContactAdapter;
import comunes.Teclado;
import interfaces.IObservable;
import interfaces.IObservador;

public class Logica extends ContactAdapter {

	private ArrayList<IObservador> observadores;

	public Logica() {
		observadores = new ArrayList<IObservador>();
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
