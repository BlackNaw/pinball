package behaviors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import bodies.MyBody;
import comunes.Constantes;

public class BarraColisionadorBehavior extends MyBehavior {
	float vecX, vecY;
	float fuerzaBumperA = Constantes.FUERZA_MAX_BUMPER-0.4f;
	boolean activado=false;

	public BarraColisionadorBehavior(MyBody myBody) {
		super(myBody);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act(float delta) {

	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		if (activado)
			myBody.sprite.draw(batch);

	}

	@Override
	public void chocar(Body bolaBody) {

		Thread hilo = new Thread(new Runnable() {

			public void run() {
				activado = true;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				activado = false;
			}
		});
		hilo.start();

		vecX = bolaBody.getLinearVelocity().x * -0.08f;
		vecY = bolaBody.getLinearVelocity().y * -0.08f;

		vecX = (Math.abs(vecX) < fuerzaBumperA) ? vecX : fuerzaBumperA * (Math.abs(vecX) / vecX);
		vecY = (Math.abs(vecY) < fuerzaBumperA) ? vecY : fuerzaBumperA * (Math.abs(vecY) / vecY);
		vecX = (myBody.sprite.getRotation() < 0) ? -Math.abs(vecX) : Math.abs(vecX);
		vecY = (vecY < (-0.4f)) ? -0.4f : vecY;
		bolaBody.applyLinearImpulse(new Vector2(vecX, vecY), myBody.body.getWorldCenter(), true);
	}

}
