package behaviors;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import bodies.AgujeroNegroBody;
import bodies.MyBody;
import comunes.Constantes;
import comunes.Estados;

public class AgujeroNegroBehaviors extends MyBehavior {

	private float elapsedTime = 0;
	ArrayList<Body> actores;
	boolean parado = false;

	public AgujeroNegroBehaviors(MyBody myBody, ArrayList<Body> actores) {
		super(myBody);
		this.actores = actores;
	}

	@Override
	public void act(float delta) {
		if (Estados.bolaEnJuego.getEstado())
			for (Body myActor : actores) {
				double distanciaObjetos = obtenerDistancia(myBody.body, myActor);
				if (distanciaObjetos <= Constantes.DISTANCIA_PARAR_OBJETO_AGUJERO_NEGRO) {
					paralizarObjeto(myActor, distanciaObjetos);
				}
				atraerObjetos(myActor, distanciaObjetos);
			}
	}

	private double obtenerDistancia(Body actorOne, Body actorTwo) {
		return Math.sqrt(Math.pow(actorOne.getPosition().x - actorTwo.getPosition().x, 2)
				+ Math.pow(actorOne.getPosition().y - actorTwo.getPosition().y, 2));
	}

	private void paralizarObjeto(Body myActor, double distanciaObjetos) {
		if (distanciaObjetos <= Constantes.DISTANCIA_LANZAR_OBJETO_AGUJERO_NEGRO) {
			lanzarObjeto(myActor);
		}
	}

	private void atraerObjetos(Body myActor, double distanciaObjetos) {
		for (int i = Constantes.DISTANCIA_AGUJERO_NEGRO.length - 1; i >= 0; i--) {
			if (distanciaObjetos <= Constantes.DISTANCIA_AGUJERO_NEGRO[i]) {
				myActor.applyForce(
						(myBody.body.getPosition().x - myActor.getPosition().x) * Constantes.ATRACCION_AGUJERO_NEGRO[i],
						(float) ((myBody.body.getPosition().y - myActor.getPosition().y)
								* Constantes.DISTANCIA_AGUJERO_NEGRO[i]),
						myActor.getPosition().x, myActor.getPosition().y, true);
				i = 0;
			}
		}
	}

	private void lanzarObjeto(Body myActor) {
		float numero = obtenerLanzamientoObjetoX(myActor);
		myActor.applyLinearImpulse(new Vector2(numero, Constantes.VELOCIDAD_Y_LANZAMIENTO_OBJETO_AGUJERO_NEGRO),
				myActor.getWorldCenter(), true);
	}

	private float obtenerLanzamientoObjetoX(Body myActor) {
		Random random = new Random();
		float numero = random.nextFloat();
		if (numero >= 0.7f) {
			numero = numero / 2;
		}
		if ((myActor.getPosition().x * Constantes.PIXELS_TO_METERS) > (Constantes.ANCHO_PANTALLA / 2)) {
			numero = -numero;
		}
		return numero;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		Animation<?> animation = ((AgujeroNegroBody) myBody).animacion;
		float x = myBody.sprite.getX();
		float y = myBody.sprite.getY();
		elapsedTime += Gdx.graphics.getDeltaTime();
		TextureRegion textureRegion = (TextureRegion) animation.getKeyFrame(elapsedTime, true);
		batch.draw(textureRegion, x, y);
	}

}
