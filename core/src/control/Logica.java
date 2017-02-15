package control;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.Contact;

import comunes.ContactAdapter;
import comunes.Teclado;
import interfaces.IObservable;
import interfaces.IObservador;

public class Logica extends ContactAdapter implements IObservable {

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
	public void addObserver(IObservador observador) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeObserver(IObservador observador) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyObservers(ArrayList<IObservador> observador) {
		// TODO Auto-generated method stub

	}

}
