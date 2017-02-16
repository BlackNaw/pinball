package behaviors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import bodies.MyBody;
import comunes.Constantes;
import comunes.Teclado;
import control.Logica;
import interfaces.IObservable;
import interfaces.IObservador;

public class BallBehavior extends MyBehavior implements IObservador {

	public BallBehavior(MyBody myBody) {
		super(myBody);
		
	}
	@Override
	public void act(float delta) {
		myBody.sprite.setPosition((myBody.body.getPosition().x * Constantes.PIXELS_TO_METERS) - myBody.sprite.getWidth() / 2,
				(myBody.body.getPosition().y * Constantes.PIXELS_TO_METERS) -myBody.sprite.getHeight() / 2);
		
		
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		myBody.sprite.draw(batch);
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	

	

}
