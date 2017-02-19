package comunes;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.scenes.scene2d.ui.Table.Debug;

import debug.MyDebug;
import interfaces.IObservable;
import interfaces.IObservador;

public class Teclado extends InputAdapter implements IObservable {
	public  ArrayList<IObservador> observadores;
	private boolean ctrl = false;
	public boolean space = false;

	public Teclado() {
		observadores = new ArrayList<IObservador>();
	}

	@Override
	public boolean keyDown(int keycode) {
		comprobarCombinacion(keycode);
		if (keycode == Input.Keys.SPACE) {
			space = true;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == 129) {
			ctrl = false;
		}

		return true;
	}

	private void comprobarCombinacion(int keycode) {
		if (ctrl) {

			if (keycode == Input.Keys.D) {
				notifyObservers();

			}
		}
		if (keycode == 129)
			ctrl = true;

	}


	@Override
	public void addObserver(IObservador observador) {
		observadores.add(observador);
	}

	@Override
	public void removeObserver(IObservador observador) {
		observadores.remove(observador);
	}

	@Override
	public void notifyObservers() {
		for (IObservador iObservador : observadores) {
			iObservador.update();
		}

	}

}
