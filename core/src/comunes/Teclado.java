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
	public static ArrayList<IObservador> debug;
	public static ArrayList<IObservador> observadoresUno;
	private boolean ctrl = false;
	public boolean space = false;

	public Teclado() {
		debug = new ArrayList<IObservador>();
		observadoresUno = new ArrayList<IObservador>();
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
		if (keycode == Input.Keys.SPACE) {
			notifyObservers(observadoresUno);
			space = false;
		}

		return true;
	}

	private void comprobarCombinacion(int keycode) {
		if (ctrl) {

			if (keycode == Input.Keys.D) {
				notifyObservers(debug);

			}
		}
		if (keycode == 129)
			ctrl = true;

	}

	public void addObserverDebug(IObservador observador) {
		debug.add(observador);

	}

	public void addObserverDos(IObservador observador) {
		observadoresUno.add(observador);
	}

	@Override
	public void addObserver(IObservador observador) {

	}

	@Override
	public void removeObserver(IObservador observador) {
		debug.remove(observador);
	}

	@Override
	public void notifyObservers(ArrayList<IObservador> observer) {
		for (IObservador iObservador : observer) {
			iObservador.update();
		}

	}

}
