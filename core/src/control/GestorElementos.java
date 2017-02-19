package control;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import actores.Ball;
import actores.Boton;
import actores.BumperA;
import actores.ConjuntoBotones;
import actores.HUD;
import actores.MyActor;
import actores.RejillaAcceso;
import actores.Tablero;
import actores.TodosBotones;
import behaviors.TodosBotonesBehavior;
import interfaces.IObservador;


public class GestorElementos {
		MyActor ball,tablero,hud,rejillaAcceso;
		ArrayList<MyActor> bumpers=new ArrayList<MyActor>();
//		ArrayList<ConjuntoBotones> conjuntoBotones=new ArrayList<ConjuntoBotones>();
		MyActor todosBotones;
		
		
	
	public GestorElementos(World world) {
		
		ball=new Ball(world,360,200);
		tablero=new Tablero(world, 0, 0);
		hud=new HUD(world, Gdx.graphics.getWidth()-200, Gdx.graphics.getHeight()-100);
		rejillaAcceso=new RejillaAcceso(world, 45, 450);
				
		todosBotones=new TodosBotones(world, 0, 0);
		((TodosBotonesBehavior)todosBotones.myBody.myBehavior).addObserver((IObservador) ball);
		
		bumpers.add(new BumperA(world, 200, 500,(TodosBotonesBehavior) todosBotones.myBody.myBehavior));
		bumpers.add(new BumperA(world, 245, 425,(TodosBotonesBehavior) todosBotones.myBody.myBehavior));
		bumpers.add(new BumperA(world, 150, 410,(TodosBotonesBehavior) todosBotones.myBody.myBehavior));
		bumpers.add(new BumperA(world, 80,530,(TodosBotonesBehavior) todosBotones.myBody.myBehavior));
	}
	
	
	public void anadirElementosStage(Stage stage){
		((Ball)ball).setStage(stage);
		stage.addActor(tablero);
		for (MyActor myActor : bumpers) {
			stage.addActor(myActor);
		}
		stage.addActor(todosBotones);
		
		for (ConjuntoBotones conjunto : ((TodosBotones)todosBotones).getConjuntoBotones()) {
			for (MyActor myActor : conjunto.getBotones()) {
				stage.addActor(myActor); 
			}
			
		}
//		for (ConjuntoBotones conjunto : conjuntoBotones) {
//			for (MyActor myActor : conjunto.getBotones()) {
//				stage.addActor(myActor); 
//			}
//		}
		
		stage.addActor(rejillaAcceso);
		stage.addActor(ball);
		stage.addActor(hud);
	}
	
	
	public MyActor getBall(){
		return ball;
	}
	
}
