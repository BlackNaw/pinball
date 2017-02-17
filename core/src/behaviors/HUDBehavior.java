package behaviors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;

import actores.HUD;
import bodies.MyBody;
import comunes.Constantes;
import interfaces.IHUD;
import interfaces.IReiniciable;

public class HUDBehavior extends MyBehavior implements IReiniciable {
	public HUDBehavior(MyBody myBody) {
		super(myBody);
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		myBody.sprite.draw(batch);
		myBody.font.draw(batch, "Vidas: "+HUD.vidas,myBody.sprite.getX()+20,myBody.sprite.getY());
		myBody.font.draw(batch, "Score: "+HUD.puntuacion,myBody.sprite.getX()+20,myBody.sprite.getY()-25);
		
	}

	@Override
	public void reiniciar() {
		HUD.puntuacion=0;
		HUD.vidas=3;
		
	}
	
	

}
