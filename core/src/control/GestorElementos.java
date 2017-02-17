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


public class GestorElementos {
		MyActor ball,tablero,hud,rejillaAcceso;
		ArrayList<MyActor> bumpers=new ArrayList<MyActor>();
		ArrayList<ConjuntoBotones> conjuntoBotones=new ArrayList<ConjuntoBotones>();
		
		
	
	public GestorElementos(World world) {
		ball=new Ball(world,360,200);
		tablero=new Tablero(world, 0, 0);
		hud=new HUD(world, Gdx.graphics.getWidth()-200, Gdx.graphics.getHeight()-100);
		rejillaAcceso=new RejillaAcceso(world, 45, 450);
		bumpers.add(new BumperA(world, 200, 500));
		bumpers.add(new BumperA(world, 245, 425));
		bumpers.add(new BumperA(world, 150, 410));
		bumpers.add(new BumperA(world, 80,530));
		
		conjuntoBotones.add(new ConjuntoBotones(world, 32, 305, 0,1));
		conjuntoBotones.add(new ConjuntoBotones(world, 345, 290, 30,0.5f));
		conjuntoBotones.add(new ConjuntoBotones(world, 335, 525, 40,1f));
		conjuntoBotones.add(new ConjuntoBotones(world, 58, 467, -60,1.5f));
		conjuntoBotones.add(new ConjuntoBotones(world, 43,587, -58,1.5f));
	}
	
	
	public void anadirElementosStage(Stage stage){
		stage.addActor(tablero);
		for (MyActor myActor : bumpers) {
			stage.addActor(myActor);
		}
		for (ConjuntoBotones conjunto : conjuntoBotones) {
			for (MyActor myActor : conjunto.getBotones()) {
				stage.addActor(myActor); 
			}
		}
		
		stage.addActor(rejillaAcceso);
		stage.addActor(ball);
		stage.addActor(hud);
	}
	
	
	public MyActor getBall(){
		return ball;
	}
	
}
