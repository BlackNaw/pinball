package actores;

import com.badlogic.gdx.physics.box2d.World;

import behaviors.MuroBehaviors;
import bodies.MuroBody;
import fixturas.MuroFixture;
import interfaces.IObservador;

public class Muro extends MyActor implements IObservador {

	boolean impulsar = false;

	public Muro(World world, float posX, float posY, int alto, int ancho, String tipoMuro) {
		super(world, posX, posY);
		myBody = new MuroBody(world, posX, posY, alto, ancho, tipoMuro);
		myBody.myBehavior = new MuroBehaviors(myBody);
		myFixture = new MuroFixture(myBody);
	}

	public void setImpulsar(boolean impulsar) {
		((MuroBehaviors) myBody.myBehavior).impulso = impulsar;
	}

	@Override
	public void update() {
		if (((MuroBehaviors) myBody.myBehavior).impulso == true) {
			setDesactivar(false);
		}
	}

	public void setDesactivar(boolean activar) {
		((MuroBehaviors) myBody.myBehavior).desactivar = activar;
	}

}
