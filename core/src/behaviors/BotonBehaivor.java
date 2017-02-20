package behaviors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import actores.Boton;
import actores.HUD;
import actores.MyActor;
import bodies.BallBody;
import bodies.BotonBody;
import bodies.MyBody;
import comunes.Constantes;
import interfaces.IReiniciable;

public class BotonBehaivor extends MyBehavior implements IReiniciable{
	float vecX, vecY;
	float fuerzaBumperA = Constantes.FUERZA_MAX_BUMPER;
	public boolean activado=false;
	public BotonBehaivor(MyBody myBody) {
		super(myBody);
	}

	@Override
	public void act(float delta) {
		
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		myBody.sprite.draw(batch);
		
	}
	
	@Override
	public void chocar(Body bolaBody) {
		if(!activado){
			HUD.puntuacion+=50;
		}
		
		activado=true;
		
		vecX = bolaBody.getLinearVelocity().x * -0.08f;
		vecY = bolaBody.getLinearVelocity().y * -0.08f;

		vecX = (Math.abs(vecX) < fuerzaBumperA) ? vecX : fuerzaBumperA * (Math.abs(vecX) / vecX);
		vecY = (Math.abs(vecY) < fuerzaBumperA) ? vecY : fuerzaBumperA * (Math.abs(vecY) / vecY);

		vecY = (vecY < (-0.4f)) ? -0.4f : vecY;
		
		bolaBody.applyLinearImpulse(new Vector2(vecX, vecY), myBody.body.getWorldCenter(), true);
		
		((BotonBody)myBody).desactivar();
	
	}

	@Override
	public void reiniciar() {
		activado=false;
		((BotonBody)myBody).activar();
		
	}



	
	
	
	
	

}
