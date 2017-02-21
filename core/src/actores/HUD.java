package actores;

import com.badlogic.gdx.physics.box2d.World;

import behaviors.BallBehavior;
import behaviors.HUDBehavior;
import bodies.BallBody;
import bodies.HUDBody;
import comunes.Constantes;
import fixturas.BallFixture;

public class HUD extends MyActor {
	public static long puntuacion=0;
	public static Integer vidas=Constantes.NUMEROVIDAS;
	
	public HUD(World world, float posX, float posY) {
		super(world, posX, posY);
		myBody = new HUDBody(world, posX, posY);
		myBody.myBehavior = new HUDBehavior(myBody);
//		myFixture = new BallFixture(myBody);
	}

}
