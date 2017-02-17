package behaviors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;

import bodies.MyBody;
import comunes.Constantes;
import interfaces.IHUD;
import interfaces.IReiniciable;

public class HUDBehavior extends MyBehavior implements IHUD, IReiniciable {
	
	public int puntuacion=0;
	public int numeroVidas=Constantes.NUMEROVIDAS;
	public HUDBehavior(MyBody myBody) {
		super(myBody);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		
		myBody.sprite.draw(batch);
		myBody.font.draw(batch, "Vidas: "+numeroVidas,myBody.sprite.getX()+50,myBody.sprite.getY());
		myBody.font.draw(batch, "Score: "+puntuacion,myBody.sprite.getX()+50,myBody.sprite.getY()-25);
		
	}

	@Override
	public void restarVida() {
		numeroVidas--;
		
	}

	@Override
	public void sumarPuntuacion(int puntuacion) {
		this.puntuacion+=puntuacion;
		
	}

	@Override
	public void reiniciar() {
		this.puntuacion=0;
		this.numeroVidas=3;
		
	}
	
	

}
