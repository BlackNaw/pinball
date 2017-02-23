package comunes;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table.Debug;

import actores.MyActor;
import behaviors.BallBehavior;
import debug.MyDebug;
import interfaces.IObservable;
import interfaces.IObservador;

public class Teclado extends InputAdapter implements IObservable {
	public ArrayList<IObservador> observadores;
	private boolean ctrl = false;
	public boolean space = false;
	Stage stage;
	float contador = 0;

	public Teclado(Stage stage) {
		observadores = new ArrayList<IObservador>();
		this.stage = stage;
	}

	@Override
	public boolean keyDown(int keycode) {
		comprobarCombinacion(keycode);
		

		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == 129) {
			ctrl = false;
		}
		if (keycode == Keys.SPACE) {
			for (Actor actor : stage.getActors()) {
				if (actor.getClass().getSimpleName().contains("Ball") && !Estados.bolaEnJuego.getEstado()&&Estados.bolaEnLanzador.getEstado()) {
					((BallBehavior)(((MyActor) actor).myBody.myBehavior)).setPulsado(true);
				
				}
			}
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
