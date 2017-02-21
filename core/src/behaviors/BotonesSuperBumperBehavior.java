package behaviors;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;

import actores.ConjuntoBotones;
import bodies.MyBody;
import comunes.Constantes;
import interfaces.IObservable;
import interfaces.IObservador;
import interfaces.IReiniciable;

public class BotonesSuperBumperBehavior extends MyBehavior implements IReiniciable, IObservable {
	ArrayList<ConjuntoBotones> conjuntoBotones;
	public  ArrayList<IObservador> observadores;
	public boolean fuera=false;

	public BotonesSuperBumperBehavior(MyBody myBody, ArrayList<ConjuntoBotones> conjuntoBotones) {
		super(myBody);
		this.conjuntoBotones = conjuntoBotones;
		observadores=new ArrayList<IObservador>();
	}

	@Override
	public void act(float delta) {
		if (comprobarBotones()&&!fuera) {
			notifyObservers();
			
			Thread bumper = new Thread(new Runnable() {

				public void run() {
					try {
						fuera=true;
						Thread.sleep((Constantes.TIEMPO_SUPERBUMPER * 1000));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					reiniciar();
					fuera=false;
			}
			});
			bumper.start();
			
		
			
			
		}

	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub

	}

	private boolean comprobarBotones() {
		boolean activado=true;
		for (ConjuntoBotones b : conjuntoBotones) {
			if (!b.comprobarConjuntoBotones())
				activado=false;
		}
		return activado;
	}

	@Override
	public void reiniciar() {
		for (ConjuntoBotones conjuntoBotones2 : conjuntoBotones) {
			conjuntoBotones2.reiniciarConjuntoBotones();
		}

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
