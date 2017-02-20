package control;

import com.badlogic.gdx.physics.box2d.Contact;

import bodies.MyBody;
import bodies.RejillaAccesoBody;
import comunes.ContactAdapter;
import comunes.Estados;
import fixturas.ISensor;

public class Logica extends ContactAdapter {

	MyBody bodyA, bodyB;

	public Logica() {

	}

	public void act() {
		if(!Estados.juegoTerminado.getEstado()){
			//System.out.println("en juego");
			
		}
	}

	@Override
	public void beginContact(Contact contact) {
		super.beginContact(contact);
		bodyA = (MyBody) (contact.getFixtureA().getBody().getUserData());
		bodyB = (MyBody) (contact.getFixtureB().getBody().getUserData());
		
		//SENSORES
		if(contact.getFixtureA().isSensor()){
			((ISensor)bodyA).sensorPulsado();
		}else if(contact.getFixtureB().isSensor()){
			((ISensor)bodyB).sensorPulsado();
		}
			
			
		if (bodyA.getClass().getSimpleName().contains("Ball")) {
			bodyB.myBehavior.chocar(bodyA.body);
		} else {
			bodyA.myBehavior.chocar(bodyB.body);

		}

	}
	
	
	@Override
	public void endContact(Contact contact) {
		super.endContact(contact);
		bodyA = (MyBody) (contact.getFixtureA().getBody().getUserData());
		bodyB = (MyBody) (contact.getFixtureB().getBody().getUserData());
		if (bodyA.getClass().getSimpleName().contains("Muro")) {
			bodyB.myBehavior.chocar(bodyA.body);
		} else if (bodyB.getClass().getSimpleName().contains("Muro")) {
			bodyA.myBehavior.chocar(bodyB.body);

		}
	}

}
