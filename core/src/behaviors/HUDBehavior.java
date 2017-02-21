package behaviors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import actores.HUD;
import bodies.MyBody;
import comunes.Constantes;
import interfaces.IHUD;
import interfaces.IReiniciable;

public class HUDBehavior extends MyBehavior implements IReiniciable {
	Texture textura;
	public HUDBehavior(MyBody myBody) {
		super(myBody);
		textura=new Texture(Gdx.files.internal("Imagenes/HUD/paredPuntuacion.png"));
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		
//		batch.draw(textura, 390, 0);
//		myBody.sprite.draw(batch);
//		myBody.font.draw(batch, "Vidas: "+HUD.vidas,myBody.sprite.getX()+20,myBody.sprite.getY());
//		if(HUD.puntuacion<100000){
//			myBody.font.draw(batch, "Score: \n"+HUD.puntuacion,myBody.sprite.getX()+20,myBody.sprite.getY()-25);
//		}else {
//		
//			myBody.font.draw(batch, "Score: "+String.valueOf(HUD.puntuacion).substring(0,String.valueOf(HUD.puntuacion).length()-3)+"K",myBody.sprite.getX()+20,myBody.sprite.getY()-25);
//		}
		
		batch.draw(textura, 390, 0);
		myBody.sprite.draw(batch);
		myBody.font.draw(batch, "Vidas:"+HUD.vidas,myBody.sprite.getX()+25,myBody.sprite.getY()+140);
		if(HUD.puntuacion<100000){
			myBody.font.draw(batch, "Score: \n"+HUD.puntuacion,myBody.sprite.getX()+25,myBody.sprite.getY()+80);
		}else {
		
			myBody.font.draw(batch, "Score: \n"+String.valueOf(HUD.puntuacion).substring(0,String.valueOf(HUD.puntuacion).length()-3)+"K",myBody.sprite.getX()+25,myBody.sprite.getY()+80);
		}
		
	}

	@Override
	public void reiniciar() {
		HUD.puntuacion=0;
		HUD.vidas=3;
		
	}
	
	

}
