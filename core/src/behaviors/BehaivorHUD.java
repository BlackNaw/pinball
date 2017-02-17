package behaviors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;

import bodies.MyBody;

public class BehaivorHUD extends MyBehavior {
	public int numeroVidas=3;
	public int puntuacion=0;
	public BehaivorHUD(MyBody myBody) {
		super(myBody);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(myBody.marcoSuperior,Gdx.graphics.getWidth()+myBody.body.getPosition().x, Gdx.graphics.getHeight()/2+655,650,30);
		batch.draw(myBody.marcoInferior,Gdx.graphics.getWidth()+160, Gdx.graphics.getHeight()/2+600,650,30);
		
		//font.draw(batch, "Llaves :"+Jugador.llaves.size(),camera.position.x-Gdx.graphics.getWidth()/2+20, camera.position.y+Gdx.graphics.getHeight()/2-10); 
		myBody.font.draw(batch, "Score: "+puntuacion,Gdx.graphics.getWidth()/2-155,Gdx.graphics.getHeight()/2-25);
		myBody.font.draw(batch, "Life: "+numeroVidas,Gdx.graphics.getWidth()/2-450,Gdx.graphics.getHeight()/2-25);
		
	}

}
