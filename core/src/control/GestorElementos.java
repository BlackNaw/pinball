package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import actores.Ball;
import actores.BumperA;
import actores.ConjuntoBotones;
import actores.HUD;
import actores.Muro;
import actores.MyActor;
import actores.Rejilla;
import actores.RejillaAcceso;
import actores.Tablero;

public class GestorElementos {
	MyActor ball, tablero, hud;
	ArrayList<MyActor> bumpers = new ArrayList<MyActor>();
	ArrayList<ConjuntoBotones> conjuntoBotones = new ArrayList<ConjuntoBotones>();
	HashMap<String, RejillaAcceso> rejillaAccceso;
	Muro trampilla;

	public GestorElementos(World world) {
		ball = new Ball(world, 360, 200);
		tablero = new Tablero(world, 0, 0);
		hud = new HUD(world, Gdx.graphics.getWidth() - 200, Gdx.graphics.getHeight() - 100);
		
		// ----------------------- D A V I D -------------------//
		
		rejillaAccceso = new HashMap<String, RejillaAcceso>();
		rejillaAccceso.put("rejillaAcceso", new RejillaAcceso(3, world, 168, 575, "Amarillo", false));
		rejillaAccceso.put("rejillaAccesoLab", new RejillaAcceso(2, world, 15, 450, "Verde", false));
		trampilla = new Muro(world, 254, 602, 30, 2, "bloqueo.png");
		trampilla.setDesactivar(true);
		ArrayList<Rejilla> rejillas = new ArrayList<Rejilla>();
		rejillas.add(new Rejilla(world, 16, 136, "Azul"));
		rejillas.add(new Rejilla(world, 50, 136, "Azul"));
		rejillas.add(new Rejilla(world, 316, 136, "Azul"));
		rejillas.add(new Rejilla(world, 280, 136, "Azul"));
		ArrayList<Muro> muros = new ArrayList<Muro>();
		Muro muro = new Muro(world, 16, 120, 2, 20, "bloqueo.png");
		muro.setImpulsar(true);
		muros.add(muro);
		muro = new Muro(world, 316, 120, 2, 20, "bloqueo.png");
		muro.setImpulsar(true);
		muros.add(muro);
		rejillaAccceso.put("RejillaDesague", new RejillaAcceso(world, rejillas, muros, true));
		
		// -------------------------------------//

		bumpers.add(new BumperA(world, 200, 500));
		bumpers.add(new BumperA(world, 245, 425));
		bumpers.add(new BumperA(world, 150, 410));
		bumpers.add(new BumperA(world, 80, 530));

		conjuntoBotones.add(new ConjuntoBotones(world, 32, 305, 0, 1));
		conjuntoBotones.add(new ConjuntoBotones(world, 345, 290, 30, 0.5f));
		conjuntoBotones.add(new ConjuntoBotones(world, 335, 525, 40, 1f));
		conjuntoBotones.add(new ConjuntoBotones(world, 58, 467, -60, 1.5f));
		conjuntoBotones.add(new ConjuntoBotones(world, 43, 587, -58, 1.5f));
	}

	public void anadirElementosStage(Stage stage) {
		stage.addActor(tablero);
		for (MyActor myActor : bumpers) {
			stage.addActor(myActor);
		}

		for (ConjuntoBotones conjunto : conjuntoBotones) {
			for (MyActor myActor : conjunto.getBotones()) {
				stage.addActor(myActor);
			}
		}
		for (Entry<String, RejillaAcceso> rejillas : rejillaAccceso.entrySet()) {
			for (Muro trump : rejillas.getValue().getMuros()) {
				stage.addActor(trump);
			}
			for (Rejilla rejilla : rejillas.getValue().getRejillas()) {
				stage.addActor(rejilla);
			}
		}
		stage.addActor(trampilla);
		stage.addActor(ball);
		stage.addActor(hud);
	}

	public MyActor getBall() {
		return ball;
	}

}
