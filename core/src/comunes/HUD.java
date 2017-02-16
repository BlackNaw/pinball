package comunes;

import java.time.temporal.JulianFields;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public class HUD implements Disposable{
	private BitmapFont font;
	public static boolean nivel=true;
	public static int puntuacion=0;
	public static Integer highScore;
	private Texture marcoSuperior,marcoInferior;
	private int numeroVidas=3;
//	Actor actor;
	
	public HUD(){	
		marcoSuperior=new Texture("Imagenes/efectoMarco.png");
		marcoInferior=new Texture("Imagenes/efectoMarcoVolteado.png");
		this.font=new BitmapFont(Gdx.files.internal("Fuente/painball.fnt"));
	}

	public void pintar(SpriteBatch batch, Camera camera) {
		batch.draw(marcoSuperior, camera.position.x-Gdx.graphics.getWidth()+160,  camera.position.y-Gdx.graphics.getHeight()/2+655,650,30);
		batch.draw(marcoInferior, camera.position.x-Gdx.graphics.getWidth()+160,  camera.position.y-Gdx.graphics.getHeight()/2+600,650,30);
		
		//font.draw(batch, "Llaves :"+Jugador.llaves.size(),camera.position.x-Gdx.graphics.getWidth()/2+20, camera.position.y+Gdx.graphics.getHeight()/2-10); 
		font.draw(batch, "Score: "+puntuacion, camera.position.x+Gdx.graphics.getWidth()/2-155, camera.position.y+Gdx.graphics.getHeight()/2-25);
		font.draw(batch, "Life: "+numeroVidas, camera.position.x+Gdx.graphics.getWidth()/2-450, camera.position.y+Gdx.graphics.getHeight()/2-25);
	}

	@Override
	public void dispose() {
		font.dispose();
	}
}
