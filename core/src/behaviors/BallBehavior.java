package behaviors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import actores.Ball;
import actores.HUD;
import actores.MyActor;
import bodies.MyBody;
import comunes.Constantes;
import comunes.Estados;
import comunes.Teclado;
import control.Logica;
import interfaces.IObservable;
import interfaces.IObservador;

public class BallBehavior extends MyBehavior {
	Stage stage;
	Ball ball;
	World world;
	int contador=0;
	public BallBehavior(MyBody myBody,Ball ball,World world) {
		super(myBody);
		this.ball=ball;
		this.world=world;
	}

	@Override
	public void act(float delta) {
		if ((myBody.body.getPosition().x * Constantes.PIXELS_TO_METERS) < 250) {
			Estados.bolaEnJuego.setEstado(true);
		}
		
		myBody.sprite.setPosition(
				(myBody.body.getPosition().x * Constantes.PIXELS_TO_METERS) - myBody.sprite.getWidth() / 2,
				(myBody.body.getPosition().y * Constantes.PIXELS_TO_METERS) - myBody.sprite.getHeight() / 2);


		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			myBody.body.applyLinearImpulse(new Vector2(0, 0.5f), myBody.body.getWorldCenter(), true);
		}
		
		
		//CONTROLA FIN DEL JUEGO
		if((myBody.body.getPosition().y * Constantes.PIXELS_TO_METERS) < 15&&(myBody.body.getPosition().x * Constantes.PIXELS_TO_METERS) < 250){
			contador=0;
			for(Actor actor :stage.getActors()){
				if(actor.getClass().getSimpleName().contains("Ball")){
					contador++;
				}
			}
			if(contador>1){
				ball.myBody.body.setActive(false);
				ball.remove();
			}else if(HUD.vidas>0){
				Estados.bolaEnJuego.setEstado(false);
				HUD.vidas--;
				stage.addActor(new Ball(world,360,200));
				ball.myBody.body.setActive(false);
				ball.remove();
			}else {
				Estados.juegoTerminado.setEstado(true);
			}
		}
		

	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		myBody.sprite.draw(batch);

	}
	
	public void setStage(Stage stage){
		this.stage=stage;
	}

}
