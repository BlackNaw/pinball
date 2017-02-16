package control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;

import comunes.MakingACage;
import comunes.MyCamera;
import comunes.Teclado;
import comunes.Alerta;
import comunes.Constantes;
import comunes.ContactAdapter;
import debug.MyDebug;
import interfaces.IObservable;

public class Game implements Disposable{

	Stage stage;
	MyCamera mycamera;
	SpriteBatch batch;
	MyDebug myDebug;
	World world;
	GestorElementos gestor;
	MakingACage caja;
	Logica logica;
	Teclado teclado;
	Alerta alerta;
	
	
	public Game(World world) {
		this.world=world;
		batch = new SpriteBatch();
		mycamera=new MyCamera();
		stage=new Stage(mycamera.viewport,batch);
		teclado=new Teclado();
		Gdx.input.setInputProcessor(teclado);
		myDebug=new MyDebug();
		teclado.addObserver(myDebug);
////		caja = new MakingACage(world, 0, Gdx.graphics.getWidth() / Constantes.PIXELS_TO_METERS,
//				Gdx.graphics.getHeight() / Constantes.PIXELS_TO_METERS, 1);
		logica=new Logica();
		gestor=new GestorElementos(world);
		gestor.anadirElementosStage(stage);
//		alerta=new Alerta(logica);
		this.world.setContactListener(logica);
	}
	
	
	public void act(){
		logica.act();
		stage.act();
		
	}
	
	public void render(){
		//UPDATE
		mycamera.update();
		
		//DRAWS
		stage.draw();
		mycamera.draw(batch);
		myDebug.draw(world,batch);
		
	}


	@Override
	public void dispose() {
		batch.dispose();
		stage.dispose();
		
	}
	

}
